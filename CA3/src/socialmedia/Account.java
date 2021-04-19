package socialmedia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains all the methods and attributes of the Account and therefore
 * is responsible for handling all the details related to a user on the Social Media
 * Platform. 
 * <p>
 * An Account has a unique ID (sequencially incremennting acording to num 
 * of users on the system), a string handle (username) and a description similar to 
 * a bio. 
 * <p>
 * The class itself has a static value for its SerialVersionUID used when 
 * serializing the platform, a num of accounts which tracks the number of accounts
 * created and a HashSet of all usernames (handles).
 * 
 * @author 700008432
 * @author 690033172
 * @version 1.0
 */
public class Account implements Serializable {

    /**
     * The SerialVersionUID which represents the class version.
     */
    private static final long serialVersionUID = 8225229775036968396L;

    /**
     * This is the unique sequential identifier of the account.
     */
    private int id;

    /**
     * This is the handle attributed to the account.
     */
    private String handle;

    /**
     * This is the description that the user can add to their account.
     */
    private String description;

    /**
     * This is the static set of usernames in the system, it contains
     * all the handles of each user within the system.
     */
    private static final Set<String> usernames = new HashSet<String>();

    /**
     * This is a static integer value which records the number of accounts
     * in the system starting at 0.
     */
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

    /**
     * This method resets the number of posts to 0.
     */
    public static void resetNumAccounts() {
        numAccounts = 0;
    }

    /**
     * This method is for allowing the user the change their handle after creating their
     * account. It does all the checks to be sure there are no other users with the new handle.
     * 
     * @param newHandle     This is the handle that the user wants to change to.
     * 
     * @throws InvalidHandleException   This exception is thrown if the handle is under 30 characters,
     *                                  is blank, or contains white space.
     */
    public void changeHandle(String newHandle) 
                            throws InvalidHandleException {
        if (newHandle.length() > 30) {
			throw new InvalidHandleException("Your handle is longer than 30 characters.");
		}
		if (newHandle.contains(" ")) {
			throw new InvalidHandleException("The handle cannot contain white space.");
		}
		if (newHandle.equals("")) {
			throw new InvalidHandleException("The handle cannot be empty.");
		}
        
        this.handle = newHandle;
    }
    
    /**
     * This method allows the user to update their account description.
     * 
     * @param description The new description that they want to add.
     */
    public void updateDescription(String description) {
        this.description = description;
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
     * This method returns the id of the user.
     * 
     * @return The Id of the account is what gets returned.
     */
    public int getId() {
        return id;
    }

    /**
     * This method allows Accounts to be printed out as text that includes
     * all useful information.
     * 
     * @return The string of text is returned. 
     */
    public String toString() {
        if (description == null) {
            description = "Description has not been set.";
        }
        return "ID: " + id + "\nHandle: " + handle + "\nDescription: " + description;
    }
}