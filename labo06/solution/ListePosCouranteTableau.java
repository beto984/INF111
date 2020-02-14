
/**
 * INF111 - solution de l'exercice 1 du laboratoire #6
 * 
 * Cette classe implemente le TDA Liste avec position courante.
 * 
 * - Les operations se font par rapport a une position courante maintenue par la
 *   liste. Les services offerts permettent de deplacer cette position courante
 *   ou consulter l'element a cette position courante.
 * 
 * - L'insertion et la suppression se font toujours a la position courante.
 * 
 * - ELEMENT COURANT
 *   Lorsque cette liste n'est pas vide, la position courante refere toujours 
 *   a un element dans cette liste nomme element courant.
 *
 * DECISIONS D'IMPLEMENTATION :
 * 
 * - La structure de donnees sous-jacente pour l'implementation de cette liste
 *   est un tableau statique.
 * 
 * - La capacite refere au nombre maximum d'elements que peut contenir cette 
 *   liste
 * 
 * - IMPLEMENTATION STATIQUE : 
 *   Cette liste a une capacite fixe qui une fois atteinte, ne permet plus
 *   l'ajout d'autres elements. 
 * 
 * - Tous les services requerant une liste non vide levent une exception 
 *   explicite ListeVideException lorsqu'on les appelle sur une liste vide.
 * 
 * - Le service d'insertion leve une exception explicite ListePleineException 
 *   lorsque la liste est pleine, et que l'ajout ne peut donc pas etre effectue.
 * 
 * NOTE :
 *   Le choix d'utiliser des exceptions explicites (plutot qu'implicites) est 
 *   simplement pour vous donner la chance de pratiquer la gestion des exceptions
 *   lorsque vous utiliserez des variables de ce type (dans vos tests, par exemple).
 *
 * @author Melanie Lord
 * @version A2018
 */
public class ListePosCouranteTableau {

   //----------------------------------
   // CONSTANTE DE CLASSE
   //----------------------------------
   //capacite par defaut de cette liste
   public static final int CAPACITE_PAR_DEFAUT = 100;

   //----------------------------------
   // ATTRIBUTS D'INSTANCE
   //----------------------------------
   //les elements de la liste
   private Object[] elements;

	//La position courante qui pointe sur un element de la liste
   private int posCourante;

   //Le nombre d'elements dans cette liste
   private int nbrElements;

   //----------------------------------
   // CONSTRUCTEURS
   //----------------------------------
   /**
    * Construit une liste vide, de la capacite donnee en parametre.
    *
    * @param capacite le maximum d'elements pouvant etre ajoutes a cette liste
    *        NOTE : on suppose que capacite est >= 0.
    */
   public ListePosCouranteTableau(int capacite) {
      
      elements = new Object[capacite];
      posCourante = 0;  
      nbrElements = 0;
   }

   /**
    * Construit une liste vide, d'une capacite = CAPACITE_PAR_DEFAUT.
    */
   public ListePosCouranteTableau() {
      //appel de l'autre constructeur
      this(CAPACITE_PAR_DEFAUT);
   }

   //----------------------------------
   // METHODES D'INSTANCE PUBLIQUES
   //----------------------------------
   
   //-- SERVICES DE CONSULTATION --
      
   /**
    * Permet d'obtenir la taille de cette liste (son nombre d'elements).
    *
    * @return la taille de cette liste
    */
   public int taille() {
      return nbrElements;
   }

   /**
    * Teste si cette liste est vide.
    *
    * @return true si cette liste est vide, false sinon.
    */
   public boolean estVide() {
      return taille() == 0;
   }
   
   /**
    * Teste si cette liste est pleine. 
    *
    * @return true si cette liste est pleine, false sinon.
    */
   public boolean estPleine() {
      return taille() == elements.length;
   }
   
   /**
    * Permet de consulter l'element courant (celui qui est se trouve a la 
    * position courante).
    * 
    * ANTECEDENT : cette liste ne doit pas etre vide
    * CONSEQUENT : cette liste et sa position courante demeurent inchangees.
    * 
    * @return l'element courant
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public Object getElement() throws ListeVideException {
      
      //lever une exception si la liste est vide
      if (estVide()) {
         throw new ListeVideException();
      }
      
      //retourner l'element a la position courante
      return elements[posCourante];
   }
   
   //-- FIN SERVICES DE CONSULTATION --
   
   //SERVICES DE DEPLACEMENT DE LA POSITION COURANTE

   /**
    * Met la position courante sur l'element au debut de cette liste.
    *
    * ANTECEDENT : cette liste ne doit pas etre vide
    * 
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public void setPosDebut() throws ListeVideException {
      if (estVide()) {
         throw new ListeVideException();
      }
      posCourante = 0;
   }
   
   /**
    * Met la position courante sur l'element a la fin de cette liste.
    * 
    * ANTECEDENT : cette liste ne doit pas etre vide
    * 
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public void setPosFin() throws ListeVideException {
      if (estVide()) {
         throw new ListeVideException();
      }
      posCourante = nbrElements - 1;
   }
   
   /**
    * Met la position courante sur l'element qui precede l'element courant.
    * Si la position courante est au debut avant l'appel, elle demeure 
    * inchangee.
    * 
    * ANTECEDENT : cette liste ne doit pas etre vide
    * 
    * @return true si la position courante a ete deplacee sur le precedent, 
    *         false sinon
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public boolean setPosPrecedent() throws ListeVideException {
      boolean aUnPrecedent;
      
      if (estVide()) {
         throw new ListeVideException();
      }
      
      aUnPrecedent = posCourante > 0;
      
      if (aUnPrecedent) {
         posCourante--;
      }
      
      return aUnPrecedent;
   }
   
   /**
    * Met la position courante sur l'element qui suit l'element courant.
    * Si la position courante est a la fin de cette liste avant l'appel, 
    * elle demeure inchangee.
    * 
    * ANTECEDENT : cette liste ne doit pas etre vide
    * 
    * @return true si la position courante a ete deplacee sur le suivant, 
    *         false sinon
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public boolean setPosSuivant() throws ListeVideException {
      
      boolean aUnSuivant;
      
      if (estVide()) {
         throw new ListeVideException();
      }
      
      aUnSuivant = posCourante != nbrElements - 1;
      
      if (aUnSuivant) {
         posCourante++;
      }
      
      return aUnSuivant;
   }
   
   //-- FIN SERVICES DE DEPLACEMENT DE LA POSITION COURANTE --
   
   
   //-- SERVICES D'INSERTION ET DE SUPPRESSION --
   
   /**
    * Insere l'element donne dans cette liste, a la position courante, apres
    * avoir deplace d'une position vers la droite l'element courant et tous 
    * les elements qui le suivent.
    * 
    * ANTECEDENT : cette liste ne doit pas etre pleine.
    * 
    * CONSEQUENTS : 
    *    - La position courante demeure inchangee, et l'element ajoute se 
    *      trouve a la position courante (il devient l'element courant).
    *    - Il y a un element de plus dans cette liste.
    * 
    * @param element l'element a inserer a la position courante
    * @throws ListePleineException si cette liste est pleine avant l'appel
    */
   public void inserer (Object element) throws ListePleineException {
      
      if (estPleine()) {
         throw new ListePleineException();
      }
      
      //decaler les elements d'une position vers la droite, a partir
      //de l'element courant jusqu'au dernier element
      decalerDroite (elements, posCourante, nbrElements - 1);
      
      //Ajouter l'element a la position courante
      elements[posCourante] = element;
      
      //Ajuster le nombre d'elements
      nbrElements ++;
   }
   
   /**
    * Ajoute l'element donne a la suite du dernier element. L'element ajoute
    * devient l'element courant.
    * 
    * ANTECEDENT : cette liste ne doit pas etre pleine.
    * 
    * CONSEQUENTS : 
    *    - La position courante est sur le dernier element de cette liste
    *      (celui qu'on vient d'ajouter)
    *    - Il y a un element de plus dans cette liste.
    * 
    * @param element l'element a inserer a la position courante
    * @throws ListePleineException si cette liste est pleine avant l'appel
    */
   public void ajouterFin (Object element) throws ListePleineException {
      
      if (estPleine()) {
         throw new ListePleineException();
      }
      
      //Ajuster la position courante sur le suivant du dernier element 
      posCourante = nbrElements;
      
      //Ajouter l'element a la position courante
      elements[posCourante] = element;
      
      //Ajuster le nombre d'elements
      nbrElements ++;
   }
   
   /**
    * Supprime de cette liste l'element courant (celui qui se trouve a 
    * la position courante), en decalant d'une position vers la gauche
    * tous les elements qui venaient apres l'element courant.
    * 
    * ANTECEDENT : cette liste ne doit pas etre vide.
    * 
    * CONSEQUENTS : 
    *    - Il y a un element de moins dans cette liste
    *    - La position courante se trouve sur l'element qui venait juste 
    *      apres l'element courant avant l'appel ou se trouve sur le dernier
    *      element si l'element a supprimer etait le dernier.
    * 
    * @return l'element supprime de cette liste.
    * @throws ListeVideException si cette liste est vide avant l'appel
    */
   public Object supprimer () throws ListeVideException {
      
      Object eltSupprime;  //l'element supprime, a retourner.
      
      //lever une exception si la liste est vide (la suppression ne peut pas
      //avoir lieu)
      if (estVide()) {
         throw new ListeVideException();
      }
      
      //conserver l'element courant a supprimer pour le retourner
      eltSupprime = getElement();
      
      //decaler d'une position vers la gauche tous les elements suivants 
      //l'element courant qui aura pour effet d'ecraser l'element a supprimer
      decalerGauche (elements, posCourante + 1, nbrElements - 1);
      
      //Ajuster le nombre d'elements
      nbrElements --;
      
      //Ajuster la position courante si la liste est vide apres la suppression
      //if (estVide()) {
      //   posCourante = -1;
      //}
      
      //retourner l'element qu'on vient de supprimer de cette liste
      return eltSupprime;
   }
   
   /**
    * Retire tous les elements de cette liste.
    * 
    * CONSEQUENT : la liste ne contient aucun element, estVide() retourne true.
    */
   public void vider() {
      nbrElements = 0;
      posCourante = 0;
   }
   
   //-- FIN SERVICES D'INSERTION ET DE SUPPRESSION --
   
   
   //----------------------------------
   // METHODES D'INSTANCE PRIVEES
   //----------------------------------
   
   /**
    * Decale d'une position vers la gauche tous les elements de tab se situant 
    * entre debut et fin inclusivement.
    * 
    * ANTECEDENTS : 
    *    - tab n'est pas null
    *    - debut et pos sont des indices valides dans tab
    *    - debut <= fin (sinon, aucun decalage n'est effectue
    * 
    * @param tab le tableau dans lequel on veut decaler les elements
    * @param debut 
    * @param fin 
    */
   private void decalerGauche (Object[] tab, int debut, int fin) {
      
      for(int i = debut ; i <= fin ; i++) {
			tab[i - 1] = tab[i];
		}
   }
   
   
   /**
    * Decale d'une position vers la droite tous les elements de tab se situant 
    * entre debut et fin inclusivement.
    * 
    * ANTECEDENTS : 
    *    - tab n'est pas null
    *    - debut et pos sont des indices valides dans tab
    *    - debut <= fin (sinon, aucun decalage n'est effectue
    * 
    * @param tab le tableau dans lequel on veut decaler les elements
    * @param debut 
    * @param fin 
    */
   private void decalerDroite(Object[] tab, int debut, int fin) {

      for (int i = fin ; i >= debut ; i--) {
         tab[i + 1] = tab[i];
      }
   }
   
   
}
