package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controllerPackage.*;
import exceptionPackage.CloseException;


public class PrincipalWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu optionMenu, rechercheMenu, whoMenu;
    private JMenuItem accueil, exit, rechercheTrans, rechercheVente, rechercheModele;
    private Container frameContainer = this.getContentPane();
    private ConnectionController controller;

    public PrincipalWindow(){
        super("Accueil");
        setController(new ConnectionController());
        new AccueilPanel(this).setPanel();
        // MENU
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        optionMenu = new JMenu("Option");
        optionMenu.setMnemonic('O');
        menuBar.add(optionMenu);

        rechercheMenu = new JMenu("Recherche");
        rechercheMenu.setMnemonic('R');
        menuBar.add(rechercheMenu);

        whoMenu = new JMenu("?");
        whoMenu.setMnemonic('?');
        menuBar.add(whoMenu);
        whoMenu.addMouseListener(new whoMenuAction(this));

        //Item Menu 1
        accueil = new JMenuItem("Accueil");
        accueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(accueil);
        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(exit);

        //Item Menu 2
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
        rechercheTrans.addActionListener(new MenuRechercheTransaction(this));
        rechercheModele.addActionListener(new MenuRechercheModele(this));
        rechercheVente.addActionListener(new MenuRechercheVente(this));
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
            catch (CloseException e){
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
            catch (CloseException e){
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
            if (!(exit.getComponent() instanceof AccueilPanel))
                new AccueilPanel(w).setPanel();
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
}

