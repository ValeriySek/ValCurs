package space.sekirin.rendez_vous.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_valute_item.view.*
import space.sekirin.rendez_vous.R
import space.sekirin.rendez_vous.data.models.Valute

class ValuteAdapter(var context: Context): RecyclerView.Adapter<ValuteAdapter.ViewHolder>() {

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
        holder.itemView.animation = AnimationUtils.loadAnimation(context,
            R.anim.fade_transition_animation
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        private var tvCharCode = itemView.tvCharCode
        private var tvName: TextView = itemView.tvName
        private var tvValue: TextView = itemView.tvValue

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemClickListener.onItemClick(adapterPosition)
        }

        fun bind(item: Valute, valuteValue: Double){
            tvCharCode.text = item.charCode
            tvName.text = item.name
            tvValue.text = String.format("%.4f", (valuteValue / item.value.replace(",", ".").toDouble()))
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}