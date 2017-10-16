package com.m3c.hk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alumniCurie07 on 11/10/2017.
 */
public class BinaryTreeStandard implements BinaryTree {

    public static Node root;
    Node current = root;
    int nodeCount = 0;
    List<Integer> checkedNodes = new ArrayList<Integer>();
    List<Integer> ascDscList = new ArrayList<Integer>();
    List<Integer> ascDscNodes = new ArrayList<Integer>();


    public  BinaryTreeStandard(){
        this.root = null;
    }

    public int getRootElement() {

        if(root != null){
            return root.value;
        }
        return 0;
    }

    public int treeSize(Node node){

        if( node != null && !checkedNodes.contains(node.value)){
            nodeCount++;
            checkedNodes.add(node.value);
        }
        if( node.leftNode != null){
            nodeCount++;
            checkedNodes.add(node.leftNode.value);
            treeSize(node.leftNode);
        }
        if( node.rightNode != null){
            nodeCount++;
            checkedNodes.add(node.rightNode.value);
            treeSize(node.rightNode);
        }
        return nodeCount;
    }

    public List<Integer> ascDscLister(Node node){

        if(node != null && !ascDscNodes.contains(node.value)){
            ascDscNodes.add(node.value);
            ascDscList.add(node.value);
        }
        if(node.rightNode!= null){
            Node rightNode = node.rightNode;
            ascDscList.add(rightNode.value);
            ascDscNodes.add(rightNode.value);
            ascDscLister(rightNode);
        }
        if(node.leftNode != null){
            Node leftNode = node.leftNode;
            ascDscList.add(leftNode.value);
            ascDscNodes.add(leftNode.value);
            ascDscLister(leftNode);
        }

        return ascDscList;
    }

    public int getNumberOfElements() {
        return treeSize(root);
    }

    public void addElement(int element) {

        Node newNode = new Node(element);

        if (findElement(newNode.value) == 1){

            try {
                throw new Problems();
            } catch (Problems problems) {
                problems.duplicate();
            }
        }

        if(root == null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(element < current.value){
                current = current.leftNode;
                if(current == null){
                    parent.leftNode = newNode;
                    return;
                }
            }else{
                current = current.rightNode;
                if (current == null){
                    parent.rightNode = newNode;
                    return;
                }
            }
        }
    }

    public void addElements(int[] elements) {

        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    public int findElement(int element) {

        Node current = root;
        while (current != null){
            if(current.value == element){
                return 1;
            }
            else if(current.value > element){
                current = current.leftNode;
            }
            else{
                current = current.rightNode;
            }
        }
        return -1;
    }

    public int getLeftChild(int element) {

        Node current = root;
        Node parent = null;

        while(true){
            parent = current;
            if(element < current.value){
                if(current.leftNode != null){
                    current = current.leftNode;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }else if( current.value == element){
                Node given = current;
                if (given.leftNode != null){
                    Node leftNode = given.leftNode;
                    return leftNode.value;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }
            else{
                if(current.rightNode != null){
                    current = current.rightNode;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }
        }
        return 0;
    }

    public int getRightChild(int element) {

        Node current = root;
        Node parent = null;

        while(true){
            parent = current;
            if(element > current.value){
                if(current.rightNode != null){
                    current = current.rightNode;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }else if( current.value == element){
                Node given = current;
                if (given.rightNode != null){
                    Node rightNode = given.rightNode;
                    return rightNode.value;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }
            else{
                if(current.leftNode != null){
                    current = current.leftNode;
                }else{
                    System.out.println("Element is a leaf node");
                    break;
                }
            }
        }
        return 0;
    }

    public List<Integer> getSortedTreeAsc() {
        ascDscLister(root);
        Collections.sort(ascDscList);
        return ascDscList;
    }

    public List<Integer> getSortedTreeDesc() {
        ascDscLister(root);
        Collections.sort(ascDscList, Collections.<Integer>reverseOrder());
        return ascDscList;
    }
}
