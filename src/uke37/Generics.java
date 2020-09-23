package uke37;

public class Generics {

    public static
    <T extends Comparable<? super T>> //Må fortelle java hva slags datatype T er
    int maksGeneric(T[]value){
        T current_max=value[0];
        int current_index=0;
        for(int i=1; i<value.length; i++){
            //if(value[i]>current_max){
            if(value[i].compareTo(current_max)>0){ //ersatte > med compareTo
                current_max=value[i];
                current_index=i;
            }

        }
        return current_index;
    }

    public static int maks(char[]values){
        char current_maks=values[0];
        int current_index=0;

        for(int i=1;i<values.length; i++){
            if(values[i]>current_maks){
                current_maks=values[i];
                current_index=i;
            }
        }
        return current_index;
    }
    public static void main(String[]args){
        //int[]a={1,8,9,18,98,2,3,9};
        //char[]b={'A','C','K','L','Z','Y','N'};

        //System.out.println("Maks av int-tabell");
        //System.out.println(maks(a));

        //System.out.println("Maks av char-modell");//kan ikke kjøre denne, med mindre man har char-metoden.
        //System.out.println(maks(b));

        Integer[]a={4,7,8,9,2,3,4,13,5,6};
        Character[]b={'A','O','U','B','S'};
        String[]c={"Kari", "Poteter","Lammelår", "ASF"};
        System.out.println("Maks av maksGenerics");
        System.out.println(maksGeneric(a));
        System.out.println(maksGeneric(b)); //på disse to kjører vi samme metode, noe som er en stooor fordel
        System.out.println(maksGeneric(c));


    }
}
