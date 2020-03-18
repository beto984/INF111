package appli;
import gui.*;
import audio.*;
import javax.swing.UIManager;

/**
 * DemarreSynthetiseur
 */
public class DemarreSynthetiseur {

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