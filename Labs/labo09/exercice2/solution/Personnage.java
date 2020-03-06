
public abstract class Personnage {
   private String nom;
   private ModeDAttaque modeAttaque;  //COMPOSITION
   
   public Personnage(String nom, ModeDAttaque modeAttaque) {
      this.nom = nom;
      this.modeAttaque = modeAttaque;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public ModeDAttaque getModeAttaque() {
      return modeAttaque;
   }

   public void setModeAttaque(ModeDAttaque modeAttaque) {
      this.modeAttaque = modeAttaque;
   }
   
   public void attaquer() {
      //delegation de l'attaque a l'objet modeAttaque.
      modeAttaque.attaquer();
   }
   
}
