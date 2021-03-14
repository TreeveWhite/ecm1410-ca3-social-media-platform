# ECM1410 CA3 - Social Media
This is the final coursework for the ECM1410 at the University of Exeter in 2021. The program is a simple social media network for a university (see spec for further details).

# Issues
Any issues with the code or areas we need to look at.

# Notes of Spec

The two interfaces which need to be implimented are SocialMediaPlatform and MiniSocialMediaPlatform, ie the SocialMediaPlatform extends the fucntonality described by MiniSocialMediaPlatform. 

The program is run and tested from the SocialMediaplatformTestApp.java outside the socialmedia package under src.

### File Structure

* AccountIDNotRecognisedException.java - A custom exception for when attempting to use an account id that does not exist in the system.
* BadSocialMedia.java - The implimentation of the functions in the two interfaces discussed above.
* HandleNotRecognisedException.java - A custom exception for whe trying to use an account string handle (username) which doesnt exist in the system.
* IllegalHandleException.java - A custom exception for when an string handle already exists.
* InvalidhandleException.java - A custom excpetion for when trying to asign an empty handle or the handle is in incorect format for system. (See file for details).
* InvalidPostException.java - A custom exception for when trying to create an empty post or a post with > 100 characters.
* MiniSocialMediaPlatform.java - An interface for the fundermentals of the platform.
* NotActionablePostException.java - A custom exception for when atempting to act upon a non-actionable post.
* PostIDNotrecognisedException.java - A custom excpetion for when trying to use a post ID which does not exist in the system.
* SocialMediaPlatform.java - An interface which extends the MiniSocialMedia interface by adding definitions of more functionality.


