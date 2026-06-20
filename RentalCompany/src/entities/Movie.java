package entities;

public class Movie {
	private String title;
	private Genre genre;
	private int releaseYear;
	
	public Movie(String title, Genre genre, int releaseYear) {
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	@Override
	public String toString() {
		return title.toUpperCase() + " (" + releaseYear + ")\nGenre: " + genre;
	}
}
