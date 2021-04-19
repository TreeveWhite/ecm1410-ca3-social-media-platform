import java.io.IOException;

import socialmedia.AccountIDNotRecognisedException;
import socialmedia.HandleNotRecognisedException;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
import socialmedia.NotActionablePostException;
import socialmedia.PostIDNotRecognisedException;
import socialmedia.SocialMedia;


/**
 * SocialMediaTest
 * 
 * This file is used to test our social media package and file.
 */
public class TreeveTest {

    public static void main(String[] args) throws 
                                            IllegalHandleException, 
                                            InvalidHandleException, 
                                            HandleNotRecognisedException, 
                                            InvalidPostException, 
                                            PostIDNotRecognisedException,
                                            NotActionablePostException,
                                            IOException,
                                            ClassNotFoundException,
                                            AccountIDNotRecognisedException {

        SocialMedia mySocialMedia = new SocialMedia();
        
        // Testing Account Methods

        int account0 = mySocialMedia.createAccount("test0");

        mySocialMedia.updateAccountDescription("test8", "Added desc");

        // int account1 = mySocialMedia.createAccount("test1", "this is an account is test 1.");

        // int post0 = mySocialMedia.createPost("test0", "this is a post made by test1");
        
        // int endorsement0 = mySocialMedia.endorsePost("test0", post0);

        // int comment0 = mySocialMedia.commentPost("test0", post0, "this is a comment on post0 by test0");
        // int comment1 = mySocialMedia.commentPost("test0", comment0, "this is a comment on comment0 by test0");
        // int comment2 = mySocialMedia.commentPost("test0", post0, "this is a comment on post0 by test0");
        // int comment3 = mySocialMedia.commentPost("test0", comment2, "this is a comment on comment2 by test0");

        System.out.println(mySocialMedia.showAccount("test0"));
        
        

    }

}