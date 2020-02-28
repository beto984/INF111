import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fichier {

    public static PieceMusicale obtenirChanson(String cheminFichier) {
        PieceMusicale pieceAJouer = null;
        File fichier = new File(cheminFichier);

        try {
            Scanner reader = new Scanner(fichier);
            GenerateurAccord generateur = new GenerateurAccord();
            String titre = reader.nextLine();
            int bpm = reader.nextInt();
            pieceAJouer = new PieceMusicale(titre, bpm);

            String accord = "";
            double duree;

            while (reader.hasNext()) {
                accord = reader.next();
                duree = reader.nextDouble() * (60000 / bpm);
                pieceAJouer.ajouterAccord(generateur.obtenirAccord(accord, duree));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pieceAJouer;
    }
}
