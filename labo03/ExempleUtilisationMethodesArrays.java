
//À importer pour utiliser les methodes de la classe Arrays
import java.util.Arrays;

/**
 * Voici quelques exemples d'utilisation de quelques methodes de la classe 
 * java.util.Arrays.
 * 
 * Voir la Javadoc de la classe Arrays pour plus de details.
 * 
 * @author melanie lord
 * @version automne 2018
 */
public class ExempleUtilisationMethodesArrays {

   
   public static void main (String [] args) {
      
      String [] t1 = {"allo", "coucou", "oups", "blop"};
      int [] t2 = {2, 4, 8, 1, 9, 13, 5};
      int [] tt2;
      String [] tt1;
      
      //-----------------------
      //Methode toString (tab)  
      //-----------------------
      /*
      retourne une representation de tab
      sous forme de chaine de caracteres "[v1, v2, v3, ...]
      Utile pour afficher un tableau.
      */
      //Affiche : [allo, coucou, oups, blop]
      System.out.println(Arrays.toString(t1));
      
      //Affiche : [2, 4, 8, 1, 9, 13, 5]
      System.out.println(Arrays.toString(t2)); 
      
      
      //----------------------------------------
      //Methode copyOf (tab, nouvelle_longueur)
      //----------------------------------------
      /*
      Permet d'obtenir un NOUVEAU tableau obtenu en tronquant ou en agrandissant
      le tableau donne en parametre. 
      
      Le tableau donne en parametre N'EST PAS modifie.
      
      Si l'on agrandit, les cases supplementaires a la fin du tableau 
      contiennent les valeurs par defaut du type du tableau donne en parametre.
      
      Le deuxieme parametre est la nouvelle longueur pour le tableau retourne.
      Si l'on donne une longueur identique a la longueur du tableau en parametre,
      on obtient une copie identique.
      */
      
      
      tt1 = Arrays.copyOf(t1, t1.length); //Cree une copie identique
      //Affiche : [allo, coucou, oups, blop]
      System.out.println(Arrays.toString(tt1));
      
      tt1 = Arrays.copyOf(t1, 2);  //tronque
      //Affiche : [allo, coucou]
      System.out.println(Arrays.toString(tt1));
      
      tt2 = Arrays.copyOf(t2, 10); //agrandit
      //Affiche : [2, 4, 8, 1, 9, 13, 5, 0, 0, 0]
      System.out.println(Arrays.toString(tt2));
      
      
      //----------------------------------------
      //Methode equals (tab1, tab2)
      //----------------------------------------
      /*
      Retourne true si les deux tableaux ont la même longueur et le même contenu
      (memes elements aux memes indices).
      */
      
      tt1 = new String[] {"allo", "coucou", "oups", "blop"};
      tt2 = new int[] {2, 4, 8, 1000, 9, 13, 5};
      
      //RAPPEL : l'op. == compare les references, et pas le contenu :
      System.out.println(t1 == tt1); //false meme s'ils ont le meme contenu
      
      System.out.println(Arrays.equals(t1, tt1)); //true, meme contenu
      
      System.out.println(Arrays.equals(t2, tt2)); //false, pas meme contenu
      
      //----------------------------------------
      //Methode fill (tab, val)
      //----------------------------------------
      /*
      Modifie le contenu de tab en affectant a toutes ses cases la valeur val.
      */
      tt1 = new String[]{"a", "x", "w", "p", "s", "e", "r"};
      Arrays.fill(tt1, "Q");
      //Affiche : [Q, Q, Q, Q, Q, Q, Q]
      System.out.println(Arrays.toString(tt1));
      
      
      //------------------------------------------------
      //Methode fill (tab, indiceDebut, indiceFin, val)
      //------------------------------------------------
      /*
      Modifie le contenu de tab en affectant ses cases de indiceDebut (inclus) 
      a indiceFin (non inclus) avec la valeur val.
      */
      tt2 = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
      Arrays.fill(tt2, 3, 7, 50);
      //Affiche : [1, 2, 3, 50, 50, 50, 50, 8, 9, 10, 11, 12]
      System.out.println(Arrays.toString(tt2));
      
      
      //------------------------------------------------
      //Methode sort (tab)
      //------------------------------------------------
      /*
      Modifie tab en triant ses elements en ordre croissant.
      */
      Arrays.sort(t1);
      //Affiche : [allo, blop, coucou, oups]
      System.out.println(Arrays.toString(t1));
      
      Arrays.sort(t2);
      //Affiche : [1, 2, 4, 5, 8, 9, 13]
      System.out.println(Arrays.toString(t2));
      
   }

}
