package tvSeriesApp;

import java.util.Scanner;

public class RatingApp {

	public static SeriesLibrary sLibrary = new SeriesLibrary();

	// Prints menu once at the beginning
	public static void main(String[] args) {
		printMenu();
	}

	private static void printMenu() {
		System.out.println("-----TV Series Ratings-----");
		System.out.println("Enter a key:");
		System.out.println("1 - Add a TV Series");
		System.out.println("2 - Edit TV Series details");
		System.out.println("3 - Rate a TV Series");
		System.out.println("4 - Browse TV Series");
		System.out.println("5 - Search TV Series");
		System.out.println("6 - Exit the application");
		System.out.println("---------------------------");

		Scanner sc = new Scanner(System.in);

		// Validation and option selection
		boolean valid = true;
		do {
			String option = "";
			valid = true;
			if (sc.hasNextLine() && valid)
				option = sc.nextLine();

			// Add a TV Series
			if (option.equals("1"))
				sLibrary.addTVShow();

			// Edit TV Series Details
			else if (option.equals("2"))
				sLibrary.editDetails();

			// Rate a TV Series
			else if (option.equals("3"))
				sLibrary.addNewReview();

			// Browse TV Series
			else if (option.equals("4"))
				sLibrary.printAllDetails();

			// Search TV Series
			else if (option.equals("5"))
				sLibrary.search(sc);

			// Exit the application
			else if (option.equals("6")) {
				System.out.println("Application successfully closed");
				sc.close();
				System.exit(0);
			}

			// Invalid input
			else {
				valid = false;
				System.out.println("Please enter a value between 1 and 6:");
			}
		} while (!valid);

		// Prints menu every time the methods have finished
		System.out.println("\n\n");
		printMenu();
	}
}
