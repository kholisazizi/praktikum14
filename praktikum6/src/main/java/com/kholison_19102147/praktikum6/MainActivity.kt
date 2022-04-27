package com.kholison_19102147.praktikum6

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kholison_19102147.praktikum6.adapter.CardViewMyDataAdapter
import com.kholison_19102147.praktikum6.adapter.GridMyDataAdapter
import com.kholison_19102147.praktikum6.adapter.ListMyDataAdapter

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_mydata).setHasFixedSize(true)
        list.addAll(getListMyDatas())
        showRecyclerList()
    }

    private fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    @SuppressLint("CutPasteId")
    private fun showRecyclerList() {
        findViewById<RecyclerView>(R.id.rv_mydata).layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = ListMyDataAdapter(list)
        findViewById<RecyclerView>(R.id.rv_mydata).adapter = listMyDataAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                showRecyclerCardView()
            }
        }
    }
    @SuppressLint("CutPasteId")
    private fun showRecyclerGrid() {
        findViewById<RecyclerView>(R.id.rv_mydata).layoutManager = GridLayoutManager(this, 2)
        val gridMyDataAdapter = GridMyDataAdapter(list)
        findViewById<RecyclerView>(R.id.rv_mydata).adapter = gridMyDataAdapter
    }
    @SuppressLint("CutPasteId")
    private fun showRecyclerCardView() {
        findViewById<RecyclerView>(R.id.rv_mydata).layoutManager = LinearLayoutManager(this)
        val cardViewMyDataAdapter = CardViewMyDataAdapter (list)
        findViewById<RecyclerView>(R.id.rv_mydata).adapter = cardViewMyDataAdapter
    }
}