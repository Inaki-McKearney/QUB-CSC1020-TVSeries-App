package tvSeriesApp;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
	// Declares and Initialises the title and ratings arrays
	private String[] titles = { "Breaking Bad", "Stranger Things", "Planet Earth II", "Archer" };
	private Rating[] ratings = { Rating.EIGHTEEN, Rating.FIFTEEN, Rating.PG, Rating.EIGHTEEN };
	
	// Declares the ArrayLists
	private ArrayList<ArrayList<Genre>> genres = new ArrayList<ArrayList<Genre>>();
	private ArrayList<ArrayList<String>> episodes = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> actors = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<Integer>> reviews = new ArrayList<ArrayList<Integer>>();

	public Data() {
		// Adds data to the ArrayList of the genres ArrayList
		ArrayList<Genre> genreArray = new ArrayList<Genre>(Arrays.asList(Genre.Crime, Genre.Drama, Genre.Thriller));
		genres.add(genreArray);
		genreArray = new ArrayList<Genre>(Arrays.asList(Genre.Drama, Genre.Fantasy, Genre.Horror));
		genres.add(genreArray);
		genreArray = new ArrayList<Genre>(Arrays.asList(Genre.Documentary, Genre.None, Genre.None));
		genres.add(genreArray);
		genreArray = new ArrayList<Genre>(Arrays.asList(Genre.Animation, Genre.Action, Genre.Comedy));
		genres.add(genreArray);

		// Adds data to the ArrayList of the episodes ArrayList
		ArrayList<String> array = new ArrayList<String>(
				Arrays.asList("Pilot", "Cat's in the Bag...", "...And the Bag's in the River"));
		episodes.add(array);
		array = new ArrayList<String>(
				Arrays.asList("The Vanishing of Will Byers", "The Weirdo on Maple Street", "Holly Jolly"));
		episodes.add(array);
		array = new ArrayList<String>(
				Arrays.asList("Islands", "Mountains", "Jungles", "Deserts", "Grasslands", "Cities"));
		episodes.add(array);
		array = new ArrayList<String>(Arrays.asList("Mole Hunt", "Training Day", "Diversity Hire", "Killing Utne",
				"Honeypot", "Skorpio", "Skytanic", "The Rock", "Job Offer", "Dial M for Mother"));
		episodes.add(array);

		// Adds data to the ArrayList of the actors ArrayList
		array = new ArrayList<String>(Arrays.asList("Bryan Cranston", "Aaron Paul", "Anna Gunn"));
		actors.add(array);
		array = new ArrayList<String>(Arrays.asList("Winona Ryder", "David Harbour", "Finn Wolfhard"));
		actors.add(array);
		array = new ArrayList<String>(Arrays.asList("David Attenborough"));
		actors.add(array);
		array = new ArrayList<String>(Arrays.asList("H. Jon Benjamin", "Judy Greer", "Amber Nash", "Chris Parnell",
				"Aisha Tyler", "Jessica Walter", "Adam Reed", "Lucky Yates"));
		actors.add(array);

		// Adds data to the ArrayList of the reviews ArrayList
		ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(92, 97, 93, 94, 98, 94, 93));
		reviews.add(intArray);
		intArray = new ArrayList<Integer>(Arrays.asList(92, 89, 93, 94, 87, 94, 90));
		reviews.add(intArray);
		intArray = new ArrayList<Integer>(Arrays.asList(99, 98, 100, 99, 97, 100, 99));
		reviews.add(intArray);
		intArray = new ArrayList<Integer>(Arrays.asList(92, 91, 87, 89, 85, 88, 89));
		reviews.add(intArray);

	}

	// ACCESSORS AND MUTATORS
	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public Rating[] getRatings() {
		return ratings;
	}

	public void setRatings(Rating[] ratings) {
		this.ratings = ratings;
	}

	public ArrayList<ArrayList<Genre>> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<ArrayList<Genre>> genres) {
		this.genres = genres;
	}

	public ArrayList<ArrayList<String>> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(ArrayList<ArrayList<String>> episodes) {
		this.episodes = episodes;
	}

	public ArrayList<ArrayList<String>> getActors() {
		return actors;
	}

	public void setActors(ArrayList<ArrayList<String>> actors) {
		this.actors = actors;
	}

	public ArrayList<ArrayList<Integer>> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<ArrayList<Integer>> reviews) {
		this.reviews = reviews;
	}
}
