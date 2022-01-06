package com.example.moviestask.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.moviestask.Data.ComingSoon
import com.example.moviestask.Data.NowShowing
import com.example.moviestask.R
import com.example.moviestask.Repository.mainRepo
import com.example.moviestask.ViewModel.mainViewModel
import com.example.moviestask.ViewModel.viewmodelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pageradapter: pageradapter
    var pagerlist=ArrayList<ComingSoon>()

  lateinit var repository:mainRepo
  lateinit var factory:viewmodelFactory
  lateinit var viewModel: mainViewModel

  lateinit var movieAdapter: movieAdapter
  var movielist=ArrayList<NowShowing>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        repository= mainRepo()
        factory= viewmodelFactory(repository)

        viewModel=ViewModelProviders.of(this,factory).get(mainViewModel::class.java)
        viewModel.getpageritems()
        viewModel.livepagerdata.observe(this, Observer {
            pagerlist=it as ArrayList<ComingSoon>
            setpageradapter()
        })

        VPviewpager.offscreenPageLimit=3
        VPviewpager.clipChildren=false
        VPviewpager.clipToPadding=false

        val transformer=CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer(object :ViewPager2.PageTransformer{
            override fun transformPage(page: View, position: Float) {
                var ar:Float=1-position
                page.scaleY=0.85f+ar+0.14f

            }

        })

        VPviewpager.setPageTransformer(transformer)

        viewModel.getMovieData()
        viewModel.livemovieData.observe(this, Observer {
            movielist=it as ArrayList<NowShowing>
            setrecyclerview()
        })





    }
    fun setpageradapter(){
        val pager2=VPviewpager
        pageradapter= pageradapter(this,pagerlist,pager2)
        pager2.adapter=pageradapter
        val LinearLayoutManager=LinearLayoutManager(this)

    }

    fun setrecyclerview(){
        movieAdapter= movieAdapter(this,movielist)
        val gridLayoutManager=GridLayoutManager(this,3)
        recycler1.adapter=movieAdapter
        recycler1.layoutManager=gridLayoutManager
    }
}