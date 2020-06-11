package Classes;

import java.util.Comparator;

public class Movie {
    private MovieCollection b = new MovieCollection();
    private String movieTitle, starring, director, genre, classification, releaseDate;
    private int duration;
    private int timesBorrowed, copies;

    public Movie() {
        movieTitle = "";
        starring = new String("");
        director = new String("");
        duration = 0;
        genre = new String("");
        classification = new String("");
        releaseDate = new String("");
        timesBorrowed = 0;
        copies = 0;
    }

    public void addCopy() {
        copies++;
    }

    public void removeCopy() {
        copies--;
    }

    public Movie (String movieTitle, String starring, String director,
                  String genre, String classification,
                  int duration, String releaseDate, int timesBorrowed) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.starring = starring;
        this.genre = genre;
        this.classification = classification;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.timesBorrowed = timesBorrowed;
        this.copies = 1;
    }

    @Override
    public String toString() {
        return(String.format(movieTitle));
    }

    public static Comparator<Movie> MovieTitleComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            String MovieTitle1 = o1.getMovieTitle().toUpperCase();
            String MovieTitle2 = o2.getMovieTitle().toUpperCase();
            return MovieTitle1.compareTo(MovieTitle2);
        }
    };

    public String getMovieTitle() {  return movieTitle; }
    public String getStarring() {  return starring; }
    public String getDirector() { return director; }
    public int getDuration() { return duration; }
    public String getGenre() { return genre; }
    public String getClassification() { return classification; }
    public String getReleaseDate() { return releaseDate; }
    public int getTimesBorrowed() { return timesBorrowed; }
    public void setTimesBorrowed() { timesBorrowed++; }
    public int getCopies() { return copies; }
}
