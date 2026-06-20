package application;
import java.util.Scanner;
import entities.Genre;
import entities.Movie;
import entities.RentalCompany;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RentalCompany rentalCompany = new RentalCompany();
		
		cleanScreen();
		
		System.out.print("Quantidade de filmes: ");
		int quantity = sc.nextInt();
		
		cleanScreen();
		
		for (int i = 0; i<quantity; i++) {
			System.out.println("FILME #" + (i+1));
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			System.out.println("Gênero: ");
			System.out.println("   1 - Ação");
			System.out.println("   2 - Aventura");
			System.out.println("   3 - Comédia");
			System.out.println("   4 - Drama");
			System.out.println("   5 - Horror");
			System.out.print("N: ");
			int genreN = sc.nextInt();
			Genre genre = Genre.GENRELESS;
			
			switch (genreN) {
				case 1: genre = Genre.ACTION; break;
				case 2: genre = Genre.ADVENTURE; break;
				case 3: genre = Genre.COMEDY; break;
				case 4: genre = Genre.DRAMA; break;
				case 5: genre = Genre.HORROR; break;
			}
			System.out.print("Lançamento: ");
			int releaseYear = sc.nextInt();
			
			rentalCompany.addMovie(new Movie(title, genre, releaseYear));
			
			cleanScreen();
		}
		
		System.out.println("");
		
		System.out.println("---CATÁLOGO---");
		System.out.println();
		System.out.println(rentalCompany);
		System.out.print("Pesquisar título ('s' para sair): ");
		sc.nextLine();
		String title = sc.nextLine();
		
		cleanScreen();
		
		while (!title.equals("s")) {
			Movie movie = rentalCompany.getMovieByTitle(title);
			if (movie != null) {
				System.out.println(movie);
			}
			else {
				System.out.println("Filme não encontrado!");
			}
			System.out.println();
			System.out.print("Pesquisar título ('s' para sair): ");
			title = sc.nextLine();
			cleanScreen();
		}
		System.out.println("Catálogo fechado!");
		sc.close();
	}
	
	public static void cleanScreen() {
		for (int i = 0; i<80; i++) {System.out.println();}
	}
	public static void cleanScreen(int lines) {
		for (int i = 0; i<lines; i++) {System.out.println();}
	}
}
