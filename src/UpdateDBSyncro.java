public class UpdateDBSyncro extends Thread {
    private GestionnaireThreads gestionnaire;
    public UpdateDBSyncro(GestionnaireThreads gestionnaire){
        super("UpdateDB");
        setGestionnaire(gestionnaire);
    }
    private void setGestionnaire(GestionnaireThreads gestionnaire){
        this.gestionnaire = gestionnaire;
    }
    public void run(){
        while(true) {
            try {
                System.out.println("Updated");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
