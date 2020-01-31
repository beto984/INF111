
//Pour utiliser les methodes de la classe Arrays
import java.util.Arrays;

/**
 * INF111 : solution de l'exercice 2 du labo 03.
 * @author melanie lord
 * @version automne 2018
 */
public class ExercicesLabo3 {
   
   /**
    * Initialise les champs d'un cours avec les parametres donnes.
    * 
    * - Le champ tabNotes doit etre initialise avec un tableau vide. 
    * - Le champ nbrNotes doit etre initialise a 0.
    * 
    * @param cours le cours qu'on veut initialiser
    * @param sigle le sigle a assigner a ce cours
    * @param groupe le groupe a assigner a ce cours
    */
   public static void initCours (Cours cours, String sigle, int groupe) {
      cours.sigle = sigle;             
      cours.groupe = groupe;           
      cours.tabNotes = new double[0];
      cours.nbrNotes = 0;
   }
   
   /**
    * Affiche les champs du cours donne en parametre, dans le format explique
    * ci-dessous.
    * 
    * Exemples d'affichage : 
    * 
    *   Pour le cours INF111, groupe 03, sans aucune note, la methode
    *   devrait afficher : 
    *       INF111-03 (aucune note)
    * 
    *   Pour le cours INF111, groupe 10, avec un tabNotes = [78.3, 90, 87.5, ...]
    *   et avec nbrNotes = 3, la methode devrait afficher :
    *       INF111-10 [78.3, 90, 87.5]
    * 
    * @param cours le cours dont on veut afficher les champs
    */
   public static void afficherCours (Cours cours) {
      String sTab;
      double[] tabNotesTronque;
      
      //faire une copie qu'on va tronquer pour n'avoir que les elements
      //significatifs (autres facon de faire possibles)
      tabNotesTronque = cours.tabNotes.clone();
      
      //obtenir une representation sous forme de chaine de car du tableau tronque
      sTab = Arrays.toString(Arrays.copyOf(tabNotesTronque, cours.nbrNotes));
      
      //construire la chaine a afficher
      String s = cours.sigle + "-" + (cours.groupe < 10 ? "0"  : "") +
            cours.groupe + " " + (cours.nbrNotes == 0 ? "(aucune note)" : sTab);
              
      System.out.println(s);
   }
 
   
   /**
    * Ajoute la note donnee, au tableau des notes du cours donne, a la  
    * position donnee. 
    * 
    * Si la position donnee n'est pas valide, l'ajout n'est pas effectue.
    * 
    * ANT: on suppose que le cours.tabCours n'est pas null.
    * 
    * NOTE : UTILISER UtilitaireTabReels et n'oublier pas d'incrementer le 
    *        nombre de notes
    * 
    * @param cours le cours auquel on veut ajouter une note
    * @param note la note a ajouter a ce cours
    * @param position la position a laquelle ajouter la note dans tabNotes.
    */
   public static void ajouterNote(Cours cours, double note, int position) {
      
      if (position >= 0 && position <= cours.nbrNotes) {
         cours.tabNotes =
               UtilitaireTabReels.ajouterAPos(cours.tabNotes, cours.nbrNotes, 
                     position, note);
         
         cours.nbrNotes++;
      }
   }
   
   
   /**
    * Supprime la note a la position pos donnee, dans le tableau des notes du 
    * cours donne. 
    * 
    * Si la position donnee n'est pas valide, la suppression  n'est pas 
    * effectuee.
    * 
    * ANT: on suppose que le cours.tabCours n'est pas null.
    * 
    * NOTE : UTILISER UtilitaireTabReels et n'oubliez pas de decrementer
    *        le nombre de notes.
    * 
    * @param cours le cours duquel on veut supprimer une note
    * @param position la position de la note a supprimer dans cours.tabNotes.
    */
   public static void supprimerNote(Cours cours, int position) {
      if (position >= 0 && position < cours.nbrNotes) {
         UtilitaireTabReels.supprimerAPos(cours.tabNotes, cours.nbrNotes, 
                     position);
         
         cours.nbrNotes--;
      }
   }

   public static void main (String [] args) {

      Cours c1;
      Cours c2;
      Cours c3;
      double somme = 0;
      
      c1 = new Cours();
      initCours(c1, "INF111", 3);
      
      afficherCours(c1);
      
      ajouterNote(c1, 67.4, 0);
      ajouterNote(c1, 73, 0);
      ajouterNote(c1, 88.5, 2);
      ajouterNote(c1, 77, 1);
      ajouterNote(c1, 75.9, 3);
      ajouterNote(c1, 86.7, 1);
      ajouterNote(c1, 91, 7);  //pos invalide, n'ajoute pas
      
      afficherCours(c1);
      
      supprimerNote(c1, 0);
      supprimerNote(c1, 2);
      supprimerNote(c1, 3);
      supprimerNote(c1, 4);  //pos invalide, ne supprime pas
      
      afficherCours(c1);
      
      ajouterNote(c1, 66, 1);
      
      afficherCours(c1);
      
      c2 = new Cours();
      initCours(c2, "INF254", 10);
      
      c3 = new Cours();
      initCours(c3, "INF155", 5);
      
      ajouterNote(c2, 55.6, 0);
      ajouterNote(c2, 34.9, 1);
      
      Cours [] tabCours = new Cours [5];
      tabCours[0] = c1;
      tabCours[2] = c2;
      tabCours[4] = c3;
      
      for (Cours c : tabCours) {  //vous pourriez aussi utiliser une boucle for
         if (c != null) {
            afficherCours(c);
            System.out.println("   Moyenne : " + UtilitaireTabReels.moyenne(
                    c.tabNotes, c.nbrNotes));
         }
      }

   }
   
}
