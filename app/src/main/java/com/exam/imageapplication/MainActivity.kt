package com.exam.imageapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var imageView:ImageView ?= null
    var textView:TextView ?= null
    var nxtButton:Button ?= null
    val picasso = Picasso.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.imageUrlTV)
        nxtButton = findViewById(R.id.nextBtn)

        getData()
    }



    private fun getData() {
        val call: Call<DataResponse?>? = RetforitAPI.getClient.getData()
        call?.enqueue(object : Callback<DataResponse?> {

            override fun onResponse(call: Call<DataResponse?>?, response: Response<DataResponse?>?) {
                if(response!!.isSuccessful){
                    textView?.text = response?.body()?.message

                    picasso.load(response?.body()?.message)
                        .into(imageView)
                }


            }

            override fun onFailure(call: Call<DataResponse?>?, t: Throwable?) {
            }

        })
    }

    fun refresh(view: View){
        getData()
    }
}
