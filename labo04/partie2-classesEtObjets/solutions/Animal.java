
/**
 * Cette classe modelise un animal de compagnie.
 *
 * INF111 : Solution labo04 - partie 2 (classe et objets).
 * 
 * @author Melanie Lord
 * @version A2018
 */
public class Animal {
   
   //---------------------------------
   // Constantes de classe
   //---------------------------------
   
   //nom des sortes, selon leur code 
   public final static int SORTE_0 = 0;
   public final static int SORTE_1 = 1;
   public final static int SORTE_2 = 2;
   public final static int SORTE_3 = 3;
   
   //pour obtenir le nom d'une sorte avec son code
   //par exemple, le nom de la sorte = SORTE_0 est TAB_SORTES[sorte] => "chat".
   public final static String [] TAB_SORTES 
                                    = {"chat", "chien", "oiseau", "autre"};
   
   //---------------------------------
   // Attribut de classe 
   //---------------------------------
   
   //tient le compte des animaux avec une micropuce
   private static int nbrAnimauxAvecMicropuce = 0;

   //---------------------------------
   // Attributs d'instance
   //---------------------------------
   
   private String nom;           //le nom de l'animal
   
   //la sorte de l'animal : SORTE_0, SORTE_1, SORTE_2 ou SORTE_3
   private int sorte;            
   
   private String proprietaire;   //le proprietaire de l'animal
   private boolean avecMicropuce; //true si l'animal a une micropuce, faux sinon

   //---------------------------------
   // Constructeurs
   //---------------------------------
   
   /**
    * Constructeur qui initialise l'animal avec les valeurs passees en
    * parametres.
    * 
    * ANTECEDENTS : 
    *    - la sorte donnee doit etre SORTE_0, SORTE_1, SORTE_2 ou SORTE_3
    *    - le nom, et le proprio donnes ne doivent pas etre null.
    *
    * @param nom le nom de l'animal
    * @param sorte la sorte de l'animal
    * @param proprio le proprietaire de l'animal
    * @param avecMicropuce true si l'animal a une micropuce, faux sinon
    */
   public Animal(String nom, int sorte, String proprio, boolean avecMicropuce) {
      
      //initialisation des attributs
      this.nom = nom;
      this.sorte = sorte;
      proprietaire = proprio;
      this.avecMicropuce = avecMicropuce;
      
      //Ajustement de la variable de classe qui tient le compte du nombre 
      //total d'animaux avec un micropuce.
      if (avecMicropuce) {
         nbrAnimauxAvecMicropuce++;
      }
   }
   
   /**
    * Constructeur sans argument qui construit un animal avec avec le nom = "", 
    * le proprietaire = "", avecMicropuce = false, et sorte = SORTE_0.
    */
   public Animal() {
      //re-utilisation du constructeur a 4 parametres - bonne pratique
      this("", 0, "", false);  //appel du constructeur a 4 parametres
   }
   
   /**
    * Constructeur de copie qui construit une copie de autreAnimal.
    * @param autreAnimal l'animal dont on veut une copie.
    * 
    * Si cet animal a une micropuce, l'autreAnimal en aura une aussi, et 
    * le nombre d'animaux avec micropuce doit etre incremente de 1.
    * 
    */
   public Animal(Animal autreAnimal) {
      
      //re-utilisation du constructeur a 4 parametres - bonne pratique
      this(autreAnimal.nom, autreAnimal.sorte, autreAnimal.proprietaire, 
              autreAnimal.avecMicropuce);
   }

   //----------------
   // GETTERS 
   //----------------
   
   /**
    * Permet de consulter l'attribut nom de cet animal.
    *
    * @return le nom de cet animal.
    */
   public String getNom() {
      return nom;
   }

   /**
    * Permet de consulter l'attribut sorte de cet animal.
    *
    * @return la sorte de cet animal.
    */
   public int getSorte() {
      return sorte;
   }

   /**
    * Permet de consulter l'attribut proprietaire de cet animal.
    *
    * @return le proprietaire de cet animal.
    */
   public String getProprietaire() {
      return proprietaire;
   }

   /**
    * Permet de consulter l'attribut avecMicropuce de cet animal
    * 
    * @return true si avec micropuce, false sinon
    */
   public boolean isAvecMicropuce() {
      return avecMicropuce;
   }

   //----------------
   // SETTERS
   //----------------
   
   /**
    * Permet de modifier l'attribut nom de cet animal.
    * 
    * ANTECEDENT : 
    *    - le nom donne ne doit pas etre null.
    * 
    * @param nom le nouveau nom pour cet animal.
    */
   public void setNom(String nom) {
      this.nom = nom;
   }
   
   /**
    * Permet de modifier l'attribut sorte de cet animal.
    * 
    * ANTECEDENT : 
    *    - la sorte donnee doit SORTE_0, SORTE_1, SORTE_2 ou SORTE_3
    *
    * @param sorte la nouvelle sorte pour cet animal.    
    */
   public void setSorte(int sorte) {
      this.sorte = sorte;
   }

   /**
    * Cette methode permet de modifier l'attribut proprietaire de cet animal.
    * 
    * ANTECEDENT : 
    *    - le proprietaire donne ne doit pas etre null.
    *
    * @param proprio le nouveau proprietaire pour cet animal. 
    */
   public void setProprietaire(String proprio) {
      proprietaire = proprio;
   }
   
   /**
    * Cette methode permet de modifier l'attribut avecMicropuce de cet animal.
    * 
    * @param avecMicropuce la nouvelle valeur pour cet attribut : true si l'on 
    *                      veut indiquer que l'animal a une micropuce, false 
    *                      dans le cas contraire.
    */
   public void setAvecMicropuce(boolean avecMicropuce) {
      
      //ajustement de la var. de classe qui tient le compte des animaux
      //avec une micropuce, s'il y a lieu.
      
      //Si l'animal avait une micropuce, et qu'apres la modification, il n'en
      //aura plus, il faut decrementer la variable nbrAnimauxAvecMicropuce.
      if (this.avecMicropuce && !avecMicropuce) {
         
         nbrAnimauxAvecMicropuce--;
      
      //Si l'animal n'avait pas de micropuce, et qu'apres la modification, il en
      //aura une, il faut incrementer la variable nbrAnimauxAvecMicropuce.
      } else if (!this.avecMicropuce && avecMicropuce) {
         
         nbrAnimauxAvecMicropuce++;
      }
      
      //effectuer la modification
      this.avecMicropuce = avecMicropuce;
   }

   //---------------------------------
   // AUTRE METHODE D'INSTANCE
   //---------------------------------
   
   /**
    * Construit une representation sous forme de chaine de caracteres des 
    * attributs de cet animal.
    * 
    * NOTE : UTILISEZ TAB_SORTES pour obtenir le nom de la sorte.
    * 
    * @return une representation sous forme de chaine de caracteres de 
    *         cet animal
    */
   public String toString() {
      String s;
      String mp = (avecMicropuce) ? "(avec micropuce)" : "(sans micropuce)";
      
      s = "Nom     : " + nom + mp + "\n" + "Sorte   : " + TAB_SORTES[sorte]
              + "\nProprio : " + proprietaire;
      
      return s;
   }
   
   /**
    * Retourne true si le proprietaire de cet animal est le meme que le 
    * proprietaire de l'animal donne en parametre. Si autreAnimal est null, 
    * la methode retourne false.
    * 
    * @param autreAnimal l'autre animal avec lequel on veut comparer les
    *                    proprietaires
    * @return true si le proprietaire de cet animal est le meme que le 
    *         proprietaire de l'animal donne en parametre
    */
   public boolean equals (Animal autreAnimal) {
      boolean egaux = false;
      
      if (autreAnimal != null) {
         egaux = this.proprietaire.equalsIgnoreCase(autreAnimal.proprietaire);
      }
      
      return egaux;
   }
   
   

   //---------------------------------
   // METHODES DE CLASSE
   //---------------------------------
   
   /**
    * Permet d'obtenir le nombre total d'animaux avec une micropuce.
    * 
    * @return le nombre total d'animaux avec une micropuce 
    */
   public static int getNbrAnimauxAvecMicropuce () {
      return nbrAnimauxAvecMicropuce;
   }
   
   
   /**
    * Decremente le nombre total d'animaux avec une micropuce de nbr.
    * 
    * @param nbr le nombre a soustraire au nombre d'animaux avec micropuce
    */
   public static void decrementerNbrAnimauxAvecMicropuce (int nbr) {
      nbrAnimauxAvecMicropuce -= nbr;
   }
   
     
}
