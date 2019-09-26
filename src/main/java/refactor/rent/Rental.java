package refactor.rent;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    protected double getCharge(){
        return movie.getCharge(daysRented);
    }

    protected int getFrequentRenterPoints(){
       return movie.getFrequentRenterPoints(daysRented);
    }

}
