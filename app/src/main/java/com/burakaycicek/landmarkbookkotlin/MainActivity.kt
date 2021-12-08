package com.burakaycicek.landmarkbookkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.burakaycicek.landmarkbookkotlin.databinding.ActivityDetailsBinding
import com.burakaycicek.landmarkbookkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  landmarkList : ArrayList<Landmark>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()
        //Data

        val pisa = Landmark("Pisa","Italy",R.drawable.pisa_tower)
        val colosseum = Landmark("Colosseum","Italy",R.drawable.colosseum)
        val pantheon = Landmark("Pantheon", "Italy",R.drawable.pantheon)
        val florence = Landmark("Florence Cathedral","Italy",R.drawable.florence_cathedral)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(pantheon)
        landmarkList.add(florence)

        //Inefficient
        //val pisaBitmap = BitmapFactory.decodeResource(resources,R.drawable.pisa_tower)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter (landmarkList)
        binding.recyclerView.adapter = landmarkAdapter

        /*

        //Adapter : Layout % Data

        //Mapping

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            startActivity(intent)
        }

         */


    }
}