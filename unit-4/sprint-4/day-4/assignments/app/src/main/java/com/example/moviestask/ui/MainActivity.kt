package com.example.moviestask.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.R
import com.example.moviestask.ViewModel.mainViewModel
import com.example.moviestask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickListener {



    lateinit var pageradapter: pageradapter
    var pagerlist=ArrayList<ComingSoon>()
    private lateinit var activityMainBinding: ActivityMainBinding
  private val viewModel by viewModels<mainViewModel>()
  lateinit var movieAdapter: movieAdapter
  var movielist=ArrayList<NowShowing>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel.getpageritems()
        viewModel.livepagerdata.observe(this, Observer {
            pagerlist=it as ArrayList<ComingSoon>
            setpageradapter()
        })

      // pageTransformer to set margin betwwn pagerItems
        val transformer=CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer(object :ViewPager2.PageTransformer{
            override fun transformPage(page: View, position: Float) {
                var ar:Float=1-position
                page.scaleY=0.85f+ar+0.14f

            }

        })
        pagerProperty()
               //setting transformer
        activityMainBinding.VPviewpager.setPageTransformer(transformer)

        viewModel.getMovieData()
        // live data observer
        viewModel.livemovieData.observe(this, Observer {
            movielist=it as ArrayList<NowShowing>
            setrecyclerview()
        })





    }
    // recycler view adapter and layout manager set
    private fun setpageradapter(){
        val pager2=activityMainBinding.VPviewpager
        pageradapter= pageradapter(this,pagerlist,pager2, this)
        pager2.adapter=pageradapter
        val LinearLayoutManager=LinearLayoutManager(this)

    }

    //Initialising pager properties
    private fun pagerProperty(){
        activityMainBinding.apply {
            VPviewpager.offscreenPageLimit = 3
            VPviewpager.clipChildren = false
            VPviewpager.clipToPadding = false

        }
    }


   // Pager adapter
   private fun setrecyclerview(){
        movieAdapter= movieAdapter(this,movielist, this)
        val gridLayoutManager=GridLayoutManager(this,3)
        activityMainBinding.recycler1.adapter = movieAdapter
        activityMainBinding.recycler1.layoutManager = gridLayoutManager
    }

    override fun onPagerclick(position: Int, Comingsoon: ComingSoon) {
        var intent= Intent(this,PagerActivity::class.java)
        intent.putExtra("pagerImage",Comingsoon.posterurl)
        intent.putExtra("relDate",Comingsoon.releaseDate)
        intent.putExtra("disc",Comingsoon.storyline)
        startActivity(intent)

    }

    override fun onmovieclick(position: Int, nowShowing: NowShowing) {
        var intent= Intent(this,MovieActivity::class.java)
        intent.putExtra("movieImage",nowShowing.posterurl)
        intent.putExtra("relDate1",nowShowing.releaseDate)
        intent.putExtra("story",nowShowing.storyline)
        startActivity(intent)
    }
}