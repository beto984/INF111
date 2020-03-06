
/**
 * Exemple inspire de Savitch, Absolute Java, chap. 7.
 *
 * @author Louise Laforest (laforest.louise@uqam.ca)
 * @version 4 janvier 2005 - 6 janvier 2011
 * @revisor Melanie Lord A18
 */
public class Administrateur extends EmployeSalarie {

   private String titre;
   private String domaine;
   private String superviseur;

   //-------------------------
   // CONSTRUCTEURS
   //-------------------------
   
   /**
    * Constructeur qui initialise un administrateur avec des valeurs par defaut.
    */
   public Administrateur() {
      
      //Appel implicite du constructeur sans arguments de la superclasse

      titre = "sans titre";
      domaine = "sans domaine";
      superviseur = "sans superviseur";
   }

   /**
    * Constructeur qui initialise le nouvel Administrateur avec les valeurs
    * passees en parametres.
    * @param leNom le nom de cet administrateur
    * @param laDate la date d'embauche de cet administrateur
    * @param leSalaire le salaire annuel de cet adiministrateur
    * @param leTitre le titre de cet administrateur
    * @param leDomaine le domaine d'expertise de cet administrateur
    * @param leSup le superieur immediat de cet administrateur
    */
   public Administrateur(String leNom, Date laDate, double leSalaire, 
           String leTitre, String leDomaine, String leSup) {

      //Appel explicite du constructeur de la superclasse
      //pour initialiser ses attributs
      super(leNom, laDate, leSalaire);

      //initialisation des attributs de cette classe
      titre = leTitre;
      domaine = leDomaine;
      superviseur = leSup;
   }
   
   /**
    * Constructeur de copie.
    * @param autreAdmin l'administrateur a copier.
    */
   public Administrateur(Administrateur autreAdmin) {
      
      //Appel explicite du constructeur de la superclasse
      //pour "COPIER" ses attributs
      super((EmployeSalarie)autreAdmin);
      
      //copie des attributs de cette classe
      titre = autreAdmin.titre;
      domaine = autreAdmin.domaine;
      superviseur = autreAdmin.superviseur;
   }

	//-------------------------
   // GETTERS ET SETTERS
   //-------------------------
   public String getTitre() {
      return this.titre;
   }

   public String getDomaine() {
      return this.domaine;
   }

   public String getSuperviseur() {
      return this.superviseur;
   }

   public void setTitre(String titre) {
      this.titre = titre;
   }

   public void setDomaine(String domaine) {
      this.domaine = domaine;
   }

   public void setSuperviseur(String superviseur) {
      this.superviseur = superviseur;
   }

   //-------------------------
   // AUTRES METHODES
   //-------------------------
   
   /**
    * Retourne sous forme de String les informations sur cet Administrateur.
    * - Redefinitionde la methode toString de la classe EmployeSalarie.
    * @return une representation sous forme de chaine de caracteres de cet
    * Administrateur.
    */
   public String toString() {
      return super.toString() + "\n" + titre + ", " + domaine + ", " 
              + superviseur + ".";
   }
   
   /**
    * Teste si cet Administrateur est egal a autreAdministrateur.
    * - Redefinition de la methode equals de la classe EmployeSalarie.
    * @param autreAdministrateur l'administrateur dont on veut tester s'il est 
    * egal a cet Administrateur.
    * @return true s'ils sont egaux, false sinon.
    */
   public boolean equals (Object autreAdministrateur) {
      return super.equals(autreAdministrateur) &&
            titre.equals(((Administrateur)autreAdministrateur).titre) &&
            domaine.equals(((Administrateur)autreAdministrateur).domaine) &&
            superviseur.equals(((Administrateur)autreAdministrateur).superviseur);
              
            
   }
}
