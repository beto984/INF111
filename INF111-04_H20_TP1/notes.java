public class notes{
    static int note = 0;

    public static int saisiNotes(){
        int choix; 

        System.out.println("Notes");
        System.out.println("---------------------------------------------");
        System.out.println("1  : Do \n"+
        "2  : Do# \n" +
        "3  : Ré \n" +
        "4  : Ré# \n" +
        "5  : Mi \n" +
        "6  : Fa \n" +
        "7  : Fa# \n" +
        "8  : Sol \n" +
        "9  : Sol# \n" +
        "10 : La \n" +
        "11 : La# \n" +
        "12 : Si \n");

        choix = UtilitaireValidation.lireInt(constApplications.STRING_CHOIX_NOTES, 1, 12);
        return choix; 
    }

    public static void remplirManche(boolean [][] manche, int note){
        int[] positionNote = constApplications.POSITION[note - 1];

        for(int i = 0; i < 6; i++ ){
            for(int j = 0; j < 25; j++){
                if(j == positionNote[i] || j == positionNote[i]+12){
                    manche[i][j] = true;
                }
                System.out.print(manche[i][j]+ " ");
            }
            System.out.println("\n");
        }
        UtilitaireValidation.pause();
    }

    public static void afficheManche(boolean [][] manche){
        
        for (int i = 0; i < 6; i++){
            System.out.print(i + " |"); 
            for (int j = 0; j < 25 ; j++){
                if(manche[i][j] == true){
                    System.out.print(" " + j + " |");
                }else{
                    System.out.print("___|");
                }
            }
        }
    }

    public static void menuNotes(boolean[][] manche){
        note=saisiNotes();
        
        switch (note) {
            case constApplications.DO:
                remplirManche(manche, constApplications.DO);
                afficheManche(manche);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            
            case constApplications.DO_DIESE:
                remplirManche(manche, constApplications.DO_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;
            case constApplications.RE:
                remplirManche(manche, constApplications.RE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.RE_DIESE:
                remplirManche(manche, constApplications.RE_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI:
                remplirManche(manche, constApplications.MI);
                programmePrincipal.initialiseMancheFaux(manche);
                break;    

            case constApplications.MI_DIESE:
                remplirManche(manche, constApplications.MI_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA:
                remplirManche(manche, constApplications.FA);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.FA_DIESE:
                remplirManche(manche, constApplications.FA_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SOL:
                remplirManche(manche, constApplications.SOL);
                programmePrincipal.initialiseMancheFaux(manche);
                break; 

            case constApplications.SOL_DIESE:
                remplirManche(manche, constApplications.SOL_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI:
                remplirManche(manche, constApplications.SI);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            case constApplications.SI_DIESE:
                remplirManche(manche, constApplications.SI_DIESE);
                programmePrincipal.initialiseMancheFaux(manche);
                break;

            default:
                break;
        }
    }


}