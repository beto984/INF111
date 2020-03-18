import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * PanneauClavier
 */
public class PanneauClavier extends JPanel{

    public PanneauClavier(){
        initComposants();
    }

    private void initComposants(){
        this.setLayout(new GridLayout(5,3,0,10));


        for(int i = 0; i < 9; i++){
            this.add(new JButton(i + 1 + ""));
        }

        this.add(new JButton("*"));
        this.add(new JButton("0"));
        this.add(new JButton("#"));
        this.add(new JPanel());
        this.add(new JButton("SEND"));
        this.add(new JPanel());
    }
    
}