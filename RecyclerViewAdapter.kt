package com.bugrakaragozoglu.retrofitkotlin.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugrakaragozoglu.retrofitkotlin.R
import com.bugrakaragozoglu.retrofitkotlin.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>,private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface Listener{
        fun onItemClick(cryptoModel :CryptoModel)
    }


    private val colors: Array<String> = arrayOf("#FFA500","#A52A2A","#0000FF","#D5D6EA","#008B8B","#6B8E23","#4B5320","#387C44")

   inner class RowHolder(view: View) : RecyclerView.ViewHolder(view){
      fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener: Listener){
          itemView.setOnClickListener{listener.onItemClick(cryptoModel)}
          itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
          itemView.text_name.text = cryptoModel.currency
          itemView.text_price.text = cryptoModel.price
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }
}