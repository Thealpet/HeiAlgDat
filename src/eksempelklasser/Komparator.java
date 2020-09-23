package eksempelklasser;

import uke37.Tabel;

import java.util.Arrays;

@FunctionalInterface
public interface Komparator<T> {
    int compare(T x, T y);

    public static void main(String... args) {
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

       /* class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabel.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
        */

       /* Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabel.innsettingssortering(p, c);                // se Programkode 1.4.6 b)
        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p*/

       /* Tabel.innsettingssortering(p, (p1, p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));*/

        Student[] s = new Student[6];                             // en studenttabell
        s[0] = new Student("Kari", "Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Thea", "Pettersen", Studium.Elektro);

        /*Tabel.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s));*/
       /* Komparator<Student> c = (s1,s2) ->
        {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabel.innsettingssortering(s, c);    // Programkode 1.4.6 b)
        System.out.println(Arrays.toString(s));
    }*/

       /* Tabel.innsettingssortering(s, (s1, s2) -> //lamda uttrykk
                {
                    int k = s1.studium().compareTo(s2.studium());
                    return k != 0 ? k : s1.compareTo(s2);
                }
        );

        for (Student t : s) {
            System.out.println(t);
        }*/

        /*Tabel.innsettingssortering(s,(s1,s2)->{
                    int k=s1.studium().compareTo(s2.studium());
                    if(k!=0){
                        return k;
                    }else{
                        k=s1.fornavn().compareTo(s2.fornavn());
                    }

                    if(k!=0){
                        return k;
                    }
                    else{
                        return s1.etternavn().compareTo(s2.etternavn());
                    }

                }
                );
        for(Student t: s){
            System.out.println(t);
        }*/


       // String[]s={"Lars", "Anders", "Bodil", "Berit", "Kari", "Per"};
       /* String[]s={"21","18","8","13","20","6","16","25","3","10"};
        Tabel.innsettingssortering(s,(s1, s2)-> {
                int k= s1.length()-s2.length(); //skriver ut minste lengde først
                return k!=0 ? k: s1.compareTo(s2); //sorterer alfabetisk, minste verdi først
        }

                );
        System.out.println(Arrays.toString(s));*/

      /*  Komparator<Integer>c=(x,y)->
        {
            if(((x-y)&1)==0){ // x og y er oddetall eller x og y er partall
                if(x<y){
                    return -1;
                }else if(x>y){
                    return 1;
                }else{
                return 0;}

            }else if((x&1)==0){ //x partall og y oddetall
                return 1;
            }else{
                return -1; //x oddetall og y partall
            }


        };
        Integer[]b={6,2,7,1,9,5,10,8,4,3};
        Tabel.innsettingssortering(b,c);
        System.out.println(Arrays.toString(b));

        Komparator<Student>t=(s1, s2)->
        {
            int cmp=s1.studium().name().compareTo(s2.studium().name());
            return cmp!=0 ?cmp: s1.compareTo(s2);

        };


        Tabel.innsettingssortering(s,t);
        System.out.println(Arrays.toString(s));*/
    }
}
