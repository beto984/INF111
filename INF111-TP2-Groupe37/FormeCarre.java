/**
 * FormeCarre
 */
public class FormeCarre extends FormeOnde{

    public FormeCarre(double frequence, double freqEchantillonage){
        super(frequence,freqEchantillonage);
    }   

    public double echantillon(int i){
        double echantillon;
        double periode = 1 / getFrequence();
        double a = i / getFreqEchantillonage();
        double r = Math.IEEEremainder(a, periode);

        if (r < 0){
            r += periode;
        }

        if (r < periode / 2){
            echantillon = 1; 
        } else {
            echantillon = -1; 
        }

        return echantillon;
    }

}