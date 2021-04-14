package socialmedia;

/**
 * <h2>Endorsement</h2>
 * This class consists of the methods and attributes of a Endorsement.
 * <p>
 * An Endorsement inherits from a Post and thefore has access to all of a Post's attributes 
 * and methods. In addition to these, an Endorsement has a linkedPost attribute which refers
 * to the Post which the endorsement has been placed on and replicates the message of the post
 * it is associated with.
 * 
 * @author 700008432
 * @author 690033172
 * @version 1.0
 */
public class Endorsement extends Post {

    /**
     * The SerialVersionUID which represents the class version.
     */
    private static final long serialVersionUID = 8178673147762741699L;
    
    /**
     * This is the post the comment is associated with.
     */
    private Post linkedPost;

    /**
     * This is the constructor method for an Endorsement, it takes in the parameters author which refers
     * to the account associated with the post and a Post which the endorsement is associated with.
     * The message of the post it is associated wth is formatted as:
     * 
     * <p>
	 * <code>"EP@" + [endorsed account handle] + ": " + [endorsed message]</code>
	 * <p>
     * 
     * @param author        The account associated with the endorsement.
     * @param linkedPost    The Post which the endorsement has ben added on.
     * 
     * @throws InvalidPostException             Thrown when the message is longer than 100 characters.
     * @throws HandleNotRecognisedException     Thrown if an Account with given handle does not exist.
     * @throws PostIDNotRecognisedException     Thrown if post endorsement linked to does not exist.
     */
    public Endorsement(Account author, Post linkedPost)
                        throws HandleNotRecognisedException {
        super(author, linkedPost);
        this.linkedPost = linkedPost;
    }

    /**
     * This method returns the Post the endorsement is associated with.
     * 
     * @return The post the endorsement is associated with.
     */
    public Post getLinkedPost() {
        return linkedPost;
    }
}