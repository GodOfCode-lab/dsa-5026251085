package lw03.unguided;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> enrollment = new HashMap<String, Integer>();
        List<String> courseOrder = new ArrayList<String>();
        List<String> checkResults = new ArrayList<String>();

        int rejectedOperations = 0;

        while (sc.hasNext()) {

            String operation = sc.next();
            String course = sc.next();

            if (operation.equals("REGISTER")) {
                int count = sc.nextInt();

                if (count <= 0) {
                    rejectedOperations++;

                } else {
                    if (enrollment.containsKey(course)) {
                        int current = enrollment.get(course);
                        enrollment.put(course, current + count);
                    } else {
                        enrollment.put(course, count);
                        courseOrder.add(course);
                    }
                }

            } else if (operation.equals("WITHDRAW")) {
                int count = sc.nextInt();
                if (count <= 0) {
                    rejectedOperations++;
                } else if (!enrollment.containsKey(course)) {
                    rejectedOperations++;
                } else {
                    int current = enrollment.get(course);
                    if (current >= count) {
                        enrollment.put(course, current - count);
                    } else {
                        rejectedOperations++;
                    }
                }

            } else if (operation.equals("CHECK")) {
                if (enrollment.containsKey(course)) {
                    int current = enrollment.get(course);
                    checkResults.add(
                            course + ": " + current + " students"
                    );
                } else {
                    checkResults.add(
                            course + ": Not found"
                    );
                }
            }
        }

        sc.close();

        System.out.println("===== Enrollment Checks =====");

        for (String result : checkResults) {
            System.out.println(result);
        }

        System.out.println("===== Final Enrollment =====");

        for (String course : courseOrder) {
            System.out.println(
                    course + ": " + enrollment.get(course) + " students"
            );
        }

        System.out.println(
                "Rejected operations: " + rejectedOperations
        );
    }
}