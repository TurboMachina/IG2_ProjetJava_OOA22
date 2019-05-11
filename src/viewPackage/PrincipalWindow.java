package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controllerPackage.*;
import modelPackage.*;


public class PrincipalWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem accueil, exit;
    private Container frameContainer = this.getContentPane();
    public PrincipalWindow(){
        super("Accueil");
        setBounds(100,100,1800,500);
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
        PrincipalWindow.ClosingWindow closer = new ClosingWindow();
        this.addWindowListener(closer);
        PrincipalWindow.MenuExit menuCloser = new MenuExit();
        exit.addActionListener(menuCloser);
        setVisible(true);
    }

    public Container getFrameContainer(){
        return this.frameContainer;
    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            try{
                // utilityController.closeConnection();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }
    }

    private class MenuExit implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try{
                // utilityController.closeConnection();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }
    }

}
