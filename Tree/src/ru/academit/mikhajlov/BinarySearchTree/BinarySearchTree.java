package ru.academit.mikhajlov.BinarySearchTree;

import ru.academit.mikhajlov.TreeNode.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public BinarySearchTree(T rootValue) {
        this.root = new TreeNode<>(rootValue, null, null);
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        TreeNode<T> current = root;
        TreeNode<T> addNode = new TreeNode<>(data, null, null);

        boolean isAdded = false;
        while (!isAdded) {
            if (current.getData().compareTo(addNode.getData()) > 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(addNode);
                    isAdded = true;
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(addNode);
                    isAdded = true;
                }
            }
        }
        size++;
    }

//    @Override
//    public String toString() {
//
//    }
}
