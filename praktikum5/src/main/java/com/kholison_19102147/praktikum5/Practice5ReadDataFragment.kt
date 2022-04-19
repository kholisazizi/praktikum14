package com.kholison_19102147.praktikum5

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Practice5ReadDataFragment : Fragment() {
    var nim: Int? = null
    companion object {
        var EXTRA_NAMA = "extra_nama"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val myName = arguments?.getString(EXTRA_NAMA)
            view.findViewById<TextView>(R.id.tvMyData).text = "Nama Saya : $myName, NIM Saya : $nim"
        }

        view.findViewById<Button>(R.id.btnKembaliBeranda).setOnClickListener {
            val mIntent = Intent(activity, Practice5Activity::class.java)
            startActivity(mIntent)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice5_read_data, container, false)
    }
}
