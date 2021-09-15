
public class TournmentsTree {

    /**
     * A node in a tournament tree. Each node
     * has a "pointer" to its children.
     * A Java object is actually just a pointer to a memory address where the objects data lies.
     * This means that we can have an instantiated object of Node,
     * Node root = new Node('r');
     * This node, root, then is a pointer to a memory location. At this location, we will then find
     * the value 'r', and two more pointers: left_child and right_child.
     */
    public static class Node{
        char value;
        Node left_child;
        Node right_child;

        /**
         * constructor
         * @param value
         */
        Node(char value){
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        /**
         * This is a so-called recursive function that prints pre-order.
         * print function ends up printing all
         * nodes in the binary tournament tree to screen.
         */
        void print() {
            System.out.println(value + "");
            if (this.left_child != null) {
                this.left_child.print();
            }
            if (this.right_child != null){
                this.right_child.print();
        }
        }

    }

    /**
     * A function that plays a match between two teams, and
     * creates a parent node with the winner
     * @param team_1 First team to play
     * @param team_2 Second team to play
     * @return The winner, with the two teams (team_1, and team_2) as children
     */
    static Node playMatch(Node team_1, Node team_2){

        char winner;
        if(team_1.value > team_2.value){
            winner = team_1.value;
        }else {
            winner = team_2.value;
        }

        //Create the parent node, and set the pointers
        //to the children
        Node parent = new Node(winner);
        parent.left_child = team_1;
        parent.right_child = team_2;

        return parent;

    }

    public static void main(String[] args) {
        //Create the four teams that we want to play a tournament with
        Node z = new Node('Z');
        Node c = new Node('C');
        Node f = new Node('F');
        Node k = new Node('K');


        //Verdien av en char bestemmes av ASCII-tabellen.
        //f.eks. så er 'A' = 65, 'B' = 66, ... 'a' = ??

        //Play semi-finals, and store the winners
        Node semi_1 = playMatch(z, c);
        Node semi_2 = playMatch(f, k);
        System.out.println("semi final winner");

        //semi_1.print();
        //semi_2.print();

        Node winner = playMatch(semi_1, semi_2);
        //System.out.println("Winner");

        System.out.println("Turnerings pre-orden");
        winner.print();
    }



    // oblig
    /**
     * En metode som skal finne største tall i arreyet a. Den gjør dette ved å starte
     * å sammenligne den i verdien av arrayet med i + 1 verdien.
     * Hvis i er større så bytter den
     * @param a array
     * @return int
     */
    public static int maks(int[] a) {
        if(a.length == 0) { //Sjekker om arrayet er tum og retunerer feil melding hvis den er tum
            throw new UnsupportedOperationException("Arrayet kan ikke være tum!");
        }
        int n = a.length;


        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i + 1]){ //Hvis den foreløping verdi av indeks  i er større enn i + 1, bytter plass med i
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        return a[n-1]; // Retunere den siste elementet siden det største elementeet skal være plassert der

    }

    /**
     * En metode som går gjennom arrayet og bytter om plass til elementene i arrayet
     * og teller antall ombyttinger
     * @param a
     * @return int
     */
    public static int ombyttinger(int[] a) {
        int n = a.length;
        if (n < 2) {//Kontrollerer lengden på arrayet, hvis midre enn 2 retunerer untakk melding.
            throw new UnsupportedOperationException("Ikke nok elementer i arrayet til ombytting!");
        }
        int antall = 0; //Variable for å holde antall ombyttinger
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) { //Hvis den foreløping verdi av indeks  i er større enn i + 1, bytter plass med i
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                antall++;

            }

        }
        return antall;
    }


    public static boolean sortertStigende(int[] a){

        int n = a.length;
        int start = 0;
        int sist = 1;
        while(sist <= n - 1){
            if(a[start] > a[sist]){
                return false;
            }else {
                start ++;
                sist ++;
            }
        }
        return true;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        int n = a.length;
        if(n < 0) {
            throw new UnsupportedOperationException();

        } else if(sortertStigende(a) == false){

            throw new IllegalStateException("Rekkefølgen i arrayet er ikke på stigende format!");

        }

        int antall = 0;
        for(int i = 0; i < n - 1; i++){
            if(a[i] == a[i + 1]){
                antall++;
            }
        }
        return antall;
    }


}

