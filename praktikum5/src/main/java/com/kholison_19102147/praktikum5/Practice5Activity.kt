package com.kholison_19102147.praktikum5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Practice5Activity : AppCompatActivity() {
    val CALL_REQUEST_CODE = 100
    @SuppressLint("MissingPermission")
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5)
        findViewById<Button>(R.id.btnProdi).setOnClickListener{
            val namaProdi = findViewById<EditText>(R.id.inputProdi).text.toString()
            if (namaProdi.isEmpty()) {
                findViewById<EditText>(R.id.inputProdi).error = "Prodi Tidak Boleh Kosong"
                return@setOnClickListener
            }

            val moveWithDataIntent = Intent(this@Practice5Activity, Practice5ReadDataActivity::class.java)
            moveWithDataIntent.putExtra(Practice5ReadDataActivity.EXTRA_PRODI, namaProdi)
            startActivity(moveWithDataIntent)
        }

        findViewById<Button>(R.id.btnCallBrowser).setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://ittelkom-pwt.ac.id/")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCallCamera).setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCallPhone).setOnClickListener{
            val phoneNumber = findViewById<EditText>(R.id.inputPhoneNumber).getText()
            if (phoneNumber.isEmpty()) {
                findViewById<EditText>(R.id.inputPhoneNumber).error = "Nomor Telpon Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }
        setupPermissions()

        findViewById<Button>(R.id.btnFragment).setOnClickListener{
            val intent = Intent(this, Practice5ForFragmentActivity::class.java)
            startActivity(intent)
        }

    }
}