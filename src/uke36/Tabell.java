package uke36;

public class Tabell {

    public static void bytt(int[]a, int i, int j){
        int temp=a[i];
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

    public static void snu(int[]a, int v, int h){//snur intervallet
        while(v<h){
            bytt(a, v++, h--);
        }
    }

    public static void snu(int[]a, int v){ //snur fra og med v og ut tabellen
        snu(a, v, a.length-1);
    }

    public static void snu(int[]a){ //snur hele tabellen
        snu(a, 0, a.length-1);
    }

    public static boolean nestePermutasjon(int[]a){
        int i=a.length-2; //i starter nest bakerst
        while(i>=0&&a[i]>a[i+1]){ //går mot venstre
            i--;
        }
        if(i<0){
            return false;
        }

        int j=a.length-1; //j starter bakerst
        while(a[j]<a[i]){ //stopper når a[j]>a[i]
            j--;
        }
        bytt(a,i, j);
        snu(a, i+1); //bytter og snur

        return true;

    }

    public static int min(int[]a, int fra, int til){
        if(fra<0||til>a.length||fra>=til){
            throw new IllegalArgumentException("illegalt intervall!");
        }

        int m =fra;
        int minVerdi=a[fra];
        for(int i=fra+1; i<til; i++){
            if(a[i]<minVerdi){
                m=i;
                minVerdi=a[m];
            }

        }
        return m;
    }

    public static void utvalgssortering(int[]a){
        for(int i=0; i<a.length-1; i++){
            bytt(a, i, min(a, i, a.length));
        }
    }

    public static void utvalgsSortering(int[]a){

        for(int i=0; i<a.length-1; i++){
            int m=i; //indeks til den foreløpig minste
            int minverdi=a[i]; //verdien til den foreløpig minste

            for(int j=i+1; j<a.length; j++){
                if(a[j]<minverdi){
                    minverdi=a[j]; //ny minste verdi
                    m=j; //indeksen til ny minste verdi
                }
            }

            //bytter om a[i] og a[m]
            int temp=a[i];
            a[i]=a[m];
            a[m]=temp;

        }

    }
    public static void utvalgssortering(int[]a, int fra, int til){

        for(int i=fra; i<til-1; i++){
            int m=fra; //indeks til den foreløpig minste
            int minverdi=a[fra]; //verdien til den foreløpig minste

            for(int j=i+1; j<til; j++){
                if(a[j]<minverdi){
                    minverdi=a[j]; //ny minste verdi
                    m=j; //indeksen til ny minste verdi
                }
            }

            //bytter om a[i] og a[m]
            int temp=a[i];
            a[i]=a[m];
            a[m]=temp;

        }
    }



    /*public static void main(String[]args){
        int[]a={3,1,4,9,8,2,6,5,7,10};
        Tabell.nestePermutasjon(a);
        Tabell.skriv(a);
    }*/

    public static void main(String[]args){
        int[]a={7,5,9,2,10,4,1,8,6,3};
        Tabell.utvalgsSortering(a);
        Tabell.skriv(a);

    }

}
