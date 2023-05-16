/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalia Ramirez
 */
public class CustomerTest {
    
    Ps3Game littleBigPlanet;
    Xbox360Game fable2;
    WiiGame superSmashBrosBrawl;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        littleBigPlanet = new Ps3Game("Little Big Planet");
        fable2 = new Xbox360Game("Fable 2");
        superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");
    }

    @After
    public void tearDown() throws Exception {
    }

    
    @Test
    public void testGetName() {
        System.out.println("testGetName");
        String name = "John Doe";
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void testAddMovieRental() {
        System.out.println("addMovieRental");
        Customer cliente = new Customer("Pepe");
        Movie prueba = new Movie("True Beauty",Movie.NEW_RELEASE);
        cliente.addMovieRental(new MovieRental(prueba,7));
        assertEquals("Rental Record for Pepe\n"
                        +"\tTrue Beauty\t21.0\n"+
                        "Amount owed is 21.0\n"
                        + "You earned 2 frequent renter points",
                cliente.statement());

    }

    @Test
    public void testStatementPs3GameOnly() {
        // Ps3 games cost $4.00 for the first 4 days, and $1.250/day thereafter
        // a rental earns 2 frequent-renter point no matter how many days
        System.out.println("testStatementPs3GameOnly");
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 1, false));
        assertEquals("Rental Record for John Doe\n" +
                        "\tLittle Big Planet\t4.0\n" +
                        "Amount owed is 4.0\n" +
                        "You earned 2 frequent renter points",
                johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 3, false));
        assertEquals("Rental Record for John Doe\n" +
                        "\tLittle Big Planet\t4.0\n" +
                        "\tLittle Big Planet\t4.0\n" +
                        "Amount owed is 8.0\n" +
                        "You earned 4 frequent renter points",
                johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 5, false));
        assertEquals("Rental Record for John Doe\n" +
                        "\tLittle Big Planet\t4.0\n" +
                        "\tLittle Big Planet\t4.0\n" +
                        "\tLittle Big Planet\t5.25\n" +
                        "Amount owed is 13.25\n" +
                        "You earned 6 frequent renter points",
                johnDoe.statement());
    }

    @Test
    public void testStatementWiiGameOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        System.out.println("testStatementWiiGameOnly");
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 1, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                        "\tSuper Smash Bros. Brawl\t3.0\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 3, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                        "\tSuper Smash Bros. Brawl\t3.0\n" +
                        "\tSuper Smash Bros. Brawl\t3.0\n" +
                        "Amount owed is 6.0\n" +
                        "You earned 2 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 5, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                        "\tSuper Smash Bros. Brawl\t3.0\n" +
                        "\tSuper Smash Bros. Brawl\t3.0\n" +
                        "\tSuper Smash Bros. Brawl\t4.5\n" +
                        "Amount owed is 10.5\n" +
                        "You earned 3 frequent renter points",
                johnDoeJr.statement());
    }

    @Test
    public void testStatementXbox360GameOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        System.out.println("testStatementXbox360GameOnly");
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 1, false));
        assertEquals("Rental Record for Jane Doe\n" +
                        "\tFable 2\t3.5\n" +
                        "Amount owed is 3.5\n" +
                        "You earned 2 frequent renter points",
                janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 2, false));
        assertEquals("Rental Record for Jane Doe\n" +
                        "\tFable 2\t3.5\n" +
                        "\tFable 2\t3.5\n" +
                        "Amount owed is 7.0\n" +
                        "You earned 4 frequent renter points",
                janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 4, false));
        assertEquals("Rental Record for Jane Doe\n" +
                        "\tFable 2\t3.5\n" +
                        "\tFable 2\t3.5\n" +
                        "\tFable 2\t5.0\n" +
                        "Amount owed is 12.0\n" +
                        "You earned 6 frequent renter points",
                janeDoe.statement());
    }

    
    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    @Test
    public void testAddVideoGameRental() {
        System.out.println("addVideoGameRental");
        VideoGameRental arg = new VideoGameRental(fable2, 5, true);
        Customer instance = new Customer("Pepe");
        instance.addVideoGameRental(arg);
        
    }

}
