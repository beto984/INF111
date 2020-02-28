import java.util.NoSuchElementException;

/**
 * File
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
    
    private int nbrElements;
    private int capacite;
    private Object[] elements;
    private int debut;
    private int fin;

    //------------------------------------
    // CONSTRUCTEURS
    //------------------------------------

    public File(int capacite){
        nbrElements = 0;
        this.capacite = capacite;
        elements = new Object[capacite];
        debut = 0;
        fin = capacite - 1;
    }

    public File(){
        this(CAPACITE_INITIALE);
    }

    //------------------------------------
    // METHODES
    //------------------------------------

    public int getNbrElements(){
        return nbrElements;
    }

    public boolean estVide(){
        return nbrElements == 0;
    }

    public Object consulterDebut(){
        Object retour = null;
        if(estVide()){
            throw new NoSuchElementException();
        }else{
            retour = elements[debut];
        }
        return retour; 
    }

    public void enfiler(Object elem){
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

    public Object defiler(){
        if(estVide()){
            throw new NoSuchElementException();
        }

        Object elem = consulterDebut();

        debut = indiceSuivant(debut);

        nbrElements--;
        return elem;
    }

    public void vider(){
        debut = 0;
        nbrElements = 0;
        fin = capacite - 1; 

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