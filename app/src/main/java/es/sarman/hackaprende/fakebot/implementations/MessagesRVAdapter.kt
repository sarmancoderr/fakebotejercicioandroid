package es.sarman.hackaprende.fakebot.implementations

import android.text.Layout.Alignment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.sarman.hackaprende.fakebot.R
import es.sarman.hackaprende.fakebot.models.Message

class MessagesRVAdapter (private val dataSet: ArrayList<Message>) : RecyclerView.Adapter<MessagesRVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView = itemView.findViewById(R.id.message_text)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessagesRVAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessagesRVAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].message
        if (dataSet[position].from == "user") {
            // TODO: Alienar al otro lado
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun addMessage (message: Message) {
        dataSet.add(message)
        notifyDataSetChanged()
    }

}