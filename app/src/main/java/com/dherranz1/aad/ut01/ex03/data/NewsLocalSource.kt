package com.dherranz1.aad.ut01.ex03.data

import android.content.SharedPreferences
import com.dherranz1.aad.ut01.ex03.domain.News
import com.google.gson.Gson

class NewsLocalSource (val sharedPref: SharedPreferences){

    fun setNews(news : News){

        val gson = Gson()
        val jsonNews = gson.toJson(news, News::class.java)

        val editor = sharedPref.edit()

        editor.putString(news.id.toString(), jsonNews)

        editor.apply() // asincrono
    }

    fun findById(newsId : Int) : News{

        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(), "")

        return gson.fromJson(jsonNews, News::class.java)
    }

    fun setNewsList(newsList: MutableList<News>){
        val iterador = newsList.iterator()

        while(iterador.hasNext())
            setNews(iterador.next())

        // Sin iterador
        //newsList.forEach()
    }
/*
    fun findAll() : MutableList<News>{
        // Buscar y devolver todas las noticias
        val mapa = sharedPref.all
        //return mutableListOf()
    }
    */

}