package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // PROBLEM 1

        List<String> playlist = new ArrayList<String>();

        Scanner playlistScanner = new Scanner(
                new File("src/lw03/prelab/playlist.txt")
        );

        while (playlistScanner.hasNext()) {

            String operation = playlistScanner.next();

            if (operation.equals("ADD")) {

                String song = playlistScanner.next();

                playlist.add(song);

            } else if (operation.equals("INSERT")) {

                int index = playlistScanner.nextInt();
                String song = playlistScanner.next();

                playlist.add(index, song);

            } else if (operation.equals("REMOVE")) {

                String song = playlistScanner.next();

                if (playlist.contains(song)) {
                    playlist.remove(song);
                }
            }
        }

        playlistScanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {

            System.out.println(
                    (i + 1) + ": " + playlist.get(i)
            );
        }


        // PROBLEM 2

        Set<String> participants = new LinkedHashSet<String>();

        Scanner participantScanner = new Scanner(
                new File("src/lw03/prelab/participants.txt")
        );

        int duplicateRegistrations = 0;

        while (participantScanner.hasNext()) {

            String name = participantScanner.next();

            if (participants.contains(name)) {

                duplicateRegistrations++;

            } else {

                participants.add(name);
            }
        }

        participantScanner.close();

        System.out.println("===== Problem 2 =====");
        System.out.println(
                "Unique participants: " + participants.size()
        );

        int number = 1;

        for (String participant : participants) {

            System.out.println(
                    number + ". " + participant
            );

            number++;
        }

        System.out.println(
                "Duplicate registrations: " + duplicateRegistrations
        );


        // PROBLEM 3

        Map<String, Integer> inventory =
                new LinkedHashMap<String, Integer>();

        Scanner inventoryScanner = new Scanner(
                new File("src/lw03/prelab/inventory.txt")
        );

        int failedSales = 0;

        while (inventoryScanner.hasNext()) {

            String type = inventoryScanner.next();
            String product = inventoryScanner.next();
            int quantity = inventoryScanner.nextInt();

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);
                    stock = stock + quantity;

                    inventory.put(product, stock);

                } else {

                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);

                    if (stock >= quantity) {

                        stock = stock - quantity;

                        inventory.put(product, stock);

                    } else {

                        failedSales++;
                    }

                } else {

                    failedSales++;
                }
            }
        }

        inventoryScanner.close();

        System.out.println("===== Problem 3 =====");

        for (String product : inventory.keySet()) {

            System.out.println(
                    product + ": " + inventory.get(product)
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}