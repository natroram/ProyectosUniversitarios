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
public class MovieTest {
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPriceCode method, of class Movie.
     */
    @Test
    public void testGetPriceCode() {
        System.out.println("getPriceCode");
        Movie instance = new Movie("Película Uno", Movie.CHILDRENS);
        int expResult = Movie.CHILDRENS;
        int result = instance.getPriceCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriceCode method, of class Movie
     */
    @Test
    public void testSetPriceCode() {
        System.out.println("setPriceCode");
        int arg = Movie.REGULAR;
        Movie instance = new Movie("Película Dos", Movie.NEW_RELEASE);
        instance.setPriceCode(arg);
        assertEquals(arg, instance.getPriceCode());
    }
    
    /**
     * Para las pruebas unitarias
     */ 
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    @Before
    public void setUp2(){
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
    }
    @Test
    public void testGetPriceCode2() {
        System.out.println("getPriceCode con Setup");
        assertEquals(Movie.REGULAR, theManWhoKnewTooMuch.getPriceCode());
    }
}
