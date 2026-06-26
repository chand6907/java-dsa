package binarysearchtree.part2;

import java.util.*;

public class merge2bst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Inorder Traversal
    public static void getinorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getinorder(root.left, arr);
        arr.add(root.data);
        getinorder(root.right, arr);
    }

    // Create Balanced BST from Sorted ArrayList
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {

        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // Merge Two BSTs
    public static Node mergebst(Node root1, Node root2) {

        // Step 1 : Inorder of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinorder(root1, arr1);

        // Step 2 : Inorder of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getinorder(root2, arr2);

        // Step 3 : Merge Two Sorted Lists
        int i = 0, j = 0;
        ArrayList<Integer> finalarr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {

            if (arr1.get(i) <= arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;
            } else {
                finalarr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalarr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
            j++;
        }

        // Step 4 : Sorted Array -> Balanced BST
        return createBST(finalarr, 0, finalarr.size() - 1);
    }

    // Preorder Traversal
    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal (for Printing)
    public static void inorderPrint(Node root) {

        if (root == null) {
            return;
        }

        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String args[]) {

        // BST 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // BST 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Merge BSTs
        Node root = mergebst(root1, root2);

        System.out.println("Preorder Traversal:");
        preorder(root);

        System.out.println();

        System.out.println("Inorder Traversal:");
        inorderPrint(root);
    }
}