package uke37;

public class Ternery {

    public static int myTerneryIfTest(int value){
       /* if(value<5){
            return 0;
        }else{
            return 98;
        }*/

        return (value<5)? 0:98; //sånn her istedet for sånn over. betyr hvis value er mindre enn fem, return 0, else return 98.
    }

    public static void main(String[]args){
        for(int i=0; i<10; i++){
            int a=i;
            int b=myTerneryIfTest(a);
            System.out.println(b);
        }

        int a=17;
        int b=(a<5)?13 :17;
    }
}
