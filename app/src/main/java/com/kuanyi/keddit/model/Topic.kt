package com.kuanyi.keddit.model

/**
 * Created by kuanyi on 2017/6/7.
 */
class Topic(val title: String,
            var upVoteCount: Int = 0) {

    fun upVote() {
        upVoteCount++
    }

    fun downVote() {
        upVoteCount--
    }

}