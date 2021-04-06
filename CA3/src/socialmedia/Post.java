package socialmedia;

/**
 * This class consists of the methods and attributes of a Post.
 * 
 * A Post had a unique sequencial ID, a message up to 100 characters long, an 
 * author (Account) it is associated with, a list of all comments it recieves 
 * and a list of all endorsements it recieves.
 */
public class Post {

    /**
     * This is the unique sequencial identifier of the post.
     */
    private int id;

    /**
     * This is the message with up to 100 characters.
     */
    private String message;

    /**
     * This is the Account associated with the post.
     */
    private Account author;

    /**
     * This is an array of all the comments the post receieves.
     */
    private Comment[] allComments;

    /**
     * This is an array of all the endorsements the post receieves.
     */
    private Endorsement[] allEndorsements;

    /**
     * This is a staic integer value which records the number of accounts in the system starting 
     * at 0, it is used to get the next sequencial ID for when a post is created.
     */
    private static int numPosts = 0;

    /**
     * This is the constructor method for a Post, it takes in the parameters author which refers
     * to the account associated with the post and message which must be up to 100 characters long.
     *  
     * @param author    The account associated with the post.
     * @param message   The message contained in the post.
     * 
     * @throws InvalidPostException     Thrown if the message is longer than 100 characters.
     */
    public Post(Account author, String message) throws InvalidPostException{

        if (message.length() > 100) {
            throw new InvalidPostException("Post has a length of more than 100 characters.");
        }
        this.author = author;
        this.message = message;
        this.id = numPosts++;
    }

    /**
     * This methods adds a new comment to the post's list of comments it has recieved.
     * 
     * @param newComment    The new comment to add to its list.
     */
    public void addComment(Comment newComment) {
        Comment[] newList = new Comment[allComments.length + 1];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = allComments[i];
        }
        newList[allComments.length] = newComment;
        allComments = newList;
    }

    /**
     * This method adds a new endorsement to the post's list of endorsements it has recieved.
     * 
     * @param newEndorsement    The new endorsement to add to its list.
     */
    public void addEndorsement(Endorsement newEndorsement) {
        Endorsement[] newList = new Endorsement[allEndorsements.length + 1];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = allEndorsements[i];
        }
        newList[allEndorsements.length] = newEndorsement;
        allEndorsements = newList;
    }

    /**
     * This method returns the id of the Post.
     * 
     * @return The id of the Post.
     */
    public int getID() {
        return id;
    }

    /**
     * This method returns the message contained in the Post.
     * 
     * @return The message contained in the Post.
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method returns the author of the Post.
     * 
     * @return The author associated with the Post.
     */
    public Account getAuthor() {
        return author;
    }
}