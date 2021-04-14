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
 * This file is used to test our social media package and file.
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
        
        //int account0 = mySocialMedia.createAccount("jstall", "this is an account all about coding");
        
        //int account1 = mySocialMedia.createAccount("twhite");

        // int account2 = mySocialMedia.createAccount("boyIReallyHopeThisHandleIsn'tTooLong");//testing invalid handle execption
        
        //System.out.println(account0);

        //System.out.println(account1);

        //System.out.println(account2);

        //System.out.println(mySocialMedia.showAccount("jstall"));

        //System.out.println(mySocialMedia.showAccount("twhite"));

        //mySocialMedia.updateAccountDescription("twhite", "i always longed to haved a description...");

        //System.out.println(mySocialMedia.showAccount("twhite"));

        //System.out.println(mySocialMedia.showAccount("notACorrectHandle")); //testing that errors get thrown

        //int post1 = mySocialMedia.createPost("jstall", "First message");

        //System.out.println(mySocialMedia.showIndividualPost(post1));

        //int post2 = mySocialMedia.commentPost("twhite", post1, "First Comment");

        //System.out.println(mySocialMedia.showIndividualPost(post2));

        //int post3 = mySocialMedia.commentPost("jstall", post2, "Sub Comment Comment");

        //int post4 = mySocialMedia.commentPost("twhite", post3, "Second Sub Comment");


        //int post5 = mySocialMedia.commentPost("twhite", post1, "Second Comment");


        //int endorse1 = mySocialMedia.endorsePost("twhite", post1);
        
        

        // String post1Desc = mySocialMedia.showIndividualPost(post2);

        //System.out.println();

        //System.out.println(mySocialMedia.showIndividualPost(post1));

        // System.out.println(mySocialMedia.getTotalOriginalPosts());

        // System.out.println(post1Desc);

        // StringBuilder test = mySocialMedia.showPostChildrenDetails(post1);

        //mySocialMedia.savePlatform("test.ser");

        //mySocialMedia.loadPlatform("test.ser");

        //System.out.println(mySocialMedia.showAccount("jstall"));

        //System.out.println(mySocialMedia.showAccount("twhite"));

        //System.out.println(mySocialMedia.showPostChildrenDetails(0).toString());

    }

}