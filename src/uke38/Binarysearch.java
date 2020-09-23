package uke38;

public class Binarysearch {

    public static void main(String[]args){
        int values[]={1,2,4,8,17,19,22};
        for(int i=0; i<25; i++) {
            System.out.println(i+" - "+binary_search(i, values, 0, values.length-1));
        }

    }
    //search in the interval [left, right] Lukket intervall
    public static int binary_search(int search_value, int[]values, int left, int right){
        //sjekke om midtpunktet er verdien vår
        int middle=(left+right)/2;

        //hvis verdien ikke finnes i listen
        if(right-left==0){
            if(values[middle]==search_value) {
                return middle;
            }
            else{
                return -middle;
            }
        }
        //leter til høyre for midtpunktet
        if(values[middle]<=search_value){
            if(values[middle]==search_value) {
                return middle;
            }

            return binary_search(search_value, values, middle+1, right);
        }
        else{
            return binary_search(search_value, values, left, middle-1);
        }
    }
}
