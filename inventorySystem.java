import java.util.Scanner;
import java.util.InputMismatchException;

class Item {
    protected String name;
    protected String company;


    public void setDetails(String n, String c) {
        name = n;
        company = c;
    }

    public void setDetails() { // overload
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        name = sc.next();
        System.out.print("Enter company name: ");
        company = sc.next();
    }


    public void display() {
        System.out.println("Item: " + name);
        System.out.println("Company: " + company);
    }
}

class Painkillers extends Item {
    private String expiryDate;
    private String ageGroup;

    public void update() {
        Scanner sc = new Scanner(System.in);
        try {
            setDetails();
            System.out.print("Enter expiry date: ");
            expiryDate = sc.next();
            System.out.print("Enter age group: ");
            ageGroup = sc.next();
        } catch (Exception e) {
            System.out.println("Invalid input! Please re-enter details.");
            update(); // retry
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Age Group: " + ageGroup);
        System.out.println("Category: Painkillers\n");
    }
}


class Bandages extends Item {
    private String expiryDate;
    private String ageGroup;
    private char waterproof;

    public void update() {
        Scanner sc = new Scanner(System.in);
        try {
            setDetails();
            System.out.print("Enter expiry date: ");
            expiryDate = sc.next();
            System.out.print("Enter age group: ");
            ageGroup = sc.next();

            System.out.print("Is it waterproof (y/n): ");
            waterproof = sc.next().charAt(0);

            if (waterproof != 'y' && waterproof != 'n') {
                throw new Exception("Invalid input for waterproof!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            update(); // retry
        }
    }


    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Age Group: " + ageGroup);
        System.out.println("Waterproof: " + waterproof);
        System.out.println("Category: Bandages\n");
    }
}

class Equipment extends Item {
    private double weight;

    public void update() {
        Scanner sc = new Scanner(System.in);
        try {
            setDetails();
            System.out.print("Enter item weight (lbs): ");
            weight = sc.nextDouble();  // may throw InputMismatchException
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Weight must be a number.");
            update(); // retry
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Weight: " + weight + " lbs");
        System.out.println("Category: Equipment\n");
    }
}

public class inventorySystem {
    public static void main(String[] args) {
        Painkillers p = new Painkillers();
        Bandages b = new Bandages();
        Equipment e = new Equipment();

        System.out.println("\n--- Enter Painkiller Details ---");
        p.update();

        System.out.println("\n--- Enter Bandage Details ---");
        b.update();

        System.out.println("\n--- Enter Equipment Details ---");
        e.update();

        System.out.println("\n--- Inventory Display ---");
        p.display();
        b.display();
        e.display();
    }
}