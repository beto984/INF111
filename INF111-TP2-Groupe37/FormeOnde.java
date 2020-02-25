/**
 * FormeOnde
 */
public class FormeOnde {
    
    //Attributs
    private double frequence;
    private double freqEchantillonage;

    /**
     * Construit un objet FormeOnde avec les attributs passés en parametre
     * @param frequence
     * @param freqEchantillonage
     */
    public FormeOnde(double frequence,double freqEchantillonage){
        this.frequence = frequence;
        this.freqEchantillonage = freqEchantillonage;
    }
    
    /**
     * Retourne la valeur de la frequence
     * @return frequence
     */
    public double getFrequence(){
        return frequence;
    }

    /**
     * Retourne la valeur de la frequence d'echantillonage 
     * @return freqEchantillonage
     */
    public double getFreqEchantillonage(){
        return freqEchantillonage;
    }

}