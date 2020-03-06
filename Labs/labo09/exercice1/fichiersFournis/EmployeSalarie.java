
/**
 * Exemple inspire de Savitch, Absolute Java, chap. 7.
 *
 * @author Louise Laforest (laforest.louise@uqam.ca)
 * @version 4 janvier 2005 - 6 janvier 2011
 * @revisor Melanie Lord A2018
 */
public class EmployeSalarie extends Employe {

   private double salaire; // salaire annuel

   //------------------------------
   // CONSTRUCTEURS
   //------------------------------
   
   /**
    * Construit un employe horaire avec nom = NOM_BIDON, une date 
    * d'embauche = null, et un salaire annuel = 0.
    */
   public EmployeSalarie() {
      // Appel implicite du constructeur sans argument de la classe superieure
      salaire = 0;
   }

   /**
    * Construit un employe salarie avec les valeurs passees en parametres.
    * 
    * @param leNom le nom de cet employe salarie
    * @param laDate la date d'embauche de cet employe salarie
    * @param leSalaire le salaire annuel de cet employe salarie
    */
   public EmployeSalarie(String leNom, Date laDate, double leSalaire) {
      // Appel explicite du constructeur de la classe superieure
      super(leNom, laDate);

      if (leSalaire >= 0) {
         salaire = leSalaire;
      } else {
         salaire = 0;
      }
   }

   /**
    * Constructeur de copie : construit une copie de autreEmploye.
    * @param autreEmploye l'autreEmploye dont on veut faire une copie.
    */
   public EmployeSalarie(EmployeSalarie autreEmploye) {
      // Appel explicite du constructeur de la classe superieure
      super(autreEmploye);

      salaire = autreEmploye.salaire;
   }

   //------------------------------
   // GETTERS ET SETTERS
   //------------------------------
   
   public double getSalaire() {
      return salaire;
   }

   public void setSalaire(double nouveauSalaire) {
      if (nouveauSalaire >= 0) {
         salaire = nouveauSalaire;
      } else {
         salaire = 0;
      }
   }

   //------------------------------
   // AUTRES METHODES
   //------------------------------
   
   /**
    * Calcule le salaire mensuel de cet employe salarie.
    * @return le salaire mensuel de cet employe salarie
    */
   public double leSalaireParMois() {
      return salaire / 12;
   }

   /**
    * Retourne sous forme de String les informations sur cet EmployeSalarie.
    * - Redefinitionde la methode toString de la classe Employe.
    * @return une representation sous forme de chaine de caracteres de cet
    * EmployeSalarie.
    */
   public String toString() {
      return super.toString() + "\n$" + salaire + " par annee";
   }
   
   /**
    * Teste si cet EmployeHoraire est egal a autreEmployeSalarie.
    * - Redefinition de la methode equals de la classe Employe.
    * @param autreEmployeSalarie l'employe salarie dont on veut tester s'il est 
    * egal a cet EmployeSalarie.
    * @return true s'ils sont egaux, false sinon.
    */
   public boolean equals (Object autreEmployeSalarie) {
      return super.equals(autreEmployeSalarie) &&
            salaire == ((EmployeSalarie)autreEmployeSalarie).salaire;
            
   }

}
