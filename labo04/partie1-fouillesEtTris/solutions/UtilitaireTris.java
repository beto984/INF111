
import java.util.Arrays;

/**
 * Classe regroupant des methode de tris pour des tableaux d'entiers.
 * INF111 : solution du laboratoire 4 (partie 1), EXERCICE 2.
 * 
 * @author Melanie Lord
 * @version automne 2018
 */
public class UtilitaireTris {

  
   /**
    * Affiche le tableau donne sous le format [a1, a2, ..., an-1]
    * 
    * @param t le tableau a afficher
    */
   public static void afficher(int[] t) {
      System.out.println(Arrays.toString(t));
   }
   
   /**
    * Permute les elements aux indices i et j, dans le tableau t. 
    * 
    * Antecedents : 
    *    - t n'est pas null.
    *    - i et j sont des indices valides dans t.
    * 
    * Consequent : Les elements aux indices i et j ont été permutes.
    * 
    * @param t le tableau dans lequel on veut permuter des elements.
    * @param i l'indice de l'element a permuter avec t[j].
    * @param j l'indice de l'element a permuter avec t[i]
    */
   public static void permuter(int[] t, int i, int j) {
      int temp = t[i];
      t[i] = t[j];
      t[j] = temp;
   }
   
   
   /**
    * Tri le tableau t, en ordre croissant, avec le tri à bulles.
    * 
    * Antecedent : t n'est pas null
    * Consequent : t est trie
    * 
    * @param t le tableau a trier
    */
   public static void trierBulles(int[] t) {
     
      for (int i = t.length - 2 ; i >= 0 ; i--) {
         
         for (int j = 0 ; j <= i ; j++) {
            
            if (t[j] > t[j + 1]) {
               
               //permuter t[j] avec t[j + 1]
               permuter(t, j, j + 1);
            }
            
         }
         
         // ici,  t1[i+1] = max ( t1[0], t1[2], ..., t1[i+1] )
      }
   }
   

   /**
    * Tri le tableau t, en ordre croissant, avec le tri par insertion.
    * 
    * Antecedent : t n'est pas null
    * Consequent : t est trie
    * 
    * @param t le tableau a trier
    */
   public static void trierInsertion(int[] t) {
      int temp;
      int j;

      for (int i = 1; i < t.length; i++) {
         
         //inserer t1[i] au bon endroit parmi t1[0 .. i - 1]
         temp = t[i];
         j = i - 1;
         
         while (j >= 0 && temp < t[j]) {
            t[j + 1] = t[j];
            j--;
         }
         
         t[j + 1] = temp;
      }
   }
   

   /**
    * Tri le tableau t, en ordre croissant, avec le tri par selection.
    * Antecedent : t n'est pas null
    * Consequent : t est trie
    * 
    * @param t le tableau a trier
    */
   public static void trierSelection(int[] t) {
      int jMin;

      for (int i = 0; i < t.length - 1; i++) {
         
         //trouver l'indice du minimum parmi t1 [ i .. n - 1 ]
         jMin = i;
         
         for (int j = i + 1; j < t.length; j++) {
            
            if (t[j] < t[jMin]) {
               jMin = j;
            }
         }
         //permuter t[i] avec t[jMin]
         permuter(t, i, jMin);
      }
   }
   
}
