package socialmedia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			if (account.getHandle().equals(handle)) {
				wantedAccount = account;
				break;
			}
		}
		return wantedAccount;
	}

	/**
	 * This method gets an Account from all accounts with the given handle.
	 * 
	 * @param handle	The handle of the desired account.
	 * 
	 * @return	This returns the account with the matching handle.
	 */
	public Account getAccount(int id) {
		Account wantedAccount = null;
		for (Account account : allAccounts) {
			if (account.getId() == id) {
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
	 * 
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
     * This method allows the user to create an account with the handle and description.
	 * 
	 * @param handle	The handle of the new user.
	 * @param description	The description to be displayed on the profile.
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
     * This method allows the user to delete an account using the account id.
	 * 
	 * @param id The id related to account to be deleted.
	 * 
	 * @throws AccountIDNotRecognisedException	Thrown when the account id used is not in the system.
	 * 
     */
	@Override
	public void removeAccount(int id)
								throws AccountIDNotRecognisedException {
		Account deleteAccount = getAccount(id);

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
     * This method allows the user to remove an account using the account handle.
	 * 
	 * @param handle	The handle of the account to be removed.
	 * 
	 * @throws HandleNotRecognisedException	Thrown when the provided handle is not in the system.
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
     * This method allows a user to change their account handle.
	 * 
	 * @param oldHandle		The handle of the user already in the system.
	 * @param newHandle		The handle the user would like to change to.
	 * 
	 * @throws HandleNotRecognisedException 	Thrown when the old handle is not recognised in the system.
	 * @throws IllegalHandleException 	Thrown when the new handle is already in use by another account.
	 * @throws InvalidHandleException 	Thrown when the new handle is over 30 chars, empty, or contains white space.
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
     * This method allows the user to update their account description.
	 * 
	 * @param handle	The handle of the account.
	 * @param description	The new description to be displayed.
	 * 
	 * @throws HandleNotRecognisedException Thrown when the handle is not recognised as belonging to an account in the system.
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
	 * This method allows an account selected with the handle to be displayed as a string, giving all the important info.
	 * 
	 * @param handle	The handle of the account to be displayed
	 * 
	 * @throws HandleNotRecognisedException Thrown when the handle provided is not in the system.
	 * 
	 * @return Returns the account information as a string.
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
		Account author = getAccount(handle);
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
		Account author = getAccount(handle);
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
		Account author = getAccount(handle);
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
     * This method impliments the showPostChildrenDetails of the MiniSocialMediaPlatform 
	 * interface by building a StringBuilder showing the details of the current post and
	 * all its children posts. The format is as follows:
	 * 
	 * See an example:
	 * 
	 * <pre>
	 * ID: 1
	 * Account: user1
	 * No. endorsements: 2 | No. comments: 3
	 * I like examples.
	 * |
	 * | > ID: 3
	 *     Account: user2
	 *     No. endorsements: 0 | No. comments: 1
	 *     No more than me...
	 *     |
	 *     | > ID: 5
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 1
	 *         I can prove!
	 *         |                                         
	 *         | > ID: 6                                 
	 *             Account: user2                        
	 *             No. endorsements: 0 | No. comments: 0 
	 *             prove it                    
	 * | > ID: 4
	 *     Account: user3
	 *     No. endorsements: 4 | No. comments: 0
	 *     Can't you do better than this?
	 * 
	 * | > ID: 7
	 *     Account: user5
	 *     No. endorsements: 0 | No. comments: 1
	 *     where is the example?
	 *     |
	 *     | > ID: 10
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 0
	 *         This is the example!
	 * </pre>
	 * 
	 * 
	 * @param id 	The id of the post to be shown.
	 * 
	 * @throws PostIDNotRecognisedException 	Thrown if the ID does not match to any post in
	 *                                      	the system.
	 * @throws NotActionablePostException   	Thrown if the ID refers to an endorsement post.
	 *                                      	Endorsement posts do not have children
	 *                                      	since they are not endorsable nor
	 *                                      	commented.
	 * 
	 * @return A formatted StringBuilder containing the details of the post and its
	 *         children.
     */
	@Override
	public StringBuilder showPostChildrenDetails(int id)
												throws PostIDNotRecognisedException,
												NotActionablePostException {
		StringBuilder postDetails = new StringBuilder();

		Post wantedPost = getPost(id);

		postDetails.append(showIndividualPost(id));
		postDetails.append("\n | ");

		addPostChildrenDetails(postDetails, wantedPost.getAllComments(), 0);

		return postDetails;
	}

	/**
	 * This is method which uses recurssion to display the posts and all the sub-posts. 
	 * 
	 * @param postDetails	The StringBuilder to add the posts details to.
	 * @param comments		The comments to loop over adding them to the BuildString
	 * 						and recursively calling the method again for any subcomments.
	 * @param numTabs		The number of tabs to add for this set of comments.
	 * 
	 * @throws PostIDNotRecognisedException 	Thrown if the ID does not match to any post in
	 *                                      	the system.
	 */
	public void addPostChildrenDetails(StringBuilder postDetails, Comment[] comments, int numTabs) 
										throws PostIDNotRecognisedException {
		for (Comment comment : comments) {
			String tabs = new String(new char[numTabs]).replace("\0", "     ");
			postDetails.append("\n"+tabs+" | > "+showIndividualPost(comment.getID()).replace("\n", "\n     "+tabs));
			if (comment.getAllComments().length != 0) {
				tabs = new String(new char[numTabs + 1]).replace("\0", "     ");
				postDetails.append("\n"+tabs+" | ");
				addPostChildrenDetails(postDetails, comment.getAllComments(), numTabs+1);
			}
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
     * This method impliments the erasePlatform method in the MiniSocialMediaPlatform 
	 * interface by emptying this SocialMediaPlatform of its contents and resets all
	 * internal counters in Account and Post.
     */
	@Override
	public void erasePlatform() {
		allAccounts = new Account[] {};
		allPosts = new Post[] {};
		Post.resetNumPosts();
		Account.resetNumAccounts();
	}

    /**
     * This method impliments the savePlatform method in the MiniSocialMediaPlatform 
	 * interace by saving this SocialMediaPlatform's contents into a serialised file, with
	 * the filename given in the argument.
	 *
	 * @param filename The path and name of the file to be saved to.
	 * 
	 * @throws IOException Thrown if there is a problem experienced when trying to save the
	 *                     store contents to the file.
     */
	@Override
	public void savePlatform(String filename) 
							throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.allAccounts);
		out.writeObject(this.allPosts);
		out.close();
		fileOut.close();
	}

    /**
     * This method impliments the loadPlatform method in the MiniSocialMediaPlatform 
	 * interface by loading and replacing this SocialMediaPlatform's contents with the
	 * serialised contents stored in the file given in the argument.
	 *
	 * @param filename The location of the file to be loaded.
	 * 
	 * @throws IOException            Thrown if there is a problem experienced when trying
	 *                                to load the store contents from the file.
	 * @throws ClassNotFoundException Thrown if required class files cannot be found when
	 *                                loading.
     */
	@Override
	public void loadPlatform(String filename) 
							throws IOException,
							ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		allAccounts = (Account[]) in.readObject();
		allPosts = (Post[]) in.readObject();
		in.close();
		fileIn.close();
	}
}