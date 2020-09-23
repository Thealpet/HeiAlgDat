package uke35;

public class Tabell {

    private Tabell() {

    }



        public static int min1 ( int[] a, int fra, int til){
            if (fra < 0 || til > a.length || fra >= til) {
                throw new IllegalArgumentException("Illegalt intervall!");
            }

            int m = fra;
            int minverdi = a[fra];

            for (int i = fra + 1; i < til; i++) {
                if (a[i] < minverdi) {
                    m = i;
                    minverdi = a[m];
                }

            }
            return m;
        }


        public static void main (String[]args){
        Tabell tabell=new Tabell();
            int[] a = {1, 8, 19, 23, 16, 13, 7, 5, 2, 4};
            int ut = min1(a, 0, 10);
            System.out.print(ut);

        }
    }
