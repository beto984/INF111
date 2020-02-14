
/**
 * Cette classe est un programme test pour tester la classe Animal.
 *
 * INF111 : Labo04 - partie 2 (classe et objets)
 *
 * @author Melanie Lord
 * @version A2018
 */
public class TestsAnimal {

   public static void main(String[] args) {

      Animal a1 = new Animal();
      Animal a2 = new Animal("Gontrant", Animal.SORTE_3, "Yvan Lamothe", false);
      Animal a3 = new Animal("Titi", Animal.SORTE_2, "Mimi Gonzalez", false);
      Animal a4 = new Animal("Pacha", Animal.SORTE_0, "Pierre Poirier", true);
      Animal a5 = new Animal("Xeus", Animal.SORTE_1, "Mimi Gonzalez", true);
      Animal a6;
      
      System.out.println("-----------------------");
      System.out.println(a1);
      System.out.println("-----------------------");
      System.out.println(a2);
      System.out.println("-----------------------");
      System.out.println(a3);
      System.out.println("-----------------------");
      System.out.println(a4);
      System.out.println("-----------------------");
      System.out.println(a5);
      System.out.println("-----------------------");
      
      /*
      -----------------------
      Nom     : (sans micropuce)
      Sorte   : chat
      Proprio : 
      -----------------------
      Nom     : Gontrant(sans micropuce)
      Sorte   : autre
      Proprio : Yvan Lamothe
      -----------------------
      Nom     : Titi(sans micropuce)
      Sorte   : oiseau
      Proprio : Mimi Gonzalez
      -----------------------
      Nom     : Pacha(avec micropuce)
      Sorte   : chat
      Proprio : Pierre Poirier
      -----------------------
      Nom     : Xeus(avec micropuce)
      Sorte   : chien
      Proprio : Mimi Gonzalez
      -----------------------
      */
      
      System.out.println(a3.equals(a5));    //true
      System.out.println(a3.equals(a4));    //false
      System.out.println(a3.equals(null));  //false
      
      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //2

      a1.setNom("Ratatouille");
      a1.setProprietaire("France Dufour");
      a1.setSorte(Animal.SORTE_3);
      a1.setAvecMicropuce(true);

      System.out.println(a1.getNom());          //Ratatouille
      System.out.println(a1.getSorte());        //3
      System.out.println(a1.getProprietaire()); //France Dufour
      System.out.println(a1.isAvecMicropuce()); //true

      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //3
      
      a4.setAvecMicropuce(false);
      
      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //2
      
      a2.setAvecMicropuce(true);
      
      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //3
      
      a2 = null;  //mort
      a5 = null;  //mort
      
      Animal.decrementerNbrAnimauxAvecMicropuce(2);
      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //1
      
      System.out.println("-----------------------");
      System.out.println(a1);
      System.out.println("-----------------------");
      System.out.println(a2);
      System.out.println("-----------------------");
      System.out.println(a3);
      System.out.println("-----------------------");
      System.out.println(a4);
      System.out.println("-----------------------");
      System.out.println(a5);
      System.out.println("-----------------------");
      
      /*
      -----------------------
      Nom     : Ratatouille(avec micropuce)
      Sorte   : autre
      Proprio : France Dufour
      -----------------------
      null
      -----------------------
      Nom     : Titi(sans micropuce)
      Sorte   : oiseau
      Proprio : Mimi Gonzalez
      -----------------------
      Nom     : Pacha(sans micropuce)
      Sorte   : chat
      Proprio : Pierre Poirier
      -----------------------
      null
      -----------------------
      */
      
      //Test du constructeur de copie et methode equals
      a6 = new Animal (a1);
      
      System.out.println("-----------------------");
      System.out.println(a1);
      System.out.println("-----------------------");
      System.out.println(a6);
      System.out.println("-----------------------");
      
      /*
      -----------------------
      Nom     : Ratatouille(avec micropuce)
      Sorte   : autre
      Proprio : France Dufour
      -----------------------
      Nom     : Ratatouille(avec micropuce)
      Sorte   : autre
      Proprio : France Dufour
      -----------------------
      */
      
      System.out.println(a1 == a6);       //false (ils n'ont pas la meme reference)
      System.out.println(a1.equals(a6));  //true (ils ont le meme proprietaire)
      
      System.out.println(Animal.getNbrAnimauxAvecMicropuce()); //2
      
   }

}
