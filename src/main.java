import java.util.Arrays;
import java.util.Scanner;
class TShirt {
    private String name;
    private String productCode;
    private double price;
    private String brand;
    private String description;
    private String[] sizes;

    // Constructor
    public TShirt(String name, String productCode, double price, String brand, String description, String[] sizes) {
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.sizes = sizes;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }

    // Method to describe the T-shirt
    public String describeTShirt() {
        return "Item name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Product code: " + productCode + "\n" +
                "Brand: " + brand + "\n" +
                "Price: " + price + "\n" +
                "Sizes: " + Arrays.toString(sizes) + "\n";
    }
}

class Order {
    private String name;
    private String phoneNumber;
    private String[] items;
    private double[] prices;

    // Constructor
    public Order(String name, String phoneNumber, String[] items, double[] prices) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.items = items;
        this.prices = prices;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    // Method to generate the bill
    public String generateBill() {
        double totalPrice = Arrays.stream(prices).sum();
        double vatAmount = totalPrice * 0.13;
        double totalAmount = totalPrice + vatAmount;

        // Constructing the bill in the required format
        return "Order details:\n" +
                "   Name: " + name + "\n" +
                "   Phone number: " + phoneNumber + "\n" +
                "   Items: " + Arrays.toString(items) + "\n" +
                "   Price: " + Arrays.toString(prices) + "\n" +
                "\n   Total Price: " + totalPrice + "\n" +
                "   VAT (13%): " + vatAmount + "\n" +
                "   Total Amount: " + totalAmount + "\n";
    }
}


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for T-shirt 1
        System.out.println("Enter details for T-shirt 1:");
        System.out.print("Item name: ");
        String tshirt1Name = scanner.nextLine();
        System.out.print("Product code: ");
        String tshirt1ProductCode = scanner.nextLine();
        System.out.print("Price: ");
        double tshirt1Price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Brand: ");
        String tshirt1Brand = scanner.nextLine();
        System.out.print("Description: ");
        String tshirt1Description = scanner.nextLine();
        System.out.print("Sizes:  ");
        String tshirt1SizesInput = scanner.nextLine();
        String[] tshirt1Sizes = tshirt1SizesInput.split(",\\s*");

        // Creating T-shirt 1 object
        TShirt tshirt1 = new TShirt(tshirt1Name, tshirt1ProductCode, tshirt1Price, tshirt1Brand, tshirt1Description, tshirt1Sizes);

        // Input for T-shirt 2
        System.out.println("\nEnter details for T-shirt 2:");
        System.out.print("Item name: ");
        String tshirt2Name = scanner.nextLine();
        System.out.print("Product code: ");
        String tshirt2ProductCode = scanner.nextLine();
        System.out.print("Price: ");
        double tshirt2Price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Brand: ");
        String tshirt2Brand = scanner.nextLine();
        System.out.print("Description: ");
        String tshirt2Description = scanner.nextLine();
        System.out.print("Sizes: ");
        String tshirt2SizesInput = scanner.nextLine();
        String[] tshirt2Sizes = tshirt2SizesInput.split(",\\s*");

        // Creating T-shirt 2 object
        TShirt tshirt2 = new TShirt(tshirt2Name, tshirt2ProductCode, tshirt2Price, tshirt2Brand, tshirt2Description, tshirt2Sizes);

        // Printing T-shirt details
        System.out.println("\nT-shirt 1 details:");
        System.out.println(tshirt1.describeTShirt());

        System.out.println("\nT-shirt 2 details:");
        System.out.println(tshirt2.describeTShirt());

        // Input for Order 1
        System.out.println("\nEnter details for Order 1:");
        System.out.print("Name: ");
        String order1Name = scanner.nextLine();
        System.out.print("Phone number: ");
        String order1PhoneNumber = scanner.nextLine();
        System.out.print("Items (comma-separated): ");
        String order1ItemsInput = scanner.nextLine();
        String[] order1Items = order1ItemsInput.split(",\\s*");
        System.out.print("Prices (comma-separated): ");
        String order1PricesInput = scanner.nextLine();
        double[] order1Prices = Arrays.stream(order1PricesInput.split(",\\s*")).mapToDouble(Double::parseDouble).toArray();

        // Creating Order 1 object
        Order order1 = new Order(order1Name, order1PhoneNumber, order1Items, order1Prices);

        // Generating and printing the bill for Order 1
        System.out.println("\nOrder 1 details:");
        System.out.println(order1.generateBill());

    }
}
