
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
 * INF111 : solution Laboratoire #10 - Exercice 1.
 * Petite interface graphique simple.
 *
 * @author Melanie Lord
 * @version novembre 2018
 */
public class Exercice1 implements Runnable {
   
   //------------------------------------------------
   // CONSTANTES
   //------------------------------------------------
   
   private static final String [] TAB_CHOIX_CASSE = {"Minuscule", "Majuscule"};
   private static final int LARG_FENETRE = 700;
   private static final int HAUT_FENETRE = 80;
   private static final String TITRE_FENETRE = "Exercice 1";
   
   //------------------------------------------------
   // ATTRIBUTS D'INSTANCE
   //------------------------------------------------
   
   private JFrame fenetre = new JFrame();
   private JLabel jLMot = new JLabel("Mot");
   
   //Champ texte de longueur 8 colonnes 
   //(setSize ne fonctionne pas dans un FlowLayout)
   private JTextField jTFMot = new JTextField(8);  
   
   //Construction de la combo box avec les elements de TAB_CHOIX_CASSE
   private JComboBox jCBChoixCasse = new JComboBox(TAB_CHOIX_CASSE);
   
   //Boutons radio
   private JRadioButton jRBleu = new JRadioButton("Bleu");
   private JRadioButton jRRouge = new JRadioButton("Rouge");
   
   //Creation du groupe de boutons pour les boutons radio
   private ButtonGroup groupeCouleurs = new ButtonGroup();
   
   private JButton jBInverser = new JButton("Inverser Mot");
   
   //Champ texte pour le mot inverse de longueur 8 colonnes 
   //(setSize ne fonctionne pas dans un FlowLayout)
   private JTextField jTFMotInverse = new JTextField(8);
   
   /**
    * Initialise les composants graphiques.
    */
   private void initComposants() {
      Container c;
      
      //modifier le layout du JFrame pour un FlowLayout dont l'alignement est
      //centre, avec un hgap de 5 et un vgap de 15.
      fenetre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
      
      fenetre.setTitle(TITRE_FENETRE);
      fenetre.setSize(LARG_FENETRE, HAUT_FENETRE);
   
      //Positionner la fenetre dans le centre de l'ecran
      fenetre.setLocationRelativeTo(null);
      
      //Terminer le programme a la fermeture de la fenetre
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Assigner la couleur bleu a la police dans le champ texte Mot
      jTFMot.setForeground(Color.BLUE);
      
      //Selectionner le bouton radio bleu
      jRBleu.setSelected(true);
      
      //Ajouter les deux boutons radion dans le ButtonGroup groupeCouleurs
      //pour empecher la selection de plus d'un bouton a la fois.
      groupeCouleurs.add(jRBleu);
      groupeCouleurs.add(jRRouge);
      
      //rendre le champ texte du mot invers non editable
      jTFMotInverse.setEditable(false);
      
      //Ajouter les composants a la fenetre
      c = fenetre.getContentPane();
      c.add(jLMot);
      c.add(jTFMot);
      c.add(jCBChoixCasse);
      c.add(jRBleu);
      c.add(jRRouge);
      c.add(jBInverser);
      c.add(jTFMotInverse);
      
      //rendre la fenetre visible
      fenetre.setVisible(true);
   }
   
   //------------------------------------------------
   // IMPLEMENTATION DE L'INTERFACE RUNNABLE
   //------------------------------------------------
   
   /**
    * Redefinition de la methode run de l'interface Runnable.
    * Initialisation des composants graphiques.
    */
   public void run() {
      //initialisation des composants
      initComposants();
   }
   
   //------------------------------------------------
   // METHODE MAIN
   //------------------------------------------------
   
   /**
    * Demarrer l'application.
    * @param args (non utilises)
    */
   public static void main (String [] args) {
      Thread t = new Thread(new Exercice1());
      t.start();
   }
   
}
