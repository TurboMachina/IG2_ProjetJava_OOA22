package viewPackage;

import exceptionPackage.ThreadException;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class ThreadDisco extends JFrame implements Runnable {

        private Thread disco;
        private PrincipalWindow w;
        private Boolean isRunning = false;
        private Color [] couleurs = new Color[]{yellow,black,cyan,pink,gray,red,white,green};

        public ThreadDisco(PrincipalWindow w){
            this.w = w;
        }

        public void threadStart(){
            if(!this.isRunning){
                disco = new Thread(this);
                this.isRunning = true;
                disco.start();
            }
        }

        public void run(){
           while(true){
               for(Color couleur : couleurs){
                   w.getFrameContainer().setBackground(couleur);
                   try{
                       disco.sleep(1000);
                   }
                   catch(InterruptedException e) {
                       JOptionPane.showMessageDialog(w, new ThreadException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                   }
               }
           }
        }
    }

