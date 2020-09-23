package øk1;

public class Kap113 {
    public static int[] minmaks(int[]a){
        int minst=a[0];
        int max=a[0];
        int[]b={minst,max};


        for(int i=1; i<a.length; i++){
            if(a[i]>max){
                max=a[i];
            }
            if(a[i]<minst){
                minst=a[i];
            }

        }

        return b;

    }

    public static void main(String[]args){
        int []tabel={2,5,6,7,11,10};
       /* int []minMaks=minmaks(tabel);
        System.out.print(minMaks[0]+""+minMaks[1]);*/
        System.out.println(minmaks(tabel));



    }
}
