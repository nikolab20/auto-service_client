/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.FrmClient;

/**
 *
 * @author nikol
 */
public class AnimationMenuCloseThread extends Thread {

    private JPanel panel1;

    public AnimationMenuCloseThread(JPanel panel1) {
        this.panel1 = panel1;
    }

    @Override
    public void run() {
        try {
            for (int i = 200; i >= 0; i--) {
                Thread.sleep(1);
                panel1.setSize(i, panel1.getHeight());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
