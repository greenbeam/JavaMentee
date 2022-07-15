package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

public class MyBinTree {

    private Node root;

    public MyBinTree()
    {
        this.root = null;
    }

    public static void main(String[] args) {
        Object[] inOrderSequence = { 9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
        Object[] postOrderSequence = { 9, 1, 2, 12, 7, 5, 3, 11, 4, 8};

        System.out.println("Input inOrderSequence[] : " + Arrays.toString(inOrderSequence));
        System.out.println("Input postOrderSequence[] : " + Arrays.toString(postOrderSequence));
        System.out.println();

        MyBinTree myTree = MyBinTree.buildTree(inOrderSequence, postOrderSequence);
        System.out.print("Output inOrderTraversal() : ");
        myTree.inorderTraversal();
        System.out.print("Output postOrderTraversal() : ");
        myTree.postorderTraversal();
    }

    private Node buildTreeRecursion(Object inOrderSequence[], Object postOrderSequence[]){
        if(inOrderSequence.length == 0 || postOrderSequence.length == 0) {
            return null;
        }
        Object rData = postOrderSequence[postOrderSequence.length-1];
        Node root = new Node(rData);

        Object indexData = null;
        int x = 0;

        while(rData != indexData)
        {
            indexData = inOrderSequence[x];
            x++;
        }
        Object inOrderSequenceLeft[] = new Object[x-1];
        Object inOrderSequenceRight[] = new Object[inOrderSequence.length - x];
        Object postOrderSequenceLeft[] = new Object[x-1];
        Object postOrderSequenceRight[] = new Object[postOrderSequence.length - x];

        System.arraycopy(inOrderSequence, 0, inOrderSequenceLeft, 0, x-1);
        System.arraycopy(inOrderSequence, x, inOrderSequenceRight, 0, inOrderSequence.length - x);
        System.arraycopy(postOrderSequence, 0, postOrderSequenceLeft, 0, x-1);
        System.arraycopy(postOrderSequence, x-1, postOrderSequenceRight, 0, postOrderSequence.length - x);

        root.setLeft(buildTreeRecursion(inOrderSequenceLeft, postOrderSequenceLeft));
        root.setRight(buildTreeRecursion(inOrderSequenceRight, postOrderSequenceRight));
        return root;
    }

    private void buildTreeHelper(Object inOrderSequence[], Object postOrderSequence[])
    {
        this.root = buildTreeRecursion(inOrderSequence, postOrderSequence);
    }

    static MyBinTree buildTree(Object inOrderSequence[], Object postOrderSequence[]){
        MyBinTree returnTree = new MyBinTree();
        returnTree.buildTreeHelper(inOrderSequence, postOrderSequence);
        return returnTree;
    }

    public void inorderTraversal()
    {
        ArrayList<Object> toPrint = new ArrayList();
        printInorderTraversal(root, toPrint);
        System.out.println(toPrint);
    }

    private void printInorderTraversal(Node node ,ArrayList<Object> aList)
    {
        if(node == null) { return; }
        printInorderTraversal(node.getLeft(), aList);
        aList.add(node.getData());
        printInorderTraversal(node.getRight(), aList);
    }

    public void postorderTraversal()
    {
        ArrayList<Object> toPrint = new ArrayList();
        printPostorder(root, toPrint);
        System.out.println(toPrint);
    }

    private void printPostorder(Node node, ArrayList<Object> aList)
    {
        if(node == null) { return; }
        printPostorder(node.getLeft(), aList);
        printPostorder(node.getRight(), aList);
        aList.add(node.getData());
    }
}
