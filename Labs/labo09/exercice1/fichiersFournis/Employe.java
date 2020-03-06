
/**
 * Exemple inspire de Savitch, Absolute Java, chap. 7. Tous les objets ont un
 * nom et une date d'embauche. Le nom "pas de nom" signifie qu'aucun nom n'a
 * encore ete attribue. Une date d'embauche le 1er janvier 0 signifie qu'aucune
 * date d'embauche n'a encore ete attribuee.
 *
 * @author Louise Laforest (laforest.louise@uqam.ca)
 * @version 4 janvier 2005 - 6 janvier 2011
 * @revisor Melanie Lord A2018
 */
public class Employe {

   // nom bidon pour absence de nom
   public static final String NOM_BIDON = "pas de nom";

   private String nom;           // nom de l'employe
   private Date dateEmbauche;    // date d'embauche

   //------------------------
   // CONSTRUCTEURS
   //------------------------
   
   /**
    * Construit un employe avec le nom NOM_BIDON et une date d'embauche le 1er
    * janvier 0.
    */
   public Employe() {
      this(NOM_BIDON, null);
   }

   /**
    * Construit un employe avec le nom leNom si celui-ci n'est pas null, sinon
    * avec NOM_BIDON ainsi que la date d'embauche laDate si celle-ci n'est pas
    * null, sinon avec le 1er janvier 0.
    *
    * @param leNom le nom de l'employe
    * @param laDate la date d'embauche de l'employe
    */
   public Employe(String leNom, Date laDate) {
      if (leNom == null) {
         nom = NOM_BIDON;
      } else {
         nom = leNom;
      }
      
      if (laDate == null) {
         dateEmbauche = new Date(); // 1er janvier 0
      } else {
         dateEmbauche = laDate.copie();
      }
   }

   /**
    * Construit un nouvel employe qui sera une copie de l'employe passe en 
    * parametre
    *
    * @param unEmploye l'employe dont on veut une copie.
    */
   public Employe(Employe unEmploye) {
      nom = unEmploye.nom;
      dateEmbauche = unEmploye.dateEmbauche.copie();
   }

   
   //------------------------
   // GETTERS ET SETTERS
   //------------------------
   
   /**
    * Retourne le nom de l'employe.
    *
    * @return le nom de l'employe.
    */
   public String getNom() {
      return nom;
   }

   /**
    * Retourne la date d'embauche de l'employe.
    * 
    * @return la date d'embauche de l'employe.
    */
   public Date getDateDembauche() {
      return dateEmbauche.copie();
   }

   /**
    * Modifie le nom de l'employe par celui passe en parametre.
    *
    * @param nouveauNom nouveau nom de l'employe
    */
   public void setNom(String nouveauNom) {
      if (nouveauNom == null) {
         nom = NOM_BIDON;
         
      } else {
         nom = nouveauNom;
      }
   }

   /**
    * Modifie la date d'embauche de l'employe par celle passee en parametre. Si
    * celle-ci est null, la date du 1er janvier 0 sera utilisee.
    *
    * @param nouvelleDate nouvelle date d'embauche de l'employe
    */
   public void setDateDembauche(Date nouvelleDate) {
      if (nouvelleDate == null) {
         dateEmbauche = new Date();
         
      } else {
         dateEmbauche = nouvelleDate.copie();
      }
   }
   
   //------------------------
   //AUTRES METHODES
   //------------------------

   /**
    * Retourne sous forme de String les informations sur cet Employe.
    * - Redefinition de la methode toString de la classe Object.
    * @return une representation sous forme de chaine de caracteres de cet
    * Employe.
    */
   public String toString() {
      return nom + " " + dateEmbauche;
   }
   
   /**
    * Teste si cet Employe est egal a autreEmploye.
    * - Redefinition de la methode equals de la classe Object.
    * @param autreEmploye l'employe dont on veut tester s'il est egal 
    * a cet Employe.
    * @return true s'ils sont egaux, false sinon.
    */
   public boolean equals (Object autreEmploye) {
      return autreEmploye != null &&
              //getClass retourne le type dynamique
              getClass() == autreEmploye.getClass() &&
              nom.equals(((Employe)autreEmploye).nom) &&
              dateEmbauche.equals(((Employe)autreEmploye).dateEmbauche);
   
   }
}
