package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.FrmClient;

/**
 *
 * @author nikol
 */
public class AnimationMenuOpenThread extends Thread {

    /**
     * Panel which user wants to open.
     */
    private final JPanel panel;

    /**
     * Parameterized constructor for this class.
     *
     * @param panel is an object of JPanel class.
     */
    public AnimationMenuOpenThread(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 200; i++) {
                Thread.sleep(1);
                panel.setSize(i, panel.getHeight());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
