package uke36;

public class SortertSøk {
    public static int sortertSøk(int[]a, int value){
        int step_length=2;
        for(int i=0; i<a.length; i=i+step_length){
            if(a[i]>=value){
                int begin=i-step_length;
                int end=i+1;
                for(int j=begin; j<end; j++){
                    if(a[j]==value){
                        return j;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        int[]a={2,3,4,7,9};
        System.out.print(sortertSøk(a, 10));
    }
}
