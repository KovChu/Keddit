package com.kuanyi.keddit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.kuanyi.keddit.topic.TopicListFragment



class MainActivity : AppCompatActivity() {

    companion object {
        val FRAGMENT_TOPIC_LIST = "FRAGMENT_TOPIC_LIST"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
                .add(R.id.content, TopicListFragment(), FRAGMENT_TOPIC_LIST)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
