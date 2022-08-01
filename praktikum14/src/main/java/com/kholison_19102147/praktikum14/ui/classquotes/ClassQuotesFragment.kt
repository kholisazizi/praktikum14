package com.kholison_19102147.praktikum14.ui.classquotes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kholison_19102147.praktikum14.CoroutineContextProvider
import com.kholison_19102147.praktikum14.R
import com.kholison_19102147.praktikum14.TokenPref
import com.kholison_19102147.praktikum14.`interface`.MainView
import com.kholison_19102147.praktikum14.adapter.QuoteAdapter
import com.kholison_19102147.praktikum14.api.MainPresenter
import com.kholison_19102147.praktikum14.databinding.FragmentClassQuotesBinding
import com.kholison_19102147.praktikum14.model.Login
import com.kholison_19102147.praktikum14.model.Quote
import com.kholison_19102147.praktikum14.model.Token
import kotlinx.android.synthetic.main.fragment_class_quotes.*

class ClassQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_class_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClassQuotesBinding.bind(view)
        binding.recyclerviewClassQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewClassQuotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getClassQuotes(token.token)
        swiperefresh.setOnRefreshListener {
            progressbar.visibility = View.INVISIBLE
            presenter.getClassQuotes(token.token)
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getClassQuotes(token.token)
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }
}