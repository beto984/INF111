
public class DemarrerTelephone {

   public static void main (String [] args) {
      
      //Demarrer le gui dans un nouveau thread.
      Thread t = new Thread(new Telephone());
      t.start();
   }
   
}
