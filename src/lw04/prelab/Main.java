package lw04.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        int N = scanner.nextInt();

        int[] branches = new int[N];
        for (int i = 0; i < N; i++) {
            branches[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();

        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = scanner.nextInt();
        }

        scanner.close();

        insertionSort(branches, M);

        for (int i = 0;i < branches.length; i++) {
            System.out.print(branches[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < M; i++) {
            int result = linearSearch(branches, targets[i]);

            if (result != -1) {
                System.out.println(targets[i] + ": FOUND at index " + result);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }

        // System.out.println(N);
        // System.out.println(Arrays.toString(branches));
        // System.out.println(M);
        // System.out.println(Arrays.toString(targets));
    }

    public static void insertionSort (int[] data, int passes) {
        for (int i = 1; i <= passes && i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }

    public static int linearSearch (int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
