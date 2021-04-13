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
	private Account[] allAccounts = {};

	/**
	 * This is an array of all posts on the platform.
	 */
	private Post[] allPosts = {};

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
	 * This method gets a Post from all posts with the given id.
	 * 
	 * @param id 	The id of the wanted post.
	 * 
	 * @return wantedPost The post with the given id.
	 */
	public Post getPost(int id) {
		Post wantedPost = null;
		for (Post post : allPosts) {
			if (post.getID() == id) {
				wantedPost = post;
				break;
			}
		}
		return wantedPost;
	}
	
	/**
	 * This method gets an Account from all accounts with the given handle.
	 * 
	 * @param handle	The handle of the desired account.
	 * 
	 * @return	This returns the account with the matching handle.
	 */
	public Account getAccount(String handle) {
		Account wantedAccount = null;
		for (Account account : allAccounts) {
			if (account.getHandle() == handle) {
				wantedAccount = account;
				break;
			}
		}
		return wantedAccount;
	}

    /**
     * This method allows the user to create an account with just their handle
	 * and it returns their id number afterwards. It does the checks on the handle
	 * to ensure that there are no other users with the same handle, the handle is 
	 * under 30 characters, is not empty and finally that it has no white space.
	 * 
	 * @param handle	This is the handle the user wants to use
	 * 
	 * @throws IllegalHandleException	Thrown if the handle is already in use by another user.
	 * @throws InvalidHandleException	Thrown if the handle is over 30 chars, is empty or has white space.
	 * @return This returns the id of the new account. 
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
     * Descrip
	 * 
	 * @param handle
	 * @description 
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
		
		for (Post post : allPosts) {
			if (post.getAuthor() == deleteAccount) {
				deletePost(post);
			}
		}
		deleteAccount(deleteAccount);

	}

    /**
     * Descrip
	 * 
	 * @param handle
	 * 
	 * @throws HandleNotRecognisedException
	 * 
     */
	@Override
	public void removeAccount(String handle)
								throws HandleNotRecognisedException {
		Account deleteAccount = getAccount(handle);

		if (deleteAccount == null) {
			throw new HandleNotRecognisedException("The account handle used when trying to delete account does not exist in system.");
		}

		for (Post post : allPosts) {
			if (post.getAuthor() == deleteAccount) {
				deletePost(post);
			}
		}
		deleteAccount(deleteAccount);

	}

    /**
     * Descrip
	 * 
	 * @param oldHandle
	 * @param newHandle
	 * 
	 * @throws HandleNotRecognisedException
	 * @throws IllegalHandleException
	 * @throws InvalidHandleException
	 * 
     */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
									throws HandleNotRecognisedException,
									IllegalHandleException,
									InvalidHandleException {

		Account changeHandle = getAccount(oldHandle);

		for (Account account : allAccounts) {
			if (account.getHandle() == newHandle) {
				throw new IllegalHandleException("Handle is already in use in the system. ");
			}
		}

		if (changeHandle == null) {
			throw new HandleNotRecognisedException("The old account handle used does not exist in the system.");
		}
		
		changeHandle.changeHandle(newHandle);
	}

    /**
     * Descrip
	 * 
	 * @param handle
	 * @param description
	 * 
	 * @throws HandleNotRecognisedException
	 *	
     */
	@Override
	public void updateAccountDescription(String handle, String description) 
										throws HandleNotRecognisedException {

		Account accountDescrip = getAccount(handle);
		if (accountDescrip == null) {
			throw new HandleNotRecognisedException("The account handle used was not recognised by the system.");
		}
		accountDescrip.updateDescription(description);
	}

    /**
	 * Descrip
	 * 
	 * @param handle
	 * 
	 * @throws HandleNotRecognisedException
	 * 
	 * @return
	 */
	@Override
	public String showAccount(String handle)
								throws HandleNotRecognisedException {

		Account wantedAccount = getAccount(handle);

		if (wantedAccount == null) {
			throw new HandleNotRecognisedException("The handle used is not recognised in the system");
		}

		String accountDisplayed = wantedAccount.toString();
		return accountDisplayed;
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
		Post newPost = new Post(author, message);
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
		Post linkedPost = getPost(id);

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
		Post linkedPost = getPost(id);

		if (linkedPost == null) {
			throw new PostIDNotRecognisedException("Post ID is not associated with Post in platform.");
		}

		Comment newComment = new Comment(author, message, linkedPost);
		linkedPost.addComment(newComment);
		addPost(newComment);
		return newComment.getID();
	}

    /**
     * This method impliments the deletePost method of the MiniSocialMediaPlatform interface 
	 * by removing the post from the platform. When a post is removed, all
	 * its endorsements should be removed as well. All replies to this post should
	 * be updated by replacing the reference to this post by a generic empty post.
	 * <p>
	 * The generic empty post message should be "The original content was removed
	 * from the system and is no longer available.". This empty post is just a
	 * replacement placeholder for the post which a reply refers to. Empty posts
	 * should not be linked to any account and cannot be acted upon, i.e., it cannot
	 * be available for endorsements or replies.
	 * <p>
	 * 
	 * @param id	The id of the post to be displayed.
	 * 
	 * @throws PostIDNotRecognisedException		Thrown when the post id is not associated with a post on
	 * 											the platform.
     */
	@Override
	public void deletePost(int id) 
							throws PostIDNotRecognisedException {
		Post deletePost = getPost(id);

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
     * This method impliments the showIndividualPost method by finding the Post which coresponds with the
	 * given post ID and the getting the descirption from the post's toString method. The format is
	 * as follows:
	 * 
	 * <pre>
	 * ID: [post ID]
	 * Account: [account handle]
	 * No. endorsements: [number of endorsements received by the post] | No. comments: [number of comments received by the post]
	 * [post message]
	 * </pre>
	 * 
	 * @param id		The id of the post to be displayed.
	 * 
	 * @throws PostIDNotRecognisedException		Thrown when the post id is not associated with a post on
	 * 											the platform.
	 * 
	 * @return The description of the Post.
     */
	@Override
	public String showIndividualPost(int id)
										throws PostIDNotRecognisedException {
		Post wantedPost = getPost(id);

		if (wantedPost == null) {
			throw new PostIDNotRecognisedException("Post with given id does not exist in system.");
		}

		String description = wantedPost.toString();

		return description;
	}

    /**
     * 
     */
	@Override
	public StringBuilder showPostChildrenDetails(int id)
												throws PostIDNotRecognisedException,
												NotActionablePostException {
		StringBuilder postDetails = new StringBuilder();

		Post wantedPost = getPost(id);

		postDetails.append(showIndividualPost(id));

		addPostChildrenDetails(postDetails, wantedPost.getAllComments());

		return postDetails;
	}

	public void addPostChildrenDetails(StringBuilder postDetails, Comment[] comments) 
										throws PostIDNotRecognisedException {
		for (Comment comment : comments) {
			if (comment.getAllComments().length != 0) {
				addPostChildrenDetails(postDetails, comment.getAllComments());
			}
			postDetails.append("\n | > "+showIndividualPost(comment.getID()));
		}
	}

    /**
     * This method is an implimentation of the getNumberAccounts method in the 
	 * SocialMediaPlatform interface by returning the current total number of accounts
	 * present in the platform. Note, this is NOT the total number of accounts ever 
	 * created since the current total should discount deletions.
	 * 
	 * @return The total number of accounts in the platform.
     */
	@Override
	public int getNumberOfAccounts() {
		int numAccounts = allAccounts.length;
		return numAccounts;
	}

    /**
     * This method is an implimentation of the getTotalOriginalPosts method in the
	 * SocialMediaPlatform interface by returning the current total number of original
	 * posts (i.e., disregarding endorsements and comments) present in the platform. 
	 * Note, this is NOT the total number of posts ever created since the current total
	 * should discount deletions.
	 * 
	 * @return The total number of original posts in the platform.
     */
	@Override
	public int getTotalOriginalPosts() {
		int numoriginalPosts = 0;
		for (Post post : allPosts) {
			if (post.getClass().getName().startsWith("socialmedia.Post")) {
				numoriginalPosts++;
			}
		}
		return numoriginalPosts;
	}

    /**
     * This method is an implimentation of the getTotalEndorsementPost method in the
	 * SocialMediaPlatform interface by returning the current total number of endorsement
	 * posts present in the platform. Note, this is NOT the total number of endorsements 
	 * ever created since the current total should discount deletions.
	 * 
	 * @return The total number of endorsement posts in the platform.
     */
	@Override
	public int getTotalEndorsmentPosts() {
		int numEndorsementPosts = 0;
		for (Post post : allPosts) {
			if (post.getClass().getName().startsWith("socialmedia.Endorsement")) {
				numEndorsementPosts++;
			}
		}
		return numEndorsementPosts;
	}
    
    /**
     * This method is an implimentation of the getTotalCommentPosts method in the 
	 * SocialMediaPlatform interface by returning the current total number of comments posts
	 * present in the platform. Note, this is NOT the total number of comments ever created 
	 * since the current total should discount deletions.
	 * 
	 * @return The total number of comments posts in the platform.
     */
	@Override
	public int getTotalCommentPosts() {
		int numCommentPosts = 0;
		for (Post post : allPosts) {
			if (post.getClass().getName().startsWith("socialmedia.Comment")) {
				numCommentPosts++;
			}
		}
		return numCommentPosts;
	}

    /**
     * This method implients the getMostEndorsedPost method in the MiniSocialMediaPlatform
	 * iterface by identifing and returning the post with the most number of endorsements,
	 * a.k.a. the most popular post.
	 * 
	 * @return The ID of the most popular post.
     */
	@Override
	public int getMostEndorsedPost() {
		Post mostEndorsed = null;
		int maxNumEndorsements = 0;
		int postNumEndorsements;
		for (Post post : allPosts) {
			postNumEndorsements = post.getAllEndorsements().length;
			if (postNumEndorsements >= maxNumEndorsements) {
				mostEndorsed = post;
				maxNumEndorsements = postNumEndorsements;
			}
		}
		return mostEndorsed.getID();
	}

	/**
	 * This method allows the user to retrieve the account with most endorsements. It loops over every
	 * account within the system and checks over all their posts to see how many endorsements each user
	 * has.
	 * 
	 * @return It returns the Id of the account with the most endorsements on the platform.
	 */
	@Override
	public int getMostEndorsedAccount() {
		Account mostEndorsedAccount = null;
		
		for (Account account : allAccounts) {
			int maxNumEndorsements = 0;
			int accountNumEndorsements = 0;
			for (Post post : allPosts) {
				if (post.getAuthor() == account) {
					accountNumEndorsements += post.getAllEndorsements().length;
				}
			}
			if (accountNumEndorsements > maxNumEndorsements) {
				mostEndorsedAccount = account;
				maxNumEndorsements = accountNumEndorsements;
			}
		}
		return mostEndorsedAccount.getId();
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