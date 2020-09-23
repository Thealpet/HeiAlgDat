package eksempelklasser;

import uke37.Tabel;

import java.util.Arrays;

@FunctionalInterface
public interface Komparator2<T> {
    int compare(T o1, T o2);//en abstrakt metode

    public static <T extends Comparable<? super T>> Komparator2<T>naturligOrden(){
        return (x,y)->x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Komparator2<T>omvendtOrden(){
        return (x,y) ->y.compareTo(x);
    }

    public static <T,R extends Comparable<? super R>>Komparator2<T>orden(Funksjon<? super T, ? extends R> velger){
        return (x,y) ->velger.anvend(x).compareTo(velger.anvend(y));
    }

    public static <T, R>Komparator2<T>orden(Funksjon <? super T, ? extends R>velger, Komparator2<? super R> c){
        return (x,y)->c.compare(velger.anvend(x), velger.anvend(y));
    }

    default Komparator<T> deretter(Komparator<? super T> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(x, y);
        };
    }

    default <R extends Comparable<? super R>>
    Komparator<T> deretter(Funksjon<? super T, ? extends R> velger)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
        };
    }

    default <R> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }

    default Komparator<T> omvendt()
    {
        return (x, y) -> compare(y, x);  // bytter x og y
    }


    public static void main(String[]args){
        Double[]d={5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabel.innsettingssortering(d, Komparator2.naturligOrden());
        Tabel.innsettingssortering(d, Komparator2.omvendtOrden());
        System.out.println(Arrays.toString(d));

        Boolean []b={false, true, true, false, false, true, false, true};
        Tabel.innsettingssortering(b, Komparator2.naturligOrden());
        System.out.println(Arrays.toString(b));

        Person[] p = new Person[5];
        p[0] = new Person("Kari", "Svendsen");
        p[1] = new Person("Boris", "Zukanovic");
        p[2] = new Person("Ali", "Kahn");
        p[3] = new Person("Azra", "Zukanovic");
        p[4] = new Person("Kari", "Pettersen");

       Tabel.innsettingssortering(p, Komparator2.orden(Person::etternavn));
       System.out.println(Arrays.toString(p));

       String[]s={"Lars", "Anders", "Bodil", "Kari", "Per", "Berit"};
       Tabel.innsettingssortering(s, Komparator2.orden(x-> -x.length()));
       System.out.println(Arrays.toString(s));

       Tabel.innsettingssortering(d, Komparator2.naturligOrden());
       Tabel.innsettingssortering(d, Komparator2.orden(x ->-x));
       System.out.println(Arrays.toString(d));


    }
}
