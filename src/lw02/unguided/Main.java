package lw02.unguided;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        final int MAX_BORROW = 2;

        LinkedList<String[]> requests = new LinkedList<String[]>();
        LinkedList<String[]> books = new LinkedList<String[]>();
        LinkedList<String[]> members = new LinkedList<String[]>();
        LinkedList<String[]> successRequests = new LinkedList<String[]>();

        Queue<String[]> queue = new LinkedList<String[]>();
        Stack<String[]> failedRequests = new Stack<String[]>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (scanner.hasNext()) {

            String name = scanner.next();
            String book = scanner.next();

            String[] request = new String[2];
            request[0] = name;
            request[1] = book;

            requests.add(request);

            boolean found = false;

            for (String[] member : members) {

                if (member[0].equals(name)) {
                    found = true;
                }
            }

            if (found == false) {

                String[] newMember = new String[2];

                newMember[0] = name;
                newMember[1] = "0";

                members.add(newMember);
            }
        }

        scanner.close();

        while (requests.isEmpty() == false) {

            String[] request = requests.poll();

            queue.add(request);
        }

        while (queue.isEmpty() == false) {

            String[] request = queue.poll();

            String name = request[0];
            String bookName = request[1];

            String[] currentBook = null;
            String[] currentMember = null;

            for (String[] book : books) {

                if (book[0].equals(bookName)) {
                    currentBook = book;
                }
            }

            for (String[] member : members) {

                if (member[0].equals(name)) {
                    currentMember = member;
                }
            }

            int stock = Integer.parseInt(currentBook[1]);
            int borrowed = Integer.parseInt(currentMember[1]);

            if (stock > 0 && borrowed < MAX_BORROW) {

                successRequests.add(request);

                stock = stock - 1;
                borrowed = borrowed + 1;

                currentBook[1] = String.valueOf(stock);
                currentMember[1] = String.valueOf(borrowed);

            } else {

                failedRequests.push(request);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");

        for (String[] request : successRequests) {

            System.out.println(
                    request[0] + " " + request[1]
            );
        }

        System.out.println("=== Remaining Book Stock ===");

        for (String[] book : books) {

            System.out.println(
                    book[0] + " : " + book[1]
            );
        }

        System.out.println("=== Failed Requests ===");

        while (failedRequests.isEmpty() == false) {

            String[] failed = failedRequests.pop();

            System.out.println(
                    failed[0] + " " + failed[1]
            );
        }
    }
}