package com.kuanyi.keddit.topic

import com.kuanyi.keddit.model.Topic

/**
 * The implementation of TopicListPresenter
 * Created by kuanyi on 2017/6/8.
 */
class TopicListPresenterImp(val viewInterface: TopicListViewInterface) : TopicListPresenter {

    /**
     * The user has click on add new topic
     */
    override fun onAddClicked() {
        viewInterface.displayCreateDialog()
    }

    /**
     * The user has click on add when creating new topic
     */
    override fun onTopicCreate(title: String) {
        //create a new topic item and display
        val topic = Topic(title)
        viewInterface.onNewTopic(topic)
    }

}