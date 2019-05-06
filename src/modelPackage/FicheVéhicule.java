package modelPackage;

import java.util.*;

public class FicheVéhicule {
    private long numChassis;
    private GregorianCalendar dateMiseCircu;
    public FicheVéhicule(long numChassis, int jour, int mois, int annee){
        this.numChassis = numChassis;
        dateMiseCircu = setDateMiseCircu(jour, mois, annee);
    }
    public GregorianCalendar setDateMiseCircu(int jour, int mois, int annee){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.DAY_OF_MONTH,jour);
        gc.set(Calendar.MONTH, mois);
        gc.set(Calendar.YEAR,annee);
        return gc;
    }
}
