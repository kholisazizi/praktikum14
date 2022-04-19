package com.kholison_19102147.praktikum5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class Practice5ReadDataActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5_read_data)
        val prodi = intent.getStringExtra(EXTRA_PRODI)
        findViewById<TextView>(R.id.lblProdiSaya).text = "Prodi Saya Adalah $prodi"


    }
}