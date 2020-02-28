
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
   
   //maillon contenant le premier element de la liste
   private Maillon debut;

   //nombre d'elements dans la liste
   private int nbrElements;

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
      return nbrElements == 0;
   }

   /**
    * Retourne le nombre d'elements dans cette liste.
    *
    * @return le nombre d'elements dans la liste
    */
   public int taille() {
      return nbrElements;
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

      Maillon m;  //maillon temporaire pour parcourir la liste
      Object reponse = null;  //element a retourner

      if (pos < 0 || pos > nbrElements - 1) {
         throw new NoSuchElementException();
      }

      //obtenir le maillon a la position pos
      m = positionner(pos);

      //m contient l'element en position pos
      reponse = m.element;

      return reponse;

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
      return getElement(0);
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
      return getElement(taille() - 1);
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

      Maillon m; //maillon temporaire pour parcourir la liste

      if (pos < 0 || pos > nbrElements) {
         throw new NoSuchElementException();
      }

      if (pos == 0) {   // insertion au debut
         debut = new Maillon(element, debut);

      } else {
         //obtenir le maillon qui precedera celui a inserer
         m = positionner(pos - 1);

         //inserer le nouveau maillon apres m
         m.suivant = new Maillon(element, m.suivant);
      }

      nbrElements++;  //ajuster le nombre d'elements
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

      Maillon m; //maillon temporaire pour parcourir la liste
      Object reponse = null;  //element supprime a retourner

      if (pos < 0 || pos > nbrElements - 1) {
         throw new NoSuchElementException();
      }

      if (pos == 0) {  //supprimer au debut
         reponse = debut.element;
         debut = debut.suivant;

      } else {
         //obtenir le maillon qui precede celui a supprimer
         m = positionner(pos - 1);

         //conserver l'element du maillon a supprimer pour le retourner
         reponse = m.suivant.element;

         //supprimer le maillon apres m et chainant m avec le suivant du 
         //maillon a supprimer
         m.suivant = m.suivant.suivant;
      }

      nbrElements--;  //ajuster le nombre d'elements

      return reponse;
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
      return supprimer(0);
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
      return supprimer(taille() - 1);
   }

   /**
    * Permet de retirer tous les elements de cette liste.
    *
    * CONSEQUENT : - cette liste est vide (taille() = 0)
    */
   public void vider() {

      //on recree le tableau elements avec la capacite donnee
      debut = null;

      //on ajuste le nombre d'elements a 0
      nbrElements = 0;
   }

   //----------------------------------
   // METHODES D'INSTANCE PRIVEES
   //----------------------------------
   
   /**
    * Retourne le ieme maillon de cette liste
    *
    * @param i la position du maillon a retourner
    * @return le ieme maillon de cette liste
    */
   private Maillon positionner(int i) {
      Maillon m = debut;

      for (int j = 0; j < i; j++) {
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
