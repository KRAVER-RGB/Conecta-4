package com.example.conecta4

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout

class Token @JvmOverloads constructor(context: Context,
            attrs:AttributeSet? = null,
            defStyleAtrr:Int = 0): ConstraintLayout(context,attrs,defStyleAtrr) {

    private lateinit var cardViewToken:CardView

    var coordX:Int = 0
    set(value) {
        field = value
    }

    var coordY:Int = 0
    set(value) {
        field = value
    }

    var tokenColor:TokenTypes = TokenTypes.NEUTRAL
    set(value) {
        field = value
        changeTokenColor(value)
    }

    var onClick:((Token) -> Unit)? = null
    set(value) {
        field = value
    }


    init{
        initViews()
    }

    fun changeTokenColor(tokenColor:TokenTypes){
        when(tokenColor){
            TokenTypes.NEUTRAL -> cardViewToken.setCardBackgroundColor(context.getColor(R.color.white))
            TokenTypes.RED -> cardViewToken.setCardBackgroundColor(context.getColor(R.color.app_red_token_color))
            TokenTypes.YELLOW -> cardViewToken.setCardBackgroundColor(context.getColor(R.color.app_yellow_token_color))
        }
    }

    private fun initViews(){
        inflate(context, R.layout.token,this)
        cardViewToken = findViewById(R.id.tokenCardView)

        cardViewToken.setOnClickListener {
            onClick?.invoke(this)
        }

    }

}