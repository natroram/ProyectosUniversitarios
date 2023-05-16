package rentalsystem2;

import java.util.*;

class Customer {

    public String _name;
    private final ArrayList<MovieRental> _movieRentals;
    private final ArrayList<VideoGameRental> _videoGameRental; 
    public Customer(String name) {
        this._videoGameRental = new ArrayList<>();
        this._movieRentals = new ArrayList<>();
        _name = name;
    }

    public void addMovieRental(MovieRental arg) {
        _movieRentals.add(arg);
    }

    public void addVideoGameRental(VideoGameRental arg) {
        _videoGameRental.add(arg);
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + _name + "\n";

//        _movieRentals.forEach((mov) -> {
        Iterator<MovieRental> movIterator = _movieRentals.iterator();
        Iterator<VideoGameRental> gameIterator = _videoGameRental.iterator();
        
        while (movIterator.hasNext()) {
            MovieRental mov = movIterator.next();
            double thisAmount = 0;
    		
            // determine amounts for each line
            switch (mov.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (mov.getDaysRented() > 2)
                        thisAmount += (mov.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += mov.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (mov.getDaysRented() > 3)
                        thisAmount += (mov.getDaysRented() - 3) * 1.25;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((mov.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && mov.getDaysRented() > 1) frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + mov.getMovie()._title+ "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        while (gameIterator.hasNext()) {
            VideoGameRental game = gameIterator.next();
        
            frequentRenterPoints += game.getFrequentRenterPoints();
            result += "\t" + game.getVideoGame() + "\t"
            		+ String.valueOf(game.getCharge()) + "\n";
            totalAmount += game.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
