import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class TestJouerNotes {

    public static void main(String args[]) {
        AudioFormat audioFmt =
                new AudioFormat(20500, 16, 1, true, true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                SourceDataLine ligne;

                try {
                    ligne = AudioSystem.getSourceDataLine(audioFmt);
                    ligne.open(audioFmt);

                    // Démarre la production de son
                    ligne.start();

                    // Joue la gamme de do majeure à une intensité de
                    // 30% pendant une demie seconde. Le 4 signifie
                    // la gamme au centre du piano. C3 est plus grave et
                    // C5 est plus aigu.

                    jouer(ligne, "C4", .3, 500);
                    jouer(ligne, "D4", .3, 500);
                    jouer(ligne, "E4", .3, 500);
                    jouer(ligne, "F4", .3, 500);
                    jouer(ligne, "G4", .3, 500);
                    jouer(ligne, "A4", .3, 500);
                    jouer(ligne, "B4", .3, 500);
                    jouer(ligne, "C5", .3, 1000); // do plus aigu, 1 seconde
                } catch (LineUnavailableException e) {
                    System.out.println("# Erreur : impossible de trouver une ligne de sortie audio au format :");
                    System.out.println("# " + audioFmt);
                }
            }
        });

        t.start();
    }

    public static void jouer(SourceDataLine ligne, String note, double intensite, double duree) {
        Note n = new Note(note, duree); //création d'une Note
        n.jouer(ligne, intensite); //appel de la méthode jouer de la classe Note
    }
}
