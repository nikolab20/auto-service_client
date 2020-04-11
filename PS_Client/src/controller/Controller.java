package controller;

import domain.Klijent;
import domain.Radnik;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {

    /**
     * The instance of the controller class. The instance created on this site
     * ensures its uniqueness for the whole project.
     *
     * @return the instance of the controller class.
     */
    @Getter
    private static Controller instance = new Controller();

    /**
     * A logical value that represents whether the server is set to the default
     * configuration or not.
     *
     * @param defaultConfig is the boolean value for the attribute defaultConfig
     * of this class.
     * @return the boolean value.
     */
    @Getter
    @Setter
    private boolean defaultConfig;

    @Getter
    @Setter
    private Locale locale;

    @Getter
    @Setter
    private Radnik radnik;

    /**
     * The constructor of this class without any parameters.
     */
    private Controller() {

    }

    /**
     * Method for reading a data from properties file.
     *
     * @return An object of the {@link Properties} class that contains data from
     * a file.
     * @throws IOException if file doesn't exist.
     */
    public Properties readPropertiesFile() throws IOException {
        FileInputStream in = new FileInputStream("props/conn.properties");
        Properties props = new Properties();
        props.load(in);

        return props;
    }

    /**
     * Method for putting data into properties file.
     *
     * @param host is String that represents host of the server.
     * @param port is String that represents port of the server.
     * @throws IOException if file doesn't exist.
     */
    public void writeIntoPropertiesFile(String host, String port) throws IOException {
        FileInputStream in = new FileInputStream("props/conn.properties");
        Properties props = new Properties();
        props.load(in);

        props.setProperty("host", host);
        props.setProperty("port", port);
    }

    /**
     * Method for initial adjusting the form.
     *
     * @param form is the form tuned by this method.
     * @param mainPanel is the content panel of this form.
     */
    public void defaultPrepareForm(JFrame form) {
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.pack();
        form.setLocationRelativeTo(null);
        URL imageUrl = ClassLoader.getSystemResource("img/transportation.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        form.setIconImage(icon.getImage());
    }

    /**
     * Method for putting icon on label.
     *
     * @param file is the image file for the icon.
     * @param label is the label on which the method places the icon.
     */
    public void setIconToLabel(String file, JLabel label) {
        URL imageUrl = ClassLoader.getSystemResource(file);
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        label.setIcon(imageIcon);
    }

    /**
     * Method for putting icon on button.
     *
     * @param file is the image file for the icon.
     * @param button is the button on which the method places the icon.
     */
    public void setIconToButton(String file, JButton button) {
        URL imageUrl = ClassLoader.getSystemResource(file);
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        button.setIcon(imageIcon);
    }

    public void setToolTipTextToButton(JButton button, String name, ResourceBundle resourceBundle) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setToolTipText(resourceBundle.getString("client_" + name + "_toolTip"));
    }

    public String generateRandomString() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 12;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
