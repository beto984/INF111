import javafx.beans.value.WeakChangeListener;


/**
 * Classe qui contient le programme principal 
 *
 * @author Kenza Zniber et Humberto Villarino
 * Date: 24 janvier 2020
 */

 public class programmePrincipal{
    
    static boolean fin=false; 
    static boolean[][] manche = new boolean[6][25];
    static int mode = constApplications.MODE_MENU_PRINCIPAL;
    
    /*
    * Fonction qui initialise la manche a Faux 
    *
    * @param manche[][] tableau 2d vide
    * @return void
    */
    public static void initialiseMancheFaux(boolean manche[][]){
        for(int i=0;i<6;i++){
            for (int j =0; j<25; j++){
                manche[i][j]=false;
            }
        }
    }

    public static void main(String[] args) {
        do {
        

            switch (mode){
                case constApplications.MODE_MENU_PRINCIPAL:
                    initialiseMancheFaux(manche);
                    System.out.println("Utilitaire pour guitare");
                    System.out.println("---------------------------------------------");
                    System.out.println("1 : Afficher une note sur le manche"); 
                    System.out.println("2 : Afficher une gamme sur le manche");
                    System.out.println("3 : Quitter");
                    System.out.println("---------------------------------------------");
                    mode=UtilitaireValidation.lireInt(constApplications.STRING_CHOIX, 1, 3);
                    break;

                case constApplications.MODE_MENU_CHOIX_NOTE:
                    

                case constApplications.MODE_QUITTER:
                    System.out.println("Programme quitté normalement");
                    fin = true;
            }
        }while(!fin);
    
    }
    
 }