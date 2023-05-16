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
public class MovieRentalTest {
    Movie eraserHead, coco, blackWidow;

    public MovieRentalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
     
    @Before
    public void setUp() {
        eraserHead = new Movie("Eraser Head", Movie.REGULAR);
        coco = new Movie("Coco", Movie.CHILDRENS);
        blackWidow = new Movie("Black Widow", Movie.NEW_RELEASE);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDaysRented method, of class MovieRental.
     */
    @Test
    public void testGetDaysRented() {
        System.out.println("getDaysRented");
        MovieRental instance = new MovieRental(eraserHead, 2);
        int expResult = 2;
        int result = instance.getDaysRented();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMovie method, of class MovieRental.
     */
    @Test
    public void testGetMovie() {
        System.out.println("getMovie");
        MovieRental instance = new MovieRental(blackWidow, 5);
        Movie expResult = blackWidow;
        Movie result = instance.getMovie();
        assertEquals(expResult, result);
    }
    
}
