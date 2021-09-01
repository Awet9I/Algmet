import java.util.Random;

public class Example01 {

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
     * A method with the algorithm to find the max from an array with in a given interval
     * @param a array
     * @param fra integer
     * @param til integer
     * @return array
     */
    public static int maxWithInterval(int [] a, int fra, int til){
        if(fra < 0 || til > a.length || fra >= til){ //Limit check
            throw new IllegalArgumentException("Invalid Exception");
        }

        int m = fra;
        int maks = a[fra]; // vi starter med å sette max verdien til den første elemnten i listen

        for(int i = fra + 1; i < til; i++){ // start fra elementet etter førte elemnent
            if(a[i] > maks){ // hvis elementet i [i] er støre enn den forelepig maks verdien
                m = i; // oppdatere m til i
                maks = a[m]; // oppdatere maks verdien
            }
        }
        return m;
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
    public static int [] arrayGenerator(int n){

        int [] arr = new int[n]; //Create a new array with n number of elements

        Random rand = new Random(); //Initialising random

       for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(n); //Generate a new int on each loop and set to the current index

            for(int j = 0; j < i; j++){ //This loop starts on the second loop of the first loop, j < i will stop the loop on the first round
                if(arr[i] == arr[j]) {  //This loop compares the currently generated number to all the previously generated numbers, If any of them are equal to the new number then continue to the nxt line
                    arr[j] = rand.nextInt(n); //Generate a new random number
                }
            }
        }
        /**
        int i = 1;
        for(int m = 0; m < arr.length; m++){
            i++;
            if(arr[i] == arr[m]){
                arr[i]+=1;
            }
        }
         */
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
     * Main method for the purpose of testing
     * @param args
     */
    public static void main(String[] args) {
        int [] a = {12, 1, 32, 2, 9, 11, 43, 84, 3};
/**
       int i =  findMax(a);
        System.out.println(i);

        int n = miniFinder(a);
        System.out.println(n);
*/
        // int interval = maxWithInterval(a, 2, 8);
       // System.out.println(a[interval]);

        int[] n = arrayGenerator(4);

        System.out.println("The entire array:");
        for(int t = 0; t < n.length; t++){
            System.out.println(n[t]);
        }



        /**
        for(int i = 0; i < 10; i++){
            System.out.println(n[i]);
        }
         int [] m = nextMax(n);
        System.out.println("Max and Next max:");
        for(int t = 0; t < m.length; t++){
            System.out.println(m[t]);
        }
*/


        int [] m = arrangerDes(n);
        for(int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }

    }

}
