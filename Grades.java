import java.util.Arrays;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the marks (space-separated): ");
        String input = scanner.nextLine();
        String[] marksStr = input.split(" ");
        int[] marks = new int[marksStr.length];
        for (int i = 0; i < marksStr.length; i++) {
            marks[i] = Integer.parseInt(marksStr[i]);
        }

        int[] stats = {0, 0, 0, 0, 0};
        int max = marks[0];
        int min = marks[0];
        int sum = 0;

        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }

            if (mark < min) {
                min = mark;
            }

            sum += mark;

            if (mark <= 20) {
                stats[0]++;
            } else if (mark <= 40) {
                stats[1]++;
            } else if (mark <= 60) {
                stats[2]++;
            } else if (mark <= 80) {
                stats[3]++;
            } else {
                stats[4]++;
            }
        }

        System.out.println("Values:");
        System.out.println("The maximum grade is: " + max);
        System.out.println("The minimum grade is: " + min);
        System.out.printf("The average grade is: %.2f\n", (double) sum / marks.length);


        System.out.println("\nGraph:");
        int maxCount = Arrays.stream(stats).max().getAsInt();
        for (int i = maxCount; i > 0; i--) {
            System.out.print(i + "  >");
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("   #######");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }
                                   
        System.out.println("     +---------+---------+---------+---------+---------+");
        System.out.println("     I   0-20  I   21-40 I  41-60  I  61-80  I  81-100 I");

    }
}
