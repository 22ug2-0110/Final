package package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static int id;
    static String name;
    static String yob;
    static int height;
    static int weight;
    static Bmi bmi;
    public static List<Bmi> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.println("Please Enter User Id");
                    choice = scanner.nextInt();
                    view(choice);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public static void displayMenu() {
        System.out.println(" - BMI CALCULATOR - ");
        System.out.println("");
        System.out.println("1.Make a data sheet");
        System.out.println("2.All users BMI data");
        System.out.println("3.Selected user BMI data");
        System.out.println("4.Delete all data sheets ");
        System.out.println("5.Exit ");
        System.out.println("");
        System.out.println("Enter Your object");

    }

    public static void view(int id) { // show onw record
        users.forEach(user -> {
            if (user.getId() == id) {
                user.display();
            }
        });
    }

    public static void create() {

        boolean isIdOk = false;
        boolean isNameOk = false;
        boolean isYobOk = false;
        boolean isHeightOk = false;
        boolean isWeightOk = false;

        for (int i = 0; i < 3; i++) {

            if (!isIdOk) {
                System.out.println("Add your id:");
                id = scanner.nextInt();
                scanner.nextLine();
            }
            if (!isNameOk) {
                System.out.println("Add your name:");
                name = scanner.nextLine();
                isNameOk = true;
            }
            if (!isYobOk) {
                System.out.println("Add your yob:");
                yob = scanner.nextLine();
            }
            if (!isHeightOk) {
                System.out.println("Add your height:");
                height = scanner.nextInt();
                isHeightOk = true;
            }
            if (!isWeightOk) {
                System.out.println("Add your weight:");
                weight = scanner.nextInt();
                isWeightOk = true;
            }

            if (id < 0 || id > 6) {
                System.out.println("The ID must be within the range of 0 to 5, exclusive");
                i = 1;
            } else {
                isIdOk = true;
                i = 3;
            }

            if (Integer.parseInt(yob) >= 2025) {
                System.out.println("The year of birth must be before 2025.");
                i = 1;
            } else {
                isYobOk = true;
                if (i != 1) {//error on previous validation
                    i = 3;
                }
            }

        }

        bmi = new Bmi(id, name, yob, height, weight);
        users.add(bmi);
        index();
        System.out.println(users.size());

//        displayMenu();
//        scanner.nextLine();
    }

    public static void index() {
        users.forEach(user -> user.display());

    }

    public static void delete() {
        users.clear();
    }

    public static void exit() {
        System.exit(0);
    }

}
