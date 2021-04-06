package socialmedia;

/**
 * <h2>Comment</h2>
 * This class consists of the methods and attributes of a Comment.
 * <p>
 * A Comment inherits from a Post and thefore has access to all of a Post's attributes 
 * and methods. In addition to these, a Comment has a linkedPost attribute which refers
 * to the Post which the comment has been placed on.
 */
public class Comment extends Post{

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
     * @throws InvalidPostException     Thrown when the message is longer than 100 characters.
     */
    public Comment(Account author, String message, Post linkedPost) 
                    throws InvalidPostException {
        super(author, message);
        this.linkedPost = linkedPost;
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