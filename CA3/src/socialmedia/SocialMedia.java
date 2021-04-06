package socialmedia;

import java.io.IOException;

/**
 * SocialMedia
 * 
 * This is an implimentation of the SocialMediaPlatform Interface.
 */
public class SocialMedia implements SocialMediaPlatform {

	private Account[] allAccounts;

	private Post[] allPosts;

    /**
     * 
     */
    @Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * 
     */
	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		Account author = null;
		for (Account account : allAccounts) {
			if (handle.equals(account.getHandle())) {
				author = account;
				break;
			}
		}
		Post newPost = new Post(author, "message");
		return newPost.getID();
	}

    /**
     * 
     */
	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * 
     */
	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * 
     */
	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    /**
     * 
     */
	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}
}