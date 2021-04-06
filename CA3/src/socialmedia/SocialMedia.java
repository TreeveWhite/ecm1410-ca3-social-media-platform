package socialmedia;

import java.io.IOException;

/**
 * <h2>SocialMedia</h2>
 * 
 * This is an implimentation of the SocialMediaPlatform Interface.
 * <p>
 * 
 */
public class SocialMedia implements SocialMediaPlatform {

	/**
	 * This is an array of all accounts on the platform.
	 */
	private Account[] allAccounts;

	/**
	 * This is an array of all posts on the platform.
	 */
	private Post[] allPosts;

	/**
	 * This method is used to add a instance of an account to the array of all accounts on
	 * the platform.
	 * 
	 * @param newAccount	The new account to be added to the array.
	 */
	public void addAccount(Account newAccount) {
		Account[] newList = new Account[allAccounts.length + 1];
		for (int i = 0; i < allAccounts.length; i++) {
			newList[i] = allAccounts[i];
		}
		newList[allAccounts.length] = newAccount;
		allAccounts = newList;
	}

	/**
	 * This method is used to add a instance of an account to the array of all accounts on
	 * the platform.
	 * 
	 * @param newAccount	The new account to be added to the array.
	 */
	public void addPost(Post newPost) {
		Post[] newList = new Post[allPosts.length + 1];
		for (int i = 0; i < allPosts.length; i++) {
			newList[i] = allPosts[i];
		}
		newList[allPosts.length] = newPost;
		allPosts = newList;
	}

    /**
     * 
     */
    @Override
	public int createAccount(String handle)
								throws IllegalHandleException,
								InvalidHandleException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int createAccount(String handle, String description)
								throws IllegalHandleException,
								InvalidHandleException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public void removeAccount(int id)
								throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void removeAccount(String handle)
								throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
									throws HandleNotRecognisedException,
									IllegalHandleException,
									InvalidHandleException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void updateAccountDescription(String handle, String description) 
										throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public String showAccount(String handle)
								throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * This method impliments the SocialMediaPlatform method createPost by creating a post
	 * for the account identified by the given handle with the following message.
	 * 
	 * @param 	handle  The handle of the account the post is associated with.
	 * @param 	message The message associated with the post.
	 * 
	 * @throws HandleNotRecognisedException Thrown If the handle does not match to any
	 *                                      account in the system.
	 * @throws InvalidPostException         Thrown if the message is empty or has more than
	 *                                      100 characters.
	 * 
	 * @return The sequential ID of the created post.
     */
	@Override
	public int createPost(String handle, String message)
							throws HandleNotRecognisedException,
							InvalidPostException {
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
							throws HandleNotRecognisedException,
							PostIDNotRecognisedException,
							NotActionablePostException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public int commentPost(String handle, int id, String message)
							throws HandleNotRecognisedException,
							PostIDNotRecognisedException,
							NotActionablePostException,
							InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     */
	@Override
	public void deletePost(int id) 
							throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public String showIndividualPost(int id)
										throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * 
     */
	@Override
	public StringBuilder showPostChildrenDetails(int id)
												throws PostIDNotRecognisedException,
												NotActionablePostException {
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
	public void savePlatform(String filename) 
							throws IOException {
		// TODO Auto-generated method stub

	}

    /**
     * 
     */
	@Override
	public void loadPlatform(String filename) 
							throws IOException,
							ClassNotFoundException {
		// TODO Auto-generated method stub

	}
}