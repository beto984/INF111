import java.util.NoSuchElementException;
/**
 * File
 */
public class File {

    private final static int CAPACITE_INITIALE = 10;

    private final static int INCREMENT = 10;


    //ATTRIBUTS D'INSTANCE
    private int nbrElements;
    private int capacite;
    private Object[] elements; 
    private int debut;
    private int fin; 

    public File(int capaciteInit){
        nbrElements = 0;
        capacite = capaciteInit;
        elements = new Object[capaciteInit];
        debut = 0;
        fin = capacite - 1; 
    }

    public File(){
        this(CAPACITE_INITIALE);
    }    

    public int getNbrElements(){
        return nbrElements;
    }

    public boolean estVide(){
        return nbrElements == 0; 
    }

    public Object consulterDebut(){
        Object retour;

        if(estVide()){
            throw new NoSuchElementException();
        }

        return elements[debut]; 
    }

    public void enfiler(Object elem){
        if(capacite == nbrElements){
            reallouer();
        }
        fin = indiceSuivant(fin);
        elements[fin] = elem;
        nbrElements++; 
    }

    public Object defiler(){
        if(estVide()){
            throw new NoSuchElementException();
        }

        Object retour = consulterDebut();

        debut = indiceSuivant(debut);
        nbrElements--; 
        
        return retour; 
    }

    public void vider(){
        nbrElements = 0;
        debut = 0; 
        fin = capacite - 1 ; 
    }





    private void reallouer(){
        Object[] temp = new Object[capacite + INCREMENT];

        for(int i = 0 ; i < nbrElements; i++ ){
            temp[i] = elements[debut];
            debut = indiceSuivant(debut); 
        }

        elements = temp;
        debut = 0;
        fin = nbrElements - 1; 
        capacite = temp.length;
    }

    private int indiceSuivant(int i) {
        return (i + 1) % capacite;
     }
}