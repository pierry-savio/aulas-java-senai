package entities;

import java.util.ArrayList;

public class RentalCompany {
	private ArrayList<Movie> movies = new ArrayList<>();

	public RentalCompany() {}
	
	public RentalCompany(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	public Movie getMovieByTitle(String title) {
		for (Movie movie : movies) {
			if (movie.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return movie;
			}
		}
		return null;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void removeMoveByTitle(String title) {
		for (int i = 0; i<movies.size(); i++) {
			if (movies.get(i).getTitle().equals(title)) {
				movies.remove(i);
			}
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for (int i = 0; i<movies.size(); i++) {
			result += "--FILME #" + (i+1) + "--\n" + movies.get(i) + "\n\n";
		}		
		return result;
	}
}
