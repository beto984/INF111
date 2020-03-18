import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

/**
 * Exercice1
 */
public class Exercice1 implements Runnable {

    private static final String[] TAB_CHOIX_CASSE = { "Minuscule", "Majuscule" };
    private static final int LARG_FENETRE = 700;
    private static final int HAUT_FENETRE = 80;
    private static final String TITRE_FENETRE = "Exercice 1";

    // Attributs d'instance

    private JFrame fenetre = new JFrame();
    private JLabel jLMot = new JLabel();

    // Champ texte
    private JTextField jTFMot = new JTextField(8);

    // ComboBox
    private JComboBox jCBChoixCasse = new JComboBox(TAB_CHOIX_CASSE);

    private JRadioButton jRBleu = new JRadioButton("Bleu");
    private JRadioButton jRRouge = new JRadioButton("Rouge");

    private ButtonGroup groupeCouleurs = new ButtonGroup();

    private JButton jBInverser = new JButton("Inverser Mot");

    private JTextField jTFMotInverse = new JTextField(8);

    private void initComposants() {
        Container c; 

        fenetre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
        
        fenetre.setTitle(TITRE_FENETRE);
        fenetre.setSize(LARG_FENETRE,HAUT_FENETRE);

        fenetre.setLocationRelativeTo(null);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jTFMot.setForeground(Color.BLUE);
    

        jRBleu.setSelected(true);

        groupeCouleurs.add(jRBleu);
        groupeCouleurs.add(jRRouge);

        jTFMotInverse.setEditable(false);

        c = fenetre.getContentPane();
        c.add(jLMot);
        c.add(jTFMot);
        c.add(jCBChoixCasse);
        c.add(jRBleu);
        c.add(jRRouge);
        c.add(jBInverser);
        c.add(jTFMotInverse);

        fenetre.setVisible(true);
    }

    @Override
    public void run() {
        initComposants();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Exercice1());
        t.start();
    }
}