package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.BinarySearchTree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        int rootValue = 2;
        BinarySearchTree tree = new BinarySearchTree(rootValue);

        tree.add(22);
        System.out.println(tree.getSize());
        System.out.println(tree);
    }
}
