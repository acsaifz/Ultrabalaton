package hu.progmatic;

import hu.progmatic.Model.Kategoria;
import hu.progmatic.Model.Verseny;
import hu.progmatic.Model.Versenyzo;

import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Verseny ultraBalaton2017 = new Verseny();
        ultraBalaton2017.betoltFajlbol("src/main/resources/ub2017egyeni.txt");

        System.out.println(String.format("3. feladat: Egyéni indulók: %d fő",ultraBalaton2017.getVersenyzok().size()));
        System.out.println(String.format("4. feladat: Célbaérő női versenyzők: %d fő", ultraBalaton2017.celbaEroVersenyzokKategoriaAlapjan(Kategoria.NOI).size()));
        System.out.print("5. feladat: Kérem a sportoló nevét: " );
        Versenyzo sportolo = ultraBalaton2017.getVersenyzoNevAlapjan(kerdSportoloNeve());
        System.out.print("\tIndult egyéniben a sportoló? ");
        if (sportolo != null){
            System.out.println("Igen");
            System.out.println("\tTeljesítette a teljes távot? " + (sportolo.getTavSzazalek() == 100 ? "Igen" : "Nem"));
        }else{
            System.out.println("Nem");
        }
        System.out.println(String.format("7. feladat: Átlagos idő: %f óra", ultraBalaton2017.atlagIdoKategoriaSzerintTeljesTavon(Kategoria.FERFI)));
        System.out.println("8. feladat: Verseny győztesei");
        Map<Kategoria,Versenyzo> gyoztesek = ultraBalaton2017.gyoztesekKategoriaSzerint();
        System.out.println("\tNők: " + gyoztesek.get(Kategoria.NOI));
        System.out.println("\tFérfiak: " + gyoztesek.get(Kategoria.FERFI));
    }

    public static String kerdSportoloNeve(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
