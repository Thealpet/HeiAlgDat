package uke37;

import java.util.Arrays;

public class GenericSorting {
    public static class Person implements Comparable<Person> {
        String first_name;
        String last_name;

        Person(String first_name, String last_name){
            this.first_name=first_name;
            this.last_name=last_name;
        }

        public int compareTo(Person other){ //må lage denne klassen siden jeg har med comparable
            /*
            if (this.last_name<other.last_name){
                return -1;
            }else if(this.last_name==other.last_name){
                return 0;
            }else{
                return 1;
            }

            */

            int last_compare=this.last_name.compareTo(other.last_name);
            if(last_compare==0){
                return this.first_name.compareTo(other.first_name);
            }else{
                return last_compare;
            }

        }

        public String toString(){
            return first_name+" "+last_name;
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[]values){
        for(int i=0; i<values.length-1; i++){ //looper over alle unntatt siste element
            //finn største element i intervallet [i, a.length]
            int max_index=maks(values, i, values.length);

            //bytt største element til posisjon i
            T temp=values[i];
            values[i]=values[max_index];
            values[max_index]=temp;

            //fortsett


        }
    }


    public static <T extends Comparable<? super T>> int maks(T[]values, int begin, int end){
        T current_max=values[begin];
        int current_index=begin;

        for(int i=begin+1; i<end; i++ ){
            if(values[i].compareTo(current_max)>0){
                current_max=values[i];
                current_index=i;
            }
        }
        return current_index;
    }

    public static void main(String[]args){
        Integer[]a={4,7,8,9,2,3,4,13,5,6};
        Character[]b={'A','O','U','B','S'};
        String[]c={"Kari", "Poteter","Lammelår", "ASF","eple","Petter"};
        Person[]d={new Person("Petter","Pettersen"),new Person("Kari", "Pettersen"),new Person("Nils","Abrahamsen"), new Person("Tor","Toresen")};

        int person_maks=maks(d, 0, d.length);

        System.out.println("Siste person, leksiografisk er: "+d[person_maks].toString());

        System.out.println("Sorterer personer");
        System.out.println("Før: "+Arrays.toString(d));
        sort(d);
        System.out.println("Etter: "+Arrays.toString(d));


    }
}
