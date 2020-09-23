package uke36;

public class Søk {
    public static int sortertSøk(int[]a, int value){
        for(int i=0; i<a.length; i++){
            if(a[i]==value){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[]args){
        int[]a={9,7,4,5,3};
        System.out.print(sortertSøk(a, 8));
    }
}
