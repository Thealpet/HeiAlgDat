package eksempelklasser;

public enum Studium {
    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Elektro ("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel
    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public String toString() { return fulltnavn; }

    public static void main(String[]args){
        for(Studium s: Studium.values()){
            System.out.println(s.toString()+"("+s.name()+")");

        }
    }
}


