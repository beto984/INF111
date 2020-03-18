package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/**
 * PanneuControle
 */
public class PanneauControle extends JPanel{

    JSlider volume = new JSlider();
    JButton augmente = new JButton();
    JButton diminue = new JButton(); 
    JTextField ecran = new JTextField();
    int numOctave;
    JLabel volumeLabel = new JLabel("Volume");
    JLabel octaveLabel = new JLabel("Octave");


    public PanneauControle(int volumeIn, int octaveIn){
        initComposants(volumeIn, octaveIn);
    }



    private void initComposants(int volumeIn, int OctaveIn) {
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;


        numOctave = OctaveIn;

        initEcran(numOctave);
        initVolume(volumeIn);
        initBoutons();
        this.add(volumeLabel,c);
        c.gridy++;
        this.add(volume,c);
        c.gridx++;
        this.add(diminue,c);
        c.gridx++;
        this.add(ecran,c);
        c.gridy--;
        this.add(octaveLabel,c);
        c.gridx++;
        c.gridy++;
        this.add(augmente,c);

    }

    private void initEcran(int numOctave){
        ecran.setEditable(false);
        ecran.setColumns(2);
        ecran.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        ecran.setText(Integer.toString(numOctave));
    }

    private void initVolume(int volumeIn){
        volume.setMinimum(0);
        volume.setMaximum(10);
        volume.setPaintLabels(true);
        volume.setPaintTicks(true);
        volume.setSnapToTicks(true);
        volume.setMajorTickSpacing(1);
        volume.setValue(volumeIn);
    }


    private void initBoutons(){
        augmente.setText(">");
        diminue.setText("<");
    }

    public JSlider getSlider(){
        return volume; 
    }
    
    public JTextField getEcran(){
        return ecran;
    }

    public JButton getAugmente(){
        return augmente;
    }

    public JButton getDiminue(){
        return diminue;
    }

    public void augmenteNumOctave(){
        numOctave++;
        initEcran(numOctave);
    }

    public void diminueNumOctave(){
        numOctave--;
        initEcran(numOctave);
    }

    public int getNumOctave(){
        return numOctave;
    }
}