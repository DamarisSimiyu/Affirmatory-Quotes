package com.example.affirmation_quotes_app
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.affirmation_quotes_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: listData
    var dataArrayList = ArrayList<listData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quoteList = arrayOf(
            "Self Love Quote",
            "Motivate Quote",
            "Leadership Quote",
            "Friendship Quote",
            "Birthday Quote",
            "Funny Quote",
            "Gratitude Quote",
            "Change Quote"
        )
        val authorList = arrayOf( "Amit Ray", "20 Quotes", "20 Quotes", "20 Quotes", "20 Quotes",
            "20 Quotes",
            "20 Quotes",
            "20 Quotes"
        )
        val imageList = intArrayOf(
            R.drawable.selflove,
            R.drawable.motivate,
            R.drawable.leader,
            R.drawable.friend,
            R.drawable.birthday,
            R.drawable.funny,
            R.drawable.thanks,
            R.drawable.change
        )

        val informationList = intArrayOf(
            R.string.info,
            R.string.info,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
        )

        for (i in imageList.indices) {
            listData = listData(quoteList[i], authorList[i], informationList[i], imageList[i])
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(this@MainActivity, information::class.java)
                intent.putExtra("quote", quoteList[i])
                intent.putExtra("author", authorList[i])
                intent.putExtra("information", informationList[i])
                intent.putExtra("image", imageList[i])
                startActivity(intent)
            }
    }
}