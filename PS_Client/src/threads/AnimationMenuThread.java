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

    /**
     * Panel which user wants to close.
     */
    private final JPanel panel1;

    /**
     * Panel which user wants to open.
     */
    private final JPanel panel2;

    /**
     * Parameterized constructor for this class.
     *
     * @param panel1 is an object of JPanel class.
     * @param panel2 is an object of JPanel class.
     */
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
