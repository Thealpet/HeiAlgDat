package eksempelklasser;

import uke37.Tabel;

import java.util.Arrays;

public final class Heltall implements Comparable<Heltall> {
    private final int verdi; //et heltall som instansvariabel

    public Heltall(int verdi){ this.verdi=verdi; } //konstruktør

    public int intVerdi(){return verdi;} //aksessor

    public int compareTo(Heltall h){ //Heltall som parameter
        //return verdi<h.verdi ?-1 : (verdi==h.verdi?0:1); //hvis verdi er mindre enn h.verdi; returner -1, else returner verdi==h.verdi?0:1
        if (verdi < h.verdi) return -1;
        else if (verdi == h.verdi) return 0;
        else return 1;
    }

    public boolean equals(Object o){
        if(o==this){return true;} //sammenligner med seg selv
        if(!(o instanceof Heltall)){return false;} //feil datatype
        return verdi==((Heltall)o).verdi;
    }

    public boolean equals(Heltall h){return verdi==h.verdi;}

    public int hashCode(){return 31+verdi;}

    public String toString(){return Integer.toString(verdi);}

    public static void main(String[]args){
        int[]a={5,2,7,3,9,1,8,10,4,6};
        Heltall[]h=new Heltall[a.length];

        for(int i=0; i<h.length; i++){
            h[i]=new Heltall(a[i]);
        }
        Tabel.innsettingssortering(h); //generisk sortering
        System.out.println(Arrays.toString(h)); //utskrift@

        /*Heltall x=new Heltall(3), y=new Heltall(3); //x og y er like
        System.out.println(x.compareTo(y)+" "+x.equals(y));*/

        Heltall x=new Heltall(3), y=new Heltall(3);
        System.out.println(x.hashCode()+" "+y.hashCode());
    }

}
