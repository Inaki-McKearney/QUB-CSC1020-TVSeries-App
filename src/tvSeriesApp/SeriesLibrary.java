package tvSeriesApp;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesLibrary {

	private ArrayList<TVSeries> tvsList = new ArrayList<TVSeries>();
	private Scanner scan = new Scanner(System.in);

	public SeriesLibrary() {
		createTVSeriesArrayList();
	}

	public Data data = new Data();

	/*
	 * Method populate the ArrayList with TV series with data being obtained
	 * from the Data class
	 */
	private void createTVSeriesArrayList() {
		int numShows = data.getTitles().length;

		for (int i = 0; i < numShows; i++) {
			TVSeries tvs = new TVSeries();
			tvs.setTitle(data.getTitles()[i]);
			tvs.setRating(data.getRatings()[i]);
			tvs.setGenres(data.getGenres().get(i));
			tvs.setEpisodes(data.getEpisodes().get(i));
			tvs.setActors(data.getActors().get(i));
			tvs.setReviews(data.getReviews().get(i));
			tvsList.add(tvs);
		}
	}

	// Method to add a new TV Series
	public void addTVShow() {
		TVSeries tvs = new TVSeries();
		String input = "";
		// Adds the title
		addTitle(input, tvs);

		// Adds the rating
		addRating(input, tvs);

		// Adds the genres
		addGenres(input, tvs);

		// Adds the episodes
		addEpisodes(input, tvs);

		// Adds the actors
		addActors(input, tvs);

		// Adds the review
		addReviews(input, tvs);

		tvs.printDetails();
		this.tvsList.add(tvs);
	}

	/*
	 * Method to print the details of a TV Series with the ArrayList index
	 * passed in as a parameter
	 */
	public void printDetails(int i) {
		String tvRating;
		switch (tvsList.get(i).getRating()) {
		case TWELVE:
			tvRating = "12";
			break;
		case FIFTEEN:
			tvRating = "15";
			break;
		case EIGHTEEN:
			tvRating = "18";
			break;
		default:
			tvRating = tvsList.get(i).getRating().toString();
			break;
		}
		System.out.printf(
				"Title: %1$s\n" + "Rating: %2$s\n" + "Genres: %3$s\n" + "Episodes: %4$s\n" + "Actors: %5$s \n" + "Reviews: %6$s \n\n",
				tvsList.get(i).getTitle(), tvRating, tvsList.get(i).getGenre(), tvsList.get(i).getEpisodes(),
				tvsList.get(i).getActors(), tvsList.get(i).getReviews());
	}

	/*
	 * Method to print the details of all TV Series using a for loop
	 */
	public void printAllDetails() {
		for (int i = 0; i < tvsList.size(); i++) {
			printDetails(i);
		}
	}

	/*
	 * Prints the search menu for the various search options, receives a valid
	 * user input and calls the appropriate method
	 */
	public void search(Scanner sc) {
		System.out.println("Search for:");
		System.out.println("1: Title");
		System.out.println("2: Episodes");
		System.out.println("3: Actors");
		boolean valid = true;
		do {
			String option = "";
			valid = true;
			if (sc.hasNextLine() && valid)
				option = sc.nextLine();

			if (option.equals("1")) {
				searchTitle(sc);
			}

			else if (option.equals("2")) {
				searchEpisode(sc);
			}

			else if (option.equals("3")) {
				searchActor(sc);
			}

			else {
				valid = false;
				System.out.println("Please enter a value between 1 and 3:");
			}
		} while (!valid);
	}

	/*
	 * Used to search the TVSeries ArrayList for a title containing the value
	 * entered by the user. Blank space or a null value cancels the search.
	 * Prints the number of results found.
	 */
	private void searchTitle(Scanner sc) {
		System.out.println("Enter the title of the series: (leave blank to exit");
		String searchTitle = sc.nextLine();
		int results = 0;
		cancel: for (int i = 0; i < tvsList.size(); i++) {
			if (!notEmpty(searchTitle)) {
				System.out.println("Search cancelled");
				results = -1;
				break cancel;
			}
			if (tvsList.get(i).getTitle().toLowerCase().contains(searchTitle.trim().toLowerCase())) {
				System.out.println();
				printDetails(i);
				results++;
			}
		}
		if (results == 0)
			System.out.println("\nSeries not found");
		else if (results > 0)
			System.out.println("Results found: " + results);
	}

	/*
	 * Used to search the Episode ArrayList in the TVSeries ArrayList for an
	 * episode title containing the value entered by the user. Blank space or a
	 * null value cancels the search. Prints the number of results found.
	 */
	private void searchEpisode(Scanner sc) {
		System.out.println("Enter the title of the episode: (leave blank to exit)");
		String searchTitle = sc.nextLine();
		int results = 0;
		cancel: for (int i = 0; i < tvsList.size(); i++) {
			if (!notEmpty(searchTitle)) {
				System.out.println("Search cancelled");
				results = -1;
				break cancel;
			}
			for (int j = 0; j < tvsList.get(i).getEpisodes().size(); j++) {
				if (tvsList.get(i).getEpisodes().get(j).toLowerCase().contains(searchTitle.trim().toLowerCase())) {
					System.out.println("\nFound: \"" + tvsList.get(i).getEpisodes().get(j) + "\"");
					printDetails(i);
					results++;
				}
			}
		}
		if (results == 0)
			System.out.println("Episode not found");
		else if (results > 0)
			System.out.println("Results found: " + results);
	}

	/*
	 * Used to search the Actor ArrayList in the TVSeries ArrayList for an actor
	 * name containing the value entered by the user. Blank space or a null
	 * value cancels the search. Prints the number of results found.
	 */
	private void searchActor(Scanner sc) {
		System.out.println("Enter the name of the actor: (leave blank to exit)");
		String searchTitle = sc.nextLine();
		int results = 0;
		cancel: for (int i = 0; i < tvsList.size(); i++) {
			if (!notEmpty(searchTitle)) {
				System.out.println("Search cancelled");
				results = -1;
				break cancel;
			}
			for (int j = 0; j < tvsList.get(i).getActors().size(); j++) {
				if (tvsList.get(i).getActors().get(j).toLowerCase().contains(searchTitle.trim().toLowerCase())) {
					System.out.println("\nFound: \"" + tvsList.get(i).getActors().get(j) + "\"");
					printDetails(i);
					results++;
				}
			}
		}
		if (results == 0)
			System.out.println("Episode not found");
		else if (results > 0)
			System.out.println("Results found: " + results);
	}

	/*
	 * Prints each value of the Rating enum along with an increment for the user
	 * to select their option as a multiple choice
	 */
	private void printRatingList() {
		int ratingID = 1;
		for (Rating tvRating : Rating.values()) {
			String rating;
			switch (tvRating) {
			case TWELVE:
				rating = "12";
				break;
			case FIFTEEN:
				rating = "15";
				break;
			case EIGHTEEN:
				rating = "18";
				break;
			default:
				rating = tvRating.toString();
				break;
			}
			System.out.println(ratingID + ": " + rating);
			ratingID++;
		}
	}

	/*
	 * Prints each value of the Genre enum along with an increment for the user
	 * to select their option as a multiple choice
	 */
	private void printGenreList() {
		int genreID = 1;
		for (Genre gen : Genre.values()) {
			System.out.println(genreID + ": " + gen);
			genreID++;
		}
	}

	/*
	 * Validates the input brought in as a parameter and sets it as the title
	 * for the TVSeries object brought in as a parameter
	 */
	private void addTitle(String input, TVSeries tvs) {
		System.out.println("\nEnter the title of the new TV Series:");
		input = scan.nextLine();
		while (!notEmpty(input)) {
			System.out.println("Invalid input: Enter the title:");
			input = scan.nextLine();
		}
		tvs.setTitle(input);
	}

	/*
	 * Prints Validates the input brought in as a parameter and uses it to
	 * select a rating to set as the rating for the TVSeries object brought in
	 * as a parameter
	 */
	private void addRating(String input, TVSeries tvs) {
		printRatingList();
		System.out.println("Enter the ID of the rating you want to add: ");
		input = scan.nextLine();
		while (!notEmpty(input) || !isInt(input)
				|| (Integer.parseInt(input) < 1 || Integer.parseInt(input) > Rating.values().length)) {
			System.out.println("Error: Enter an integer between 1 and " + Rating.values().length);
			input = scan.nextLine();
		}
		tvs.setRating(Rating.values()[Integer.parseInt(input) - 1]);
	}

	/*
	 * Validates the input brought in as a parameter and uses it to select a
	 * genre to set as the genre for the TVSeries object brought in as a
	 * parameter. Three genres must be selected, even if none selected for all
	 */
	private void addGenres(String input, TVSeries tvs) {
		printGenreList();
		ArrayList<Genre> genre = new ArrayList<Genre>();
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the id of the genre you want to add:");
			input = scan.nextLine();
			while (!notEmpty(input) || !isInt(input)
					|| (Integer.parseInt(input) < 1 || Integer.parseInt(input) > Genre.values().length)) {
				System.out.println("Error: Enter an integer between 1 and " + Genre.values().length);
				input = scan.nextLine();
			}
			genre.add(Genre.values()[(Integer.parseInt(input) - 1)]);
		}
		tvs.setGenres(genre);
	}

	/*
	 * Validates the input brought in as a parameter and uses it to set as the
	 * episode title for the TVSeries object brought in as a parameter. The user
	 * is prompted for multiple titles. Leaving input blank after one has been
	 * added will close the method.
	 */
	private void addEpisodes(String input, TVSeries tvs) {
		System.out.println("\nEnter the episodes(hitting enter between each)");
		ArrayList<String> episodes = new ArrayList<String>();
		while (episodes.size() >= 0) {
			System.out.println("Enter episode name(Leave blank to stop):");
			input = scan.nextLine();
			if (notEmpty(input)) {
				episodes.add(input);
				System.out.println("Episode added");
			}
			cancel: while (!notEmpty(input) && episodes.size() == 0) {
				System.out.println("Enter at least one episode title:");
				input = scan.nextLine();
				if (notEmpty(input)) {
					episodes.add(input);
					System.out.println("Episode added");
					break cancel;
				}
			}
			if (!notEmpty(input) && episodes.size() > 0)
				break;
		}
		tvs.setEpisodes(episodes);
	}

	/*
	 * Validates the input brought in as a parameter and uses it to set as the
	 * actor name for the TVSeries object brought in as a parameter. The user is
	 * prompted for multiple names. Leaving input blank after one has been added
	 * will close the method.
	 */
	private void addActors(String input, TVSeries tvs) {
		System.out.println("\nEnter the actors:");
		ArrayList<String> actors = new ArrayList<String>();
		while (actors.size() >= 0) {
			System.out.println("Enter actor name(Leave blank to stop):");
			input = scan.nextLine();
			if (notEmpty(input)) {
				actors.add(input);
				System.out.println("Actor added");
			}
			cancel: while (!notEmpty(input) && actors.size() == 0) {
				System.out.println("Enter at least one actor name:");
				input = scan.nextLine();
				if (notEmpty(input)) {
					actors.add(input);
					System.out.println("Actor added");
					break cancel;
				}
			}
			if (!notEmpty(input) && actors.size() > 0)
				break;
		}
		tvs.setActors(actors);
	}

	/*
	 * Validates the input brought in as a parameter and uses it to set as the
	 * review for the TVSeries object brought in as a parameter. The user is
	 * prompted for multiple reviews. Leaving input blank after one has been
	 * added will close the method.
	 */
	private void addReviews(String input, TVSeries tvs) {
		System.out.println("\nEnter a Review(0-100)");
		ArrayList<Integer> reviews = new ArrayList<Integer>();
		while (reviews.size() >= 0) {
			System.out.println("Enter review(Leave blank to stop):");
			input = scan.nextLine();

			if (notEmpty(input)) {
				int intInput = (convertToInt(input, 0, 100));
				if (intInput >= 0 && intInput <= 100 && isInt(input)) {
					reviews.add(intInput);
					System.out.println("Review added");
				} else if (reviews.size() >= 0)
					System.out.println("Error: Enter an integer between 0 and 100");
			}
			cancel: while (!notEmpty(input) && reviews.size() == 0) {
				System.out.println("Enter at least one review:");
				input = scan.nextLine();

				int intInput = (convertToInt(input, 0, 100));
				if ((intInput >= 0 && intInput <= 100) && isInt(input)) {
					reviews.add(intInput);
					System.out.println("Review added");
					break cancel;
				}
			}
			if (!notEmpty(input) && reviews.size() > 0) {
				break;

			}
			tvs.setReviews(reviews);
		}
	}

	/*
	 * Prints the tvsList as well as an ID increment for each. Validates the
	 * input and uses it to add a new review to the TVSeries object selected by
	 * the user. Leaving input blank after one has been added will close the
	 * method without adding a review.
	 */
	public void addNewReview() {
		int tvsID = 1;
		for (int i = 0; i < tvsList.size(); i++) {
			System.out.printf("%1$s:\nTitle: %2$s\n" + "Reviews: %3$s \n\n", tvsID, tvsList.get(i).getTitle(), tvsList.get(i).getReviews());
			tvsID++;
		}
		System.out.println("Enter the id of the series you want to review:");
		String selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.size())) {

			System.out.println("Error: Enter an integer between 1 and " + tvsList.size());
			selection = scan.nextLine();
		}
		int selectionID = Integer.parseInt(selection) - 1;

		System.out.println(
				"Enter the review for \"" + tvsList.get(selectionID).getTitle() + "\" (leave blank to cancel)");
		String newReview = scan.nextLine();
		cancel: if (notEmpty(newReview)) {
			while (!isInt(newReview) || (Integer.parseInt(newReview) < 0 || Integer.parseInt(newReview) > 100)) {
				if (!notEmpty(newReview)) {
					System.out.println("Review not added");
					break cancel;
				}
				System.out.println("Error: Enter an integer between 0 and 100");
				newReview = scan.nextLine();
			}
			tvsList.get(selectionID).getReviews().add(Integer.parseInt(newReview));
			System.out.println("Review successfully added");
			System.out.println("\nThe reviews for \"" + tvsList.get(selectionID).getTitle() + "\" are:\n"
					+ tvsList.get(selectionID).getReviews());

		} else
			System.out.println("Review not added");
	}

	/*
	 * Method to edit the TV Series details. The tvsList is printed with an ID
	 * increment for each. The list of attributes is also printed with an ID
	 * increment for each. The user selects both the TVSeries and the attribute
	 * they want to edit as a multiple choice. After validation, the appropriate
	 * method is then called.
	 */
	public void editDetails() {
		int tvsID = 1;
		for (int i = 0; i < tvsList.size(); i++) {
			String rating;
			switch (tvsList.get(i).getRating()) {
			case TWELVE:
				rating = "12";
				break;
			case FIFTEEN:
				rating = "15";
				break;
			case EIGHTEEN:
				rating = "18";
				break;
			default:
				rating = tvsList.get(i).getRating().toString();
				break;
			}
			System.out.printf(
					"%7$s:\nTitle: %1$s\n" + "Rating: %2$s\n" + "Genres: %3$s\n" + "Episodes: %4$s\n" + "Actors: %5$s \n" + "Reviews: %6$s \n\n",
					tvsList.get(i).getTitle(), rating, tvsList.get(i).getGenre(), tvsList.get(i).getEpisodes(),
					tvsList.get(i).getActors(), tvsList.get(i).getReviews(), tvsID);
			tvsID++;
		}

		// Ensures user input is of type int and between 0 and the size of the
		// ArrayList
		System.out.println("Enter the id of the series you want to edit:");
		String selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.size())) {
			System.out.println("Error: Enter an integer between 1 and " + tvsList.size());
			selection = scan.nextLine();
		}
		// use this value to select the TV Series
		tvsID = Integer.parseInt(selection) - 1;
		System.out.println(
				"\nEnter the id of the value you want to edit\n1: Title\n2: Genres\n3: Rating\n4: Episodes\n5: Actors\n6: Reviews\n");
		selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 6)) {

			System.out.println("Error: Enter an integer between 1 and 6");
			selection = scan.nextLine();
		}
		int attributeID = Integer.parseInt(selection);
		switch (attributeID) {
		case 1:
			editTitle(tvsID);
			break;

		case 2:
			editGenre(tvsID);
			break;

		case 3:
			editRating(tvsID);
			break;

		case 4:
			editEpisode(tvsID);

			break;

		case 5:
			editActor(tvsID);
			break;

		case 6:
			editReview(tvsID);
			break;
		}
	}

	/*
	 * Uses a parameter to determine which series is to be edited. Prints list
	 * of actors for the series with ID increments. User selects the actor to
	 * edit by the ID. The validated input is then set to that position in the
	 * actor ArrayList.
	 */
	private void editActor(int tvsID) {
		int selectionID = 1;
		for (int i = 0; i < tvsList.get(tvsID).getActors().size(); i++) {
			System.out.println(selectionID + ": " + tvsList.get(tvsID).getActors().get(i));
			selectionID++;
		}

		System.out.println("Enter the id of the actor you want to change:");
		String selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.get(tvsID).getActors().size())) {
			System.out.println("Error: Enter an integer between 1 and " + tvsList.get(tvsID).getActors().size());
			selection = scan.nextLine();
		}
		selectionID = Integer.parseInt(selection) - 1;

		System.out.println("Enter the ammended actor name for \"" + tvsList.get(tvsID).getTitle() + "\" (leave blank to cancel)");
		System.out.println("The current actor is: \"" + tvsList.get(tvsID).getActors().get(selectionID) + "\"");
		selection = scan.nextLine();
		if (notEmpty(selection)) {
			tvsList.get(tvsID).getActors().set(selectionID, selection);
			System.out.println("Actor successfully changed to " + tvsList.get(tvsID).getActors().get(selectionID));
		} else
			System.out.println("Episode title remains unchanged");
	}

	/*
	 * Uses a parameter to determine which series is to be edited. User inputs
	 * the new title for the TV Series and the validated input is set as the new
	 * title.
	 */
	private void editTitle(int tvsID) {
		System.out.println("Enter the new title for \"" + tvsList.get(tvsID).getTitle() + "\" (leave blank to cancel)");
		String selection = scan.nextLine();
		if (notEmpty(selection)) {
			tvsList.get(tvsID).setTitle(selection);
			System.out.println("Title successfully changed to \"" + tvsList.get(tvsID).getTitle() + "\"");
		} else
			System.out.println("Title remains unchanged");
	}

	/*
	 * Uses a parameter to determine which series is to be edited. Prints list
	 * of genres for the series with ID increments. User selects the genre to
	 * edit by the ID. The user then selects the genre to replace it by from a
	 * list of genres.
	 */
	private void editGenre(int tvsID) {
		System.out.println("Enter the ID of the genre you want to change");
		int selectionID = 1;
		for (int i = 0; i < tvsList.get(tvsID).getGenre().size(); i++) {
			System.out.println(selectionID + ": " + tvsList.get(tvsID).getGenre().get(i));
			selectionID++;
		}
		String selection = scan.nextLine();
		while (!notEmpty(selection) || !isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.get(tvsID).getGenre().size())) {
			System.out.println("Error: Enter an integer between 1 and " + tvsList.get(tvsID).getGenre().size());
			selection = scan.nextLine();
		}
		selectionID = Integer.parseInt(selection) - 1;

		printGenreList();
		System.out.println("Enter the id of the new genre for: " + tvsList.get(tvsID).getTitle());
		selection = scan.nextLine();
		while (!notEmpty(selection) || !isInt(selection)|| (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > Genre.values().length)) {
			System.out.println("Error: Enter an integer between 1 and " + Genre.values().length);
			selection = scan.nextLine();
		}
		if (notEmpty(selection)) {
			tvsList.get(tvsID).getGenre().set(selectionID, Genre.values()[(Integer.parseInt(selection) - 1)]);
			System.out.println("Genre successfully changed to " + tvsList.get(tvsID).getGenre().get(selectionID));
		}
	}

	/*
	 * Uses a parameter to determine which series is to be edited. Prints list
	 * of ratings for the series with ID increments. User selects the rating to
	 * edit by the ID. The user then selects the rating to replace it by from a
	 * list of ratings.
	 */
	private void editRating(int tvsID) {
		printRatingList();
		System.out.println("Enter the id of the new rating for: " + tvsList.get(tvsID).getTitle());
		String selection = scan.nextLine();
		while (!notEmpty(selection) || !isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > Rating.values().length)) {
			System.out.println("Error: Enter an integer between 1 and " + Genre.values().length);
			selection = scan.nextLine();
		}
		System.out.println("Enter the new rating for \"" + tvsList.get(tvsID).getTitle() + "\" (leave blank to cancel)");
		System.out.println("The current rating is: \"" + tvsList.get(tvsID).getRating() + "\"");
		if (notEmpty(selection)) {
			tvsList.get(tvsID).setRating(Rating.values()[(Integer.parseInt(selection) - 1)]);
			System.out.println("Rating successfully changed to " + tvsList.get(tvsID).getRating());
		} else
			System.out.println("Rating remains unchanged");
	}

	/*
	 * Uses a parameter to determine which series is to be edited. Prints list
	 * of episodes for the series with ID increments. User selects the episode
	 * to edit by the ID. The user input is then validated and set as the
	 * episode title at that index.
	 */
	private void editEpisode(int tvsID) {
		int selectionID = 1;
		for (int i = 0; i < tvsList.get(tvsID).getEpisodes().size(); i++) {
			System.out.println(selectionID + ": " + tvsList.get(tvsID).getEpisodes().get(i));
			selectionID++;
		}

		System.out.println("Enter the id of the episode you want to change:");
		String selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.get(tvsID).getEpisodes().size())) {
			System.out.println("Error: Enter an integer between 1 and " + tvsList.get(tvsID).getEpisodes().size());
			selection = scan.nextLine();
		}
		selectionID = Integer.parseInt(selection) - 1;

		System.out.println("Enter the ammended episode title for \"" + tvsList.get(tvsID).getTitle() + "\" (leave blank to cancel)");
		System.out.println("The current title is: \"" + tvsList.get(tvsID).getEpisodes().get(selectionID) + "\"");
		selection = scan.nextLine();
		if (notEmpty(selection)) {
			tvsList.get(tvsID).getEpisodes().set(selectionID, selection);
			System.out.println(
					"Episode title successfully changed to " + tvsList.get(tvsID).getEpisodes().get(selectionID));
		} else
			System.out.println("Episode title remains unchanged");
	}

	/*
	 * Uses a parameter to determine which series is to be edited. Prints list
	 * of reviews for the series with ID increments. User selects the review to
	 * edit by the ID. The user input is then validated and set as the series
	 * review at that index.
	 */
	private void editReview(int tvsID) {
		int selectionID = 1;
		for (int i = 0; i < tvsList.get(tvsID).getReviews().size(); i++) {
			System.out.println(selectionID + ": " + tvsList.get(tvsID).getReviews().get(i));
			selectionID++;
		}

		System.out.println("Enter the id of the review you want to change:");
		String selection = scan.nextLine();
		while (!isInt(selection) || (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > tvsList.get(tvsID).getReviews().size())) {
			System.out.println("Error: Enter an integer between 1 and " + tvsList.get(tvsID).getReviews().size());
			selection = scan.nextLine();
		}
		selectionID = Integer.parseInt(selection) - 1;

		System.out.println("Enter the ammended review for \"" + tvsList.get(tvsID).getTitle() + "\" (leave blank to cancel)");
		System.out.println("To replace: \"" + tvsList.get(tvsID).getReviews().get(selectionID) + "\"");
		selection = scan.nextLine();
		cancel: if (notEmpty(selection)) {
			while (!isInt(selection) || (Integer.parseInt(selection) < 0 || Integer.parseInt(selection) > 100)) {
				if (!notEmpty(selection)) {
					System.out.println("Rating remains unchanged");
					break cancel;
				}
				System.out.println("Error: Enter an integer between 0 and 100");
				selection = scan.nextLine();
			}
			tvsList.get(tvsID).getReviews().set(selectionID, Integer.parseInt(selection));
			System.out.println("Review successfully changed to " + tvsList.get(tvsID).getReviews().get(selectionID));
		} else
			System.out.println("Rating remains unchanged");
	}

	/*
	 * Method that receives a string and min and max values. Returns an int if
	 * the String can be converted to int and is between the min and max.
	 */
	private int convertToInt(String input, int min, int max) {
		int value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
		}
		return value;
	}

	/*
	 * Method to return true if the string can be converted to type int
	 */
	private boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 * Method to return false if the input contains only whitespace or is null
	 */
	private boolean notEmpty(String input) {
		if (input.trim().length() > 0)
			return true;
		else
			return false;
	}
}
