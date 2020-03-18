
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
 * INF111 : solution Laboratoire #10 - Exercice 2.
 * Interface graphique : telephone
 *
 * @author Melanie Lord
 * @version novembre 2018
 */
public class Telephone implements Runnable {
   
   //------------------------------------------------
   // CONSTANTES
   //------------------------------------------------
   
   private static final int LARG_FENETRE = 210;
   private static final int HAUT_FENETRE = 280;
   private static final String TITRE_FENETRE = "Telephone";

   //-----------------------------
   // ATTRIBUTS D'INSTANCE
   //-----------------------------
   
   //fenetre principale
   //On conserve le layout manager par defaut : BorderLayout
   
   //Creer la fenetre avec un titre
   private JFrame fenetre = new JFrame(TITRE_FENETRE);      
   
   //panneau principal qui contient l'ecran et le clavier
   private JPanel jPPrincipal = new JPanel();               
   
   //panneau qui contient les boutons du clavier
   private PanneauClavier pClavier = new PanneauClavier();  
   
   //Le champ texte representant l'ecran
   private JTextField ecran = new JTextField();
   
   
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

   /**
    * Initialisation des composants graphiques.
    */
   private void initComposants() {

      //-----------------------------
      // INIT FENETRE
      //-----------------------------
      
      //Dimensionner la fenetre principale
      fenetre.setSize(LARG_FENETRE, HAUT_FENETRE);
      
      //centrer la fenetre au milieu de l'ecran
      fenetre.setLocationRelativeTo(null);
      
      //fenetre redimensionnable
      fenetre.setResizable(true);

      //terminer le programme a la fermeture de la fenetre
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //------------------------------------------------
      // INIT ECRAN
      //------------------------------------------------

      initEcran();
      
      //------------------------------------------------
      // INIT PANNEAU PRINCIPAL
      //------------------------------------------------

      initPanneauPrincipal();
      
      //------------------------------------------------
      // AJOUT DES COMPOSANTS A LA FENETRE
      //------------------------------------------------
      
      //Ajouter le panneau pricipal a la fenetre 
      //(dans region du centre par defaut)
      fenetre.getContentPane().add(jPPrincipal);

      //rendre la fenetre visible
      fenetre.setVisible(true);
   }
   
   /**
    * Initialise le champ texte pour l'ecran :
    *    - non editable
    *    - avec bordure noire de 1 px
    *    - avec police Dialog, PLAIN, grosseur 16
    */
   private void initEcran() {
      
      //Rendre l'ecran non editable
      ecran.setEditable(false);
      
      //Ajouter une bordure noire au champ ecran
      ecran.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
      
      //Modier la police de caracteres pour qu'elle soit plus grande que
      //celle par defaut
      ecran.setFont(new Font("Dialog", Font.PLAIN, 16));
   }
   
   /**
    * Initialise le panneau principal et y ajoute l'ecran et le clavier
    *    - BoxLayout
    *    - Bordure invisible pour creer une marge
    */
   private void initPanneauPrincipal() {
      
      //Modifier le layout manager du panneau principal pour un
      //BoxLayout aligne verticalement.
      jPPrincipal.setLayout(new BoxLayout(jPPrincipal, BoxLayout.Y_AXIS));
      
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
