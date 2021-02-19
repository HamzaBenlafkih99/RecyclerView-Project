package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the LayoutManager that this RecyclerView will use.
        recycler_view_items.layoutManager = LinearLayoutManager(this)

        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ItemAdapter(this, getItemsList())

        // adapter instance is set to the recyclerview to inflate the items.
        recycler_view_items.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<DataModel> {

        val lines: List<String> = readlines(R.raw.dictionnaire)
        var items = ArrayList<DataModel>()

        lines.forEach { line ->
            run {
                val tab = line.split(':')
                if (tab.size >= 2)
                    items.add(DataModel(tab[0], tab[1].trim()))
            }
        }
        return items
    }

    private fun readlines(file_resource : Int) : ArrayList<String>{
        val result = ArrayList<String>()
        val `is`: InputStream = this.resources.openRawResource(file_resource)
        val reader = BufferedReader(InputStreamReader(`is`))
        var string : String? = ""
        while (true) {
            try {
                if (reader.readLine().also { string = it} == null) break
            } catch (e: IOException) {
                e.printStackTrace()
            }
            result.add(string.toString())
        }
        `is`.close()
        return result
    }
}