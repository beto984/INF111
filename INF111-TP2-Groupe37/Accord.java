import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;

/**
 * Accord
 */
public class Accord {

    private String nom;
    private ArrayList<Note> listeNotes; 

    public Accord(String nom, ArrayList<Note> listeNotes){
        this.nom = nom;
        this.listeNotes = new ArrayList<Note>();

        if(listeNotes != null){
            for(int i = 0; i< listeNotes.size();i++){
                this.listeNotes.add(i, listeNotes.get(i));
            }
        }
    }   

    public String getNom(){
        return nom; 
    }

    @Override
    public boolean equals(Object unAccord){
        boolean egal; 
        if(unAccord == null || unAccord.getClass() != this.getClass()){
            egal = false; 
        }

        Accord cache = (Accord) unAccord;

        egal = cache.getNom().equals(this.getNom());

        return egal; 
    }

    public void jouer(){
        SourceDataLine[] listeLigne = 
                new SourceDataLine[this.listeNotes.size()];

        AudioFormat audioFmt =
                new AudioFormat(20500, 16, 1, true, true);
        
        for (int i = 0; i<listeNotes.size();i++){
            int j =i;
            Thread t = new Thread (new Runnable(){
                @Override
                public void run(){
                    try{
                        listeLigne[j] = AudioSystem.getSourceDataLine(audioFmt);
                        listeLigne[j].open(audioFmt);
                        listeLigne[j].start();
                        Note n = listeNotes.get(j); //création d'une Note
                        n.jouer(listeLigne[j], .3);
                    }catch (LineUnavailableException e){
                        System.out.println("# Erreur : impossible de trouver une ligne de sortie audio au format :");
                        System.out.println("# " + audioFmt);
                    }
                }
            });
            t.start();
        }
    }

    @Override
    public String toString(){
        String retour = "Nom de l'accord: " + this.getNom() + 
                "\n Notes: ";

        for(int i = 0; i< listeNotes.size(); i++){
            retour += listeNotes.get(i).getNom_();
        }

        return retour; 
    }
}