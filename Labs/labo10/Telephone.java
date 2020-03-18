
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Telephone
 */
public class Telephone implements Runnable{



    private static final int LARG_FENETRE = 210;
    private static final int HAUT_FENETRE = 280;
    private static String TITRE_FENETRE = "Telephone";

    private JFrame fenetre = new JFrame(TITRE_FENETRE);

    private JPanel jPPrincipal = new JPanel();

    private PanneauClavier pClavier = new PanneauClavier();

    private JTextField ecran = new JTextField;

    @Override
    public void run() {
        initComposants();
    }

    private void initComposants(){
        fenetre.setSize(LARG_FENETRE,HAUT_FENETRE);

        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initEcran();
        initPanneauPrincipal();

        fenetre.getContentPane().add(JPPrincipal);

        fenetre.setVisible(true); 
    }

    private void initEcran(){
        ecran.setEditable(false);

        ecran.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));        
        ecran.setFont(new Font("Dialog", Font.PLAIN,16));
    }

    private void initPanneauPrincipal(){
        jPPrincipal.setLayout(new BoxLayout(jPPrincipal,BoxLayout.Y_AXIS));

         //Ajouter une bordure invisible autour du panneau principale pour 
      //creer une marge.
      jPPrincipal.setBorder(
        BorderFactory.createEmptyBorder(20, 10, 10, 10));

        //Ajout de l'ecran au panneau principal
        jPPrincipal.add(ecran);

        //Ajout d'un espacement rigide entre l'ecran et le clavier
        jPPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        //Ajout du clavier au panneau principal
        jPPrincipal.add(pClavier);
    }
    
    
}