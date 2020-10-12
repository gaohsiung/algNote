import java.util.*;
/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    /** Initialize your data structure here. */
    private class Tweet implements Comparable<Tweet> {
        int timeStamp;
        int tweetId;

        private Tweet(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }

        @Override
        public int compareTo(Tweet that) {
            return this.timeStamp - that.timeStamp;
        }
    }

    Map<Integer, Set<Integer>> whoToFollow;
    Map<Integer, List<Tweet>> oneUserTweetLists;
    private int timeStamp;
    private int tweetFeedNum;
    public Twitter() {
        this.whoToFollow = new HashMap<>();
        this.oneUserTweetLists = new HashMap<>();
        this.timeStamp = 0;
        this.tweetFeedNum = 10;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(this.timeStamp++, tweetId);
        if (!this.oneUserTweetLists.containsKey(userId)) {
            this.oneUserTweetLists.put(userId, new ArrayList<>());
        }
        if (!this.whoToFollow.containsKey(userId)) {
            this.whoToFollow.put(userId, new HashSet<>());
            this.whoToFollow.get(userId).add(userId); // follow self
        }
        this.oneUserTweetLists.get(userId).add(newTweet);
        return;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!this.whoToFollow.containsKey(userId)) {
            this.whoToFollow.put(userId, new HashSet<>());
            this.whoToFollow.get(userId).add(userId); // follow self
        }
        if (!this.oneUserTweetLists.containsKey(userId)) {
            this.oneUserTweetLists.put(userId, new ArrayList<>());
        }
        PriorityQueue<Tweet> newsFeedMinHeap = new PriorityQueue<>();
        // get tweetFeeds
        for (Integer user: this.whoToFollow.get(userId)) {
            List<Tweet> curUserTweetList = this.oneUserTweetLists.get(user);
            if (curUserTweetList == null) continue;
            for (Tweet curUserTweet: curUserTweetList) {
                if (newsFeedMinHeap.size() == this.tweetFeedNum) {
                    if (newsFeedMinHeap.peek().timeStamp < curUserTweet.timeStamp) {
                        newsFeedMinHeap.poll();
                        newsFeedMinHeap.offer(curUserTweet);
                    }
                } else {
                    newsFeedMinHeap.offer(curUserTweet);
                }
            }
        }
        // convert to list<Integer>
        List<Integer> ret = new LinkedList<>();
        while (!newsFeedMinHeap.isEmpty()) {
            ret.add(0, newsFeedMinHeap.poll().tweetId);
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!this.whoToFollow.containsKey(followerId)){
            this.whoToFollow.put(followerId, new HashSet<>());
            this.whoToFollow.get(followerId).add(followerId); // follow self
        }
        this.whoToFollow.get(followerId).add(followeeId);
        return;
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!this.whoToFollow.containsKey(followerId) 
        || !this.whoToFollow.get(followerId).contains(followeeId) 
        || followerId == followeeId) { // can't unfollow self!!!!!!!!!!!!!!!!!!!!!!!
            return;
        }
        this.whoToFollow.get(followerId).remove(followeeId);
        return;
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        // twitter.getNewsFeed(1);
        twitter.follow(1,1);
        twitter.getNewsFeed(1);
        // twitter.unfollow(2, 1);
        // twitter.getNewsFeed(2);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

