
import java.util.NoSuchElementException;

/**
 * Implementation du TDA Liste indicee.
 *
 * - Structure lineaire contenant une suite d’elements. 
 * - Le nombre d’elements est appele taille (ou longueur). 
 * - La taille est toujours >= 0 
 * - La liste est vide si la taille est egale a 0 
 * - Chaque element de la liste possede une position (un indice) 
 * - Les numeros de position vont de 0 à taille – 1 inclusivement. 
 *   Le premier element de la liste est a l'indice 0, le deuxième
 *   a l'indice 1, et ainsi de suite jusqu’au dernier qui est a l'indice 
 *   taille – 1.
 * - Chaque element de la liste est accessible en donnant sa position. 
 * - On supprime en donnant la position de l'element a supprimer. 
 * - On insere en donnant la position a laquelle inserer.
 *
 * NOTES SUR L'IMPLEMENTATION :
 *
 * - La structure de donnees sous-jacente utilisee pour conserver les elements
 *   de la liste est une liste de maillons chaines(voir classe interne Maillon).
 *
 * - IMPLEMENTATION DYNAMIQUE : La liste s'agrandit ou rapetisse a mesure qu'on
 *   ajoute ou supprime des elements.
 *
 * @author Melanie Lord
 * @version A2018
 */
public class ListeIndiceeChainee {

   //----------------------------------
   // ATTRIBUTS D'INSTANCE
   //----------------------------------
   
   //A FAIRE : definir les attributs d'instance ici...
   private int nbrElements;
   private Maillon debut; 

   //----------------------------------
   // CONSTRUCTEUR
   //----------------------------------
   
   //Le constructeur par defaut est suffisant pour creer une liste vide :
   //nbrElements est a 0 par defaut et le maillon debut est a null par defaut
   
   //----------------------------------
   // METHODES D'INSTANCE PUBLIQUES
   //----------------------------------
   
   /**
    * Teste si cette liste est vide.
    *
    * @return true si la liste est vide, false autrement
    */
   public boolean estVide() {
      
      //A FAIRE
      return nbrElements == 0; //pour compilation seulement... a modifier.
   }

   /**
    * Retourne le nombre d'elements dans cette liste.
    *
    * @return le nombre d'elements dans la liste
    */
   public int taille() {
      
      //A FAIRE
      return nbrElements; //pour compilation seulement... a modifier.
   }

   /**
    * Retourne l'element en position pos dans la liste.
    *
    * ANTECEDENT : pos doit etre entre 0 et taille() - 1 inclusivement
    *
    * CONSEQUENT : cette liste n'est pas modifiee
    *
    * @param pos la position de l'element qu'on veut obtenir
    * @return l'element en position pos dans cette liste
    * @throws NoSuchElementException si pos < 0 ou pos >= taille().
    */
   public Object getElement(int pos) {
      Object retour; 

      //A FAIRE
       //pour compilation seulement... a modifier.
      if(pos < 0 || pos >= taille()){
         throw new NoSuchElementException();
      }
      retour = positionner(pos).element;
      return retour ; 

   }

   /**
    * Retourne le premier element de cette liste.
    *
    * ANTECEDENT : cette liste ne doit pas etre vide
    *
    * @return le premier element de la liste
    * @throws NoSuchElementException si cette liste est vide
    */
   public Object getElementDebut() {
      
      //A FAIRE... penser a reutiliser votre code...
      return getElement(0); //pour compilation seulement... a modifier.
   }

   /**
    * Retourne le dernier element de cette liste.
    *
    * ANTECEDENT : cette liste ne doit pas etre vide
    *
    * @return le dernier element de la liste
    * @throws NoSuchElementException si cette liste est vide
    */
   public Object getElementFin() {
      
      //A FAIRE... penser a reutiliser votre code...
      return getElement(taille() - 1); //pour compilation seulement... a modifier.
   }

   /**
    * Insere l'element en position pos dans cette liste, en decalant d'une
    * position vers la droite les elements allant de pos a taille - 1
    * inclusivemnt . - Si pos = 0, insere au debut - Si pos = taille, insere a
    * la fin
    *
    * ANTECEDENT : pos doit etre entre 0 et taille() inclusivement
    *
    * CONSEQUENTS : 
    *    - cette liste contient un element de plus 
    *    - l'element insere se trouve a pos
    *
    * @param element l'element a inserer
    * @param pos position ou inserer l'element
    * @throws NoSuchElementException si pos < 0 ou pos > taille()
    */
   public void inserer(Object element, int pos) {

      Maillon m; 

      if(pos < 0 || pos > taille()){
         throw new NoSuchElementException();
      }
      if(pos == 0){
         debut = new Maillon(element, debut);
      }else{
         m = positionner(pos - 1);
         m.suivant = new Maillon(element, m.suivant);
      }
      nbrElements++;

   }

   /**
    * Insere l'element au debut de cette liste.
    *
    * CONSEQUENTS : - cette liste contient un element de plus. - l'element
    * insere est le premier element de cette liste
    *
    * @param element l'element a inserer
    */
   public void insererDebut(Object element) {
      
      //A FAIRE... penser a reutiliser votre code...
      inserer(element, 0);
   }

   /**
    * Insere l'element a la fin de cette liste.
    *
    * CONSEQUENTS : - cette liste contient un element de plus. - l'element
    * insere est le dernier element de cette liste
    *
    * @param element l'element a inserer
    */
   public void insererFin(Object element) {
      
      //A FAIRE... penser a reutiliser votre code...
      inserer(element, taille());
   }

   /**
    * Retire et retourne l'element en position pos dans cette liste, en decalant
    * les elements entre pos + 1 et taille() - 1 d'une position vers la gauche.
    *
    * ANTECENDENT : pos doit etre entre 0 et taille() - 1 inclusivement
    *
    * CONSEQUENT : il y a un element de moins dans cette liste
    *
    * @param pos la position de l'element a supprimer
    * @return l'element supprime
    * @throws NoSuchElementException si pos < 0 ou pos >= taille()
    */
   public Object supprimer(int pos) {
      Object retour;
      Maillon m; 
      //A FAIRE

      if(pos < 0 || pos >= taille() ){
         throw new NoSuchElementException();
      }

      if(pos == 0){
         retour = debut.element;    
         debut = debut.suivant;
      }else{
         m = positionner(pos - 1 );
         retour = m.suivant.element;
         m.suivant = m.suivant.suivant; 
      }

      nbrElements--; 

      return retour; //pour compilation seulement... a modifier.
   }

   /**
    * Retire et retourne l'element au debut de cette liste.
    *
    * ANTECENDENT : cette liste ne doit pas etre vide
    *
    * @return l'element supprime
    * @throws NoSuchElementException si cette liste est vide avant l'appel
    */
   public Object supprimerDebut() {
      
      //A FAIRE... penser a reutiliser votre code...
      return supprimer(0); //pour compilation seulement... a modifier.
   }

   /**
    * Retire et retourne l'element a la fin de cette liste.
    *
    * ANTECENDENT : cette liste ne doit pas etre vide
    *
    * @return l'element supprime
    * @throws NoSuchElementException si cette liste est vide avant l'appel
    */
   public Object supprimerFin() {
      
      //A FAIRE... penser a reutiliser votre code...
      return supprimer(taille() - 1); //pour compilation seulement... a modifier.
   }

   /**
    * Permet de retirer tous les elements de cette liste.
    *
    * CONSEQUENT : - cette liste est vide (taille() = 0)
    */
   public void vider() {

      //A FAIRE
      debut = null;
      nbrElements = 0; 
   }

   //----------------------------------
   // METHODES D'INSTANCE PRIVEES
   //----------------------------------
   
   //A faire s'il y a lieu
   private Maillon positionner(int pos){
      Maillon m = debut;

      for(int i = 0; i < pos; i++){
         m = m.suivant;
      }

      return m;
   }

   //-------------------------------------------
   // CLASSE INTERNE MAILLON 
   //-------------------------------------------
   
   /**
    * Classe interne Maillon. Des maillons peuvent etre chaines les uns aux
    * autres pour creer une liste chainee.
    *
    * @author Melanie Lord
    * @version A2018
    */
   private class Maillon {

     //--------------------------------
      // ATTRIBUTS D'INSTANCE
      //--------------------------------
      private Object element;  //element encapsule dans le maillon
      private Maillon suivant; //reference vers le maillon suivant

     //--------------------------------
      // CONSTRUCTEURS
      //--------------------------------
      /**
       * Cree un nouveau maillon ayant un autre maillon existant comme suivant
       *
       * @param element l'element qui sera stockee dans le maillon
       * @param suivant le maillon qui sera le suivant du maillon cree
       */
      public Maillon(Object element, Maillon suivant) {
         this.element = element;
         this.suivant = suivant;
      }

      /**
       * Cree un nouveau maillon n'ayant pas de maillon suivant.
       *
       * @param element l'element qui sera stockee dans le maillon
       */
      public Maillon(Object element) {
         //utilisation du constructeur ci-dessus
         this(element, null);
      }
      
      //NOTE : 
      //les getters et setters ne sont pas utiles puisque c'est une classe
      //interne et qu'on a acces au attributs directement.

   } //fin classe interne Maillon

}
