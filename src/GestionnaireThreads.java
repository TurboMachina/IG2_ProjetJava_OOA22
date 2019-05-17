import viewPackage.PrincipalWindow;

public class GestionnaireThreads {
    // ZONE COMMUNE

    private boolean toRefresh = true;

    public synchronized void updateDB(){
        if(!toRefresh) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        toRefresh = true;
        notify();

    }

    public synchronized void affichageWindow(){
        if(toRefresh) {
            try {
                wait();
            }
            catch (InterruptedException e){
                e.getMessage();
            }
        }
        toRefresh = false;
        notify();
    }

}
