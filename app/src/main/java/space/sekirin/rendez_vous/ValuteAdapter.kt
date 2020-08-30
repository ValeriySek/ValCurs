package space.sekirin.rendez_vous

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.nio.ByteBuffer

class ValuteAdapter : androidx.recyclerview.widget.ListAdapter<Valute, ValuteAdapter.ViewHolder>(ValuteDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_valute_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var valuteValue = getItem(0).value.replace(",", ".").toDouble()
        holder.bind(getItem(position), valuteValue)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvName: TextView
        private var tvValue: TextView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvValue = itemView.findViewById(R.id.tvValue)
        }

        fun bind(item: Valute, valuteValue: Double){
            tvName.text = item.name
            tvValue.text = (valuteValue / item.value.replace(",", ".").toDouble()).toString()
        }

    }


}

private class ValuteDiffCallback : DiffUtil.ItemCallback<Valute>(){
    override fun areItemsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return oldItem == newItem
    }

}