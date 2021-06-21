package com.bridgelabz;

public class MyBinaryTree <K extends Comparable<K>> {
    public MyBinaryNode<K> root;
    public void add(K key)
    {
        this.root = this.addRecursively(root,key);

    }
    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key)
    {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if(compareResult == 0)
            return current;
        if (compareResult < 0)
            current.left = addRecursively(current.left, key);
        else
            current.right = addRecursively(current.right, key);
        return current;
    }
    public int getSize()
    {
        return this.getSizeRecursive(root);
    }
    public int getSizeRecursive(MyBinaryNode<K> current){
        return current == null ? 0 : 1 +this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
    }

    public boolean search (K key)
    {
        return (searchRecursive(root, key) != null);
    }
    public MyBinaryNode<K> searchRecursive(MyBinaryNode<K> currentNode, K key)
    {
        if(currentNode == null)
            return null;
        else if(currentNode.key.compareTo(key) > 0)
            return searchRecursive(currentNode.right, key);
        else if (currentNode.key.compareTo(key) < 0)
            return searchRecursive(currentNode.left, key);
        else
            return currentNode;
    }
}
