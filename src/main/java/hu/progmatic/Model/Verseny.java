package hu.progmatic.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Verseny {
    private final List<Versenyzo> versenyzok = new ArrayList<>();

    public Map<Kategoria,Versenyzo> gyoztesekKategoriaSzerint(){
        Map<Kategoria,Versenyzo> gyoztesek = new HashMap<>();
        double minNoiIdo = Integer.MAX_VALUE;
        double minFerfiIdo = Integer.MAX_VALUE;

        for (Versenyzo versenyzo: versenyzok){
            if (versenyzo.getKategoria() == Kategoria.FERFI){
                if (minFerfiIdo > versenyzo.getIdoOraban() && versenyzo.getTavSzazalek() == 100){
                    minFerfiIdo = versenyzo.getIdoOraban();
                    gyoztesek.put(Kategoria.FERFI,versenyzo);
                }
            }else{
                if (minNoiIdo > versenyzo.getIdoOraban() && versenyzo.getTavSzazalek() == 100){
                    minNoiIdo = versenyzo.getIdoOraban();
                    gyoztesek.put(Kategoria.NOI,versenyzo);
                }
            }
        }
        return gyoztesek;
    }

    public double atlagIdoKategoriaSzerintTeljesTavon(Kategoria kategoria){
        double osszeg = 0;
        int szamlalo = 0;
        for (Versenyzo versenyzo: versenyzok){
            if (versenyzo.getKategoria() == kategoria && versenyzo.getTavSzazalek() == 100){
                osszeg += versenyzo.getIdoOraban();
                szamlalo++;
            }
        }
        return osszeg/szamlalo;
    }

    public void betoltFajlbol(String fajlUtvonal){
        try(Scanner olvaso = new Scanner(new File(fajlUtvonal))){
            olvaso.nextLine();
            while (olvaso.hasNextLine()){
                versenyzok.add(
                        new Versenyzo(this,olvaso.nextLine())
                );
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Versenyzo getVersenyzoNevAlapjan(String nev){
        for (Versenyzo versenyzo: versenyzok){
            if(versenyzo.getNev().equalsIgnoreCase(nev)){
                return versenyzo;
            }
        }
        return null;
    }

    public List<Versenyzo> celbaEroVersenyzokKategoriaAlapjan(Kategoria kategoria){
        List<Versenyzo> nok = new ArrayList<>();
        for (Versenyzo versenyzo: versenyzok){
            if (versenyzo.getKategoria() == kategoria && versenyzo.getTavSzazalek() == 100){
                nok.add(versenyzo);
            }
        }
        return nok;
    }


    public List<Versenyzo> getVersenyzok(){
        return versenyzok;
    }
}
