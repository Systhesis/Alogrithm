package concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.*;

public class TimeOutPool {
    private final static Executor executor =
            new ThreadPoolExecutor(0,
                    Integer.MAX_VALUE,
                    60L,
                    TimeUnit.SECONDS,
                    new SynchronousQueue<>(),
                    (ThreadFactory) Thread::new);

    private final Runnable cleanUpRunnable = new Runnable() {
        @Override
        public void run() {
            while(true) {
                long waitNanos = cleanUp(System.nanoTime());
                long timeOut = waitNanos / 1000000L;
                long additionNano = waitNanos - (timeOut * 1000000L);
                System.out.println(waitNanos);
                if(waitNanos == -1) {
                    return;
                }
                if(waitNanos > 0) {
                    synchronized (TimeOutPool.this) {
                        try {
                            TimeOutPool.this.wait(timeOut, (int) additionNano);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                }
            }

    };
    private final long keepAliveDuration;
    private final BlockingDeque<Task> taskDeque = new LinkedBlockingDeque<>();
    private boolean isCleanUpRunning = false;

    public TimeOutPool(long keepAliveDuration, TimeUnit timeUnit) {
        this.keepAliveDuration = timeUnit.toNanos(keepAliveDuration);
    }

    synchronized void put(Task task) {

            if(!isCleanUpRunning) {
                isCleanUpRunning = true;
                executor.execute(cleanUpRunnable);
            }
            taskDeque.add(task);
            System.out.println("put >> " + taskDeque.size());

    }


     synchronized long cleanUp(long now) {
        long minWait = Long.MIN_VALUE;
        Task waitToClean = null;


            if(taskDeque.size() == 0) {
                isCleanUpRunning = false;
                return -1;
            }
            for (Task task : taskDeque) {
                long durationTime = now - task.getPutInTime();
                if (durationTime > minWait) {
                    minWait = durationTime;
                    waitToClean = task;
                }
            }

            if(minWait >= keepAliveDuration) {
                taskDeque.remove(waitToClean);
            }else {
                return  keepAliveDuration - minWait;
            }




         System.out.println("clean up >> " + taskDeque.size());
         return 0;

    }


    public static void main(String[] args) throws InterruptedException {
        TimeOutPool timeOutPool = new TimeOutPool(5, TimeUnit.SECONDS);
        int i = 0;
        while(i < 10) {
            timeOutPool.put(new Task(String.valueOf(i), System.nanoTime()));
            //Thread.sleep(new Random().nextInt(2000) + 1000);
            i++;
        }
        Thread.sleep(10000000);
    }



}
