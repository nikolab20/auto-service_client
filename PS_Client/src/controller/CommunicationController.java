package controller;

import domain.DomainObject;
import domain.Klijent;
import domain.Radnik;
import lombok.Getter;
import lombok.Setter;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author nikol
 */

/**
 * Provides methods for controlling client application and communication between client and server application.
 */
public class CommunicationController {

    /**
     * The instance of the class.
     */
    private static CommunicationController instance;

    /**
     * A socket that it uses to communicate between the server and the client application.
     */
    private Socket socket;

    /**
     * The worker which logged.
     *
     * @return an object of class {@link Radnik} that represents a logged in worker.
     */
    //@Getter
    //private Radnik radnik;

    /**
     * Constructor for this class without parameters.
     */
    public CommunicationController() throws IOException {
        String host = Controller.getInstance().readPropertiesFile().getProperty("default_host");
        int port = Integer.parseInt(Controller.getInstance().readPropertiesFile().getProperty("default_port"));

        if (Controller.getInstance().isDefaultConfig()) {
            host = Controller.getInstance().readPropertiesFile().getProperty("host");
            port = Integer.parseInt(Controller.getInstance().readPropertiesFile().getProperty("port"));
        }

        socket = new Socket(host, port);
    }

    public static CommunicationController getInstance() throws IOException {
        if (instance == null) {
            instance = new CommunicationController();
        }

        return instance;
    }

    /**
     * Меthod for sending request to server application.
     *
     * @param request is an object that contains the operation and the data required for this operation.
     * @throws IOException if problems with stream arise.
     */
    private void sendRequest(RequestObject request) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(request);
        out.flush();
    }

    /**
     * Method for receiving a response from server.
     *
     * @return an object that contains data as a result of the operation and an exception if it occurred.
     * @throws IOException            if problems with stream arise.
     * @throws ClassNotFoundException if object from stream con't cast to response object.
     */
    private ResponseObject receiveResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ResponseObject response = (ResponseObject) in.readObject();
        return response;
    }

    public void operationChooseLanguage(Locale locale) throws IOException, ClassNotFoundException, Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_CHOOSE_LANGUAGE);

        request.setData(locale);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void operationLoginWorker(String username, String password) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_LOGIN_WORKER);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);

        request.setData(data);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        Radnik radnik = (Radnik) response.getData();
        Controller.getInstance().setRadnik(radnik);

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public DomainObject operationGenerate(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_GENERATE_CUSTOMER);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        odo = (DomainObject) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return odo;
    }

    public Klijent operationAddCustomer(Klijent klijent) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_ADD_CUSTOMER);
        request.setData(klijent);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return klijent;
    }

    public List<Klijent> operationSearchCustomer(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CUSTOMER);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Klijent> customers = (List<Klijent>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return customers;
    }

    public void operationUpdateCustomer(Klijent klijent) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_UPDATE_CUSTOMER);
        request.setData(klijent);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

}
