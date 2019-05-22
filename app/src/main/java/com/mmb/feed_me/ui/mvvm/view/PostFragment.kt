package com.mmb.feed_me.ui.mvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmb.feed_me.FeedMeApplication
import com.mmb.feed_me.R
import com.mmb.feed_me.ui.mvvm.model.Post
import com.mmb.feed_me.ui.mvvm.view_model.PostViewModel
import javax.inject.Inject

class PostFragment :Fragment(){
    @Inject
    lateinit var viewModel : PostViewModel
    var items: List<Post>? = null
    var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeedMeApplication.component.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getPosts()
        items = viewModel.list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_post_list , container , false)
    }
}