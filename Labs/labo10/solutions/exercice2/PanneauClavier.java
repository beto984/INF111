
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * INF111 - labo #10 : Solution partielle de l'exercice 2.
 * Panneau contenant les boutons d'un clavier de telephone, dans un GridLayout.
 * 
 *    1   2   3
 *    4   5   6
 *    7   8   9
 *    *   0   #
 *      SEND
 * 
 * @author melanie lord
 * @version novembre 2018
 */
public class PanneauClavier extends JPanel {

   /**
    * Constructeur qui initialise les composants graphiques.
    */
   public PanneauClavier () {
      initComposants();
   }
   
   /**
    * Initialise les composants graphiques.
    */
   private void initComposants() {
      
      //Grille 5 X 3 avec hgap = 0 et vgap = 10
      this.setLayout(new GridLayout(5, 3, 0, 10));
      
      //Ajout des 9 premiers boutons au panneau
      for (int i = 0; i < 9; i++) {
         this.add(new JButton(i + 1 + ""));
      }
    
      //Ajout des autres boutons
      this.add(new JButton("*"));
      this.add(new JButton("0"));
      this.add(new JButton("#"));
      this.add(new JPanel());  //pas de bouton ici, mais il faut mettre qqchose
      this.add(new JButton("SEND"));
      this.add(new JPanel());  //pas de bouton ici, mais il faut mettre qqchose
   
   }
}
