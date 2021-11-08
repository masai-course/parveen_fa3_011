package com.example.u5eval2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.u5eval2.data.Article
import com.example.u5eval2.data.ResponseModel
import com.example.u5eval2.viewModel.ServiceNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers.io

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private val resp=ArrayList<Article>()
    private lateinit var disposable: Disposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler)


    }
   /* private fun apicall(){
        ServiceNetwork.getapi().getposts().subscribeOn(Scheduler.io).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Article>{
                override fun onSubscribe(d: Disposable) {
                    d.let {
                      disposable=it
                            }                }

                override fun onNext(t: Article) {
                 setadaptr()
               }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
    }*/

    private fun setadaptr(){
        newsAdapter= NewsAdapter(resp)
        val layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=newsAdapter
    }
}