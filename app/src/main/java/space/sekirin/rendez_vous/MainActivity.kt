package space.sekirin.rendez_vous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ValuteAdapter.OnItemClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ValuteAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ValuteAdapter()

        recyclerView = findViewById(R.id.rvValues)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.onItemClickListener = this

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.fetchValute()

        viewModel.valuteLiveData.observe(this, Observer {
            adapter.valuts(it)
        })
    }

    override fun onItemClick(position: Int) {
        viewModel.setList(position)
        recyclerView.smoothScrollToPosition(0)
    }


    override fun onBackPressed() {
        viewModel.cancelAllRequests()
        finish()
    }
}