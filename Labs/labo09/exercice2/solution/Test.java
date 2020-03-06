
public class Test {
   
   public static void main (String[] args) {
      
      Chevalier ch = new Chevalier("Lancelot");
      Roi ro = new Roi("Arthur");
      Reine re = new Reine("Guenievre");
      Troll tr = new Troll("Boumboum");
      Sorcier so = new Sorcier("Merlin");
      
      System.out.println(ch.getNom());
      ch.attaquer();
      System.out.println("----------------------");
      
      System.out.println(ro.getNom());
      ro.attaquer();
      System.out.println("----------------------");
      
      System.out.println(re.getNom());
      re.attaquer();
      System.out.println("----------------------");
      
      System.out.println(tr.getNom());
      tr.attaquer();
      System.out.println("----------------------");
      
      System.out.println(so.getNom());
      so.attaquer();
      System.out.println("----------------------");
      
      //changer le mode d'attaque de la reine pour attaque a l'arc
      re.setModeAttaque(new AttaqueALArc());
      System.out.println(re.getNom());
      re.attaquer();
      System.out.println("----------------------");
      
      //changer le mode d'attaque du chevalier pour aucun mode d'attaque
      ch.setModeAttaque(new AucunModeDAttaque());
      System.out.println(ch.getNom());
      ch.attaquer();
      System.out.println("----------------------");
      
      
      
      
      
      
   }
   
}
