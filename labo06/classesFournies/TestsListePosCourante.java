
/**
 * Classe de tests pour les services d'une ListePosCouranteTableau
 * 
 * @author Melanie Lord
 * @version A2018
 */
public class TestsListePosCourante {
   
   //variables utilisees dans les tests
   private static ListePosCouranteTableau liste1 = new ListePosCouranteTableau(5);
   private static ListePosCouranteTableau liste2 = new ListePosCouranteTableau();
   
   /**
    * Affiche la liste donnee.
    * @param liste la liste a afficher
    */
   public static void afficher (ListePosCouranteTableau liste) {
      
      if (!liste.estVide()) {
         
         //try... catch necessaire pour la compilation
         try {
            liste.setPosDebut();

            for (int i = 0 ; i < liste.taille() ; i++) {
               System.out.print(liste.getElement() + "  ");

               liste.setPosSuivant();
            }

         } catch (ListeVideException e) {
            //ne doit pas se produire
            e.printStackTrace();  //pour deboguer
         }
      } else {
         System.out.print("LISTE VIDE");
      }
   }
   
   public static void main (String [] args) {
      
      System.out.println(
                "----------------------------------------------------------------\n"
              + "Tests pour les operations sur une liste avec position courante."
              + "\n\nLes resultats attendus sont entre parentheses.\n"
              + "----------------------------------------------------------------\n");
      
      System.out.println(liste1.estPleine() + " (false)");
      System.out.println(liste1.estVide() + " (true)");
      System.out.println(liste1.taille() + " (0)");

      try {
         System.out.println(liste1.getElement());
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.setPosDebut();
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.setPosFin();
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.setPosPrecedent();
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.setPosSuivant();
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.supprimer();
         System.out.println("ERREUR... ne leve pas une ListeVideException");
      } catch (ListeVideException e) {
         System.out.println("OK ! Leve bien une ListeVideException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListeVideException");
      }

      try {
         liste1.ajouterFin(1);
         liste1.ajouterFin(1);
         liste1.ajouterFin(1);
         liste1.ajouterFin(1);
         liste1.ajouterFin(1);
         liste1.ajouterFin(1);
         System.out.println("ERREUR... ne leve pas une ListePleineException");

      } catch (ListePleineException e) {
         System.out.println("OK ! Leve bien une ListePleineException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListePleineException");
      }

      liste1.vider();
      afficher(liste1);
      System.out.println(" (LISTE VIDE)");

      try {
         liste1.inserer(1);
         liste1.inserer(1);
         liste1.inserer(1);
         liste1.inserer(1);
         liste1.inserer(1);
         liste1.inserer(1);
         System.out.println("ERREUR... ne leve pas une ListePleineException");

      } catch (ListePleineException e) {
         System.out.println("OK ! Leve bien une ListePleineException");
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que ListePleineException");
      }

      liste1.vider();
      afficher(liste1);
      System.out.println(" (LISTE VIDE)");

      try {
         liste1.ajouterFin(3);
         liste1.ajouterFin(2);
         liste1.setPosPrecedent();
         liste1.inserer(10);

         afficher(liste1);
         System.out.println(" (10  3  2)");

         liste1.setPosDebut();
         liste1.setPosSuivant();

         System.out.println(liste1.getElement() + " (3)");

         liste1.setPosFin();
         System.out.println(liste1.setPosPrecedent() + " (true)");
         System.out.println(liste1.getElement() + " (3)");
         System.out.println(liste1.setPosPrecedent() + " (true)");
         System.out.println(liste1.getElement() + " (10)");
         System.out.println(liste1.setPosPrecedent() + " (false)");
         System.out.println(liste1.setPosSuivant() + " (true)");
         System.out.println(liste1.getElement() + " (3)");
         System.out.println(liste1.setPosSuivant() + " (true)");
         System.out.println(liste1.getElement() + " (2)");
         System.out.println(liste1.setPosSuivant() + " (false)");

         liste1.setPosPrecedent();
         liste1.inserer(43);
         liste1.setPosDebut();
         
         afficher(liste1);
         System.out.println(" (10  43  3  2)");
         
         liste1.setPosFin();
         liste1.inserer(55);

         afficher(liste1);
         System.out.println(" (10  43  3  55  2)");
         System.out.println(liste1.estPleine() + " (true)");
         
         liste1.setPosDebut();
         liste1.supprimer();
         liste1.setPosFin();
         liste1.supprimer();
         
         afficher(liste1);
         System.out.println(" (43  3  55)");
         System.out.println(liste1.getElement() + " (55)");
         
         liste1.supprimer();
         liste1.supprimer();
         liste1.supprimer();
         
         System.out.println(liste1.estVide() + " (true)");
         
         liste1.ajouterFin(1);
         liste1.ajouterFin(2);
         liste1.setPosDebut();
         liste1.inserer(0);
         liste1.setPosFin();
         liste1.inserer(0);
         liste1.setPosPrecedent();
         liste1.inserer(9);
         
         afficher(liste1);
         System.out.println(" (0  9  1  0  2)");
         
         System.out.println(liste2.estVide() + " (true)");
         System.out.println(liste2.estPleine() + " (false)");
         
         for (int i = 0 ; i < ListePosCouranteTableau.CAPACITE_PAR_DEFAUT ; i++) {
            liste2.ajouterFin(i);
         }
         
         System.out.println(liste2.estVide() + " (false)");
         System.out.println(liste2.estPleine() + " (true)");
         

      } catch (ListePleineException | ListeVideException e) {
         //ne devrait pas se produire
         e.printStackTrace();
      }

   }

   
}
