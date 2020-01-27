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

    public static void remplirManche(boolean[][] manche, int note){
        int [] positionNote = constApplications.POSITION[note-1];
        int choixGamme = choisirGamme();

        if (choixGamme == constApplications.MAJEURE){
            for (int i = 0; i < 6; i++){
                for(int j = 0; j < 25; j++){
                    if(j == positionNote[i]){
                        manche[i][j] = true; 
                        manche[i][j+2] = true;
                        manche[i][j+4] = true;
                        manche[i][j+5] = true;
                        manche[i][j+7] = true;
                        manche[i][j+9] = true;
                        manche[i][j+11] = true;
                        manche[i][j+12] = true;
                    }
                }
            }
        }
        if (choixGamme == constApplications.MINEURE){
            for (int i = 0; i < 6; i++){
                for(int j = 0; j < 25; j++){
                    if(j == positionNote[i]){
                        manche[i][j] = true; 
                        manche[i][j+2] = true;
                        manche[i][j+3] = true;
                        manche[i][j+5] = true;
                        manche[i][j+7] = true;
                        manche[i][j+8] = true;
                        manche[i][j+10] = true;
                        manche[i][j+12] = true;
                    }
                }
            }
        }

    }

    public static void menuManches(boolean[][] manche){
        note = notes.saisiNotes();

        switch (note) {
            case constApplications.DO:
                remplirManche(manche, constApplications.DO);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;
                
            case constApplications.DO_DIESE:
                remplirManche(manche, constApplications.DO_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;
            case constApplications.RE:
                remplirManche(manche, constApplications.RE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.RE_DIESE:
                remplirManche(manche, constApplications.RE_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI:
                remplirManche(manche, constApplications.MI);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI_DIESE:
                remplirManche(manche, constApplications.MI_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA:
                remplirManche(manche, constApplications.FA);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA_DIESE:
                remplirManche(manche, constApplications.FA_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SOL:
                remplirManche(manche, constApplications.SOL);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break; 

            case constApplications.SOL_DIESE:
                remplirManche(manche, constApplications.SOL_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI:
                remplirManche(manche, constApplications.SI);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI_DIESE:
                remplirManche(manche, constApplications.SI_DIESE);
                notes.afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            default:
                break;
        

        }
    }
}