package uke37;

public class GenericsPt2 {

    public static <T extends Comparable<? super T>> int maksGeneric(T[]value){
        T current_max=value[0];
        int current_index=0;
        for(int i=1; i<value.length; i++){
            if(value[i].compareTo(current_max)>0){
                current_max=value[i];
                current_index=i;
            }
        }
        return current_index;

    }

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
    }

    public static void main(String[]args){
        Integer[]a={3,5,6,9,10,1,2};
        Character[]b={'A','U','O','P','B','X'};
        Person[]c={new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

        System.out.println("Generics maks av int-array:");
        System.out.println(maksGeneric(a));

        System.out.println("Generics maks av char-array:");
        System.out.println(maksGeneric(b));

        System.out.println("Generics maks av Person-array:");
        System.out.println(maksGeneric(c));
    }

}
