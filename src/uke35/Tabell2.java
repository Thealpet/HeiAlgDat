package uke35;

import java.util.*;

public class Tabell2 {
    private Tabell2(){}

    public static int[] randPerm(int n){ //en effektiv versjon
        Random r=new Random(); //en randomsgenerator
        int[]a=new int[n]; //en tabell med plass til n tall

        Arrays.setAll(a, i->i+1); //legger inn tallene 1,2, 3,...,n,

        for(int k=n-1; k>0; k--){ //løkke som går n-1 ganger
            int i=r.nextInt(k+1);//et tilfeldig tall fra 0 til k
            bytt(a, k, i); //bytter om plasseringen av tallene i think...

        }
        return a;
    }

    public static void randPerm(int[]a){ //stokker om a
        Random r=new Random();  //randomsgenerator
        for(int k=a.length-1; k>0; k--){
            int i=r.nextInt(k+1);
            bytt(a,k,i);
        }

    }

    public static int maks(int[]a){
        fratilKontroll(a.length,4,9);
        int m=0;
        int maksverdi=a[0];

        for(int i=1; i<a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m=i;
            }
        }
        return m;
    }

    public static int maks(int[]a, int fra, int til){
        int m=fra; //indeks til største verdi i a
        int maksverdi=a[fra]; //største verdi i a
        for(int i=fra+1; i<til; i++){
            if(a[i]>maksverdi){
                m=i; //indeks til større verdi oppdateres
                maksverdi=a[i]; //større verdi oppdateres

            }
        }
        return m; //posisjonen til største verdi


    }

    public static void bytt(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void bytt2(char[]a, int i, int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;

    }

    public static void skriv(int[]a, int fra, int til){
        fratilKontroll(a.length,fra, til);
        if(til-fra>0){
            System.out.print(a[fra]);

        }
        for(int i=fra+1; i<til; i++){
            System.out.print(" "+a[i]);
        }
    }

    public static void skriv(int[]a){
        skriv(a,0, a.length);
    }

    public static void skrivIn(int[]a, int fra, int til){
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivIn(int[]a){
        skrivIn(a, 0, a.length);
    }

    public static void fratilKontroll(int tablelengde, int fra, int til){
        if(fra<0){
            throw new ArrayIndexOutOfBoundsException("fra("+fra+")er negativt!");
        }

        if(til>tablelengde){
            throw new ArrayIndexOutOfBoundsException("til("+til+")>tablelengde("+tablelengde+")");
        }

        if(fra>til){
            throw new IllegalArgumentException("fra("+fra+")>til("+til+")-illegalt intervall!");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h){
        if(v<0){
            throw new ArrayIndexOutOfBoundsException("v("+v+")<0");

        }
        if(h>=tablengde){
            throw new ArrayIndexOutOfBoundsException("h("+h+")>=tablengde("+tablengde+")");
        }

        if(v>h+1){
            throw new IllegalArgumentException("v="+v+", h="+h);
        }
    }
}


