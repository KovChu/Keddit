package com.kuanyi.keddit.topic

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.kuanyi.keddit.R
import com.kuanyi.keddit.model.Topic
import kotlinx.android.synthetic.main.fragment_topic_list.*


/**
 * The fragment that display a list of the topic that user creates,
 * user can click on the + on the option menu to create a new topic
 * or the user can click on the up vote of down vote on each topic item
 * the list should remain sorted with the most up vote on top
 * Created by kuanyi on 2017/6/7.
 */
class TopicListFragment : Fragment() {

    val topicListAdapter = TopicListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val parentView = inflater.inflate(R.layout.fragment_topic_list, container, false)
        setHasOptionsMenu(true)
        return parentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //setup recycler with linear layout manager with vertical display and from top to down
        listRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        listRecyclerView.itemAnimator = DefaultItemAnimator()
        listRecyclerView.adapter = topicListAdapter
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                val topic = Topic("doakdpasjdasdjasdaosderrwe9ruwe0ruw09ruw09ruw09ruw09wur90wure09wruw09w0ruw0rwjasoidjasoidjaiofhsdiofhdsiofsdfiosdoakdpasjdasdjasdaosderrwe9ruwe0ruw09ruw09ruw09ruw09wur90wure09wruw09w0ruw0rwjasoidjasoidjaiofhsdiofhdsiofsdfios210310")
                topicListAdapter.addTopic(topic)
                return true
            }
        }
        return false
    }
}