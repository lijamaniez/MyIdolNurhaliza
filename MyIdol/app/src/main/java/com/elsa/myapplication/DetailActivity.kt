package com.elsa.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.elsa.myapplication.fragment.HomeFragment

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val komik = intent.getParcelableExtra<Idol>(HomeFragment.INTENT_PARCELABLE)

        val image = findViewById<ImageView>(R.id.img_item_photo)
        val name = findViewById<TextView>(R.id.tv_item_name)
        val desc = findViewById<TextView>(R.id.tv_item_description)


        image.setImageResource(komik?.imgIdol!!)
        name.text = komik.nameIdol
        desc.text = komik.descIdol
    }
}