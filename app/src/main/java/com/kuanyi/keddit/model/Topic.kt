package com.kuanyi.keddit.model

/**
 * The model class for holding data for Topic, it contains the title and the current
 * count of the up vote it received. The upvote and downvote method will help to manipulate the count
 * This class also implements Comparable to keep the list sorted by its upVoteCount
 * Created by kuanyi on 2017/6/7.
 */
class Topic(val title: String,
            var upVoteCount: Int = 0) : Comparable<Topic>{
    /**
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: Topic): Int {
        if(upVoteCount <= other.upVoteCount) {
            return 1
        }else {
            return -1
        }
    }

    fun upVote() {
        upVoteCount++
    }

    fun downVote() {
        upVoteCount--
    }

}