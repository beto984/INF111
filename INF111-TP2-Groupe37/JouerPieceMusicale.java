import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * JouerPieceMusicale
 */
public class JouerPieceMusicale {

    public static void preparerPourMac() {
        try {
        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { 
            e.printStackTrace();
        } 
    }

    private static final String[] MSG_MENU = {"1) Selectionner une piece","2) Jouer la piece selectionnee",
    "3) Quitter"};
    private static final String MSG_ERREUR_NO_SONG = "Il faut selectionner une piece ";
    private static final String MSG_ERREUR_INVALID = "Choix invalide!";
    
    public static void main(String args[]) {
        preparerPourMac();
        Fichier fichier = new Fichier();
        PieceMusicale piece = null;
        String choix;
        do {
            
            choix = (String) JOptionPane.showInputDialog(null,"Choissisez une option","Menu:",
            JOptionPane.QUESTION_MESSAGE,
            null,
            MSG_MENU,
            MSG_MENU[0]
            );
            if (choix.equals(MSG_MENU[0])) {
                final JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(null);
                piece = Fichier.obtenirChanson(chooser.getSelectedFile().getPath());
            } else if (choix.equals(MSG_MENU[1])) {
                if (piece == null) {
                    JOptionPane.showMessageDialog(null, MSG_ERREUR_NO_SONG);
                } else {
                    piece.jouer();
                }
            } else if (choix.equals(MSG_MENU[2])) {

            } else {
                JOptionPane.showMessageDialog(null, MSG_ERREUR_INVALID);
            }
        } while (!choix.equals("3"));
    }
}


    
