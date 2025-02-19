package Medium;

import java.util.*;

// Card class to represent a playing card
class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

// CardCollection class to manage the card collection
public class CardCollection {
    private static Map<String, List<Card>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addCard(String symbol, String value) {
        Card card = new Card(symbol, value);
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(card);
    }

    public static void searchCardsBySymbol(String symbol) {
        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards with symbol " + symbol + ": " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }

    public static void main(String[] args) {
        // Adding some default cards
        addCard("Hearts", "Ace");
        addCard("Hearts", "King");
        addCard("Spades", "Queen");
        addCard("Diamonds", "Jack");
        addCard("Clubs", "10");

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Search for Cards by Symbol");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Symbol (Hearts, Spades, Diamonds, Clubs): ");
                    String symbol = scanner.nextLine();
                    searchCardsBySymbol(symbol);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

