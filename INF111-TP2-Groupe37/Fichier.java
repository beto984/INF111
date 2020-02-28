import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fichier {

    public static PieceMusicale obtenirChanson(String cheminFichier) {
        PieceMusicale piece = null;
        File fichier = new File(cheminFichier);

        try {
            Scanner reader = new Scanner(fichier);
            GenerateurAccord generateur = new GenerateurAccord();
            String titre = reader.nextLine();
            int bpm = reader.nextInt();
            piece = new PieceMusicale(titre, bpm);

            String accord = "";
            double duree;

            while (reader.hasNext()) {
                accord = reader.next();
                duree = reader.nextDouble() * (6000 / bpm);
                piece.ajouterAccord(generateur.obtenirAccord(accord, duree));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return piece;
    }
}
