package HjelpeKlasser;


import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {



    /**
     * Private constructor that prevents instance making of this class
     */
    private Tabell(){}


    /**
     * A method with the algorithm to find the greatest number in an array
     * @param a array
     * @return array
     */
    public static int findMax(int [] a){

        int maxValue = 0; //Max value is set to 0

        for(int i = 0; i < a.length; i++){
            if(a[i] > a[maxValue]){ //If the current element of the array is greater than the number at index maxvalue
                maxValue = i; //Set index i as max value
            }
        }
        return maxValue;

    }

    /**
     * A method with the algorithm to find the mini from an array with in a given interval
     * @param a array
     * @param fra integer
     * @param til integer
     * @return array
     */
    public static int maxWithInterval(int [] a, int fra, int til){
       // if(fra < 0 || til > a.length || fra >= til){ //Limit check
           // throw new IllegalArgumentException("Invalid Exception");
       // }
        if(a.length == 0){
            throw new NullPointerException("The array is empty!");
        }
        fratilKontroll(a.length, fra, til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");



        int m = fra;
        int max = a[fra]; // vi starter med å sette max verdien til den første elemnten i listen

        for(int i = fra + 1; i < til; i++){ // start fra elementet etter førte elemnent
            if(a[i] > max){ // hvis elementet i [i] er mindre enn den forelepig min verdien
                m = i; // oppdatere m til i
                max = a[m]; // oppdatere min verdien
            }
        }
        return m;
    }

    /**
     * A method with the algorithm to find the smallest number in an array
     * @param b
     * @return
     */
    public static int miniFinder(int [] b){
        int miniValue = 0;

        for(int i = 0; i < b.length; i++){
            if(b[i] < b[miniValue]){
                miniValue = i;
            }
        }
        return miniValue;
    }

    /**
     * A method with the algorithm to find the mini from an array with in a given interval
     * @param a array
     * @param fra integer
     * @param til integer
     * @return array
     */
    public static int minWithInterval(int [] a, int fra, int til){
        if(fra < 0 || til > a.length || fra >= til){ //Limit check
            throw new IllegalArgumentException("Invalid Exception");
        }

        int m = fra;
        int min = a[fra]; // vi starter med å sette max verdien til den første elemnten i listen

        for(int i = fra + 1; i < til; i++){ // start fra elementet etter førte elemnent
            if(a[i] < min){ // hvis elementet i [i] er mindre enn den forelepig min verdien
                m = i; // oppdatere m til i
                min = a[m]; // oppdatere min verdien
            }
        }
        return m;
    }

    /**
     * A method for swapping elements of an array
     * @param a array
     * @param i integer
     * @param j integer
     */
    public static void swap(int [] a, int i, int j){
        int temp = a[i]; //a[i] is set to temp
        a[i] = a[j];//a[i] is set to a[j], this makes a[j] available to overwrite
        a[j] = temp; //Overwrite a[j] with temp
    }


    /**
     * A method to swap char
     * @param c
     * @param i
     * @param j
     */
    public static void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    /**
     * A method that prints the elements of an array between given interval
     * All elements printed out in one line with one space between
     * @param a
     * @param fra
     * @param til
     */
    public static void print(int[] a, int fra, int til){

        for(int i = fra; i < til; i++){
            System.out.print(" " + a[i]); //Using print instead of println make it possible to print out values in one line
        }

    }

    /**
     * A method to print out all values of an array in one line
     * @param a
     */
    public static void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(" " + a[i]);
        }
    }

    /**
     * Method to create an array with a provided amount of elements>
     * This method is a bit faulty because we still end up at times with duplicated numbers.
     * This due to the second for loop which holds the newly generated number and compares it to all previously generated numbers
     * While doing so if it finds that one of them are equal to this number it generates a new one. But this number can be
     * the same as a number that already exist. And this method do not check it again, since it only compares newly generated number
     * by the first generator to
     * the rest. It is possible to have one more loop with in the second loop and check if the newly generated number is a duplicate.
     * @param n number elements
     */
    public static int [] arrayGenerator(int n) {

        int[] arr = new int[n]; //Create a new array with n number of elements

        Random rand = new Random(); //Initialising random

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n); //Generate a new int on each loop and set to the current index

            for (int j = 0; j < i; j++) { //This loop starts on the second loop of the first loop, j < i will stop the loop on the first round
                if (arr[i] == arr[j]) {  //This loop compares the currently generated number to all the previously generated numbers, If any of them are equal to the new number then continue to the nxt line
                    arr[j] = rand.nextInt(n); //Generate a new random number
                }
            }
        }
        return arr;
    }


    /**
     * Method to get the first and the next maks in an array
     * @param a array
     */
    public static int[] nextMax(int[] a){

        if(a.length < 2){
            throw new IllegalArgumentException("Not Enough Elements In The List");
        }

        int n = a.length;
        int m= 0; //Maks set to 0
        int nm = 1; //Next max set to 1

        if(a[nm] > a[m]){ //Check if the element at index 1 is greater than the element at index 0
            m = 1; //If so swap place
            nm = 0;
        }

        int maks = a[m];
        int nextMaks= a[nm];

        for(int i = 2; i < n; i++){ //Start the loop from the 3rd element

            if(a[i] > nextMaks){ //Check if it is greater than next maks, if so go in the if statement

                if(a[i] > maks){ //Check if it is greater than max
                    nm = m; //If so swap index of max to next max
                    nextMaks = maks; //Make max next max

                    m = i; //swap current greatest number with the old greatest number
                    maks = a[m]; //Make the new great number the greatest number

                }else { //If it only greater than next max, swap next max
                    nm = i;
                    nextMaks = a[nm];
                }
            }
        }
        return new int[] {m,nm,a[m],a[nm]}; //Return an array with index of max and next max and their values
    }

    /**
     * Method with the bubble sorting algorithm to arrange an array in descending order
     * @param a array
     */
    public static int [] arrangerDes(int [] a) {

        if (a.length < 2) {
            throw new IllegalArgumentException("Number of elements in the array has to be greater than two");
        }
        boolean sorted = false;
        while (!sorted) { //While sorted is true
            sorted = true;
            for (int i = 0; i < a.length -1; i++) {
                if (a[i] < a[i + 1]) { //Check if index i and index i+1 are ordered, if not swap
                    int temp = a[i + 1]; //Let temp hold the current i +1
                    a[i + 1] = a[i]; //Set i+1 to i
                    a[i] = temp; //Set i to temp
                    sorted = false;
                }

            }

        }
        return a;
    }

    /**
     * Controls the legality of inserted values
     * @param tablengde
     * @param fra
     * @param til
     */
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    /**
     * Checks the legality of inserted values of closed interval
     * @param tablengde
     * @param v
     * @param h
     */
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    /**
     * A method to copy an array to another array.
     * @param a source array
     * @param i source array start position
     * @param b destination array
     * @param j destination array start positionn
     * @param ant array length
     */
    public static void kopier(int[] a, int i, int[] b, int j, int ant){

        int n = a.length;
     //   b = new int[n*2]; //Define the length of destination array

        for(int m = i + ant; i < ant;){
            b[j++] = a[i++];
        }

        //System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        /**
        for(int p = 0; p < b.length; p++){
            System.out.println(b[p]);
        }
    */
    }


    /**
     * Sorting method, that compares and swaps two values
     * And thus bubble the largest value to the top
     * @param values
     */
        public static void bubbleSort(int[] values) {

            //Outer loop: counts the number of cards we have sorted so far
            for (int i=0; i<values.length-1; ++i) {
                //Print out values
                System.out.println("Skal finne kort på plass " + i);
                System.out.println("Array før vi starter: " + Arrays.toString(values));
                //Inner loop: loops from end of the deck and forward through the
                //unsorted cards, and bubbles up
                for (int j=values.length-1; j>i; --j) {
                    //Swap the cards if they are out of order
                    if (values[j] > values[j-1]) {
                        int temp = values[j];
                        values[j] = values[j-1];
                        values[j-1] = temp;
                        System.out.println("Bytter " + values[j] + " med " + values[j-1] + ": " + Arrays.toString(values));
                    }
                }
            }

            //Print out final sorted
            System.out.println("Ferdig sortert array:");
            System.out.println(Arrays.toString(values));
        }
    }


