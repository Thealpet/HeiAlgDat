package uke38;

import java.util.Arrays;

public class RecursivePermutations {
    public static void main(String[]args){
        System.out.println("Recursive permutations!");

        int values[]={1,2,3,4};
        //1, 2, 3
        //1, 3, 2
        //2, 1, 3
        //2, 3, 1
        //3, 1, 2
        //3, 2, 1

        recursivePermutation(values, 0);
    }

    public static void recursivePermutation(int[]values, int k){

        if(k==values.length-1){
            System.out.println(Arrays.toString(values));
        }


        //[1],2,3 =1,3,2(bytte 1érn med de andre tallene)
        //2,[1],3 => 2,3,1
        //3,2,[1] =>3,1,2
        for(int i=k; i<values.length; i++){
            swap(values, i, k);
            recursivePermutation(values, k+1);

            swap(values, k, i); //bytte den originale rekkefølgen tilbake

        }
        //recursivePermutation(values);
    }

    public static void swap(int[] values, int m, int n){
        //eksempel: m=2, n=3
        //temp =values[2]
        int temp=values[m];

        //values[2]=values[3]
        values[m]=values[n];

        //values[3]=temp=values[2] NB! Det er det som var values av 2
        values[n]=temp;


    }
}
