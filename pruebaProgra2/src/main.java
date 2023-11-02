/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
import javax.swing.SwingUtilities;


public class main {
 public static void main(String[] args) {
     
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new BlockBusterApp();
                
            }
        });
    }   
}
