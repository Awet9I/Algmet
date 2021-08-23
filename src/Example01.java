public class Example01 {

    public static int findMax(int [] a){

        int maxValue = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] > a[maxValue]){
                maxValue = i;
            }
        }
        return maxValue;

    }

    public static void main(String[] args) {
        int [] a = {12, 1, 32, 8, 9, 11, 43, 84, 3};

       int i =  findMax(a);
        System.out.println(i);
    }
}
