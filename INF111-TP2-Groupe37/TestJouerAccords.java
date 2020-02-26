public class TestJouerAccords {
    public static void main(String args[]){
        GenerateurAccord generateur = new GenerateurAccord();
        Accord accord = generateur.obtenirAccord("C",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("Dm",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("Em",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("F",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("G",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("Am",1000);
        accord.jouer();
        pause(1000);

        accord = generateur.obtenirAccord("B7",1000);
        accord.jouer();

    }

    private static void pause (int duree) {
        try {
            Thread.sleep(duree);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}