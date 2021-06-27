package com.neil.algorithm.tree.binarysearchtree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author neil zhong
 * @classname BST
 * @description TODO
 * @date 2021/6/26 下午6:18
 **/
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加e
    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(queue != null) {
            Node cur = queue.poll();
            if(cur == null) {
                return;
            }
            System.out.println(cur.e);

            if(cur.left != null) {
                queue.add(cur.left);
            }

            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minimum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }

        return minimum(root).e;

    }

    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }

        return maximum(root).e;

    }

    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }


    public E removeMin() {
        E ret = minimum();

        root = removeMin(root);

        return ret;
    }

    //返回删除之后二叉树的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);

        return node;
    }

    public E removeMax() {
        E ret = maximum();

        root = removeMax(root);

        return ret;
    }

    //返回删除之后二叉树的根
    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);

        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }

        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //向以node为根的二分搜索树中插入元素e 递归
    private Node add(Node node, E e) {
//        if(e.equals(node.e)) {
//            return;
//        } else if(e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
        if(node == null) {
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null \n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {

            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.levelOrder();

        //System.out.println(bst);
    }
}
