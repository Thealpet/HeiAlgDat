package øk1;

public class Test {

    public static int maks(int[]a){
        int m=0; //indeks til største verdi
        int maksverdi=a[0]; //største verdi

        for(int i=1; i<a.length; i++){
            if(a[i]>maksverdi){
                maksverdi=a[i];//største verdi oppdateres
                m=i; //indeks til største verdi oppdateres
            }
        }
        return maksverdi;

    }
    public static void main(String[]args){
        int[]tabell={1,2,3,4,5};
        System.out.print(maks(tabell));

    }
}
