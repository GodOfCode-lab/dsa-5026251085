package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();

        String numbersLine = read.nextLine();
        Scanner numbers = new Scanner(numbersLine);

        while (numbers.hasNextInt()) {
            int data = numbers.nextInt();
            bst.insert(data);
        }

        numbers.close();

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));

        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        read.close();
    }
}