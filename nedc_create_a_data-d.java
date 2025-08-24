import java.util.*;
import java.io.*;

public class nedc_create_a_data_d {
    // Data structure to store chatbot responses
    HashMap<String, String> responses = new HashMap<>();

    // Method to load data from a file
    void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("::");
                if (parts.length == 2) {
                    responses.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Method to parse user input and respond
    String parseInput(String input) {
        input = input.trim().toLowerCase();
        if (responses.containsKey(input)) {
            return responses.get(input);
        } else {
            return "I didn't understand that. Please try again!";
        }
    }

    public static void main(String[] args) {
        nedc_create_a_data_d chatbot = new nedc_create_a_data_d();
        chatbot.loadData("chatbot_data.txt"); // Load data from a file

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the chatbot! Type 'quit' to exit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("Chatbot: " + chatbot.parseInput(input));
        }
    }
}