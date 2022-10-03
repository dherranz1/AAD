package com.dherranz1.aad.ut01.ex03.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex03.data.NewsLocalSource
import com.dherranz1.aad.ut01.ex03.domain.News

class Ut01Ex03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ut01_ex03)

        init()
        initWithList()
    }

    private fun init(){
        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val news1 = News(1,"Titulo1", "Subtitle1", "Summary1")
        val news2 = News(2,"Titulo2", "Subtitle2", "Summary2")
        val news3 = News(3,"Titulo3", "Subtitle3", "Summary3")

        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)

        val newsRead = newsLocalSource.findById(2)

        Log.d("@dev", "News: $newsRead")
    }

    private fun initWithList(){

        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val newsList : MutableList<News> = mutableListOf<News>(
            News(4,"Titulo4", "Subtitle4", "Summary4"),
            News(5,"Titulo5", "Subtitle5", "Summary5"),
            News(6,"Titulo6", "Subtitle6", "Summary6"),
        )

        newsLocalSource.setNewsList(newsList)



    }
}