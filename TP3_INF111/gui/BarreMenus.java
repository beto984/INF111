package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * BarreMenus
 */
public class BarreMenus {

    //------------------------------
    // ATTRIBUTS D'INSTANCE
    //------------------------------
    private JMenuBar barreMenu;
    JMenu m;
    JMenuItem[] itemsMenu;
    /**
     * Construit la barre de menu avec 1 menu et 2 items
     * dans ce menu 
     * 
     * @return bar Barre de menu contenant un seul menu 
     */
    public JMenuBar creerBarreDeMenus(){
        
        
        // Creer la barre de menu
        JMenuBar bar = new JMenuBar();

        // Creer le menu
        m = new JMenu("Mode de jeu");

        //Creer et ajouter les items du menu

        itemsMenu = new JMenuItem[2];

        itemsMenu[0] = new JMenuItem("Souris");
        itemsMenu[1] = new JMenuItem("Clavier");

        for(JMenuItem item: itemsMenu){
            m.add(item);
        }
        bar.add(m);

        return bar; 
     }

    public BarreMenus(){
        barreMenu = creerBarreDeMenus();
    }
    
    /**
     * Getter pour la barreMenu
     * @return barreMenu 
     */
    public JMenuBar getBarreMenu(){
        return barreMenu;
    }

    /**
     * getter pour l'item du menu 
     * Utilisé pour le ActionListener du choix de menu
     * @param indice indice du MenuItem desiré
     * @return MenuItem desiré
     */
    public JMenuItem getMenuItem(int indice){
        return itemsMenu[indice];
    }
}