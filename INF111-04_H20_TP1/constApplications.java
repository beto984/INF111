/**
 * Classe contenant toutes les constantes utilisees
 *
 * @author Kenza Zniber et Humberto Villarino
 * Date: 24 janvier 2020
 */

 public class constApplications{
  // Constantes pour les menu
  public final static int MODE_MENU_PRINCIPAL = 0;
  public final static int MODE_MENU_CHOIX_NOTE = 1;
  public final static int MODE_MENU_CHOIX_GAMME = 2;
  public final static int MODE_QUITTER = 3; 
  public final static String STRING_CHOIX = "Entrez votre choix ";
  public final static String STRING_CHOIX_NOTES = "Entrez le numéro de la note désirée";
  // Constantes pour le menu Notes
  public final static int[][] POSITION = {
    {8, 1, 5, 10, 3, 8},
    {9, 2, 6, 11, 4, 9},
    {10, 3, 7, 0, 5, 10},
    {11, 4, 8, 1, 6, 11},
    {0, 5, 9, 2, 7, 0},
    {1, 6, 10, 3, 8, 1},
    {2, 7, 11, 4, 9, 2},
    {3, 8, 0, 5, 10, 3},
    {4, 9, 1, 6, 11, 4},
    {5, 10, 2, 7, 0, 5},
    {6, 11, 3, 8, 1, 6},
    {7, 0, 4, 9, 2, 7}
  };

  //Constantes des notes
  public final static int DO = 1;
  public final static int DO_DIESE = 2;
  public final static int RE = 3;
  public final static int RE_DIESE = 4;
  public final static int MI = 5;
  public final static int MI_DIESE = 6;
  public final static int FA = 7;
  public final static int FA_DIESE = 8;
  public final static int SOL = 9;
  public final static int SOL_DIESE = 10;
  public final static int SI = 11;
  public final static int SI_DIESE = 12;

 }
 
