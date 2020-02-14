
/**
 * Classe regroupant des méthodes de fouille dans un tableau d'entiers.
 * 
 * INF111 - Labo 4 (partie 1), EXERCICE 2 : 
 *    Implementez la methode fouilleBinaire selon l'algorithme vu en classe.
 * 
 * @author Melanie Lord
 * @version automne 2018
 */
public class UtilitaireFouilles {
   
   /**
    * Effectue une fouille binaire dans un tableau d'entiers. 
    *
    * Antecedent : tab est trie en ordre croissant
    * 
    * @param elem l'element a chercher
    * @param tab le tableau dans lequel chercher 
    *        
    * @return la position d'une occurrence dans tab ou se trouve elem ou
    *         -1 si absent
    */
   public static int fouilleBinaire(int elem, int[] tab) {
      
      int debut = 0;
      int fin = tab.length - 1;
      int milieu = -1;
      boolean trouve = false;

      if (tab != null && tab.length > 0) {
         
         while (debut <= fin && !trouve) {

            milieu = (debut + fin) / 2; //trouve le milieu 
 
            System.out.print(tab[milieu] + " ");

            if (tab[milieu] == elem) {
               trouve = true;

            } else if (tab[milieu] < elem) {// L'element est plus grand que le milieu
               debut = milieu + 1;

            } else { // L'element est plus petit que le milieu 
               fin = milieu - 1;
            }
         }

         if (!trouve) {
            milieu = -1;
         }
      }
      
      return milieu;
   }

   
   
   /**
    * Effectue une fouille sequentielle non ordonnee dans un tableau d'entiers.
    * 
    * @param elem l'element a chercher
    * @param tab le tableau dans lequel chercher
    * @return la position de la premiere occurrence dans tab ou se trouve elem
    *         ou -1 si absent
    */
   public static int fouilleSeqNonOrdonnee(int elem, int[] tab) {
      int i = 0;
      int reponse = -1;

      if (tab != null && tab.length > 0) {
         
         while (i < tab.length && tab[i] != elem) {
            i++;
         }
         //si trouve
         if (i < tab.length) {
            reponse = i;
         }
      }
      return reponse;
   }

   
   /**
    * Effectue une fouille sequentielle ordonnee dans un tableau d'entiers.
    * 
    * Antecedent : tab est trie en ordre croissant
    *
    * @param elem l'element a chercher
    * @param tab le tableau dans lequel chercher 
    * @return la position de la premiere occurrence dans tab ou se trouve elem
    *         ou -1 si absent.
    */
   public static int fouilleSeqOrdonnee(int elem, int[] tab) {
      int reponse = -1;
      int i = 0;
      
      if (tab != null && tab.length > 0) {
         
         while (i < tab.length && tab[i] < elem) {
            i++;
         }
         //si trouve
         if (i < tab.length && tab[i] == elem) {
            reponse = i;
         }
      }
      return reponse;
   }

   
      
}
