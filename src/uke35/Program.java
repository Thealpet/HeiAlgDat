package uke35;

public class Program {
    public static void main(String[]args){
        int[]a=Tabell2.randPerm(20);
        for(int k:a){
            System.out.print(k+" ");


        }

        int m=Tabell2.maks(a);


        System.out.println("\n største verdien ligger på plass "+m);


    }
}
