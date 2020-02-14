
/**
 * INF111 : solution de l'exercice 2 du labo #6.
 * 
 * @author Melanie Lord
 * @version A2018
 */
public class UtilisationListePosCourante {
   
   /**
    * Teste si l'element o est dans la liste donnee.
    * 
    * Si o est null, cette methode retourne true si la liste donnee contient
    * un element null.
    * 
    * ANTECEDENT : la liste donnee n'est pas null (mais elle peut 
    *              contenir des elements null).
    * 
    * @param liste la liste dans laquelle chercher o
    * @param o l'element a chercher dans liste
    * @return true si l'elelement est dans la liste, faux sinon.
    */
   public static boolean contientElement (ListePosCouranteTableau liste, 
           Object o) {
      
      boolean contient = false;  //resultat a retourner
      Object element;            //pour consulter chaque element de liste

      //try... catch necessaire pour la compilation
      try {
         
         if (!liste.estVide()) {
            
            //mettre la position courante sur le premier element de la liste
            liste.setPosDebut();
            
            //ne pas utiliser de boucle for... sortir de la boucle lorsqu'on trouve 
            //l'objet recherche    

            do {
               //obtenir l'element courant et verifier 
               element = liste.getElement();
               
               //verifier si c'est l'element recherche
               contient = element == null && o == null 
                       || element != null && element.equals(o);

            } while (liste.setPosSuivant() && !contient); //passer au suivant
            
         } 
         
      } catch (ListeVideException e) {
         
         //ne rien faire (ne doit pas se produire)
         e.printStackTrace(); //pour deboguer si ca se produit
      }
   
      return contient;
   }
   
   /**
    * Programme principale pour tester la methode contientElement(...).
    * @param args (non utilise)
    */
   public static void main (String [] args) {
      
      //instanciation d'une liste
      ListePosCouranteTableau liste = new ListePosCouranteTableau();
      
      //try... catch necessaire pour compilation
      try {         
         //Ajout d'elements dans la liste
         liste.ajouterFin(5);
         liste.ajouterFin(3);
         liste.ajouterFin(10);
         liste.ajouterFin(7);
         liste.ajouterFin(null);
         liste.ajouterFin(23);
         liste.ajouterFin(9);
         liste.ajouterFin(4);
         liste.ajouterFin(12);
         

         //Tests de la methode contientElement en testant la recherche 
         //d'un objet existant au debut, a la fin, au milieu, 
         //d'un objet null, et d'un objet inexistant.
         System.out.println(contientElement(liste, 5));     //true
         System.out.println(contientElement(liste, 12));    //true
         System.out.println(contientElement(liste, 7));     //true
         System.out.println(contientElement(liste, null));  //true
         System.out.println(contientElement(liste, 11));    //false
         
         //vider la liste
         liste.vider();
         
         //test dans une liste vide
         System.out.println(contientElement(liste, 1));     //false
         
      } catch (ListePleineException e) {
         
         //ne doit pas se produire
         e.printStackTrace(); //pour deboguer
      }

   }
   
}
