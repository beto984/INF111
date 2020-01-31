
//pour l'utilisation des methodes de la classe Arrays
import java.util.Arrays;

/**
 * INF111 : Solution de l'exercice 1 du labo 03.
 * @author melanie lord
 * @version automne 2018
 */
public class UtilitaireTabReels {
   /*
   ANTECENDENTS POUR TOUTES LES METHODES :
      - On suppose que le parametre nbrElts est >= 0.
      - On suppose que tab n'est pas null 
      - On suppose que nbrElts ne depasse pas la capacite de tab
      - On suppose que les valeurs significatives dans tab sont toutes au debut 
        du tableau, aux indices [0 a nbrElts - 1].
     
      ** On doit cependant verifier que pos est valide. **
   */

   
   /** 
    * Decale d'une case vers la droite, les elements se trouvant aux indices 
    * pos à nbrElts - 1.
    * 
    * ANTECEDENTS : 
    *    - tab n'est pas plein (tab.length > nbrElts)
    * 
    * La pos donnee est valide si dans l'intervalle [0, nbrElts[.
    * Si la pos donnee n'est pas valide, la methode ne fait rien
    * 
    * @param tab le tableau dont on veut decaler les elements
    * @param nbrElts le nombre d'elements significatifs dans le tableau
    * @param pos la position (incluse) a partir de laquelle on veut decaler 
    *            les elements vers la droite
    */
   public static void decalerADroite (double[] tab, int nbrElts, int pos) {
      
      //verifier si pos est valide
      if (pos >= 0 && pos < nbrElts) {
         //decaler vers la droite
         for (int i = nbrElts - 1 ; i >= pos ; i--) {
            tab[i + 1] = tab[i];
         }
      }
   }
   
   
   /** 
    * Decale d'une case vers la gauche, les elements se trouvant aux indices 
    * pos à nbrElts - 1.
    * 
    * La pos donnee est valide si elle est dans l'intervalle ]0, nbrElts[.
    * Si la pos donnee n'est pas valide, la methode ne fait rien.
    * 
    * @param tab le tableau dont on veut decaler les elements
    * @param nbrElts le nombre d'elements significatifs dans le tableau
    * @param pos la position (incluse) a partir de laquelle on veut decaler 
    *            les elements vers la droite
    */
   public static void decalerAGauche (double[] tab, int nbrElts, int pos) {

      //verifier si pos est valide
      if (pos > 0 && pos < nbrElts) {
         
         //decaler vers la gauche
         for (int i = pos ; i < nbrElts ; i++) {
            tab[i - 1] = tab[i];
         }
      }
   }
   
   
   /**
    * Ajoute l'elt donne dans le tab donne, a la pos donnee.
    * 
    * ATTENTION : retourne un NOUVEAU tableau avec l'ajout. Le tableau 
    * passe en parametre demeure inchange.
    * 
    * Une pos valide est dans l'intervalle [0, nbrElts].
    * Si pos n'est pas valide, la methode ne fait rien et retourne 
    * un nouveau tableau identique a tab.
    * 
    * Note : si pos == nbrElts, c'est qu'on ajoute a la fin (a la suite
    * de tous les elements significatifs dans tab).
    * 
    * Si pos est valide et qu'on peut donc faire l'ajout :
    *    - si le tableau est plein (tab.length == nbrElts), la methode
    *      agrandit le tableau d'une case avant de faire l'ajout.
    * 
    * @param tab le tableau dans lequel ajouter elt
    * @param nbrElts le nombre d'elements significatifs dans tab
    * @param pos l'indice du tableau auquel on veut ajouter l'elt
    * @param elt l'element a ajouter dans tab, a l'indice pos
    * @return un NOUVEAU tableau contenant l'ajout si effectue, sinon retourne
    *         un NOUVEAU tableau identique.
    */
   public static double [] ajouterAPos (double[] tab, int nbrElts, 
           int pos, double elt) {
      
      //NOTE : utilser decalerADroite et Arrays.copyOf (pour agrandir 
      //tab si necessaire) 
      //Utiliser aussi tab.clone() pour obtenir un NOUVEAU tableau a retourner
      
      tab = tab.clone(); //nouveau tab (copie)
      
      //verifier si pos valide : dans les methode d'ajout, pos == nbrElts est
      //valide, et indique qu'on veut ajouter a la suite de tous les elements
      //presents (= ajouter a la fin).
      if (pos >= 0 && pos <= nbrElts) {
         
         //verifier si le tableau est plein et si oui, l'agrandir d'une case
         //avant d'ajouter.
         if (tab.length == nbrElts) { //tab plein
            //ajouter une case
            tab = Arrays.copyOf(tab, nbrElts + 1);
         } 
         
         //decaler les elements vers la droite pour faire une place a l'indice pos
         decalerADroite(tab, nbrElts, pos);
         
         //ajouter l'element dans tab a l'indice pos
         tab[pos] = elt;
      }
      return tab;
   }
   
   
   /**
    * Supprime du tab donne, l'element a la pos donnee.
    * 
    * Une pos valide est compris dans l'intervalle [0, nbrElts[.
    * Si pos est invalide, la methode ne fait rien.
    * 
    * @param tab le tableau dans lequel on veut supprimer l'element  
    *            a l'indice pos donne
    * @param nbrElts le nombre d'elements significatifs dans tab
    * @param pos l'indice auquel on veut supprimer l'element dans tab
    */
   public static void supprimerAPos (double[] tab, int nbrElts, int pos) {
      //NOTE : utilser decalerAGauche
      
      //verifier si pos valide
      if (pos >= 0 && pos < nbrElts) {
         //decaler les elements vers la gauche pour ecraser l'element a l'indice 
         //pos
         decalerAGauche(tab, nbrElts, pos + 1);
      }
   }

   
   /**
    * Calcule la moyenne des valeurs significatives dans le tableau tab.
    * Si nbrElts == 0, la moyenne retournee est 0.
    * 
    * Attention a la division par 0.
    * 
    * @param tab le tableau contenant les valeurs sur lesquelles on veut 
    *            calculer la moyenne
    * @param nbrElts le nombre d'elements significatifs dans tab.
    * @return la moyenne des valeurs significatives dans tab.
    */
   public static double moyenne (double[] tab, int nbrElts) {
      double moyenne = 0;
      double somme = 0;
      
      //Eviter la division par 0. S'il n'y a pas d'elements dans tab, la 
      //moyenne retournee sera 0.
      if (nbrElts > 0) {
         
         //faire la somme de tous les elements significatifs
         for (int i = 0 ; i < nbrElts ; i++) {
            somme = somme + tab[i];
         }

         //calculer la moyenne
         moyenne = somme / nbrElts;
      }
      
      return moyenne;
   }

}
