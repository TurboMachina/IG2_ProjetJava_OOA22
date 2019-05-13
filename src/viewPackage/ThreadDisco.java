package viewPackage;

import exceptionPackage.ThreadException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

public class ThreadDisco extends JFrame implements Runnable {

        private Thread t1;
        private PrincipalWindow w;
        private Boolean isRunning = false;
        private Color [] couleurs = new Color[]{yellow,black,cyan,pink,gray,red,white,green};

        public ThreadDisco(PrincipalWindow w){
            this.w = w;

        }

        public void threadStart(){
            if(!this.isRunning){
                t1 = new Thread(this);
                this.isRunning = true;
                t1.start();
            }
        }

        public void threadStop(){
            this.isRunning = false;
        }

        public boolean isRunning(){
            return this.isRunning;
        }

        public void run(){
               for(int i = 0; i < couleurs.length; i++){
                   w.getFrameContainer().setBackground(couleurs[i]);
                   try{
                       t1.sleep(1000);
                   }
                   catch(InterruptedException e) {
                       JOptionPane.showMessageDialog(w, new ThreadException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                   }
               }
        }
    }

