package com.kuanyi.keddit.topic

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kuanyi.keddit.R
import com.kuanyi.keddit.model.Topic
import kotlinx.android.synthetic.main.list_topic_item.view.*

/**
 * The RecyclerView Adapter class that binds the data with the view and
 * make changes corresponding with the user's interaction with each item
 * Created by kuanyi on 2017/6/7.
 */
class TopicListAdapter : RecyclerView.Adapter<TopicListAdapter.TopicHolder>(){

    var topicItemList = mutableListOf<Topic>()

    fun addTopic(topic : Topic) {
        val position = checkTopicPosition(topic.upVoteCount)
        topicItemList.add(position, topic)
//        notifyDataSetChanged()
        notifyItemInserted(position)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.

     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.

     * @param holder The ViewHolder which should be updated to represent the contents of the
     * *        item at the given position in the data set.
     * *
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        holder.bindTopic(topicItemList[position])
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.

     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * *               an adapter position.
     * *
     * @param viewType The view type of the new View.
     * *
     * *
     * @return A new ViewHolder that holds a View of the given view type.
     * *
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_topic_item, parent, false)
        return TopicHolder(view)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * we will display the maximum of the 20 items as per requirement
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return if (topicItemList.size > 20) 20 else topicItemList.size
    }


    fun checkTopicPosition(upVoteCount : Int): Int {
        //when initialize, mark the item to the end of the list
        var newPosition = topicItemList.size
        for(item : Topic in topicItemList) {
            if(item.upVoteCount < upVoteCount) {
                // if there is an item that has the less upVote count,
                // the original item will move up to that item's position
                newPosition = topicItemList.indexOf(item)
                break
            }
        }
        return newPosition
    }

     inner class TopicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTopic(topicItem : Topic) {

            itemView.itemUpvoteCountTxt.text = topicItem.upVoteCount.toString()
            itemView.itemTopicText.text = topicItem.title

            itemView.itemUpvoteBtn.setOnClickListener {
                topicItem.upVote()
                notifyItemChanged(topicItemList.indexOf(topicItem))

            }

            itemView.itemDownvoteBtn.setOnClickListener {
                topicItem.downVote()
                notifyItemChanged(topicItemList.indexOf(topicItem))
            }
        }
    }
}