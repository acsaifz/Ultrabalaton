package hu.progmatic.Model;

public class Versenyzo {
    private Verseny verseny;
    private String nev;
    private int rajtSzam;
    private Kategoria kategoria;
    private String versenyido;
    private int tavSzazalek;

    public Versenyzo(Verseny verseny, String line){
        String[] parameterek = line.split(";");
        this.verseny = verseny;
        this.nev = parameterek[0];
        this.rajtSzam = Integer.parseInt(parameterek[1]);
        this.kategoria = Kategoria.fromString(parameterek[2]);
        this.versenyido = parameterek[3];
        this.tavSzazalek = Integer.parseInt(parameterek[4]);
    }

    public double getIdoOraban(){
        String[] ido = versenyido.split(":");
        int ora = Integer.parseInt(ido[0]);
        int perc = Integer.parseInt(ido[1]);
        int masodperc = Integer.parseInt(ido[2]);

        return  ora + perc/60d + masodperc/3600d;
    }

    public Verseny getVerseny(){
        return verseny;
    }

    public void setVerseny(Verseny verseny){
        this.verseny = verseny;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getRajtSzam() {
        return rajtSzam;
    }

    public void setRajtSzam(int rajtSzam) {
        this.rajtSzam = rajtSzam;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public String getVersenyido() {
        return versenyido;
    }

    public void setVersenyido(String versenyido) {
        this.versenyido = versenyido;
    }

    public int getTavSzazalek() {
        return tavSzazalek;
    }

    public void setTavSzazalek(int tavSzazalek) {
        this.tavSzazalek = tavSzazalek;
    }

    @Override
    public String toString() {
        return String.format("%s (%d.) - %s",nev,rajtSzam,versenyido);
    }
}
