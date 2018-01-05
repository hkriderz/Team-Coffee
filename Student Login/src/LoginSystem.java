import java.io.*;
import java.util.Scanner;

public class LoginSystem {

	public static final File database = new File("database.txt");

	public static final Scanner userInput = new Scanner(System.in);

	// Ask the user if they are registered.
	public static void main(final String[] args) {

		if (!database.exists()) {
			System.out.println("The database.txt file does not exist. Registering first user...");
			registerUser();
		}

		while (userInput.hasNext()) {

			System.out.println("Would you like to login or register a user?");

			String input = userInput.next().trim().toLowerCase();

			if (input.equalsIgnoreCase("end") || input.equalsIgnoreCase("exit")) {
				System.out.println("Exiting...");
				System.exit(0);
			}

			if (input.contains("log")) {
				login();
			} else if (input.contains("reg") || input.contains("add")) {
				registerUser();
			} else {
				System.out.println("Sorry, input not valid. Please type either \"register\" or \"login\".");
			}

		}

	}

	private static void prompt(final String prompt) {
		System.out.print(prompt);
	}

	public static void registerUser() {
		PrintWriter outputFile = new PrintWriter("database.txt");
		
		prompt("Please enter your username for the database: ");
		String username = userInput.nextLine();
		outputFile.println(username);
		
		prompt("Please enter your ID for the database: ");
		int id = userInput.nextInt();
		outputFile.println(id);
		
		outputFile.close();
	}

	public static void login() {
		prompt("Please enter your username: ");
		String username = userInput.next().trim();

		prompt("Please enter your id number: ");
		int id = userInput.nextInt();
	}

}
