public class notes{
    

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
                if(j == positionNote[i] || j == positionNote[i]+12 ||  j == positionNote[i]+24){
                    manche[i][j] = true;
                }
                //System.out.print(manche[i][j]+ " ");
            }
            //System.out.println("\n");
        }
        
    }

    public static void afficheManche(boolean [][] manche){
        String str;
        for (int i = 0; i < 6; i++){
          if(manche[i][0] == true){
               str= "0" + (i+1) + "|";
          }
          else {
               str= " " + (i+1) + "|";
          }
            System.out.print(str);
            for (int j = 1; j < 25 ; j++){
                if(manche[i][j] == true ){
                    if (j<10)
                        System.out.print(" " + j + "|");
                    else
                        System.out.print(j + "|");

                }else{
                    System.out.print("__|");
                }
            }
            System.out.print("\n");
        }
        UtilitaireValidation.pause();
    }

    
    public static int menuNotes(boolean[][] manche){
        int note = 0;
        int mode = 1; 
        note = saisiNotes();
        if (note == 0){
            mode = 0; 
        }else{
            programmePrincipal.initialiseMancheFaux(manche);
            remplirManche(manche, note);
            afficheManche(manche);
        }
       
        
        return mode; 
    }
    


}