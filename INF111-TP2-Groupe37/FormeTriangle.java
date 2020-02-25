/**
 * FormeTriangle
 */
public class FormeTriangle extends FormeOnde{

    public FormeTriangle (double frequence, double freqEchantillonage){
        super(frequence, freqEchantillonage);
    }

    public double echantillon(int i){
        double echantillon;
        double periode = 1 / getFrequence();
        double a = i / getFreqEchantillonage();
        double r = Math.IEEEremainder(a, periode);

        if(r < 0){
            r += periode; 
        }

        if(r <= periode /4){
            echantillon = r * 4 / periode;
        }else if (r <= (3 * periode) / 4){
            r -= (periode / 4);
            echantillon = 1 - r * 4 / periode;
        }else{
            r -= (3 * periode) / 4;
            echantillon = -1 + r * 4 / periode;
        }

        return echantillon;
    }
}
