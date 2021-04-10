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
	 * This method is used to delete an account from all the accounts in the system.
	 * 
	 * @param deleteAccount 	The account to be deleted.
	 */
	public void deleteAccount(Account deleteAccount) {
		Account[] newList = new Account[allAccounts.length - 1];
		for (int i = 0; i < allAccounts.length; i++) {
			if (!allAccounts[i].equals(deleteAccount)) {
				newList[i] = allAccounts[i];
			}
		}
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
	 * This method is used to delete a post from all the posts in the system.
	 * 
	 * @param deletePost 	The post to be deleted.
	 */
	public void deletePost(Post deletePost) {
		Post[] newList = new Post[allPosts.length - 1];
		for (int i = 0; i < allPosts.length; i++) {
			if (!allPosts[i].equals(deletePost)) {
				newList[i] = allPosts[i];
			}
		}
		allPosts = newList;
	}

    /**
     * 
     */
    @Override
	public int createAccount(String handle)
								throws IllegalHandleException,
								InvalidHandleException {
		Account newAccount = new Account(handle);
		addAccount(newAccount);
		return newAccount.getId();
	}

    /**
     * 
     */
	@Override
	public int createAccount(String handle, String description)
								throws IllegalHandleException,
								InvalidHandleException {
		Account newAccount = new Account(handle, description);
		addAccount(newAccount);
		return newAccount.getId();
	}

    /**
     * 
     */
	@Override
	public void removeAccount(int id)
								throws AccountIDNotRecognisedException {
		Account deleteAccount = null;
		for (Account account : allAccounts) {
			if (account.getId() == id) {
				deleteAccount = account;
			}
		}

		if (deleteAccount == null) {
			throw new AccountIDNotRecognisedException("Account ID used when trying to delete accpunt does not exist in system.");
		}
		// Delete Posts, Comments, Endorsements associated with Account.
		deleteAccount(deleteAccount);

	}

    /**
     * 
     */
	@Override
	public void removeAccount(String handle)
								throws HandleNotRecognisedException {
		Account deleteAccount = null;
		for (Account account : allAccounts) {
			if (account.getHandle() == handle) {
				deleteAccount = account;
			}
		}

		if (deleteAccount == null) {
			throw new HandleNotRecognisedException("The account handle used when trying to delete account does not exist in system.");
		}
		// Delete Posts, Comments, Endorsements associated with Account.
		deleteAccount(deleteAccount);

	}

    /**
     * 
     */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
									throws HandleNotRecognisedException,
									IllegalHandleException,
									InvalidHandleException {
		Account changeHandle = null;
		for (Account account : allAccounts) {
			if (account.getHandle() == oldHandle) {
				changeHandle = account;
			}
		}
		if (changeHandle == null) {
			throw new HandleNotRecognisedException("The old account handle used does not exist in the system.");
		}
		for (Account account : allAccounts) {
			if (account.getHandle() == newHandle) {
				throw new IllegalHandleException("Handle is already in use in the system. ");
			}
			if (newHandle.length() > 30) {
				throw new InvalidHandleException("Your handle is longer than 30 characters.");
			}
			if (newHandle.contains(" ")) {
				throw new InvalidHandleException("The handle cannot contain white space.");
			}
			if (newHandle.equals("")) {
				throw new InvalidHandleException("The handle cannot be empty.");
			}
		}
		changeHandle.changeHandle(newHandle);
	}

    /**
     * 
     */
	@Override
	public void updateAccountDescription(String handle, String description) 
										throws HandleNotRecognisedException {
		Account accountDescrip = null;									
		for (Account account : allAccounts) {
			if (account.getHandle() == handle) {
				accountDescrip = account;
				break;
			}
		}
		if (accountDescrip == null) {
			throw new HandleNotRecognisedException("The account handle used was not recognised by the system.");
		}
		accountDescrip.updateDescription(description);
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
		addPost(newPost);
		return newPost.getID();
	}

    /**
     * This method impliments the SocialMediaPlatform method endorsePost by creating an
	 * endorsement post of an existing post, similar to a retweet on Twitter. An 
	 * endorsement post is a special post. It contains a reference to the endorsed post
	 * and its message is formatted as:
	 * <p>
	 * <code>"EP@" + [endorsed account handle] + ": " + [endorsed message]</code>
	 * <p>
	 * 
	 * @param handle 	The handle of the account associated with the endorsement.
	 * @param id		The id of the post associated with the endorsement.
	 * 
	 * @throws HandleNotRecognisedException		Thrown when the handle is not associated with a account
	 * 											on the platform.
	 * @throws PostIDNotRecognisedException		Thrown when the post id is not associated with a post on
	 * 											the platform.
	 * @throws NotActionablePostException		Thrown when attempting to act upon a non actionabe post.
	 * 
	 * @return The sequencial ID of the created endorsement.
     */
	@Override
	public int endorsePost(String handle, int id)
							throws HandleNotRecognisedException,
							PostIDNotRecognisedException,
							NotActionablePostException {
		Account author = null;
		for (Account account : allAccounts) {
			if (handle.equals(account.getHandle())) {
				author = account;
				break;
			}
		}
		Post linkedPost = null;
		for (Post post : allPosts) {
			if (id == post.getID()) {
				linkedPost = post;
				break;
			}
		}

		if (linkedPost == null) {
			throw new PostIDNotRecognisedException("Post ID is not associated with Post in platform.");
		}

		Endorsement newEndorsement = new Endorsement(author, linkedPost);
		linkedPost.addEndorsement(newEndorsement);
		addPost(newEndorsement);
		return newEndorsement.getID();
	}

    /**
	 * This method impliments the SocialMediaPlatform method commentPost by creating a comment post 
	 * referring to an existing post, similarly to a reply on Twitter. A comment post is a special
	 * post. It contains a reference to the post being commented upon.
	 * 
	 * @param handle 	The handle of the account associated with the endorsement.
	 * @param id		The id of the post associated with the endorsement.
	 * @param message 	The message conatined in the comment.
	 * 
	 * @throws HandleNotRecognisedException		Thrown when the handle is not associated with a account
	 * 											on the platform.
	 * @throws PostIDNotRecognisedException		Thrown when the post id is not associated with a post on
	 * 											the platform.
	 * @throws NotActionablePostException		Thrown when attempting to act upon a non actionabe post.
	 * @throws InvalidPostException 			Thrown if the message is empty or has more than
	 *                                      	100 characters.	
	 * 
	 * @return The sequencial ID of the created comment.
	 */
	@Override
	public int commentPost(String handle, int id, String message)
							throws HandleNotRecognisedException,
							PostIDNotRecognisedException,
							NotActionablePostException,
							InvalidPostException {
		Account author = null;
		for (Account account : allAccounts) {
			if (handle.equals(account.getHandle())) {
				author = account;
				break;
			}
		}
		Post linkedPost = null;
		for (Post post : allPosts) {
			if (id == post.getID()) {
				linkedPost = post;
				break;
			}
		}

		if (linkedPost == null) {
			throw new PostIDNotRecognisedException("Post ID is not associated with Post in platform.");
		}

		Comment newComment = new Comment(author, message, linkedPost);
		linkedPost.addComment(newComment);
		addPost(newComment);
		return newComment.getID();
	}

    /**
     * This method is used to delete a post and its endorsement posts from the system as well as
	 * edit any comment posts to now refer to an empty 
     */
	@Override
	public void deletePost(int id) 
							throws PostIDNotRecognisedException {
		Post deletePost = null;
		for (Post post : allPosts) {
			if (post.getID() == id) {
				deletePost = post;
				break;
			}
		}

		if (deletePost == null) {
			throw new PostIDNotRecognisedException("Post ID of post to be deleted not in the system.");
		}

		for (Endorsement endorsement : deletePost.getAllEndorsements()) {
			deletePost(endorsement);
		}

		for (Comment comment: deletePost.getAllComments()) {
			comment.changeLinkedPost(new Post());
		}

		deletePost(deletePost);

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