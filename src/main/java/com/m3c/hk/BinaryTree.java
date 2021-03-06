package com.m3c.hk;

import java.util.List;

/**
 * Created by keith.dauris on 26/06/2017.
 */
public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    int findElement(int value);

    int getLeftChild(int element);

    int getRightChild(int element);

    List<Integer> getSortedTreeAsc();

    List<Integer> getSortedTreeDesc();
}
