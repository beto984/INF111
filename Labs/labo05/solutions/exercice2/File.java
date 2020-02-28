
/**
 * Implementation du TDA File avec un tableau statique circulaire.
 * 
 * NOTE sur l'implementation : 
 *    - chaque fois que la capacite de la file est atteinte, celle-ci est 
 *      augmentee de INCREMENT automatiquement : on cree un tableau plus 
 *      grand et on y recopie les elements.
 *
 * Cours : INF111
 *
 * @author Melanie Lord
 * @version automne 2018
 */
public class File {
   
   //------------------------------------
   // CONSTANTES DE CLASSE
   //------------------------------------
   
   //Capacite initiale par defaut
   private static final int CAPACITE_INITIALE = 10;
   
   //le nombres de places a ajouter lorque la capacite de cette file est 
   //atteinte (file pleine).
   private static final int INCREMENT = 10;
   
   
   //------------------------------------
   // ATTRIBUTS D'INSTANCE
   //------------------------------------

   private int nbrElements;   //nombre d'elements dans cette file
   private int capacite;      //nombre total de places dans cette file
   private Object[] elements; //tableau contenant les elements de cette file
   private int debut;         //indice du premier element de cette file
   private int fin;           //indice du dernier element de cette file

   
   //------------------------------------
   // CONSTRUCTEURS
   //------------------------------------
   
   /**
    * Construit une file vide avec la capacite initiale donnee en parametre.
    * 
    * @param capaciteInit la capacite initiale de cette file
    */
   public File(int capaciteInit) {
      nbrElements = 0;
      capacite = capaciteInit;
      elements = new Object[capacite];
      debut = 0;          // premier element de la file

      // dernier element de la file 
      fin = capacite - 1;
   }
   
   /**
    * Construit une file vide de capacite initiale = CAPACTE_INITIALE.
    */
   public File() {
      //appel du construteur a un parametre
      this(CAPACITE_INITIALE);
   }
   
   
   //--------------------------------------------------
   // METHODES D'INSTANCE PUBLIQUES (SERVICES DE FILE)
   //--------------------------------------------------

   /**
    * Retourne le nombre d'elements contenus dans cette file.
    * 
    * @return le nombre d'elements dans cette file
    */
   public int getNbrElements() {
      return nbrElements;
   }
   
   /**
    * Teste si cette file est vide (aucun element).
    *
    * @return true si aucun element false autrement
    */
   public boolean estVide() {
      return nbrElements == 0;
   }
   
   /**
    * Retourne l'element au debut de cette file, sans le retirer.
    * 
    * ANTECEDENT : cette file ne doit pas etre vide
    * CONSEQUENT : cette file n'est PAS modifiee
    *
    * @return l'element au debut de cette file
    * @throws Exception si cette file est vide avant l'appel
    */
   public Object consulterDebut() throws Exception {   
      Object elem = null;
      
      if (estVide()) {
         throw new Exception();
      } else {
         elem = elements[debut];
      }
      return elem;
   }

   /**
    * Ajoute un nouvel element a la fin de cette file.
    * 
    * CONSEQUENT : cette file contient un element de plus, place a la fin
    *
    * @param elem l'element a ajouter a la fin de cette file.
    */
   public void enfiler(Object elem) {

      //Si la file est pleine, on augmente sa capacite de INCREMENT.
      if (nbrElements == capacite) {
         reallouer();
      }

      //ajuster la fin qui devient l'indice auquel enfiler l'element
      fin = indiceSuivant(fin);

      //ajouter elem a la fin
      elements[fin] = elem;

      //incrementer le nombre d'elements
      nbrElements++;
   }

   /**
    * Retire l'element au debut de cette file.
    * 
    * ANTECEDENT : cette file ne doit pas etre vide
    * CONSEQUENT : cette file contient un element de moins (celui qui etait
    *              au debut avant l'appel)
    *
    * @return l'element retire de cette file
    * @throws Exception si la file est vide avant l'appel.
    */
   public Object defiler() throws Exception {

      //l'element a defiler et retourner
      //   Note : consulterDebut() leve une exception NoSuchElementException 
      //   si cette file est vide avant l'appel, et cette methode la laisse se 
      //   propager.
      Object elem = consulterDebut();  
      
      //ajuster le debut sur l'element qui venait avant l'element defile
      debut = indiceSuivant(debut);
      
      //decrementer le nombre d'elements
      nbrElements--;
      
      return elem;
   }

   /**
    * Retire tous les elements de cette file. 
    * Aucun effet si la file est deja vide.
    * 
    * CONSEQUENT : il n'y a plus d'elements dans cette file : 
    *              estVide() retourne true
    */
   public void vider() {
      debut = 0;
      fin = capacite - 1;
      nbrElements = 0;
   }

   
   //---------------------------------------------------
   // METHODES D'INSTANCE PRIVEES (methodes utilitaires)
   //---------------------------------------------------

   private void reallouer() {
      //Creer un nouveau tableau avec INCREMENT cases de plus
      Object[] temp = new Object[capacite + INCREMENT]; 
      
      //copier les elements du tableau elements au debut de temp
      for (int i = 0; i < nbrElements; i++) { // nbrElements elements a copier
         temp[i] = elements[debut];
         debut = indiceSuivant(debut); //passer a l'indice suivant dans elements
      }
      
      //Assigner la reference de temp a elements
      elements = temp;
      
      //reajuster debut, fin, et capacite
      debut = 0;
      fin = nbrElements - 1;
      capacite = temp.length;
     
   }

   /**
    * Retourne l'indice qui vient apres i, dans le tableau circulaire.
    * @param i l'indice dont on veut le suivant
    * @return l'indice qui vient apres i, dans le tableau circulaire
    */
   private int indiceSuivant(int i) {
      return (i + 1) % capacite;
   }

}
