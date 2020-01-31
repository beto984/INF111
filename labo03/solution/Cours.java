
/**
 * INF111 : labo 03.
 * Type enregistrement qui contient les champs pour conserver les informations
 * sur un cours.
 * 
 * @author melanie lord
 * @version automne 2018
 */
public class Cours {
   public String sigle;    //le sigle du cours
   public int groupe;      //le groupe du cours
   
   //contient les notes (sur 100) pour ce cours
   public double[] tabNotes;
   
   public int nbrNotes; //le nombre de notes "significatives" dans tabNotes
}
