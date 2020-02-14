public class Animal{

//-----------------------
//Constantes pour la classe
//-----------------------

    public final static int SORTE_0 = 0;
    public final static int SORTE_1 = 1;
    public final static int SORTE_2 = 2;
    public final static int SORTE_3 = 3;

    public final String [] TAB_SORTES = {"chat", "chien", "oiseau", "autre"};

//-----------------------
//Attributs

    private String nom;
    private int sorte;
    private String proprietaire;
    private boolean avecMicropuce;

//-----------------------
// Constructeurs
//-----------------------

    public Animal(String nom, int sorte, String proprietaire, boolean avecMicropuce){
        this.nom = nom;
        this.sorte = sorte;
        this.proprietaire = proprietaire;
        this.avecMicropuce = avecMicropuce;
    }

    public Animal(Animal animal){
        this(animal.nom, animal.sorte, animal.proprietaire, animal.avecMicropuce);
    }

    public Animal(){
        this("", SORTE_0, "", false);
    }

//-----------------------
// Getters
//-----------------------

    public String getNom(){
        return nom;
    }

    public int getSorte(){
        return sorte;
    }

    public String getProprietaire(){
        return proprietaire;
    }

    public boolean isAvecMicropuce(){
        return avecMicropuce;
    }

//-----------------------
// Setters
//-----------------------

    public void setNom(String nom){
        this.nom = nom; 
    }

    public void setSorte(int sorte){
        this.sorte = sorte;
    }

    public void setProprietaire(String proprietaire){
        this.proprietaire = proprietaire;
    }

    public void setAvecMicropuce(boolean avecMicropuce){
        this.avecMicropuce = avecMicropuce;
    }

//-----------------------
// Methodes d'instance
//-----------------------

    public String toString(){
        String s;
        String mp = (avecMicropuce) ? "(avec micropuce)" : "(sans micropuce)";

        s = "Nom :   " + nom + mp + "\nSorte:    " + TAB_SORTES[sorte] + "\n Proprietaire:     "
        + proprietaire; 

        return s;
    }

    public boolean equals(Animal autreAnimal){
        boolean egaux;
        if (autreAnimal != NULL){
            egaux = this.proprietaire.equalsIgnoreCase(autreAnimal.proprietaire);
        }
        return egaux;
    }

}
