package com.kuanyi.keddit.topic

import com.kuanyi.keddit.model.Topic

/**
 * The interface of communication from presenter back to the fragment
 * Created by kuanyi on 2017/6/8.
 */
interface TopicListViewInterface {

    /**
     * notify fragment to display a dialog for user to create a new Topic
     */
    fun displayCreateDialog()

    /**
     * notify that there is a new topic created and to be added to the list
     */
    fun onNewTopic(newTopic : Topic)

}