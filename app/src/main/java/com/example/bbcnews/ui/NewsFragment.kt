package com.example.bbcnews.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbcnews.R
import com.example.bbcnews.adapter.HeadlineAdapter
import com.example.bbcnews.databinding.FragmentNewsBinding
import com.example.bbcnews.model.News

class NewsFragment : Fragment() {
    private var headlineAdapter :  HeadlineAdapter? = null
    //private var newsViewModel: NewsViewModel? = null
    private lateinit var binding: FragmentNewsBinding

    companion object {
        fun newInstance() = NewsFragment()
    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
//        return inflater.inflate(R.layout.fragment_news, container, false)
        binding= FragmentNewsBinding.inflate(inflater, container,false)
       // val root: View = binding.root

        val recyclerView=binding.rvHeadlines
        recyclerView.setLayoutManager(LinearLayoutManager(context))
        recyclerView.setHasFixedSize(true)
        headlineAdapter = HeadlineAdapter()
        recyclerView.setAdapter(headlineAdapter)

        getAllHeadlines()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun getAllHeadlines(){
        viewModel.allheadline!!.observe(viewLifecycleOwner,
            Observer<List<Any>> {headlineModel ->
                headlineAdapter?.setHeadlineList(headlineModel as ArrayList<News>)
            })
    }
//    Fragment.findNavController()
//    View.findNavController()

    override fun onDestroyView() {
        super.onDestroyView()
      //  binding = null
    }

}