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

    /**
     * Panel which user wants to close.
     */
    private final JPanel panel1;

    /**
     * Parameterized constructor for this class.
     *
     * @param panel1 is an object of JPanel class.
     */
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
