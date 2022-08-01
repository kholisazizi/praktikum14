package com.kholison_19102147.praktikum14.`interface`

import com.kholison_19102147.praktikum14.model.Login
import com.kholison_19102147.praktikum14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}