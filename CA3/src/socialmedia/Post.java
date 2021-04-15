package socialmedia;

import java.io.Serializable;

/**
 * <h2>Post</h1>
 * 
 * This class consists of the methods and attributes of a Post.
 * <p>
 * A Post had a unique sequencial ID, a message up to 100 characters long, an 
 * author (Account) it is associated with, a list of all comments it recieves 
 * and a list of all endorsements it recieves.
 * 
 * @author 700008432
 * @author 690033172
 * @version 1.0
 */
public class Post implements Serializable {

    /**
     * The SerialVersionUID which represents the class version.
     */
    private static final long serialVersionUID = -6471649759148628316L;

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
    private Comment[] allComments = {};

    /**
     * This is an array of all the endorsements the post receieves.
     */
    private Endorsement[] allEndorsements = {};


    private boolean isActionable;

    /**
     * This is a staic integer value which records the number of posts in the system starting 
     * at 0, it is used to get the next sequencial ID for when a post is created.
     */
    private static int numPosts = 0;

    /**
     * This is the constructor method for a Post, it takes in the parameters author which refers
     * to the account associated with the post and message which must be up to 100 characters long
     * for a new post or comment.
     *  
     * @param author    The account associated with the post.
     * @param message   The message contained in the post.
     * 
     * @throws InvalidPostException             Thrown if the message is longer than 100 characters.
     * @throws HandleNotRecognisedException     Thrown if an Account with given handle does not exist.
     */
    public Post(Account author, String message)
                throws InvalidPostException,
                HandleNotRecognisedException {
        if (message.length() > 100) {
            throw new InvalidPostException("Post has a length of more than 100 characters.");
        }
        if (author == null) {
            throw new HandleNotRecognisedException("Account with given handle does not exist.");
        }
        this.author = author;
        this.message = message;
        this.id = numPosts++;
        this.isActionable = true;
    }

    /**
     * This is the constructor method for a Post, it takes in the parameters author which refers
     * to the account associated with the post and linkedPost which is the post the new post is associated
     * with when creating an endorsement post.
     * 
     * @param author        The account associated with the post.
     * @param linkedPost    The post associated with this endorsement post.
     * 
     * @throws HandleNotRecognisedException     Thrown if an Account with given handle does not exist.
     */
    public Post(Account author, Post linkedPost) 
                throws HandleNotRecognisedException {
        if (author == null) {
            throw new HandleNotRecognisedException("Account with given handle does not exist.");
        }
        this.author = author;
        this.message = "EP@"+linkedPost.getAuthor().getHandle()+": "+linkedPost.getMessage();
        this.id = numPosts++;
        this.isActionable = false;
    }

    /**
     * This methods adds a new comment to the post's list of comments it has recieved.
     * 
     * @param newComment    The new comment to add to its list.
     */
    public void addComment(Comment newComment) {
        Comment[] newList = new Comment[allComments.length + 1];
        for (int i = 0; i < allComments.length; i++) {
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
        for (int i = 0; i < allEndorsements.length; i++) {
            newList[i] = allEndorsements[i];
        }
        newList[allEndorsements.length] = newEndorsement;
        allEndorsements = newList;
    }

    public void empty() {
        this.message = "The original content was removed from the system and is no longer available.";
        this.author = null;
        this.isActionable = false;
    }

    /**
     * This method resets the number of posts to 0.
     */
    public static void resetNumPosts() {
        numPosts = 0;
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

    /**
     * This method returns all the endorsement posts of the Post.
     * 
     * @return The array of all endorsements.
     */
    public Endorsement[] getAllEndorsements() {
        return allEndorsements;
    }

    /**
     * This method returns all the comments associated with the Post
     * 
     * @return The array of all comments.
     */
    public Comment[] getAllComments() {
        return allComments;
    }

    /**
     * This method returns if the post can be acted upon.
     * 
     * @return isActionable If the post can be acted upon.
     */
    public boolean getIsActionable() {
        return isActionable;
    }

    /**
     * This method returns the post in string format as defined in the MiniSocialMediaPlatform
     * interface.
     * 
     * @return The post in string format.
     */
    @Override
    public String toString() {
        String name = "";
        if (!(author == null)){
            name += author.getHandle();
        }
        return "ID: "+id+"\nAccount: "+name+"\nNo. endorsements: "+allEndorsements.length+" | No. comments: "+allComments.length+"\n"+message;
    }
}