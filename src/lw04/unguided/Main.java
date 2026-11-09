package lw04.unguided;

import java.util.*;

public class Main {

    static void sortCards(int[] arr, int passes) {
        for (int i = 0; i < passes && i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards2.txt"));

        int N = sc.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        sortCards(cards, 2);

        for (int i = 0; i < cards.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }

        System.out.println();

        for (int i = 0; i < M; i++) {
            int result = findCard(cards, targets[i]);

            if (result != -1) {
                System.out.println(
                    targets[i] + ": FOUND at index " + result);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
