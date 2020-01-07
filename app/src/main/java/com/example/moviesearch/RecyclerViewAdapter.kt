package com.example.moviesearch

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesearch.Data.Homefeed
import com.example.moviesearch.Data.Item
import kotlinx.android.synthetic.main.item_raw.view.*

class RecyclerViewAdapter(val homefeed: Homefeed): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //아이템의 갯수
    override fun getItemCount(): Int {
        return homefeed.items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bindItems(homefeed.items.get(position))
    }


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data : Item){
            //
            Glide.with(view.context).load(data.image)
                .apply(RequestOptions().override(300, 450))
                .apply(RequestOptions.centerCropTransform())
                .into(view.imageView)
            itemView.txt_name.text = data.title
            itemView.txt_email.text = "출연 ${data.actor}\n"
            itemView.txt_phone.text = "감독 ${data.director}\n"

            //클릭시 웹사이트 연결
            itemView.setOnClickListener({
                val webpage = Uri.parse("${data.link}")
                val webIntent = Intent(Intent.ACTION_VIEW, webpage)
                view.getContext().startActivity(webIntent);
            })
        }
    }

}
