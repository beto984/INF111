
/**
 * Classe permettant de construire une date formatee d'une annee, d'un mois et
 * d'un jour.
 *
 * Les mois seront representes par les nombres 1, 2, ..., 12 correspondant
 * respectivement a janvier, fevrier, mars, ..., decembre.
 *
 * @author Louise Laforest
 * @version Automne 2004
 * @revisor Melanie Lord A18
 */
public class Date {

   private int annee; //annee de cette date
   private int mois;  //mois de cette date
   private int jour;  //jour de cette date

   /**
    * Construit une Date avec l'annee 0, le mois 1 et le jour 1.
    */
   public Date() {
      annee = 0;
      mois = 1;
      jour = 1;
   }

   /**
    * Construit une Date avec annee, mois et jour. Si (annee, mois, jour) ne
    * constitue pas une date valide, l'exception DateInvalideException sera levee.
    *
    * @param annee l'annee de la date
    * @param mois le mois de la date
    * @param jour le jour de la date
    * @throws DateInvalideException si construction d'une date invalide.
    */
   public Date(int annee, int mois, int jour) throws DateInvalideException {
      if (mois < 1 || mois > 12) {
         throw new DateInvalideException("mois invalide");

      } else if (jour < 1 || jour > nbJoursMois(mois, annee)) {
         throw new DateInvalideException("jour invalide");

      } else {
         this.annee = annee;
         this.mois = mois;
         this.jour = jour;
      }
   }

   /**
    * Retourne true ou false selon que l'annee, le mois et le jour constituent
    * une date valide, false sinon.
    *
    * @param annee l'annee
    * @param mois le mois
    * @param jour le jour
    * @return true si et seulement si l'annee, le mois et le jour constituent
    * une date valide, false sinon.
    */
   public static boolean estValide(int annee, int mois, int jour) {
      return mois >= 1 && mois <= 12 && jour > 0
              && jour <= nbJoursMois(mois, annee);
   }

   /**
    * Retourne une copie de la Date.
    *
    * @return une copie de la Date.
    */
   public Date copie() {
      Date copie = null;
      try {
         copie = new Date(this.annee, this.mois, this.jour);
      } catch (DateInvalideException e) {
      }
      return copie;
   }

   /**
    * Retourne la chaine de caracteres correspondant a la Date sous la forme
    * aaaa/mm/jj.
    *
    * @return la chaine de caractere correspondant a la Date sous la forme
    * aaaa/mm/jj.
    */
   public String toString() {
      String s = this.annee + "/";
      if (mois < 10) {
         s = s + '0';
      }
      s = s + this.mois + '/';
      if (jour < 10) {
         s = s + '0';
      }
      s = s + this.jour;

      return s;
   }

   /**
    * Teste si cette Date est la meme annee, le meme mois et le meme jour 
    * que la date donnee en parametre.
    *
    * @param d la Date a comparer avec cette Date
    * @return true si et seulement si cette Date est la meme annee, le meme mois
    * et le meme jour que la date donnee en parametre, false sinon.
    */
   public boolean equals(Date d) {
      return d != null && getClass() == d.getClass() && 
              annee == d.annee && mois == d.mois && jour == d.jour;
   }

   /**
    * Teste si cette Date est anterieure a la date donnee en parametre.
    *
    * @param d la Date a comparer avec cette Date
    * @return true si et seulement si cette Date est anterieure a la date 
    * donnee en parametre, false sinon.
    */
   public boolean estAnterieure(Date d) {
      boolean reponse;
      if (this.annee != d.annee) {
         reponse = this.annee < d.annee;
      } else if (this.mois != d.mois) {
         reponse = this.mois < d.mois;
      } else {
         reponse = this.jour < d.jour;
      }
      return reponse;
   }

   /**
    * Retourne le nom du mois sous forme de chaine de caracteres. Si le mois est
    * invalide, retourne la chaine "inconnu".
    *
    * @param mois le mois
    * @return le nom du mois sous forme de chaine de caracteres. Si le mois est
    * invalide, retourne la chaine "inconnu".
    */
   public static String nomDuMois(int mois) {
      final String[] noms
              = {"janvier", "fevrier", "mars", "avril", "mai", "juin", 
                 "juillet", "aout", "septembre", "octobre", "novembre", 
                 "decembre"};
      
      return noms[ mois - 1];
   }

   /**
    * Retourne true si et seulement si l'argument represente une annee
    * bissextile, false sinon.
    *
    * @param annee l'annee a verifier
    * @return true si et seulement si l'argument represente une annee
    * bissextile, false sinon.
    */
   public static boolean estBissextile(int annee) {
      return annee % 4 == 0 && annee % 100 != 0
              || annee % 400 == 0;
   }

   /**
    * Retourne le nombre de jours du mois, en fonction de l'annee en tenant en
    * compte des annees bissextile pour le mois de fevrier.
    *
    * @param mois le mois de la date
    * @param annee l'annee de la date
    * @return Retourne le nombre de jours du mois, en fonction de l'annee en
    * tenant en compte des annees bissextile pour le mois de fevrier
    */
   private static int nbJoursMois(int mois, int annee) {

      int reponse = 0;

      if (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8
              || mois == 10 || mois == 12) {
         reponse = 31;

      } else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
         reponse = 30;

      } else if (mois == 2) {
         if (estBissextile(annee)) {
            reponse = 29;
         } else {
            reponse = 28;
         }
      }

      return reponse;

   }
}




