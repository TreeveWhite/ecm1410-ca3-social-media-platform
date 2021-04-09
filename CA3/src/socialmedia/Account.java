package socialmedia;

import java.util.HashSet;
import java.util.Set;

/**
 * Account
 * 
 * Hey mate,
 * we need to keep a record of all authors so maybe do like a hashset as a static variable we can just add
 * all the handles (usernames) to? We can also then just have a arry of all users in the Social Media class.
 * 
 * eg 
 * private static final Set<String> usernames = new HashSet<String>();
 */
public class Account {

    private String handle;
    private String description;
    private static final Set<String> usernames = new HashSet<String>();

    /**
     * 
     * @param handle
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

    }

    /**
     * 
     * @param Handle
     * @param description
     */
    public Account(String handle, String description) 
                            throws IllegalHandleException,
                            InvalidHandleException {
        if (!usernames.add(handle)) {
            if (usernames.contains(handle)) {
                throw new IllegalHandleException("Handle is already in use in the system. ");
            }
            
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
    }


    public String getHandle() {
        return handle;
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String description) {
        this.description = description;
    }
    
}