package com.stematel.pipi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stematel.recylerview.Superhero
import com.stematel.recylerview.superheroAdapter

class MatematikaBabCoActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matematika_bab_co)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.ic_mtk_img2,
                "Mean, Median, dan Modus",
                "gambar satu"
            ),
            Superhero(
                R.drawable.ic_mtk_img2,
                "Menghitung Luas dan Volume Limas",
                "gambar dua"
            ),
            Superhero(
                R.drawable.ic_mtk_img2,
                "Volume dan Luas Permukaan Bola",
                "gambar tiga"
            ),
            Superhero(
                R.drawable.ic_mtk_img2,
                "Kubus dan Balok",
                "gambar tiga"
            ),
            Superhero(
                R.drawable.ic_mtk_img2,
                "Menghitung bilangam bulat negatif",
                "gambar tiga"
            ),
            Superhero(R.drawable.ic_mtk_img2, "ooo","ssss")
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter= superheroAdapter(this,superheroList){

        }

    }
}