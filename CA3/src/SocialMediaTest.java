import socialmedia.SocialMedia;


/**
 * SocialMediaTest
 * 
 * This file is used to test our social media package and file
 */
public class SocialMediaTest {

    public static void main(String[] args) {

        SocialMedia mySocialMedia = new SocialMedia();

        testCreateAccount1(mySocialMedia, "test");

        
    }

    public static boolean testCreateAccount1(SocialMedia socialMedia, String hadle) {
        try {
            socialMedia.createAccount("test");
        } catch (Exception e) {
            System.out.println("Create Account 1 Failed");
            return false;
        }
        System.out.println("Create Account 1 Passes");
        return true;
    }
    

}