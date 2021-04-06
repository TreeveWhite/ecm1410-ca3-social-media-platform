package socialmedia;

/**
 * <h2>Endorsement</h2>
 * This class consists of the methods and attributes of a Endorsement.
 * <p>
 * An Endorsement inherits from a Post and thefore has access to all of a Post's attributes 
 * and methods. In addition to these, an Endorsement has a linkedPost attribute which refers
 * to the Post which the endorsement has been placed on and replicates the message of the post
 * it is associated with.
 */
public class Endorsement extends Post {

    /**
     * This is the post the comment is associated with.
     */
    private Post linkedPost;

    /**
     * This is the constructor method for an Endorsement, it takes in the parameters author which refers
     * to the account associated with the post and a Post which the endorsement is associated with.
     * 
     * @param author        The account associated with the endorsement.
     * @param linkedPost    The Post which the endorsement has ben added on.
     * 
     * @throws InvalidPostException     Thrown when the message is longer than 100 characters.
     */
    public Endorsement(Account author, Post linkedPost)
                        throws InvalidPostException,
                        HandleNotRecognisedException {
        super(author, "EP@"+linkedPost.getAuthor().getHandle()+": "+linkedPost.getMessage());
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