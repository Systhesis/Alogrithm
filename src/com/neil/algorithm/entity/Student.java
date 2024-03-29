package com.neil.algorithm.entity;

import java.util.Objects;

/**
 * @author neil zhong
 * @classname Student
 * @description TODO
 * @date 2021/5/30 下午6:46
 **/
public class Student implements Comparable<Student>{
    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Student o) {
//        if(this.score < o.score) {
//            return -1;
//        }else if(this.score == o.score) {
//            return 0;
//        }else {
//            return 1;
//        }
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
