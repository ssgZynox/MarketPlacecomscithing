// Logan, Bell Github: ssgZynox
import java.util.ArrayList;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // arraylists to the varibles
        ArrayList<String> servicenames = new ArrayList<>();
        ArrayList<String> providers = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        boolean running = true;

        while (running) {
            // Displays main menu
            System.out.println("\n-- Local Service Marketplace --");
            System.out.println("1. Add a Service");
            System.out.println("2. View All Services");
            System.out.println("3. Book a Service");
            System.out.println("4. Exit");
            System.out.println("5. Remove a Service");
            System.out.print("Choose an option: ");

            // makes sure scanner is valid
            if (!scanner.hasNextInt()) {
                System.out.println("invalid scanner Please enter a number from 1 to 5.");
                scanner.nextLine(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Add a new service to all three lists block
                System.out.print("enter a service name: ");
                String name = scanner.nextLine();

                System.out.print("enter a provider name: ");
                String provider = scanner.nextLine();

                System.out.print("Enter price: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid price. Please enter a number.");
                    scanner.nextLine(); 
                    continue;
                }

                double price = scanner.nextDouble();
                scanner.nextLine();

                servicenames.add(name);
                providers.add(provider);
                prices.add(price);

                System.out.println("Service added");

            } else if (choice == 2) {
                // Displays all available services
                if (servicenames.isEmpty()) {
                    System.out.println("No services available.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < servicenames.size(); i++) {
                        String info = (i + 1) + ". " + servicenames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i);
                        System.out.println(info);
                    }
                }
            } else if (choice == 3) {
                // book a service from the list block
                if (servicenames.isEmpty()) {
                    System.out.println("No services to book.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < servicenames.size(); i++) {
                        String info = (i + 1) + ". " + servicenames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i);
                        System.out.println(info);
                    }

                    System.out.print("Enter the number of the service to book:");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid scanner.");
                        scanner.nextLine(); 
                        continue;
                    }

                    int selection = scanner.nextInt();
                    scanner.nextLine();

                    if (selection < 1 || selection > servicenames.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        System.out.print("Enter your name: ");
                        String user = scanner.nextLine();

                        int index = selection - 1;
                        System.out.println("Booking confirmed for " + user + ": "
                                + servicenames.get(index) + " by "
                                + providers.get(index) + " - $"
                                + prices.get(index));
                    }
                }

            } else if (choice == 4) {
                // exit the application
                System.out.println("Thank you for using the marketplace.");
                running = false;

            } else if (choice == 5) {
                // remove a service from the list block
                if (servicenames.isEmpty()) {
                    System.out.println("No services to remove.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < servicenames.size(); i++) {
                        System.out.println((i + 1) + ". " + servicenames.get(i)
                                + " by " + providers.get(i)
                                + " -$" + prices.get(i));
                    }

                    System.out.print("Enter the number of the service to remove: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine(); 
                        continue;
                    }

                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (removeIndex < 1 || removeIndex > servicenames.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        int index = removeIndex - 1;
                        System.out.println("Removed: " + servicenames.get(index));
                        servicenames.remove(index);
                        providers.remove(index);
                        prices.remove(index);
                    }
                }

            } else {
                // handles unexpected menu options
                System.out.println("Please select a valid option from 1 to 5.");
            }
        }

        scanner.close(); // cleans up the scanner
    }
}
