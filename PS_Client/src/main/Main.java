package main;

import controller.Controller;
import javax.swing.JFrame;
import view.FrmClient;
import view.FrmLanguage;
import view.SplashScreen;
import view.dialog.MessageDialog;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SplashScreen splashScreen = new SplashScreen();

        for (int i = 0; i <= 100; i++) {
            Thread.sleep(20);
            splashScreen.setVisible(true);
            splashScreen.getLblLoading().setText("Loading..." + i + "%");
            splashScreen.getPbLoading().setValue(i);
        }

        new FrmLanguage().setVisible(true);
        splashScreen.dispose();

        //new MessageDialog(new JFrame(), true).setVisible(true);
        //new FrmClient().setVisible(true);
    }
}
