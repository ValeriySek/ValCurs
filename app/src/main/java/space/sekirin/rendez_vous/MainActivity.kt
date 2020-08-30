package space.sekirin.rendez_vous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ValuteAdapter()

        var recyclerView: RecyclerView = findViewById(R.id.rvValues)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.fetchValute()


        viewModel.valuteLiveData.observe(this, Observer {
            var valuts: MutableList<Valute> = mutableListOf()
            for (i in 0 until it.size-1){
                if(it[i].charCode.equals("USD")){
                    valuts.add(0, it[i])
                } else{
                    valuts.add(it[i])
                }
            }

            adapter.submitList(valuts)
        })

    }
}