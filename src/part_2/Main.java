package part_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TriviaNightCollection triviaNightCollection = new TriviaNightCollection(10);

		System.out.println("Welcome to the Trivia Night Database!");
		int choice;

		do {
			System.out.println("Choose an option to proceed:");
			System.out.println("1 - Add a Trivia Night event");
			System.out.println("2 - Print all Trivia Night events");
			System.out.println("3 - Sort Trivia Night events by number of participants");
			System.out.println("4 - Search Trivia Night events by event name or description");
			System.out.println("0 - Exit the program");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					inputItems(triviaNightCollection);
					break;
				case 2:
					triviaNightCollection.print();
					break;
				case 3:
					triviaNightCollection.sort();
					System.out.println("Trivia Night events sorted by number of participants.");
					break;
				case 4:
					System.out.print("Enter a search keyword: ");
					String keyword = scanner.nextLine();
					search(keyword, triviaNightCollection);
					break;
				case 0:
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		scanner.close();
	}

	public static void inputItems(TriviaNightCollection triviaNightCollection) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Adding a new Trivia Night event to the collection:");
		System.out.print("Event Name: ");
		String eventName = scanner.nextLine();
		System.out.print("Event Date: ");
		String eventDate = scanner.nextLine();
		System.out.print("Number of Participants: ");
		int numberOfParticipants = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		System.out.print("Main Theme: ");
		String mainTheme = scanner.nextLine();
		System.out.print("Register URL: ");
		String registerUrl = scanner.nextLine();
		System.out.print("Chat URL: ");
		String chatUrl = scanner.nextLine();
		System.out.print("Event Location: ");
		String eventLocation = scanner.nextLine();
		System.out.print("Event Description File Path: ");
		String descriptionFilePath = scanner.nextLine();

		TriviaNight newEvent = new TriviaNight(eventName, eventDate, numberOfParticipants, mainTheme,
				registerUrl, chatUrl, eventLocation, descriptionFilePath);
		triviaNightCollection.add(newEvent);
		System.out.println("Trivia Night event added to the collection.");
	}

	public static void search(String keyword, TriviaNightCollection triviaNightCollection) {
		System.out.println("Searching for Trivia Night events containing: " + keyword);
		triviaNightCollection.find(keyword);
	}
}
