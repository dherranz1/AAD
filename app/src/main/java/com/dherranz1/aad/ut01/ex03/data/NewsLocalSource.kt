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
        //newsList.forEach{}
    }

    fun findAll() : MutableList<News>{
        val newsList = mutableListOf<News>()
        val gson = Gson()
        sharedPref.all.forEach{ entry ->
            val news = gson.fromJson(entry.value as String, News::class.java)
            newsList.add(news)
        }

        return newsList
    }
/*
    fun findAllV2(): MutableList<News>{
        val gson = Gson()
        val jsonNews = sharedPref.getString("ALL", "")

        //val typeNews : Type = object : TypeToken<MutableList<News>>
        // Completar
    }

 */

    fun findAllKotlin() : MutableList<News>{
        val gson = Gson()
        return sharedPref.all.map { entry ->
            gson.fromJson(entry.value as String, News::class.java)
        }.toMutableList()
    }

}