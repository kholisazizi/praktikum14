package com.kholison_19102147.praktikum8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SmsReceiverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receiver)

        title = getString(R.string.incoming_message)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        val dataPenipuan: List<String> = listOf<String>("hadiah", "blogspot", "wordpress", "pulsa", "selamat",
            "transfer", "mobil", "polisi", "rumah", "Hadiah", "Blogspot", "Wordpress", "Pulsa", "Selamat",
            "Transfer", "Mobil", "Polisi", "Rumah")

        if (senderMessage.toString().split(" ").toTypedArray().any(dataPenipuan.toTypedArray()::contains)) {
            findViewById<TextView>(R.id.tv_from).text = getString(R.string.coming_from)+": "+senderNo
            findViewById<Button>(R.id.btn_close).setOnClickListener { finish() }
            findViewById<TextView>(R.id.tv_message).text =
                "$senderMessage (Ini merupakan Indikasi SMS Penipuan!!!!)"
        } else {
            findViewById<TextView>(R.id.tv_from).text =
                getString(R.string.coming_from) + ": " + senderNo
            findViewById<TextView>(R.id.tv_message).text = senderMessage
            findViewById<Button>(R.id.btn_close).setOnClickListener { finish() }

        }

    }
}