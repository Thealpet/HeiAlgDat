package øk1;

public class Oppg3 {
    public static void main(String[]args){
        int[] vals = {8, 4, 17, 10, 6, 20, 11, 15, 3, 18,20, 9, 2, 7, 19};
        int max_verdi=vals[0];

        for(int i=1; i<15; i++){
            int verdi=vals[i];
            if(verdi>=max_verdi){
                max_verdi=verdi;
            }
        }
        System.out.print(max_verdi);
    }
}
