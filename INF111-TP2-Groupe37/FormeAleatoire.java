/**
 * FormeAleatoire
 */
public class FormeAleatoire extends FormeOnde{

    public FormeAleatoire(){
        super(0,0);
    }

    /**
     * Retourne le ieme echantillon de la forme d'ondes 
     * @return Un nombre aleatoire entre -1 et 1 
     */
    public double echantillon(){
        return 2 * Math.random() - 1;
    }
}