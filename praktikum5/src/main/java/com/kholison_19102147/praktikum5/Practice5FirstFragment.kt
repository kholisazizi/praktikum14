package com.kholison_19102147.praktikum5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager

class Practice5FirstFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnToSecondFragment).setOnClickListener {
            val namaSaya = view.findViewById<EditText>(R.id.inputNamaSaya).text.toString()
            if (namaSaya.isEmpty()) {
                view.findViewById<EditText>(R.id.inputNamaSaya).error = "Nama Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val nimSaya = view.findViewById<EditText>(R.id.inputNamaSaya).text.toString()
            if (nimSaya.isEmpty()) {
                view.findViewById<EditText>(R.id.inputNimSaya).error = "Nim Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val mReadDataFragment = Practice5ReadDataFragment()
            val mBundle = Bundle()
            mBundle.putString(Practice5ReadDataFragment.EXTRA_NAMA, namaSaya)
            mReadDataFragment.arguments = mBundle
            mReadDataFragment.nim = nimSaya.toInt()
            val mFragmentManager = fragmentManager as FragmentManager
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, mReadDataFragment, Practice5ReadDataFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_practice5_first, container, false)
        }
}