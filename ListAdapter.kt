package com.example.affirmation_quotes_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class ListAdapter(context: Context, dataArrayList: ArrayList<listData?>?):
ArrayAdapter<listData?>(context, R.layout.list_item, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        val listData=getItem(position)

        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.list_item,parent, false)
        }
        val listImage=view!!.findViewById<ImageView>(R.id.listImage)
        val listQuote=view!!.findViewById<TextView>(R.id.listQuote)
        val listAuthor=view!!.findViewById<TextView>(R.id.listAuthor)

        listImage.setImageResource(listData!!.image)
        listQuote.text=listData.quote
        listAuthor.text=listData.author

        return view
    }
}