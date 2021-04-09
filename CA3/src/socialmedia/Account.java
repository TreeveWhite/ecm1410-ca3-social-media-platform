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
    public Account(String handle) {
        if (!usernames.add(handle)) {
            // throw error
        }
        this.handle = handle;

    }

    /**
     * 
     * @param Handle
     * @param description
     */
    public Account(String handle, String description) {
        if (!usernames.add(handle)) {
            // throw error
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

    public void updateDescription(String handle, String description) {
        if (!usernames.contains(handle)) {
            // throw error
        }
        this.description = description;
    }
    
}