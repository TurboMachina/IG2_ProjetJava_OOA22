package modelPackage;

import java.util.*;

public class FicheVéhicule {
    private long numChassis;
    private GregorianCalendar dateMiseCircu;
    public FicheVéhicule(long nc, int jour, int mois, int annee){
        numChassis = nc;
        dateMiseCircu = setDateMiseCircu(jour, mois, annee);
    }
    public GregorianCalendar setDateMiseCircu(int jour, int mois, int annee){
        return new GregorianCalendar(jour, mois, annee); // faux mais j'ai pas internet pour la doc de GC
    }
}
