import java.util.Vector;

/**
 * PieceMusicale
 */
public class PieceMusicale {

    private String nom;
    private int bpm;
    private Vector<Accord> accords;

    public PieceMusicale(String nom, int bpm){
        this.nom = nom;
        this.bpm = bpm;
        this.accords = new Vector<Accord>();
    }

    public void ajouterAccord(Accord unAccord){
        this.accords.add(unAccord);
    }

    /**
     * Permet de pauser l'application pour donner du temps a
     * un autre processus dans un univers multitaches
     * 
     * @param duree Le temps de la pause
     */

    private void pause(int duree) {
        try {
            Thread.sleep(duree);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void jouer(){
        for(int i = 0; i < accords.size(); i++){
            accords.get(i).jouer();
            double duree = accords.get(i).getListeNotes().get(0).getDuree();
            pause((int)duree);
        }
    }

    @Override
    public String toString(){
        String retour = " ";

        for(int i = 0; i <accords.size(); i++){
            retour += accords.get(i).toString();
            if((i + 1) % 4 == 0){
                retour += "\n";
            }
        }
        return retour; 
    }

    
}