/**
 * UtilisationListePosCourante
 */
public class UtilisationListePosCourante {


    public static boolean contientElement(ListePosCouranteTableau liste, Object o){
        Object elem;
        boolean contient = false;

        try{
            if(!liste.estVide()){
                liste.setPosDebut();

                do{
                    elem = liste.getElement();

                    contient = elem == null && o == null 
                       || elem != null && elem.equals(o);
                }while(liste.setPosSuivant() && !contient);
            }

        }catch(ListeVideException e){
            e.printStackTrace(); //pour deboguer si ca se produit
        }

        return contient;
    }

    public static void main(String[] args) {
        ListePosCouranteTableau listePosCourante = new ListePosCouranteTableau();

        try{
            listePosCourante.ajouterFin(5);
            listePosCourante.ajouterFin(3);
            listePosCourante.ajouterFin(10);
            listePosCourante.ajouterFin(7);
            listePosCourante.ajouterFin(null);
            listePosCourante.ajouterFin(23);
            listePosCourante.ajouterFin(9);
            listePosCourante.ajouterFin(4);
            listePosCourante.ajouterFin(12);
         
            //Tests de la methode contientElement en testant la recherche 
            //d'un objet existant au debut, a la fin, au milieu, 
            //d'un objet null, et d'un objet inexistant.
            System.out.println(contientElement(listePosCourante, 5));     //true
            System.out.println(contientElement(listePosCourante, 12));    //true
            System.out.println(contientElement(listePosCourante, 7));     //true
            System.out.println(contientElement(listePosCourante, null));  //true
            System.out.println(contientElement(listePosCourante, 11));    //false
            
            //vider la liste
            listePosCourante.vider();
            
            //test dans une liste vide
            System.out.println(contientElement(listePosCourante, 1));     //false
        }  catch(ListePleineException e){
            e.printStackTrace(); //pour deboguer
        }
    }
}