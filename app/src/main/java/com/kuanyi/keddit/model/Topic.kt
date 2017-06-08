package com.kuanyi.keddit.model

/**
 * The model class for holding data for Topic, it contains the title and the current
 * count of the up vote it received. The upvote and downvote method will help to manipulate the count
 * Created by kuanyi on 2017/6/7.
 */
class Topic(val title: String,
            var upVoteCount: Int = 0){

    fun upVote() {
        upVoteCount++
    }

    fun downVote() {
        upVoteCount--
    }

}