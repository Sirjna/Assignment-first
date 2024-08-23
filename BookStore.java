package BookStore;

import java.util.Scanner;

public class BookStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many books do you want to add: ");
        int size = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String[] books = new String[size];

        // Reading book details from user
        for (int i = 0; i < size; i++) {
            System.out.println("Enter details for book " + (i + 1));
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Price: ");
            String price = scanner.nextLine();
            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            books[i] = String.join(",", title, author, price, publisher, isbn);
        }

        // Displaying the book list
        System.out.println("\nTitle\tAuthor\tPrice\tPublisher\tISBN");
        for (String book : books) {
            String[] details = book.split(",");
            System.out.println(details[0] + "\t" + details[1] + "\t£" + details[2] + "\t" + details[3] + "\t" + details[4]);
        }

        // Calculating book stock details
        double totalCost = 0;
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;

        for (String book : books) {
            String[] details = book.split(",");
            double price = Double.parseDouble(details[2]);

            totalCost += price;
            if (price > maxPrice) maxPrice = price;
            if (price < minPrice) minPrice = price;
        }

        // Displaying stock details
        System.out.println("\n========Totals Stocks===========");
        System.out.println("Total number of books: " + size);
        System.out.println("Total cost of books: £" + totalCost);
        System.out.println("Maximum cost of a book: £" + maxPrice);
        System.out.println("Minimum cost of book: £" + minPrice);
        System.out.println("Average cost of book: £" + (totalCost / size));

        scanner.close();
    }
}
