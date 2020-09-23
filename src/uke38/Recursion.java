package uke38;

public class Recursion {

    public static int recursiveFuntion(int value){
        System.out.println("Recursive function: "+value);

        if(value<=5){
            return -9;
        }
        else{
            return recursiveFuntion(value-1);
        }

    }

    /**
     * this function calculates n! (n factorial) using a recursive function call
     * @param n - value to compute the factorial of
     * @return n! - n factorial
     */
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }



    }

    public static void main(String[]args){
        int value=15;
        int return_value=recursiveFuntion(value);
       // System.out.println("Main: "+return_value);

        //5! = 5*4*3*2*1
        int five_factorial=factorial(5);
        System.out.println("5! = "+five_factorial);
        System.out.println("8! = "+factorial(8));
        System.out.println("52! = "+factorial(52));
    }
}

