
public class Tests {

   /**
    * Affiche chacun des employes non nuls du tableau tabEmployes
    *
    * @param tabEmployes le tableau d'employes a afficher.
    */
   public static void afficher(Employe[] tabEmployes) {

      for (int i = 0; i < tabEmployes.length; i++) {

         if (tabEmployes[i] != null) {

            System.out.println("Employe " + i + " : "
                    + tabEmployes[i].getClass().getSimpleName());

            //appel implicite de toString sur tabEmployes[i]
            System.out.println(tabEmployes[i]);
            System.out.println();
         }
      }
   }

   public static void main(String[] params) {

      Employe emp
              = new Employe("Marc Durand", new Date(2014, 3, 24));

      EmployeSalarie empS
              = new EmployeSalarie("Sissi Marcoux",
                      new Date(2009, 8, 11), 98000);

      EmployeHoraire empH
              = new EmployeHoraire("Pablo Estevez",
                      new Date(2017, 5, 18), 34.67, 40);

      Administrateur adm = new Administrateur("Isabelle Favreau",
              new Date(2001, 1, 1), 114000, "Directrice du marketing",
              "Marketing", "Leon Coutu");

      Employe[] tab = new Employe[5];

      tab[1] = emp;
      tab[2] = empS;
      tab[3] = empH;
      tab[4] = adm;

      afficher(tab);

      System.out.println();

      //copie de adm
      Administrateur adm2 = new Administrateur(adm);

      System.out.println(adm.equals(adm2));  //true
      System.out.println(adm == adm2);       //false

      //creation d'un autre admin different de adm
      Administrateur adm3 = new Administrateur("Luc Lauzon",
              new Date(2001, 1, 1), 114000, "Directeur du marketing",
              "Marketing", "Leon Coutu");
      
      System.out.println(adm.equals(adm3));  //false

   }

}
