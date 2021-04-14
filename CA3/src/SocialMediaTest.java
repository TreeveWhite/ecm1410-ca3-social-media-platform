import java.io.IOException;

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
 * This file is used to test our social media package and file
 */
public class SocialMediaTest {

    public static void main(String[] args) throws 
                                            IllegalHandleException, 
                                            InvalidHandleException, 
                                            HandleNotRecognisedException, 
                                            InvalidPostException, 
                                            PostIDNotRecognisedException,
                                            NotActionablePostException, IOException, ClassNotFoundException {

        SocialMedia mySocialMedia = new SocialMedia();
        
        // int account1 = mySocialMedia.createAccount("test", "this is an account all about coding");

        // int post1 = mySocialMedia.createPost("test", "First message");

        // int post2 = mySocialMedia.commentPost("test", post1, "First Comment");

        // int post3 = mySocialMedia.commentPost("test", post2, "Sub Comment Comment");

        // int post4 = mySocialMedia.commentPost("test", post3, "Second Sub Comment");

        // int post5 = mySocialMedia.commentPost("test", post1, "Second Comment");

        // String post1Desc = mySocialMedia.showIndividualPost(post2);

        // System.out.println(mySocialMedia.showAccount("test"));

        // System.out.println(mySocialMedia.getTotalOriginalPosts());

        // System.out.println(post1Desc);

        // StringBuilder test = mySocialMedia.showPostChildrenDetails(post1);
        
        // System.out.println(test.toString());

        mySocialMedia.loadPlatform("test.ser");

        System.out.println(mySocialMedia.showPostChildrenDetails(0).toString());

    }

}