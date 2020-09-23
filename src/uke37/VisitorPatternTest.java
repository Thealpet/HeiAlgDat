package uke37;

import java.util.Arrays;

public class VisitorPatternTest {

    public static class Person {
        String first_name;
        String last_name;

        public Person(String first_name, String last_name){
            this.first_name=first_name;
            this.last_name=last_name;
        }

        public String toString(){
            return first_name+" "+last_name;
        }
    }

    //Et interface - det lover at alle klasser som implementerer dette
    //har de foreskrevne funksjonene
    @FunctionalInterface
    public interface Komparator<T>{
        int compare(T a, T b);
    }

    public static class DesendingPersonComparator implements Komparator<Person>{
        public int compare(Person a, Person b){
            int last_compare=a.last_name.compareTo(b.last_name);
            if(last_compare==0){ //hvis de er like ser vi også på fornavnet
                return a.first_name.compareTo(b.first_name);
            }
            else{
                return last_compare;
            }
        }
    }

    public static class AscendingPersonComparator implements Komparator<Person>{
        public int compare(Person a, Person b){
            int last_compare=b.last_name.compareTo(a.last_name);
            if(last_compare==0){
                return b.first_name.compareTo(a.first_name);
            }
            else{
                return last_compare;
            }
        }
    }

    public static class OddePartallKomparator implements Komparator<Integer>{
        public int compare(Integer a, Integer b){
            //først sammenlign "etternavnet" => partall eller oddetall
            if(a%2==0&&b%2==0){ //begge er partall
                return a.compareTo(b);
            }
            else if(a%2==1 && b%2==1){ //begge er oddetall
                return a.compareTo(b);
            }
            else if(a%2>b%2){//a er oddetall, b er partall
                return 1;
            }
            else if(b%2>a%2){ //b er oddetall, a er partall
                return -1;
            }

            //not a number, infinity etc. Burde kaste exception
            return 0;

        }
    }

    /**
     * denne funksjonen finner største verdi i values
     * bruker sammenlikningsfunksjoneni objektet comp for sammenlikning
     * @param values
     * @param begin
     * @param end
     * @param comp
     * @param <T>
     * @return
     */
    public static <T> int maks(T[]values, int begin, int end, Komparator<T> comp){
        T current_maks=values[begin];
        int current_indeks=begin;

        for(int i=begin+1; i<end; i++){
            //if(values[i]>current_maks)
            if(comp.compare(values[i],current_maks)>0){
                current_maks=values[i];
                current_indeks=i;
            }
        }
        return current_indeks;
    }

    public static <T> void sort(T[]values, Komparator<T> comp){
        for(int i=0; i<values.length-1; i++){ //looper over alle unntatt siste element
            //finn største element i intervallet [i, a.length]
            int max_index=maks(values, i, values.length, comp);

            //bytt største element til posisjon i
            T temp=values[i];
            values[i]=values[max_index];
            values[max_index]=temp;

            //fortsett


        }

    }

    public static void main(String[]args){
        Person[]persons={new Person("Petter","Pettersen"),new Person("Kari", "Pettersen"),new Person("Nils","Abrahamsen"), new Person("Tor","Toresen")};

        //0 Lag comparator objektet
        //vi kan nå kjøre comp.compare(a,b)
        AscendingPersonComparator compAsc=new AscendingPersonComparator();
        DesendingPersonComparator compDesc=new DesendingPersonComparator();


        //1 Lage funksjonen som tar inn både person-arrayet og en sammenlikningsfuksjon
        System.out.println("Før sortering: "+Arrays.toString(persons));
        System.out.println("Sorterer!");
        sort(persons, compDesc);
        System.out.println("Etter sorterting, Desending: "+Arrays.toString(persons));
        sort(persons, compAsc);
        System.out.println("Etter sortering, Ascending: "+Arrays.toString(persons));

        Integer integers[]={9,8,7,6,5,4,3,2,1,0};
        //Vil sortere sånn at vi får oddetall til venstre, og partall til høyre
        //Partall og oddetall skal være inbyrdes sortert
        OddePartallKomparator odd_partall =new OddePartallKomparator();

        System.out.println("Før sortering: "+Arrays.toString(integers));
        sort(integers, odd_partall);
        System.out.println("Etter sortering: "+Arrays.toString(integers));

        //Hva skal noe være?
        //- Partalls og oddetallssjekk
        //- Skille mellom partall og oddetall
        //- Bruk "er det partall?" som "etternavn", og så størrelse på tallet som fornavn
        //- noe må være en komparator <T>
    }
}
