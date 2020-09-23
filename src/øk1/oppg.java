package øk1;

public class oppg {
    public static void main(String[] args) {
        int[] vals = {8, 4, 17, 10, 6, 20, 11, 15, 3, 18, 9, 2, 7, 19};
        int min_verdi = vals[0];

        for (int i = 1; i < 14; i++) {
            int verdi = vals[i];
            if (verdi < min_verdi) {
                min_verdi = verdi;
            }


        }
        System.out.print(min_verdi);

    }
}
