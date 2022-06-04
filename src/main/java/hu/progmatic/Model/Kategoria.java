package hu.progmatic.Model;

public enum Kategoria {
    FERFI,
    NOI,
    MEGHATAROZATLAN;

    public static Kategoria fromString(String kategoria){
        if(kategoria.equalsIgnoreCase("ferfi")){
            return FERFI;
        }
        if(kategoria.equalsIgnoreCase("noi")){
            return NOI;
        }
        return MEGHATAROZATLAN;
    }
}
