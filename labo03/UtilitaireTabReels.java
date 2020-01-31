import java.util.Arrays;

/**
 * INF111 : A completer dans le cadre du labo 03.
 */
public class UtilitaireTabReels {
   /*
   ANTECENDENTS POUR TOUTES LES METHODES :
      - On suppose que le parametre nbrElts est >= 0.
      - On suppose que tab n'est pas null 
      - On suppose que nbrElts ne depasse pas la capacite de tab
      - On suppose que les valeurs significatives dans tab sont toutes au debut 
        du tableau, aux indices 0 a nbrElts - 1.
     
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
      if(pos>=0 && pos<nbrElts){
         for(int i=nbrElts-1;i>=pos;i--){
            tab[i+1]=tab[i];
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
    *            les elements vers la gauche
    */
   public static void decalerAGauche (double[] tab, int nbrElts, int pos) {
      if(pos > 0 && pos < nbrElts){
         for (int i=pos;i < nbrElts-1; i++){
            tab[i-1] = tab[i];
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

      //A FAIRE
      tab=tab.clone();
         if(pos>=0 && pos <= nbrElts){ //Valider la position 

            if(tab.length == nbrElts){//Si le tableau est deja plein on cree un nouveau tableau 
               tab = Arrays.copyOf(tab,nbrElts+1);
            }

            decalerADroite(tab, nbrElts, pos);
            tab[pos] = elt;

         }
      return tab; //A EFFACER... pour compilation seulement
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
      if(pos >= 0 && pos < nbrElts){

          //NOTE : utilser decalerAGauche
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
      double moyenne=0;
      double somme=0;
      //A FAIRE
      
      if(nbrElts == 0){
         moyenne=0;
      }else{
         for (int i=0;i<nbrElts;i++){
            somme+=tab[i];
         }
      }
      moyenne=somme/nbrElts;
      

      return moyenne; //A ENLEVER, pour compilation seulement
   }

}
