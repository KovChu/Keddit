package com.kuanyi.keddit.topic

/**
 * The presenter interface that is called when the user interact with the TopicListFragment
 * This is done to separate the view and business logic
 * Created by kuanyi on 2017/6/8.
 */
interface TopicListPresenter {

    /**
     * The user has click on add new topic
     */
    fun onAddClicked()

    /**
     * The user has click on add when creating new topic
     */
    fun onTopicCreate(title : String)
}