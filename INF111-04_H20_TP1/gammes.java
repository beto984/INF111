public class gammes{
    static int note=0;

    public static int choisirGamme(){
        int choixGamme = 0;

        System.out.println("Sortes de gammes\n "+
        "---------------------------------------------\n"+
        "1  : Mineure\n "+
        "2  : Majeure\n "+
        "---------------------------------------------");
       
        return choixGamme = UtilitaireValidation.lireInt("Entrez le numéro de la sorte de gamme désirée", 1, 2);
    }

    public static void remplirManche(boolean[][] manche, int note, int[][] gamme){
        int [] positionNote = constApplications.POSITION[note-1];
        int choixGamme = choisirGamme();

        if (choixGamme == constApplications.MINEURE){
            for(int i = 0; i < 6; i++){
                notes.remplirManche(manche, note);
                note = (note+gamme[0][i])%12;
            }
        }
        if (choixGamme == constApplications.MAJEURE){
            for(int i = 0; i < 7; i++){
                notes.remplirManche(manche, note);
                note = (note+gamme[1][i])%12;
            }
        }

    }

    public static int menuGammes(boolean[][] manche, int[][] gamme){
        note = notes.saisiNotes();

        int mode = 1; 
        
        if (note == 0){
            mode = 0; 
        }else{
            programmePrincipal.initialiseMancheFaux(manche);
            remplirManche(manche, note, gamme);
            afficheManche(manche);
        }
       
        return mode; 
        /*return mode;
        switch (note) {
            case constApplications.DO:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;
                
            case constApplications.DO_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;
            case constApplications.RE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.RE_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);  
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SOL:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break; 

            case constApplications.SOL_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI_DIESE:
                remplirManche(manche, constApplications.DO, constApplications.GAMMES);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            default:
                break;
        */

        }
    }
}