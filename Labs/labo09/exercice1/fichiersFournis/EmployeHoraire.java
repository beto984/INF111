
/**
 * Exemple inspire de Savitch, Absolute Java, chap. 7.
 *
 * @author Louise Laforest (laforest.louise@uqam.ca)
 * @version 4 janvier 2005 - 8 janvier 2011
 * @revisor Melanie Lord A2018
 */
public class EmployeHoraire extends Employe {

   private double tauxHoraire; // salaire horaire
   private double heures;      // nombre d'heures travaillees

   //------------------------
   // CONSTRUCTEURS
   //------------------------
   
   /**
    * Construit un employe horaire avec nom = NOM_BIDON, une date 
    * d'embauche = null, un taux horaire = 0 et nbr d'heures travaillees = 0.
    */
   public EmployeHoraire() {
      // Appel implicite du constructeur sans argument de la superclasse

      tauxHoraire = 0; // facultatif (init par defaut)
      heures = 0;      // facultatif (init par defaut)
   }

   /**
    * Construit un employe horaire avec les valeurs passees en parametres.
    * 
    * @param leNom le nom de cet employe horaire
    * @param laDate la date d'embauche de cet employe horaire
    * @param leTauxHoraire le taux salarial horaire de cet employe horaire
    * @param lesHeures le nombre d'heures travaillees de cet employe horaire
    */
   public EmployeHoraire(String leNom, Date laDate, double leTauxHoraire, 
           double lesHeures) {
      
      //Appel explicite du constructeur de la superclasse
      super(leNom, laDate);

      if (leTauxHoraire >= 0) {
         tauxHoraire = leTauxHoraire;
      } else {
         tauxHoraire = 0;
      }
      
      if (lesHeures >= 0) {
         heures = lesHeures;
      } else {
         heures = 0;
      }
   }

   /**
    * Constructeur de copie : construit une copie de autreEmploye.
    * @param autreEmploye l'employe dont on veut faire une copie.
    */
   public EmployeHoraire(EmployeHoraire autreEmploye) {
      
      //Appel explicite du constructeur de la superclasse
      super(autreEmploye);

      tauxHoraire = autreEmploye.tauxHoraire;
      heures = autreEmploye.heures;
   }

   //------------------------
   // GETTERS ET SETTERS
   //------------------------
   
   public double getTauxHoraire() {
      return tauxHoraire;
   }

   public double getHeures() {
      return heures;
   }

   public void setHeures(double heuresTravaillees) {
      if (heuresTravaillees >= 0) {
         heures = heuresTravaillees;
      } else {
         heures = 0;
      }
   }

   public void setTauxHoraire(double heuresTravaillees) {
      if (heuresTravaillees >= 0) {
         tauxHoraire = heuresTravaillees;
      } else {
         tauxHoraire = 0;
      }
   }

   //------------------------
   // AUTRES METHODES
   //------------------------
   
   /**
    * Calcule la paye hebdo de cette employe horaire
    * @return la paye hebdo de cet employe horaire.
    */
   public double donnerLaPaye() {
      return tauxHoraire * heures;
   }

   /**
    * Retourne sous forme de String les informations sur cet EmployeHoraire.
    * - Redefinitionde la methode toString de la classe Employe.
    * @return une representation sous forme de chaine de caracteres de cet
    * EmployeHoraire.
    */
   public String toString() {
      return (super.toString() + "\n$" + tauxHoraire + " de l'heure pour " 
              + heures + " heures");
   }
   
   /**
    * Teste si cet EmployeHoraire est egal a autreEmploye.
    * - Redefinition de la methode equals de la classe Employe.
    * @param autreEmployeHoraire l'employe horaire dont on veut tester s'il est 
    * egal a cet EmployeHoraire.
    * @return true s'ils sont egaux, false sinon.
    */
   public boolean equals (Object autreEmployeHoraire) {
      return super.equals(autreEmployeHoraire) &&
            tauxHoraire == ((EmployeHoraire)autreEmployeHoraire).tauxHoraire &&
            heures == ((EmployeHoraire)autreEmployeHoraire).heures;
   }

}
