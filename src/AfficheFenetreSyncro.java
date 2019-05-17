import viewPackage.*;

public class AfficheFenetreSyncro extends Thread {
    private GestionnaireThreads gestionnaire;
    public AfficheFenetreSyncro(GestionnaireThreads gestionnaire){
        super("AfficheFenetre");
        setGestionnaire(gestionnaire);
    }
    private void setGestionnaire(GestionnaireThreads gestionnaire){
        this.gestionnaire = gestionnaire;
    }
    public void run(){
        while(true) {
            PrincipalWindow windowToDisplay = new PrincipalWindow();
        }
    }
}
