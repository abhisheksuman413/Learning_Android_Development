package com.fps69.recycler_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

     lateinit var myRecyclerView: RecyclerView
     lateinit var newsArraylist :ArrayList<UserDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        // Set data to newsArraylist
        fetchuserdata()

        // Seting Adaptor to RecyclerView
         setRecyclerView()

    }



    // Set data to newsArraylist
    fun fetchuserdata(){
        // Set data to newsArraylist
        val newsImageArray = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic3,
        )

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
        )


        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )


        newsArraylist = arrayListOf<UserDataClass>()

        for( index in newsImageArray.indices){
            val news = UserDataClass(newsHeadingArray[index], newsImageArray[index],newsContent[index])
            newsArraylist.add(news)
        }

    }



    // Seting Adaptor to RecyclerView
    fun setRecyclerView(){
        // Seting Adaptor to RecyclerView

        myRecyclerView = findViewById<RecyclerView>(R.id.Rv1)

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val MyAdapter =MyAdapter(newsArraylist)
        myRecyclerView.adapter = MyAdapter

        MyAdapter.SetOnItemClickListener(object:MyAdapter.OnItemclickListner{
            override fun OnItemClicking(postion: Int) {

                // On Clicking each item What action do you want to perform

                val intent = Intent(applicationContext, NewsDetails::class.java) // this ke place pe applicationContext ka use kiye hai yha ko context dene ke liye

                intent.putExtra("Heading", newsArraylist[postion].newsHeading)
                intent.putExtra("newsDetails",newsArraylist[postion].newsContent)
                intent.putExtra("newsImage",newsArraylist[postion].newsImage)

                startActivity(intent)

            }
        })
    }

}