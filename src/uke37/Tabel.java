package uke37;

import eksempelklasser.Komparator;
import eksempelklasser.Komparator2;

import java.awt.color.CMMException;
import java.util.Arrays;
import java.util.Random;

public class Tabel {

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
    /*public static int maks(int[]a){
        int m=0;
        int maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i]>maksverdi){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }*/
    /*public static int maks(double[]a){
        int m=0;
        double maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i]>maksverdi){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }*/

   /* public static int maks(String[]a){
        int m=0;
        String maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i].compareTo(maksverdi)>0){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }*/

   /* public static int maks(char []a){
        int m=0;
        char maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i]>maksverdi){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }*/

   /* public static int maks(Integer[]a){
        int m=0;
        Integer maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i].compareTo(maksverdi)>0){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }*/


    //Hvis a er mindre enn b returneres -1
    //Hvis a er lik b returneres 0
    //Hvis a er større enn b returneres 1
    public static int maks(Integer a, Integer b){
        return a.compareTo(b);

    }

    public static int sammenlignn(String a, String b){
        int n1=a.length(); //lengden til a
        int n2=b.length(); //lengden til b

        int n=n1<n2 ? n1:n2; //den minste av n1 og n2. Betyr hvis n1 er mindre enn n2 returner n1, else returner n2

        for(int i=0; i<n; i++){
            char c1=a.charAt(i);
            char c2=b.charAt(i);

            if(c1!=c2){
                return c1-c2;
            }
        }
        return n1-n2;
    }

    public static <T extends Comparable<? super T>> int maks(T[]a){
        int m=0;
        T maksverdi=a[0];

        for(int i=1; i<a.length; i++){
            if(a[i].compareTo(maksverdi)>0){
                maksverdi=a[i];
                m=i;
            }
        }
        return m;
    }

    public static <T extends Comparable<? super T>>void innsettingssortering(T[]a){
        for(int i=1; i<a.length; i++){
            T verdi=a[i]; //verdi er et tabellelement
            int j=i-1; //j er en indeks

            //sammenlikner og forskyver
            for(; j>=0 && verdi.compareTo(a[j])<0; j--){
                a[j+1]=a[j];

            }
            a[j+1]=verdi; //j+1 er sortert på rett plass

        }
    }

    public static void skriv(Object[]a, int fra, int til){
        fratilKontroll(a.length, fra, til);

        for(int i=fra; i<til; i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void skriv(Object []a){
       skriv(a, 0, a.length);
    }

    public static void skrivln(Object []a, int fra, int til){
        fratilKontroll(a.length, fra, til);

        for(int i=fra; i<til; i++){
            System.out.println();
        }
    }

    public static void skrivln(Object[]a){
        skrivln(a, 0, a.length);
    }

    public static void bytt(Object[]a, int i, int j){
        Object temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static Integer[]randPermInteger(int n){
        Integer[]a=new Integer[n]; //en Integer-tabell
        Arrays.setAll(a, i ->i+1); //tallene fra 1 til n

        Random r=new Random();

        for(int k=n-1; k>0; k--){
            int i=r.nextInt(k+1); //tilfeldig tall fra [0,k]
            bytt(a, k, i); //bytter om k og i
        }
        return a; //tallene med permutasjonen returneres
    }

    public static <T> void innsettingssortering(T[] a, Komparator2<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
    public static <T> int maks(T[] a, Komparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a,int fra, int til, Komparator<? super T> c){
        int m=fra;
        T maks_verdi=a[fra];

        for(int i=fra+1; i<til; i++){
            if(c.compare(a[i],maks_verdi)>0){ //bruker komparatoren
                maks_verdi=a[i];
                m=i;
            }
        }
        return m;
    }

    public static void main(String[]args){ //forskjellen fra maks double er bare å endre double til char.
        //int[]a={5,2,7,3,9,1,8,4,6};
        //double[]d={5.7, 3.14, 7.12, 3.9, 6.5,7.1, 7.11};
        //String[]s={"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        //char[]c={'J','A','S','M','I','N'};
        //Integer[]i={5,2,7,3,9,1,8,4,6};

        //String[]s={"Per","Kari", "Ole","Anne","Ali","Eva"};
        //Tabel.innsettingssortering(s);
        //System.out.println(Arrays.toString(s));

       // String s1="B", s2="B";
        //System.out.println(s1.compareTo(s2));




        //int k=Tabel.maks(a); //posisjon til største i k
        //int l=Tabel.maks(d);
        //int m=Tabel.maks(s);
        //int j=Tabel.maks(c);
        //int w=Tabel.maks(i);


        //System.out.println(a[k]+" "+d[l]+" "+s[m]+" "+c[j]+" "+i[w]); //printer ut største verdi
       // System.out.println(maks(9,8));

        //maks(String[]a) velges først. Dersom man fjerner den metoden blir det fortsatt samme svar
       /* String[]s={"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k=Tabel.maks(s);
        System.out.println(s[k]);*/

       /* Object[]a={1,4,5,7,8};
        //skriv(a);
        Tabel.bytt(a, 0,4);
        Tabel.skriv(a);*/

      /* Integer[]a=Tabel.randPermInteger(30);
       System.out.println(Arrays.toString(a));*/

       double[] d={5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};
       Double[]b=new Double[d.length];

       //hvert element b lages som en instans av class Double
       for(int i=0; i<b.length; i++){ //autoboksing
           b[i]=d[i];
       }

       Tabel.innsettingssortering(b);
       Tabel.skrivln(b);







    }


}
