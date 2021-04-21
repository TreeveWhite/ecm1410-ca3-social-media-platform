package socialmedia;

/**
 * <h2>Comment</h2>
 * This class consists of the specific methods and attributes of a Comment, some of the other methods and
 * attributes of a Comment are inheritted from a Post. Therefore this class is responsible for the Comment
 * specific methods and attributes.
 * <p>
 * As a Comment inherits from a Post and thefore has access to all of a Post's attributes 
 * and methods. In addition to these, a Comment has a linkedPost attribute which refers
 * to the Post which the comment has been placed on.
 * <p>
 * The class itself has a static value for its SerialVersionUID used when 
 * serializing the platform.
 * 
 * @author 700008432
 * @author 690033172
 * @version 1.0
 */
public class Comment extends Post{

    /**
     * The SerialVersionUID which represents the class version.
     */
    private static final long serialVersionUID = -7709952939872791336L;
    
    /**
     * This is the post the comment is associated with.
     */
    private Post linkedPost;

    /**
     * This is the constructor method for a Comment, it takes in the parameters author which refers
     * to the account associated with the post, message which must be up to 100 characters long and
     * a Post which the comment is associated with.
     * 
     * @param author        The account associated with the comment.
     * @param message       The message contained in the comment.
     * @param linkedPost    The Post which the comment has ben added on.
     * 
     * @throws InvalidPostException             Thrown when the message is longer than 100 characters.
     * @throws HandleNotRecognisedException     Thrown when the given account ahdnle does not exist in
     *                                          the system.
     */
    public Comment(Account author, String message, Post linkedPost) 
                    throws InvalidPostException,
                    HandleNotRecognisedException {
        super(author, message);
        this.linkedPost = linkedPost;
    }

    /**
     * This method is used to change the post which the comment is associated with.
     * 
     * @param newLinkedPost     The new post the comment is associated with.
     */
    public void changeLinkedPost(Post newLinkedPost) {
        this.linkedPost = newLinkedPost;
    }

    /**
     * This method returns the Post the comment is associated with.
     * 
     * @return The post the comment is associated with.
     */
    public Post getLinkedPost() {
        return linkedPost;
    }
}