package rentalsystem2;

class MovieRental {

    private Movie _movie;
    private int _daysRented;

    public MovieRental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
    
    
}
