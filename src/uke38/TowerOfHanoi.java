package uke38;

public class TowerOfHanoi {
    public static void main(String[]args){
        towerOfHanoi('A', 'B', 'C', 2);

    }

    /**
     * Solves tower of hanoi puzzle
     * @param a => pinnen vi starter med brikker på
     * @param b => hjelpepinnen
     * @param c => pinnen vi slutter på
     */
    public static void towerOfHanoi(char a, char b, char c, int brikkenr){

        if(brikkenr==0){
            return; //gjør vi ingenting. Brikkenr 0 finnes ikke
        }
        //Flytt alle unntatt nederste fra A til B
        towerOfHanoi(a, c, b, brikkenr-1);

        //Flytt nederste fra A til C
        System.out.println("Flytter brikke "+brikkenr+" fra "+a+" til "+c );

        //Flytt alle fra B til C
        towerOfHanoi(b, a, c, brikkenr-1);
    }
}
