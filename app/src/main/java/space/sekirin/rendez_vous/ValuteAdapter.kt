package space.sekirin.rendez_vous

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ValuteAdapter: RecyclerView.Adapter<ValuteAdapter.ViewHolder>() {

    lateinit var onItemClickListener: OnItemClickListener

    var listValut: MutableList<Valute> = mutableListOf()

    fun valuts(list: List<Valute>){
        listValut.clear()
        listValut.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.list_valute_item, parent, false))
    }

    override fun getItemCount(): Int {
        Log.i("Problems", "ValuteAdapter2 " + listValut.size)
        return listValut.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val valuteValue = listValut[0].value.replace(",", ".").toDouble()
        holder.bind(listValut[position], valuteValue)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        private var tvName: TextView
        private var tvValue: TextView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvValue = itemView.findViewById(R.id.tvValue)
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemClickListener.onItemClick(adapterPosition)
        }

        fun bind(item: Valute, valuteValue: Double){
            tvName.text = item.name
            tvValue.text = String.format("%.2f", (valuteValue / item.value.replace(",", ".").toDouble()))
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}