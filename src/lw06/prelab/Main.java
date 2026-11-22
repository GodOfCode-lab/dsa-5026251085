package lw06.prelab;

import java.util.*;

public class Main {

    // Menyimpan hasil traversal
    static StringBuilder output = new StringBuilder();

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

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        output.append(root.data).append(" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        output.append(root.data).append(" ");
        inorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        output.append(root.data).append(" ");
    }

    public static void main(String[] args) {

        Node root = null;

        Scanner input = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String valuesLine = "";

        while (input.hasNextLine() && valuesLine.trim().isEmpty()) {
            valuesLine = input.nextLine();
        }

        Scanner values = new Scanner(valuesLine);

        while (values.hasNextInt()) {
            int data = values.nextInt();
            root = insert(root, data);
        }

        values.close();

        String targetLine = "";

        while (input.hasNextLine() && targetLine.trim().isEmpty()) {
            targetLine = input.nextLine();
        }

        int target = Integer.parseInt(targetLine.trim());

        input.close();

        output.setLength(0);
        preorder(root);
        System.out.println("Preorder : " + output.toString().trim());

        output.setLength(0);
        inorder(root);
        System.out.println("Inorder   : " + output.toString().trim());

        output.setLength(0);
        postorder(root);
        System.out.println("Postorder : " + output.toString().trim());

        System.out.println(
            "Search " + target + " : " + search(root, target)
        );
    }
}