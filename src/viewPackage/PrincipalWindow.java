package viewPackage;

import controllerPackage.ConnectionController;
import controllerPackage.StatistiqueController;
import exceptionPackage.CloseException;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetTransactionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PrincipalWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu optionMenu, rechercheMenu, actionMenu, whoMenu;
    private JMenuItem accueil, exit, rechercheTrans, rechercheVente, rechercheModele, listing, ajouter, statistiques;
    private Container frameContainer = this.getContentPane();
    private ConnectionController controller;
    private StatistiqueController statController;
    private Boolean isConnectionOn = false;

    public PrincipalWindow(){
        super("Accueil");
        setController(new ConnectionController());
        setStatController(new StatistiqueController());
        new AccueilPanel(this).setPanel();
        // MENU
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        optionMenu = new JMenu("Option");
        optionMenu.setMnemonic('O');
        menuBar.add(optionMenu);

        actionMenu = new JMenu("Action");
        actionMenu.setMnemonic('C');
        menuBar.add(actionMenu);

        rechercheMenu = new JMenu("Recherche");
        rechercheMenu.setMnemonic('R');
        menuBar.add(rechercheMenu);

        whoMenu = new JMenu("?");
        whoMenu.setMnemonic('?');
        menuBar.add(whoMenu);
        whoMenu.addMouseListener(new whoMenuAction(this));

        //Item Menu 1
        accueil = new JMenuItem("Accueil");
        accueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(accueil);
        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(exit);

        // Item Menu 2

        listing = new JMenuItem("Listing");
        listing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        actionMenu.add(listing);
        ajouter = new JMenuItem("Ajout");
        ajouter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
        actionMenu.add(ajouter);
        statistiques = new JMenuItem("Statistiques");
        statistiques.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        actionMenu.add(statistiques);

        //Item Menu 3
        rechercheTrans = new JMenuItem("Recherche transaction commercial");
        rechercheTrans.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK )));
        rechercheMenu.add(rechercheTrans);
        rechercheModele = new JMenuItem("Recherche modéle vendu");
        rechercheModele.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK )));
        rechercheMenu.add(rechercheModele);
        rechercheVente = new JMenuItem("Recherche vente sur une période");
        rechercheVente.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK )));
        rechercheMenu.add(rechercheVente);

        // Croix rouge ou quitter
        this.addWindowListener(new ClosingWindow(this));
        setVisible(true);

        // Bouton Menu
        accueil.addActionListener(new MenuAccueil(this));
        exit.addActionListener(new MenuExit(this));
        ajouter.addActionListener(new MenuAjout(this));
        listing.addActionListener(new MenuListing(this));
        statistiques.addActionListener(new MenuStatistiques(this));
        rechercheTrans.addActionListener(new MenuRechercheTransaction(this));
        rechercheModele.addActionListener(new MenuRechercheModele(this));
        rechercheVente.addActionListener(new MenuRechercheVente(this));
        try{
            controller.checkConnection();
        }
        catch (ConnectionException e){
            actionMenu.setEnabled(false);
            JOptionPane.showMessageDialog(this,"Connection à la base de données impossible\n Verifier la connection puis redémarrer le programme", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Container getFrameContainer(){
        return this.frameContainer;
    }

    public void setController(ConnectionController controller){
        this.controller = controller;
    }

    private class ClosingWindow extends WindowAdapter
    {
        PrincipalWindow w;

        public ClosingWindow(PrincipalWindow w){
            this.w = w;
        }

        public void windowClosing(WindowEvent event){

            try{
                controller.closeConnection();
            }
            catch (CloseException | ConnectionException e){
                JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        }
    }

    private class MenuExit implements ActionListener
    {
        PrincipalWindow w;

        public MenuExit(PrincipalWindow w){
            this.w = w;
        }

        public void actionPerformed(ActionEvent event)
        {
            try{
                controller.closeConnection();
            }
            catch (CloseException | ConnectionException e){
                JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        }
    }

    private class MenuAccueil implements ActionListener
    {
        PrincipalWindow w;
        public MenuAccueil(PrincipalWindow w){
            this.w = w;
        }

        public void actionPerformed(ActionEvent event) {
            if (!(w.getFrameContainer() instanceof AccueilPanel))
                new AccueilPanel(w).setPanel();
        }
    }
    private class MenuListing implements ActionListener
    {
        PrincipalWindow w;
        public MenuListing(PrincipalWindow w) { this.w = w; }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (!(w.getFrameContainer() instanceof ListingPanel))
                new ListingPanel(w).setPanel();
        }
    }
    private class MenuAjout implements ActionListener
    {
        PrincipalWindow w;
        public MenuAjout(PrincipalWindow w) { this.w = w; }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (!(w.getFrameContainer() instanceof ListingPanel))
                new AjoutPanel(w).setPanel();
        }
    }
    private class MenuStatistiques implements ActionListener
    {
        PrincipalWindow w;
        public MenuStatistiques(PrincipalWindow w) { this.w = w; }
        @Override
        public void actionPerformed(ActionEvent event) {
            String stats = null;

            try{
                stats = statController.getStatistiques();
            }
            catch (ConnectionException | GetTransactionException | GetMarqueException e) {
                JOptionPane.showMessageDialog(w, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(w, stats, "Statistiques", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class whoMenuAction implements MouseListener {
        PrincipalWindow w;
        public whoMenuAction(PrincipalWindow w) {this.w = w;}

        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(w,"Programme fait par Herlinvaux Alexandre & Herrent Antoine \nDans le cadre du cours de programmation avancée \nIG2 Henallux IESN Namur 2018-2019", "Information sur le programme", JOptionPane.INFORMATION_MESSAGE);
            w.whoMenu.setSelected(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class MenuRechercheTransaction implements ActionListener
    {
        PrincipalWindow w;
        public MenuRechercheTransaction(PrincipalWindow w){
            this.w = w;
        }

        public void actionPerformed(ActionEvent event) {
                new RechercheTransaction(w).setPanel();
        }

    }

    private class MenuRechercheModele implements ActionListener
    {
        PrincipalWindow w;
        public MenuRechercheModele(PrincipalWindow w){
            this.w = w;
        }

        public void actionPerformed(ActionEvent event) {
            new RechercheModele(w).setPanel();
        }

    }

    private class MenuRechercheVente implements ActionListener
    {
        PrincipalWindow w;
        public MenuRechercheVente(PrincipalWindow w){
            this.w = w;
        }

        public void actionPerformed(ActionEvent event) {
            new RechercheVente(w).setPanel();
        }

    }
    private void setStatController(StatistiqueController statController ) {this.statController = statController; }
}

