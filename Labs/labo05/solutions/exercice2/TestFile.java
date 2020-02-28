package labo5_PileFileStatique_Exceptions.exercice2.solution;


/**
 * Classe pour tester (partiellement) les operations sur une file.
 *
 * @author Louise Laforest
 * @version Fevrier 2011
 * @revisor Melanie Lord, Automne 2018
 */
public class TestFile {

   public static void main(String[] args) {

      File f = new File();     // une file d'objets

      System.out.println("----------------------------------------------" 
              + "\nTestFile - tester les operations sur une file"
              + "\nLes resultats attendus sont entre parentheses."
              + "\n----------------------------------------------");

      System.out.println("\nCreation d'un file vide...\n");
      System.out.println("estVide() = " + f.estVide() + " (true)");

      try {
         f.consulterDebut();
         System.out.println("erreur : consulterDebut() ne leve aucune exception avec une file vide");
      } catch (Exception e) {
         System.out.println("consulterDebut() leve bien Exception avec une file vide");
      } 

      try {
         f.defiler();
         System.out.println("erreur : defiler() ne leve aucune exception avec une file vide");
      } catch (Exception e) {
         System.out.println("defiler() leve bien Exception avec une file vide");
      } 

      System.out.println("\nEnfilement de A B C D E F...\n");
      f.enfiler("A");
      f.enfiler("B");
      f.enfiler("C");
      f.enfiler("D");
      f.enfiler("E");
      f.enfiler("F");

      System.out.println("estVide() = " + f.estVide() + " (false)");
      try {
         System.out.println("consulterDebut() = " + f.consulterDebut() + " (A)");
      } catch (Exception e) {
         
      }
      System.out.println("getNbrElements() = " + f.getNbrElements() + " (6)");

      
      //AJOUT D'UN TRY... CATCH pour gerer l'exception explicite EXCEPTION et 
      //permettre la compilation.
      try {
         
         
         System.out.println("\nDefilement de tous les elements, un apres l'autres...\n");
         
         while (!f.estVide()) {
            System.out.print(f.defiler() + " ");
         }
         
         System.out.println(" (A B C D E F)\n");

         System.out.println("estVide() = " + f.estVide() + " (true)");

         System.out.println("\nEnfilement de X Y Z...\n");
         f.enfiler("X");
         f.enfiler("Y");
         f.enfiler("Z");
         System.out.println("estVide() = " + f.estVide() + " (false)");
         System.out.println("consulterDebut() = " + f.consulterDebut() + " (X)");
         System.out.println("getNbrElements() = " + f.getNbrElements() + " (3)");

         System.out.println("\nVider la file (f.vider())...\n");
         f.vider();

         System.out.println("estVide() = " + f.estVide() + " (true)");
         System.out.println("getNbrElements() = " + f.getNbrElements() + " (0)");

         System.out.println("\nEnfilement de A B C D E F...\n");
         f.enfiler("A");
         f.enfiler("B");
         f.enfiler("C");
         f.enfiler("D");
         f.enfiler("E");
         f.enfiler("F");
         System.out.println("Defiler 1 fois...\n");
         f.defiler();
         System.out.println("getNbrElements()  : " + f.getNbrElements() + " (5)");
         System.out.println("consulterDebut() : " + f.consulterDebut() + " (B)");

         System.out.println("\nDefiler 3 fois...\n");
         f.defiler();
         f.defiler();
         f.defiler();
         System.out.println("getNbrElements()  : " + f.getNbrElements() + " (2)");
         System.out.println("consulterDebut() : " + f.consulterDebut() + " (E)");

         try {
            System.out.print("\nDefiler 3 fois...\n");
            f.defiler();
            f.defiler();
            f.defiler();
            System.out.println("Erreur - ne lance pas une Exception !");
            
         } catch (Exception e) {
            System.out.println("OK - leve une Exception");
         }

         System.out.println("estVide() = " + f.estVide() + " (true)");

         System.out.println("\nEnfiler 100 elements...\n");
         for (int i = 0 ; i < 100 ; i++) {
            f.enfiler("" + i);
         }

         System.out.println("getNbrElements()  : " + f.getNbrElements() + " (100)");

      } catch (Exception e) {
         e.printStackTrace();  //ne devrait pas se produire
      }

      System.out.println();
      System.out.println("F i n   n o r m a l e   d u   p r o g r a m m e\n\n\n");

   } // main
}
