package appli;

import javax.swing.UIManager;

import audio.*;
import gui.*;

/**
 * DemarreSynthetiseur
 */
public class DemarreSynthetiseur {

    /**
     * Fonction donnée utilisée pour regulariser 
     * l'esthetique de l'application sur tous les systemes
     * d'exploitation 
     */
    public static void setLookAndFeel() {
        try { UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { 
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        setLookAndFeel();
        Thread t = new Thread(new gui.GUISynthetiseur());
        t.start();
    }
}