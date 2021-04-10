package socialmedia;

import java.util.HashSet;
import java.util.Set;

/**
 * <h2>Account</h2>
 */
public class Account {

    private int id;

    private String handle;

    private String description;

    private static final Set<String> usernames = new HashSet<String>();

    private static int numAccounts = 0;

    /**
     * This is the constructor method for an Account, it takes in the parameter handle which
     * will be the username of the account. This constructor is for when the user does not
     * want to add a description on the creation of their account.
     *  
     * @param Handle    The username the user wants to use.
     * 
     * @throws IllegalHandleException   Thrown if the handle is already in use.
     * @throws InvalidHandleException   Thrown if the handle is over 30 characters, 
     *                                  is empty, or contains white space.
     */
    public Account(String handle) 
                        throws IllegalHandleException,
                        InvalidHandleException{
        if (!usernames.add(handle)) {
            throw new IllegalHandleException("Handle is already in use in the system.");
        }
        if (handle.length() > 30) {
            throw new InvalidHandleException("Your handle is longer than 30 characters.");
        }
        if (handle.contains(" ")) {
            throw new InvalidHandleException("The handle cannot contain white space.");
        }
        if (handle.equals("")) {
            throw new InvalidHandleException("The handle cannot be empty.");
        }
        this.handle = handle;
        this.id = numAccounts++;
    }

    /**
     * This is the constructor method for an Account, it takes in the parameters handle which
     * will be the username of the account, and the description which will be connected to the
     * account.
     *  
     * @param Handle        The username the user wants to use.
     * @param description   The description the user wants to display.
     * 
     * @throws IllegalHandleException   Thrown if the handle is already in use.
     * @throws InvalidHandleException   Thrown if the handle is over 30 characters, 
     *                                  is empty, or contains white space.
     */
    public Account(String handle, String description) 
                            throws IllegalHandleException,
                            InvalidHandleException {
        if (!usernames.add(handle)) {
            throw new IllegalHandleException("Handle is already in use in the system. "); 
        }
        if (handle.length() > 30) {
            throw new InvalidHandleException("Your handle is longer than 30 characters.");
        }
        if (handle.contains(" ")) {
            throw new InvalidHandleException("The handle cannot contain white space.");
        }
        if (handle.equals("")) {
            throw new InvalidHandleException("The handle cannot be empty.");
        }
        this.handle = handle;
        this.description = description;
        this.id = numAccounts++;
    }
    public void changeHandle(String newHandle) {
        this.handle = newHandle;
    }

    /**
     * This method returns the handle of the user.
     * 
     * @return The handle of the user.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * This method returns the description connected to the account.
     * 
     * @return The description of the account.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method allows the user to update their account description.
     * 
     * @param description The new description that they want to add.
     */
    public void updateDescription(String description) {
        this.description = description;
    }
    
    public int getId() {
        return id;
    }
}