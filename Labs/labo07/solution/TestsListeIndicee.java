
import java.util.NoSuchElementException;

/**
 * Classe de tests pour les methodes de la classe ListeIndiceeTablea.
 * 
 * @author Melanie Lord
 * @version A2018
 */
public class TestsListeIndicee {
   
   //variables de classe utilisees dans les tests
   private static ListeIndiceeChainee liste = new ListeIndiceeChainee();
   private static ListeIndiceeChainee liste2 = new ListeIndiceeChainee();

   /**
    * Affiche la liste donnee.
    * 
    * @param liste la liste a afficher
    * @param contenuAttendu ce que ca devrait afficher
    */
   public static void afficherListe(ListeIndiceeChainee liste, 
           String contenuAttendu) {
      
      System.out.print(" ");
      for (int i = 0; i < liste.taille(); i++) {
         if (i == liste.taille() - 1) {
            System.out.print(liste.getElement(i));
         } else {
            System.out.print(liste.getElement(i) + "  ");
         }
      }

      System.out.println("\n(" + contenuAttendu + ")\n");
      
   }
   
   /**
    * Programme de tests.
    * 
    * @param params (non utilises)
    */
   public static void main(String[] params) {
      System.out.println(
                "-------------------------------------------------------------------\n"
              + "TestsListeIndicee - tests pour les operations sur une liste indicee."
              + "\n\nLes resultats attendus sont entre parentheses.\n"
              + "-------------------------------------------------------------------\n");

      // test liste vide
      System.out.println(liste.estVide() + " (true)");
      System.out.println(liste.taille() + " (0)");
      System.out.println();
      
      // creer la liste ( 7, 6, 5, 4, 3, 2, 1, 0 )
      for (int i = 0; i < 8; i++) {
         liste.insererDebut(i);
      }

      afficherListe(liste, "7  6  5  4  3  2  1  0");

      liste.insererFin(999);
      afficherListe(liste,  "7  6  5  4  3  2  1  0  999");

      liste.inserer(-1, 0);
      afficherListe(liste, "-1  7  6  5  4  3  2  1  0  999");

      liste.inserer(444, 4);
      afficherListe(liste,  "-1  7  6  5  444  4  3  2  1  0  999");

      liste.inserer(99999, liste.taille());
      afficherListe(liste, "-1  7  6  5  444  4  3  2  1  0  999  99999");
      
      System.out.println();
      
      System.out.println(liste.getElementDebut() + " (-1)");
      System.out.println(liste.getElementFin() + " (99999)");
      System.out.println(liste.getElement(1) + " (7)");
      System.out.println(liste.getElement(5) + " (4)");
      System.out.println(liste.getElement(9) + " (0)");
      System.out.println(liste.getElement(0) + " (-1)");
      System.out.println(liste.getElement(liste.taille() - 1) + " (99999)");
      System.out.println();
      
      //-- on commence les retraits ici --
      
      liste.supprimerDebut();  
      afficherListe(liste,  "7  6  5  444  4  3  2  1  0  999  99999");

      liste.supprimerFin();
      afficherListe(liste, "7  6  5  444  4  3  2  1  0  999");

      liste.supprimer(0);
      afficherListe(liste, "6  5  444  4  3  2  1  0  999");

      liste.supprimer(liste.taille() - 1);
      afficherListe(liste, "6  5  444  4  3  2  1  0");

      liste.supprimer(2);
      afficherListe(liste, "6  5  4  3  2  1  0");

      liste.supprimer(5);

      afficherListe(liste, "6  5  4  3  2  0");
      System.out.println();

      System.out.println(liste.estVide() + " (false)");
      System.out.println(liste.taille() + " (6)");
      liste.vider();
      System.out.println(liste.estVide() + " (true)");
      System.out.println(liste.taille() + " (0)");
      System.out.println();

      liste2.insererDebut("bonjour");
      liste2.insererDebut("table");
      liste2.insererDebut("chat");
      afficherListe(liste2, "chat  table  bonjour");
      
      System.out.println(liste2.estVide() + " (false)");
      System.out.println(liste2.taille() + " (3)");
      
      //-- Tester les cas d'exception --
      
      System.out.println();
      
      try {
         liste.getElement(-1);
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.getElementFin();
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.getElementDebut();
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.supprimer(-1);
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.supprimerDebut();
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.supprimerFin();
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.inserer(23, 1);
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.insererDebut(23);
         liste.insererFin(19);
         liste.inserer(34, 2);
         liste.inserer(1, 4);
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
      try {
         liste.inserer(1, -1);
         System.out.println("ERREUR... Devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK ! Leve bien une NoSuchElementException");
      } catch (Exception e) {
         System.out.println("ERREUR... Leve une autre exception que NoSuchElementException");
      }
      
   }
}
