package eksempelklasser;

import uke37.Tabel;

import java.util.Arrays;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String fornavn;
    private final String etternavn;

    public Person(String fornavn, String etternavn){
        this.fornavn=fornavn;
        this.etternavn=etternavn;

       Objects.requireNonNull(fornavn, "fornavn er null");
       Objects.requireNonNull(etternavn, "etternavn er null");
    }

    public String fornavn(){ return fornavn; } //aksessor
    public String etternavn(){return etternavn; }// aksessor

    public int compareTo(Person p){
        int cmp=etternavn.compareTo(p.etternavn);
        if(cmp!=0)return cmp;
        return fornavn.compareTo(p.fornavn);
    }

    public boolean equals(Object o){
       /* if(o==this)return true;
        if(!(o instanceof Person))return false;
        return compareTo((Person)o)==0;*/
       if(o==this){return true;}
       if(o==null){return false;}
       if(getClass()!=o.getClass()){
           return false;
       }
       final Person p=(Person)o;
       return etternavn.equals(p.etternavn)&&fornavn.equals(p.fornavn);
    }

    public int hashCode(){return Objects.hash(etternavn, fornavn);}

    public String toString(){return fornavn+" "+etternavn;}

    public static void main(String[]args){
        Person[]p=new Person[7];
        p[0]=new Person("Kari", "Svendsen");
        p[1]=new Person("Boris", "Zukanovic");
        p[2] = new Person("Ali","Kahn");
        p[3] = new Person("Azra","Zukanovic");
        p[4] = new Person("Kari","Pettersen");
        p[5]=new Person("Thea", "Pettersen");
        p[6]=new Person("Kaya", "Engh");

        int m= Tabel.maks(p);
        System.out.println(p[m]+" er størst");

        Tabel.innsettingssortering(p);
        System.out.println(Arrays.toString(p));
    }
}
