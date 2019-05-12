package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import controllerPackage.*;
import exceptionPackage.CloseException;
import exceptionPackage.ConnectionException;
import modelPackage.*;


public class PrincipalWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem accueil, exit;
    private Container frameContainer = this.getContentPane();
    private ConnectionController controller;
    public PrincipalWindow(){
        super("Accueil");
        setController(new ConnectionController());
        setBounds(50,100,1800,500);
        new AccueilPanel(this).setPanel();

        // MENU
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        optionMenu = new JMenu("Option");
        optionMenu.setMnemonic('O');
        menuBar.add(optionMenu);
        accueil = new JMenuItem("Accueil");
        accueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(accueil);
        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        optionMenu.add(exit);

        // Croix rouge ou quitter
        this.addWindowListener(new ClosingWindow(this));
        exit.addActionListener(new MenuExit(this));
        setVisible(true);

        // Bouton accueil
        accueil.addActionListener(new MenuAccueil(this));
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
}

