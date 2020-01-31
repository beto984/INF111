
//pour utiliser les methode de la classe Arrays
import java.util.Arrays;


/**
 * Classe de tests pour le module UtilitaireTabReels.
 * 
 * A COMPLETER AVEC VOS PROPRES TESTS.
 * 
 * @author melanie lord
 * @version automne 2018
 */
public class TestsUtilitaireTabReels {
   
   /**
    * Affiche un tableau de double. - POUR TESTS.
    * @param tab le tableau a afficher.
    */
   public static void afficherTabReels (final double[] tab) {
      System.out.println(Arrays.toString(tab));
   }
   
   /**
    * Tests pour la methode decalerADroite de la classe UtilitaireTabReels.
    */
   public static void testsMethodeDecalerADroite() {
      final double[] t0 = {};
      double[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      System.out.println("\nTESTS - DECALER A DROITE");
      
      UtilitaireTabReels.decalerADroite(t0, 0, 0); //pos invalide, aucun changement
      System.out.print("1.");
      afficherTabReels(t0); //[]
      
      UtilitaireTabReels.decalerADroite(t1, 0, 0);  //pos invalide, aucun changement
      System.out.print("2.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 1, 0);
      System.out.print("3.");
      afficherTabReels(t1); //[1.0, 1.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 4, 0);
      System.out.print("4.");
      afficherTabReels(t1); //[1.0, 1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 2, 1);
      System.out.print("5.");
      afficherTabReels(t1); //[1.0, 2.0, 2.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 6, 3);
      System.out.print("6.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 4.0, 5.0, 6.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 6, 5);
      System.out.print("7.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 6.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 9, 2);
      System.out.print("8.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerADroite(t1, 7, 7);  //pos invalide, aucun changement
      System.out.print("9.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
   }
   
   
   /**
    * Tests pour la methode decalerAGauche de la classe UtilitaireTabReels.
    */
   public static void testsMethodeDecalerAGauche() {
      final double[] t0 = {};
      double[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      System.out.println("\nTESTS - DECALER A GAUCHE");
      
      UtilitaireTabReels.decalerAGauche(t0, 0, 0); //pos invalide, aucun changement
      System.out.print("1.");
      afficherTabReels(t0); //[]
      
      UtilitaireTabReels.decalerAGauche(t1, 3, 0);  //pos invalide, aucun changement
      System.out.print("2.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      UtilitaireTabReels.decalerAGauche(t1, 3, 3);  //pos invalide, aucun changement
      System.out.print("3.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 3, 1);
      System.out.print("4.");
      afficherTabReels(t1); //[2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 6, 3);
      System.out.print("5.");
      afficherTabReels(t1); //[2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 9, 5);
      System.out.print("6.");
      afficherTabReels(t1); //[1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 2, 1);
      System.out.print("7.");
      afficherTabReels(t1); // [2.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 1, 0); //pos invalide, aucun changement 
      System.out.print("8."); 
      afficherTabReels(t1); // [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      
      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 5, 4); 
      System.out.print("9.");
      afficherTabReels(t1); // [1.0, 2.0, 3.0, 5.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
   }
   
   public static void testsMethodeAjouterAPos(){
      final double[] t0 = {};
      final double[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

      System.out.println("\nTESTS - INSERER A POS");

      double[] tab2=UtilitaireTabReels.ajouterAPos(t0, 0, 0, 0);
      System.out.print("1.");
      afficherTabReels(tab2);//[0.0]

      tab2=UtilitaireTabReels.ajouterAPos(t1, 10, 3, 5);
      System.out.print("2.");
      afficherTabReels(tab2);//[[1.0, 2.0, 3.0, 5.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]]

      tab2=UtilitaireTabReels.ajouterAPos(t1, 6, 6, 7.0);
      System.out.print("3.");
      afficherTabReels(tab2);//[1.0, 2.0, 3.0, 4.0, 5.0, 7.0, 6.0, 8.0, 9.0, 10.0]

      tab2=UtilitaireTabReels.ajouterAPos(t1, 8, 6, 5.0);
      System.out.print("4.");
      afficherTabReels(tab2);//4.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 7.0, 8.0, 10.0]

   }
  
   public static void testsMethodeSuprimmerAPos(){
      final double[] t0 = {};
      double[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

      System.out.println("\nTESTS - SUPPRIMER A POS");

      UtilitaireTabReels.supprimerAPos(t0, 0, 0); //pos invalide, aucun changement
      System.out.print("1.");
      afficherTabReels(t0); //[]

      UtilitaireTabReels.supprimerAPos(t1, 4, 2);  
      System.out.print("2.");
      afficherTabReels(t1); //[1.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]

      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 10, 1); 
      System.out.print("3.");
      afficherTabReels(t1); // [2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 9.0, 10.0]

      t1 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      UtilitaireTabReels.decalerAGauche(t1, 5, 3); 
      System.out.print("4.");
      afficherTabReels(t1); // [1.0, 2.0, 4.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
   }
  
   /**
    * Executez la methode de tests correspondante a mesure que vous implementez
    * vos methodes dans la classe UtilitaireTabReels
    * 
    * Ajoutez d'autres tests pour les autres methodes de la classe 
    * UtilitaireTabReels.
    * 
    * @param args (aucun)
    */
   public static void main (final String [] args) {
      
      //Decommenter la methode de test que vous voulez executer
      
      /*
      La methode suivante doit afficher ceci si votre methode decalerADroite 
      fonctionne :
      TESTS - DECALER A DROITE
      1.[]
      2.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      3.[1.0, 1.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      4.[1.0, 1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      5.[1.0, 2.0, 2.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      6.[1.0, 2.0, 3.0, 4.0, 4.0, 5.0, 6.0, 8.0, 9.0, 10.0]
      7.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 6.0, 8.0, 9.0, 10.0]
      8.[1.0, 2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
      9.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      */
      //testsMethodeDecalerADroite();  //decommenter pour executer
      
      
      /*
      La methode suivante doit afficher ceci si votre methode decalerAGauche 
      fonctionne :
      TESTS - DECALER A GAUCHE
      1.[]
      2.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      3.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      4.[2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      5.[1.0, 2.0, 4.0, 5.0, 6.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      6.[1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 9.0, 10.0]
      7.[2.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      8.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      9.[1.0, 2.0, 3.0, 5.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      9.[1.0, 2.0, 3.0, 5.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      */
      //testsMethodeDecalerAGauche();
      

      /* La methode suivante doit afficher ceci si la methode ajouterAPos 
      fonctionne :

      TESTS - INSERER A POS
      1.[0.0]
      2.[1.0, 2.0, 3.0, 5.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      3.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      4.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 7.0, 8.0, 10.0]
      */
      //testsMethodeAjouterAPos();
      

      /*La methode suivante doit afficher ceci si la methode supprimerAPos 
      fonctionne: 

      TESTS - SUPPRIMER A POS
      1 .[]
      2.[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
      3.[2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 9.0, 10.0]
      4.[1.0, 2.0, 4.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]

      */
      //testsMethodeSuprimmerAPos();

      //Faire vos autres methodes de tests pour tester les autres methodes
      //du module UtilitaireTabReels...
   
   }
   
}
