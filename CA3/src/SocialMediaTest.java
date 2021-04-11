import socialmedia.HandleNotRecognisedException;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
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
                                            PostIDNotRecognisedException {

        SocialMedia mySocialMedia = new SocialMedia();
        
        int account1 = mySocialMedia.createAccount("test");

        int post1 = mySocialMedia.createPost("test", "First message");

        String post1Desc = mySocialMedia.showIndividualPost(post1);

        System.out.println(post1Desc);

    }

}