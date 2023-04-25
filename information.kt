package com.example.affirmation_quotes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.affirmation_quotes_app.databinding.ActivityInformationBinding

class information : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent=this.intent
        if(intent !=null){
            val quote=intent.getStringExtra("quote")
            val author=intent.getStringExtra("author")
            val information=intent.getIntExtra("information", R.string.info)
            val image=intent.getIntExtra("image", R.drawable.selflove)

            binding.informationQuote.text=quote
            binding.informationAuthor.text=author
            binding.informationContent.setText(information)
            binding.informationImage.setImageResource(image)

        }
    }
}