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
public class AnimationMenuThread extends Thread {

    private JPanel panel1;
    private JPanel panel2;

    public AnimationMenuThread(JPanel panel1, JPanel panel2) {
        this.panel1 = panel1;
        this.panel2 = panel2;
    }

    @Override
    public void run() {
        try {
            if (panel1.getWidth() == 0) {

                if (panel2.getWidth() != 0) {
                    for (int i = 200; i >= 0; i--) {
                        Thread.sleep(1);
                        panel2.setSize(i, panel2.getHeight());
                    }
                }

                for (int i = 0; i <= 200; i++) {
                    Thread.sleep(1);
                    panel1.setSize(i, panel1.getHeight());
                }
            } else {
                for (int i = 200; i >= 0; i--) {
                    Thread.sleep(1);
                    panel1.setSize(i, panel1.getHeight());
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
