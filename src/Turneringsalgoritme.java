import java.util.Arrays;

public class Turneringsalgoritme {

    public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);
        System.out.println(Arrays.toString(b));
        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }


        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst


    } // nestMaks


    /**
     *
     * @param a
     * @param i
     * @param b
     * @param j
     * @param ant
     */
    public static void kopier(int[] a, int i, int[] b, int j, int ant){


       int n = a.length;
       b = new int[n*2];

       for(int m = i + ant; i < ant;){
           b[j++] = a[i++];

       }

       for(int p = 0; p < b.length; p++){

           System.out.println(b[p]);
       }
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
     * An algorithm to reverse the order of an array
     * between given intervals. Takes i as a starting point and j
     * as end point. Then exchange i and j, then i goes ++ and j
     * goes --, which are next to change places.
     * @param a
     * @param v
     * @param h
     */
    public static int[] snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h)
            swap(a, v++, h--); //Swaps the left limit and right limit
                               // increase left limit and decrease right limit on next iteration
        return a;
    }

    /**
     * Inverse from given left limit til last member of the array
     * @param a
     * @param v
     */
    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    /**
     * Inverse the whole array
     * @param a
     */
    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }


    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1])
            i--;   // går mot venstre

            if (i < 0)
                return false;                 // a = {n, n-1, . . . , 2, 1}


            int j = a.length - 1;                    // j starter bakerst
            while (a[j] < a[i])
                j--;                 // stopper når a[j] > a[i]

                swap(a, i, j);
                snu(a, i + 1);               // bytter og snur

        return true;                         // en ny permutasjon
        }




    public static void main(String[] args) {

       int [] b = {23, 58, 44, 1, 39, 9, 0, 11, 88, 123, 18, 93};//Example01.arrayGenerator(100);
       //int [] res =  nestMaks(b);
       // for(int i = 0; i < res.length; i++){
          //  System.out.println(res[i]);
      //  }
/**
        System.out.println("Array b tournement result");

        for(int m = 0; m < b.length; m++){
            System.out.println(b[m]);
        }
   */

       //  int [] c = null;
       //  kopier(b,0, c,12, 12);
/**
         int[] res = snu(b,0, 3);
         for(int i = 0; i < res.length; i++) {
             System.out.println(res[i]);
         }
 */

int [] c = {3,1,4,9,7,10, 8, 6, 5, 2};
for(int i = 0; i < 10; i++) {
    nestePermutasjon(c);
    System.out.println(Arrays.toString(c));
}

         }

    }

