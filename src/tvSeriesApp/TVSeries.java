package tvSeriesApp;

import java.util.ArrayList;

public class TVSeries {

	private String title;
	private Rating rating;
	private ArrayList<Genre> genres = new ArrayList<Genre>();
	private ArrayList<String> episodes = new ArrayList<String>();
	private ArrayList<String> actors = new ArrayList<String>();
	private ArrayList<Integer> reviews = new ArrayList<Integer>();

	// CONSTRUCTOR
	public TVSeries(String title, Rating rating, ArrayList<Genre> genres, ArrayList<String> episodes,
			ArrayList<String> actors, ArrayList<Integer> reviews) {
		this.title = title;
		this.rating = rating;
		this.genres = new ArrayList<Genre>(genres);
		this.episodes = new ArrayList<String>(episodes);
		this.actors = new ArrayList<String>(actors);
		this.reviews = new ArrayList<Integer>(reviews);
	}

	public TVSeries() {
	}

	// Print details method
	public void printDetails() {
		String tvRating;
		switch (this.rating) {
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
			tvRating = rating.toString();
			break;
		}
		System.out.printf("Title: %1$s\n" + "Genres: %2$s\n" + "Rating: %3$s\n" + "Episodes: %4$s\n" + "Actors: %5$s \n"
				+ "Reviews: %6$s", this.title, this.genres, tvRating, this.episodes, this.actors, this.reviews);
	}

	// ACCESSORS
	public String getTitle() {
		return title;
	}

	public ArrayList<Genre> getGenre() {
		return genres;
	}

	public Rating getRating() {
		return rating;
	}

	public ArrayList<String> getEpisodes() {
		return episodes;
	}

	public ArrayList<String> getActors() {
		return actors;
	}

	public ArrayList<Integer> getReviews() {
		return reviews;
	}

	// MUTATORS
	public void setTitle(String title) {
		this.title = title;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void setEpisodes(ArrayList<String> episodes) {
		this.episodes = episodes;
	}

	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}

	public void setReviews(ArrayList<Integer> reviews) {
		this.reviews = reviews;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
}
