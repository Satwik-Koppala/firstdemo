package assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Song {
	
	private String title;
	private	String genre;
	private Date duration;
	private double rating;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

	public Song(String title, String genre, Date duration, Double rating) {
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	private static Song Createsong(String inputsong) throws ParseException {
		String[] split=inputsong.split(",");
		String title = split[0];
		String genre = split[1];
		
		Date duration =new SimpleDateFormat("mm:ss").parse(split[2]);
		String rate=split[3];
		double rating = Double.parseDouble(rate);
		Song s = new Song(title,genre, duration,rating);
		return s;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s %-10s %-12s %-12s\n",getTitle(),getGenre(),getDuration().getMinutes()+":"+getDuration().getSeconds(),getRating());
	}
	
	
	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of songs: ");
		int a=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Song");
		List<Song> songs = new ArrayList<Song>();
		for (int i = 0; i < a; i++) {
			String inputsong = scan.nextLine();
			songs.add(Createsong(inputsong));
		}
		
		System.out.println("Enter a type to sort:");
		System.out.println("1.Sort by Duration ");
		System.out.println("2.Sort by Rating ");
		int choice = scan.nextInt();
		
		//sort by Duration
		if (choice == 1) {
			Collections.sort(songs, (s1,s2)->{
				return s1.getDuration().compareTo(s2.getDuration());
			});
		} else if(choice == 2) {
			Collections.sort(songs, (s1, s2) -> {
				if (s1.getRating() < s2.getRating()) return -1;
		        if (s1.getRating() > s2.getRating()) return 1;
		        return 0;
			});
		}
		System.out.format("%-20s %-10s %-12s %-12s\n","Title","Genre","Duration","Rating");
		songs.forEach((ee)->{System.out.println(ee);});
	}
}
