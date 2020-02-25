/**
 * FormeSinus
 */
public class FormeSinus extends FormeOnde{

    public FormeSinus(double frequence, double freqEchantillonage){
        super(frequence, freqEchantillonage);
    }


    public double echantillon(int i){
        double periode = 1 / getFrequence();
        double a = i / getFreqEchantillonage();

        double r = Math.IEEEremainder(a, periode);

        if(r < 0 ){
            r += periode;
        }

        return Math.sin(2 * Math.PI * getFrequence() * r);
    }
}