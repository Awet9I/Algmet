package HjelpeKlasser;

import HjelpeKlasser.*;

import java.util.Arrays;


/**
 * A class with a main method aimed for testing
 */
public class Program {

    public static void main(String[] args) {
       // Tabell.minWithInterval()

      int[] a =  Tabell.arrayGenerator(10);

        Tabell.print(a);

        //Tabell.maxWithInterval(a, 2, 2);

        int[] b = new int[a.length];
       Tabell.kopier(a, 0, b, 0, 10);

    }

}
