package view.interf;

/**
 *
 * @author nikol
 */
public interface iFormValue {

    /**
     * Method for getting an object from data from form.
     *
     * @return an object from form.
     */
    public Object getValue();

    /**
     * Method for placing an object data on a form.
     *
     * @param object is the object to be placed on the form.
     */
    public void setValue(Object object);
}
