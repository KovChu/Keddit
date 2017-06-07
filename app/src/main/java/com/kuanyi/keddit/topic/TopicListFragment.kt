package com.kuanyi.keddit.topic

import android.app.AlertDialog
import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
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
                onAddClicked()
                return true
            }
        }
        return false
    }

    fun onAddClicked() {
        //create an alert dialog for user to input the text for the item
        val alertDialog = AlertDialog.Builder(activity)
        alertDialog.setTitle(getString(R.string.add_new_topic_title))
        alertDialog.setMessage(getString(R.string.add_new_topic_description))
        val input = EditText(activity)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        input.layoutParams = lp
        //limit the input to 255
        input.maxEms = 255
        alertDialog.setView(input)

        alertDialog.setPositiveButton(getString(R.string.actionAdd)) { dialogInterface, i ->
            //create a new topic item and display
            val topic = Topic(input.text.toString())
            topicListAdapter.addTopic(topic)
        }

        val dialog = alertDialog.show()

        //default button to disable to prevent user creating topic without entering any text
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = false

        input.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                //enable the add button when the input text is not empty
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = input.length() > 0

            }
        })
    }

}