// Logan, Bell Github: ssgZynox
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // arraylists to hold service data
        ArrayList<String> serviceNames = new ArrayList<>();
        ArrayList<String> providers = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        // cart stuff goes here
        ArrayList<String> cartServices = new ArrayList<>();
        ArrayList<String> cartProviders = new ArrayList<>();
        ArrayList<Double> cartPrices = new ArrayList<>();

        boolean running = true;

        while (running) {
            // main menu is shown
            System.out.println("\n-- Local Service Marketplace --");
            System.out.println("1. Add a Service");
            System.out.println("2. View All Services");
            System.out.println("3. Book a Service");
            System.out.println("4. Exit");
            System.out.println("5. Remove a Service");
            System.out.println("6. Update Cart");
            System.out.println("7. Checkout");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 7.");
                scanner.nextLine(); // clear bad input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // user adds a new service
                System.out.print("Enter a service name: ");
                String name = scanner.nextLine();

                System.out.print("Enter a provider name: ");
                String provider = scanner.nextLine();

                System.out.print("Enter price: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid price. Try a number.");
                    scanner.nextLine();
                    continue;
                }

                double price = scanner.nextDouble();
                scanner.nextLine();

                serviceNames.add(name);
                providers.add(provider);
                prices.add(price);

                System.out.println("Service added."); // success

            } else if (choice == 2) {
                // shows services if there is any
                if (serviceNames.isEmpty()) {
                    System.out.println("No services available.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < serviceNames.size(); i++) {
                        System.out.println((i + 1) + ". " + serviceNames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i));
                    }
                }

            } else if (choice == 3) {
                // booking a service
                if (serviceNames.isEmpty()) {
                    System.out.println("No services to book.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < serviceNames.size(); i++) {
                        System.out.println((i + 1) + ". " + serviceNames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i));
                    }

                    System.out.print("Enter the number of the service to book: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }

                    int selection = scanner.nextInt();
                    scanner.nextLine();

                    if (selection < 1 || selection > serviceNames.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        System.out.print("Enter your name: ");
                        String user = scanner.nextLine();

                        int index = selection - 1;

                        // add to cart
                        cartServices.add(serviceNames.get(index));
                        cartProviders.add(providers.get(index));
                        cartPrices.add(prices.get(index));

                        System.out.println("Booking confirmed for " + user + ": "
                                + serviceNames.get(index) + " by "
                                + providers.get(index) + " - $" + prices.get(index));

                        // remove from list cuz its booked
                        serviceNames.remove(index);
                        providers.remove(index);
                        prices.remove(index);
                    }
                }

            } else if (choice == 4) {
                // quits the program
                System.out.println("Thank you for using the marketplace.");
                running = false;

            } else if (choice == 5) {
                // removing services
                if (serviceNames.isEmpty()) {
                    System.out.println("No services to remove.");
                } else {
                    System.out.println("\nAvailable Services:");
                    for (int i = 0; i < serviceNames.size(); i++) {
                        System.out.println((i + 1) + ". " + serviceNames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i));
                    }

                    System.out.print("Enter the number of the service to remove: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }

                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (removeIndex < 1 || removeIndex > serviceNames.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        int index = removeIndex - 1;
                        System.out.println("Removed: " + serviceNames.get(index));
                        serviceNames.remove(index);
                        providers.remove(index);
                        prices.remove(index);
                    }
                }

            } else if (choice == 6) {
                // change what’s in cart
                if (cartServices.isEmpty()) {
                    System.out.println("Your cart is empty.");
                } else {
                    System.out.println("\nYour Cart:");
                    for (int i = 0; i < cartServices.size(); i++) {
                        System.out.println((i + 1) + ". " + cartServices.get(i)
                                + " by " + cartProviders.get(i)
                                + " - $" + cartPrices.get(i));
                    }

                    if (serviceNames.isEmpty()) {
                        System.out.println("No services available to update with.");
                        continue;
                    }

                    System.out.println("\nAvailable Services to Replace With:");
                    for (int i = 0; i < serviceNames.size(); i++) {
                        System.out.println((i + 1) + ". " + serviceNames.get(i)
                                + " by " + providers.get(i)
                                + " - $" + prices.get(i));
                    }

                    System.out.print("Enter the number of the item in your cart to update: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }

                    int cartPos = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new service number to replace with: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }

                    int newServiceIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (cartPos < 1 || cartPos > cartServices.size()
                            || newServiceIndex < 1 || newServiceIndex > serviceNames.size()) {
                        System.out.println("Invalid selection.");
                        continue;
                    }

                    int serviceIndex = newServiceIndex - 1;

                    // do the update
                    cartServices.set(cartPos - 1, serviceNames.get(serviceIndex));
                    cartProviders.set(cartPos - 1, providers.get(serviceIndex));
                    cartPrices.set(cartPos - 1, prices.get(serviceIndex));

                    // remove from main list
                    serviceNames.remove(serviceIndex);
                    providers.remove(serviceIndex);
                    prices.remove(serviceIndex);

                    System.out.println("Cart updated!");

                    System.out.println("\nUpdated Cart:");
                    for (int i = 0; i < cartServices.size(); i++) {
                        System.out.println((i + 1) + ". " + cartServices.get(i)
                                + " by " + cartProviders.get(i)
                                + " - $" + cartPrices.get(i));
                    }
                }

            } else if (choice == 7) {
                // final checkout
                if (cartServices.isEmpty()) {
                    System.out.println("Your cart is empty. Book somthing first.");
                } else {
                    System.out.println("\n--- Invoice ---");
                    double total = 0;

                    for (int i = 0; i < cartServices.size(); i++) {
                        System.out.println((i + 1) + ". " + cartServices.get(i)
                                + " by " + cartProviders.get(i)
                                + " - $" + cartPrices.get(i) + " per hour");
                        total += cartPrices.get(i);
                    }

                    System.out.println("---------------------");
                    System.out.printf("Total: $%.2f\n", total);

                    // confirmation
                    System.out.print("Confirm order (yes/no): ");
                    String confirm = scanner.nextLine().toLowerCase();

                    if (confirm.equals("yes")) {
                        System.out.println("Order confirmed. Thank you for booking with us!");
                        cartServices.clear();
                        cartProviders.clear();
                        cartPrices.clear();
                    } else {
                        System.out.println("Order canceled.");
                    }
                }

            } else {
                System.out.println("Please select a valid option from 1 to 7.");
            }
        }

        scanner.close(); // clean up scanner
    }
}
