
import java.util.NoSuchElementException;

/**
 * Cours INF111 - solution de l'exercice 2 du labo #7.
 * 
 * @author Melanie Lord
 * @version A2018
 */
public class UtilisationListeIndiceeChainee {
   
   /**
    * Retourne une NOUVELLE liste contenant les elements de la liste donnee
    * en parametre se trouvant entre les indices posDebut et posFin donnes,
    * inclusivement.
    * 
    * CONSEQUENT : liste n'est pas modifiee.
    * 
    * @param liste la liste dont on veut extraire une sous-liste.
    * @param posDebut la position debut de la sous-liste a retourner.
    * @param posFin la position fin de la sous-liste a retourner.
    * 
    * @return une nouvelle liste conenant les elements entre posDebut et posFin
    *         inclusivement de la liste donnee en parametre.
    * 
    * @throws NoSuchElementException si posDebut est plus grand que posFin ou 
    *         si posDebut ou posFin n'est pas une position valide dans liste.
    * 
    * @throws NullPointerException si la liste donnee en parametre est null.
    */
   public static ListeIndiceeChainee extraireSousListe (ListeIndiceeChainee liste, 
           int posDebut, int posFin) {
      
      if (posDebut < 0 || posDebut >= liste.taille() || posFin >= liste.taille() 
              || posFin < posDebut) {
         
         throw new NoSuchElementException();
      }
      
      if (liste == null) {
         throw new NullPointerException();
      }
      
      ListeIndiceeChainee sousListe = new ListeIndiceeChainee();
      
      for (int i = posDebut ; i <= posFin ; i++) {
         sousListe.insererFin(liste.getElement(i));
      }
      
      return sousListe;
   }
   
   public static void afficher (ListeIndiceeChainee liste) {
      String s = "[";
      for (int i = 0 ; i < liste.taille() ; i++) {
         s = s + liste.getElement(i) + ", ";
      }
      s = s.substring(0, s.length() - 2) + "]";
      
      System.out.println(s);
   }
   
   public static void main (String[] args) {
      ListeIndiceeChainee sListe;
      ListeIndiceeChainee liste = new ListeIndiceeChainee();
      liste.insererFin(1);
      liste.insererFin(2);
      liste.insererFin(3);
      liste.insererFin(4);
      liste.insererFin(5);
      liste.insererFin(6);
      liste.insererFin(7);
      liste.insererFin(8);
      liste.insererFin(9);
      liste.insererFin(10);
      
      try {
         extraireSousListe(null, 0, 0);
         System.out.println("ERREUR... devrait lever une NullPointerException");
      } catch (NullPointerException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NullPointerException");
      }
      
      try {
         extraireSousListe(liste, -1, 0);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      try {
         extraireSousListe(liste, 0, -1);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      try {
         extraireSousListe(liste, -1, -1);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      try {
         extraireSousListe(liste, 3, 2);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      try {
         extraireSousListe(liste, 10, 11);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      try {
         extraireSousListe(liste, 3, 10);
         System.out.println("ERREUR... devrait lever une NoSuchElementException");
      } catch (NoSuchElementException e) {
         System.out.println("OK");
         
      } catch (Exception e) {
         System.out.println("ERREUR... leve une autre exception que NoSuchElementException");
      }
      
      System.out.println();
      
      sListe = extraireSousListe(liste, 0, 0);
      afficher(sListe);
      System.out.println("[1]\n");
      
      sListe = extraireSousListe(liste, 0, 9);
      afficher(sListe);
      System.out.println("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n");
      
      sListe = extraireSousListe(liste, 2, 6);
      afficher(sListe);
      System.out.println("[3, 4, 5, 6, 7]\n");
      
      sListe = extraireSousListe(liste, 6, 8);
      afficher(sListe);
      System.out.println("[7, 8, 9]\n");
      
      sListe = extraireSousListe(liste, 5, 5);
      afficher(sListe);
      System.out.println("[6]\n");
      
      sListe = extraireSousListe(liste, 9, 9);
      afficher(sListe);
      System.out.println("[10]\n");
   }
   
}
