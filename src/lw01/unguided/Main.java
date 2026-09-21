package lw01.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/lw01/unguided/rentals.txt"));

        int total = scanner.nextInt();

        Rental[] rentals = new Rental[total];
        int[] units = new int[total];

        for (int i = 0; i < total; i++) {

            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int unit = scanner.nextInt();

            if (unit <= 0) {
                throw new IllegalArgumentException();
            }

            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days);
            } else {
                throw new IllegalArgumentException("Invalid rental type");
            }

            units[i] = unit;
        }

        for (int i = 0; i < rentals.length; i++) {
            Rental rental = rentals[i];

            System.out.println(
                rental.getId()
                + " | "
                + rental.label()
                + " | "
                + rental.calculateCharge(units[i])
            );
        }

        scanner.close();

    }
}
