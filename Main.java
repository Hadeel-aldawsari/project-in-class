import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> parking = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            parking.add("available");
        }
        int choice;
        do {
            System.out.println("*** Parking reservation system ***\n choose number");
            System.out.println("1) Display available parking");
            System.out.println("2) Display all spot parking status");
            System.out.println("3) Reserve a parking spot");
            System.out.println("4) Cancel parking reservation");
            System.out.println("5) Check the number of available parking");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displayParking(parking);
                    break;
                case 2:
                    displayAll(parking);
                    break;
                case 3:
                    reserveParking(parking);
                    break;
                case 4:
                    System.out.println("Please enter spot number that you want to cancel:");
                    int spotNumber = input.nextInt();
                    cancelReserve(parking, spotNumber);
                    break;
                case 5:
                    System.out.println("The number of available parking is: " + numberOfAvailability(parking));
                    break;
                case 6:
                    System.out.println("Thank you! \nSee you soon");
                    System.out.println("Parking reservation system always happy to serve you");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);
    }

    public static void displayAll(ArrayList<String> parking) {
        for (int i = 0; i < parking.size(); i++) {
            System.out.println("Parking (" + (i + 1) + ") " + parking.get(i));
        }
    }

    public static void displayParking(ArrayList<String> parking) {
        System.out.println("These are the available parking spots:");
        for (int i = 0; i < parking.size(); i++) {
            if (parking.get(i).equals("available")) {
                System.out.println("Parking number: " + (i + 1));
            }
        }
    }

    public static void reserveParking(ArrayList<String> parking) {
        displayParking(parking);
        Scanner in = new Scanner(System.in);
        System.out.print("Choose from the available parking: ");
        int spot = in.nextInt() - 1;
        String name;

        while (!parking.get(spot).equals("available")) {
            System.out.println("Sorry, this parking spot is not available. Choose another parking:");
            spot = in.nextInt() - 1;
        }
        in.nextLine();
        System.out.print("Great! Please enter your name: ");
        name = in.nextLine();
        parking.set(spot, "Reserved by " + name);
        System.out.println("parking number " + (spot + 1) + " has been reserved for " + name);
    }

    public static void cancelReserve(ArrayList<String> parking, int spot) {
        parking.set(spot - 1, "available");
        System.out.println("Your reservation has been successfully cancelled.");
    }

    public static int numberOfAvailability(ArrayList<String> parking) {
        int count = 0;
        for (String spot : parking) {
            if (spot.equals("available")) {
                count++;
            }
        }
        return count;
    }
}
