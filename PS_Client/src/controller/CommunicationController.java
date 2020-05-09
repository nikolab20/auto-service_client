package controller;

import domain.Deo;
import domain.DomainObject;
import domain.Klijent;
import domain.PoreskaStopa;
import domain.PredmetProdaje;
import domain.Racun;
import domain.Radnik;
import domain.Usluga;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author nikol
 */
/**
 * Provides methods for controlling client application and communication between
 * client and server application.
 */
public class CommunicationController {

    /**
     * The instance of the class.
     */
    private static CommunicationController instance;

    /**
     * A socket that it uses to communicate between the server and the client
     * application.
     */
    private final Socket socket;

    /**
     * Constructor for this class without parameters.
     *
     * @throws java.io.IOException
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

    /**
     * Method for getting an instance of this class.
     *
     * @return an instance of CommunicationController class.
     * @throws IOException if problems with making new instance of class occurs.
     */
    public static CommunicationController getInstance() throws IOException {
        if (instance == null) {
            instance = new CommunicationController();
        }

        return instance;
    }

    /**
     * Method for sending request to server application.
     *
     * @param request is an object that contains the operation and the data
     * required for this operation.
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
     * @return an object that contains data as a result of the operation and an
     * exception if it occurred.
     * @throws IOException if problems with stream arise.
     * @throws ClassNotFoundException if object from stream can't cast to
     * response object.
     */
    private ResponseObject receiveResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ResponseObject response = (ResponseObject) in.readObject();
        return response;
    }

    /**
     * Method for sending request to server for choosing language for
     * application.
     *
     * @param locale a language region requested from user.
     * @throws Exception if problem with sending request occurs.
     */
    public void operationChooseLanguage(Locale locale) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_CHOOSE_LANGUAGE);

        request.setData(locale);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Method for sending request to server for logging user.
     *
     * @param username is username of user.
     * @param password is password of user.
     * @throws Exception if problem with sending request occurs.
     */
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

    /**
     * Method for sending request to generate new domain object.
     *
     * @param odo is requested object for generate.
     * @return generated domain object.
     * @throws Exception if problem with sending request occurs.
     */
    public DomainObject operationGenerate(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_GENERATE);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        odo = (DomainObject) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return odo;
    }

    /**
     * Method for sending request to insert domain object into a database.
     *
     * @param odo is requested object for insert.
     * @return inserted domain object.
     * @throws Exception if problem with sending request occurs.
     */
    public DomainObject operationInsert(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_INSERT);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        odo = (DomainObject) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return odo;
    }

    /**
     * Method for sending request to update domain object from database.
     *
     * @param odo is requested object for update.
     * @return updated domain object.
     * @throws Exception if problem with sending request occurs.
     */
    public DomainObject operationUpdate(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_UPDATE);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (DomainObject) response.getData();
    }

    /**
     * Method for sending request to delete domain object from database.
     *
     * @param odo is requested object for delete.
     * @return deleted domain object.
     * @throws Exception if problem with sending request occurs.
     */
    public DomainObject operationDelete(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_DELETE);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (DomainObject) response.getData();
    }

    /**
     * Method for sending request for searching customers.
     *
     * @param customerID is criteria for customer search.
     * @return list of customer objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Klijent> operationSearchCustomer(Long customerID) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CUSTOMER);
        request.setData(customerID);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Klijent> customers = (List<Klijent>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return customers;
    }

    /**
     * Method for sending request for searching employees.
     *
     * @param employeeID is criteria for employees search.
     * @return list of employee objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Radnik> operationSearchEmployee(Long employeeID) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_EMPLOYEE);
        request.setData(employeeID);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Radnik> radnici = (List<Radnik>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return radnici;
    }

    /**
     * Method for sending request for getting all of tax rates.
     *
     * @return list of tax rate objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<? extends DomainObject> operationSelectAllTax() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_TAX);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<? extends DomainObject>) response.getData();
    }

    /**
     * Method for sending request for searching car parts.
     *
     * @param criteria is criteria for car parts search.
     * @return list of car part objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Deo> operationSearchCarPart(Long criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CAR_PART);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Deo> parts = (List<Deo>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return parts;
    }

    /**
     * Method for sending request for searching services.
     *
     * @param criteria is criteria for services search.
     * @return list of service objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Usluga> operationSearchService(Long criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_SERVICE);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Usluga> services = (List<Usluga>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return services;
    }

    /**
     * Method for sending request for searching objects of sale.
     *
     * @param criteria is criteria for object of sale search.
     * @return list of object of sale objects.
     * @throws Exception if problem with sending request occurs.
     */
    public PredmetProdaje operationSearchObjectOfSale(Long criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_OBJECT_OF_SALE);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        PredmetProdaje predmetProdaje = (PredmetProdaje) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return predmetProdaje;
    }

    /**
     * Method for sending request for getting all of objects of sale.
     *
     * @param criteria is an String that represents criteria for search,
     * @return list of tax rate objects.
     * @throws Exception if problem with sending request occurs.
     */
    public Map<DomainObject, String> operationSearchAllObjectOfSale(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_ALL_OBJECT_OF_SALES);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        Map<DomainObject, String> predmetiProdaje = (HashMap<DomainObject, String>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return predmetiProdaje;
    }

    /**
     * Method for sending request to insert list of domain object into database.
     *
     * @param listOdo is requested list of objects for insert.
     * @throws Exception if problem with sending request occurs.
     */
    public void operationInsertListOfDomainObject(List<? extends DomainObject> listOdo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_INSERT_LIST);
        request.setData(listOdo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Method for sending request for searching bills.
     *
     * @param criteria is criteria for bill search.
     * @return list of bill objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Racun> operationSearchBill(Long criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_BILL);
        request.setData(criteria);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Racun> bills = (List<Racun>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return bills;
    }

    /**
     * Method for sending request for searching bills from date.
     *
     * @param date is criteria for bill search.
     * @return list of bill objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Racun> operationSearchBillFromDate(Date date) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_BILL_FROM_DATE);
        request.setData(date);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Racun> bills = (List<Racun>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return bills;
    }

    /**
     * Method for sending request for searching new clients from date.
     *
     * @param date is criteria for clients search.
     * @return list of client objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Klijent> operationSearchNewClientsFromDate(Date date) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_NEW_CLIENTS_FROM_DATE);
        request.setData(date);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Klijent> clients = (List<Klijent>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return clients;
    }

    /**
     * Method for sending request for searching clients with debt.
     *
     * @return list of client objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Klijent> operationSearchClientsWithDebt() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CLIENTS_WITH_DEBT);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Klijent> clients = (List<Klijent>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return clients;
    }

    /**
     * Method for sending request for searching tax rates.
     *
     * @param id is criteria for tax rates search.
     * @return list of tax rate objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<PoreskaStopa> operationSearchTax(Long id) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_TAX);
        request.setData(id);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<PoreskaStopa> tax = (List<PoreskaStopa>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return tax;
    }

    /**
     * Method for sending request for client disconnection.
     *
     * @throws Exception if problem with sending request occurs.
     */
    public void operationDisconnect() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_DISCONNECT);

        if (socket.isConnected()) {
            sendRequest(request);
        }
    }

    /**
     * Method for sending request for getting all of employees.
     *
     * @return list of employee objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Radnik> operationSelectAllEmployees() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_EMPLOYEES);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<Radnik>) response.getData();
    }

    /**
     * Method for sending request for getting all of car parts.
     *
     * @return list of car part objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Deo> operationSelectAllCarParts() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_CAR_PARTS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<Deo>) response.getData();
    }

    /**
     * Method for sending request for getting all of services.
     *
     * @return list of service objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Usluga> operationSelectAllServices() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_SERVICES);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<Usluga>) response.getData();
    }

    /**
     * Method for sending request for getting all of bills.
     *
     * @return list of bill objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Racun> operationSelectAllBills() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_BILLS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<Racun>) response.getData();
    }

    /**
     * Method for sending request for getting all of customers.
     *
     * @return list of customer objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Klijent> operationSelectAllCustomers() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_CUSTOMERS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<Klijent>) response.getData();
    }

    /**
     * Method for sending request for getting all of objects of sale.
     *
     * @return list of object of sale objects.
     * @throws Exception if problem with sending request occurs.
     */
    public Map<DomainObject, String> operationSelectAllObjectOfSale() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_OBJECT_OF_SALE);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        Map<DomainObject, String> predmetiProdaje = (HashMap<DomainObject, String>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return predmetiProdaje;
    }

    /**
     * Method for sending request for searching bills.
     *
     * @param customerId is criteria for bill search.
     * @return list of bill objects.
     * @throws Exception if problem with sending request occurs.
     */
    public List<Racun> operationSearchBillByCustomer(Long customerId) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_BILL_BY_CUSTOMER);
        request.setData(customerId);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        List<Racun> bills = (List<Racun>) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return bills;
    }
}
