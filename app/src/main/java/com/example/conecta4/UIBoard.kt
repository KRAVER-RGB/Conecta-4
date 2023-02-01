package com.example.conecta4

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class UIBoard @JvmOverloads constructor(context: Context,
              attributeSet:AttributeSet? = null,
              styleAttrs:Int = 0):ConstraintLayout(context,attributeSet,styleAttrs) {

    private lateinit var token0_0: Token
    private lateinit var token0_1: Token
    private lateinit var token0_2: Token
    private lateinit var token0_3: Token
    private lateinit var token0_4: Token
    private lateinit var token0_5: Token

    private lateinit var token1_0: Token
    private lateinit var token1_1: Token
    private lateinit var token1_2: Token
    private lateinit var token1_3: Token
    private lateinit var token1_4: Token
    private lateinit var token1_5: Token

    private lateinit var token2_0: Token
    private lateinit var token2_1: Token
    private lateinit var token2_2: Token
    private lateinit var token2_3: Token
    private lateinit var token2_4: Token
    private lateinit var token2_5: Token


    private lateinit var token3_0: Token
    private lateinit var token3_1: Token
    private lateinit var token3_2: Token
    private lateinit var token3_3: Token
    private lateinit var token3_4: Token
    private lateinit var token3_5: Token

    private lateinit var token4_0: Token
    private lateinit var token4_1: Token
    private lateinit var token4_2: Token
    private lateinit var token4_3: Token
    private lateinit var token4_4: Token
    private lateinit var token4_5: Token


    private lateinit var token5_0: Token
    private lateinit var token5_1: Token
    private lateinit var token5_2: Token
    private lateinit var token5_3: Token
    private lateinit var token5_4: Token
    private lateinit var token5_5: Token


    private lateinit var token6_0: Token
    private lateinit var token6_1: Token
    private lateinit var token6_2: Token
    private lateinit var token6_3: Token
    private lateinit var token6_4: Token
    private lateinit var token6_5: Token

    private var listOfTokens = Array(7) { arrayOfNulls<Token>(6) }

    var onTokenClick:((token:Token) -> Unit)? = null
    set(value) {
        field = value
    }



    init {
        initViews()
    }

    fun updateBoard(colors:Array<Array<TokenTypes?>>){
        for(i in 0..6) {
            for (j in 0..5) {
                listOfTokens[i][j]?.tokenColor = colors[i][j]!!
            }
        }
    }

    private fun initViews(){
        inflate(context, R.layout.board, this)
        token0_0= findViewById(R.id.x0y0)
        token0_1= findViewById(R.id.x0y1)
        token0_2= findViewById(R.id.x0y2)
        token0_3= findViewById(R.id.x0y3)
        token0_4= findViewById(R.id.x0y4)
        token0_5= findViewById(R.id.x0y5)

        token0_0.coordX = 0
        token0_0.coordY = 0

        token0_1.coordX = 0
        token0_1.coordY = 1

        token0_2.coordX = 0
        token0_2.coordY = 2

        token0_3.coordX = 0
        token0_3.coordY = 3

        token0_4.coordX = 0
        token0_4.coordY = 4

        token0_5.coordX = 0
        token0_5.coordY = 5




        listOfTokens[0][0] = token0_0
        listOfTokens[0][1] = token0_1
        listOfTokens[0][2] = token0_2
        listOfTokens[0][3] = token0_3
        listOfTokens[0][4] = token0_4
        listOfTokens[0][5] = token0_5


        token1_0= findViewById(R.id.x1y0)
        token1_1= findViewById(R.id.x1y1)
        token1_2= findViewById(R.id.x1y2)
        token1_3= findViewById(R.id.x1y3)
        token1_4= findViewById(R.id.x1y4)
        token1_5= findViewById(R.id.x1y5)

        token1_0.coordX = 1
        token1_0.coordY = 0

        token1_1.coordX = 1
        token1_1.coordY = 1

        token1_2.coordX = 1
        token1_2.coordY = 2

        token1_3.coordX = 1
        token1_3.coordY = 3

        token1_4.coordX = 1
        token1_4.coordY = 4

        token1_5.coordX = 1
        token1_5.coordY = 5

        listOfTokens[1][0] = token1_0
        listOfTokens[1][1] = token1_1
        listOfTokens[1][2] = token1_2
        listOfTokens[1][3] = token1_3
        listOfTokens[1][4] = token1_4
        listOfTokens[1][5] = token1_5

        token2_0= findViewById(R.id.x2y0)
        token2_1= findViewById(R.id.x2y1)
        token2_2= findViewById(R.id.x2y2)
        token2_3= findViewById(R.id.x2y3)
        token2_4= findViewById(R.id.x2y4)
        token2_5= findViewById(R.id.x2y5)

        token2_0.coordX = 2
        token2_0.coordY = 0

        token2_1.coordX = 2
        token2_1.coordY = 1

        token2_2.coordX = 2
        token2_2.coordY = 2

        token2_3.coordX = 2
        token2_3.coordY = 3

        token2_4.coordX = 2
        token2_4.coordY = 4

        token2_5.coordX = 2
        token2_5.coordY = 5

        listOfTokens[2][0] = token2_0
        listOfTokens[2][1] = token2_1
        listOfTokens[2][2] = token2_2
        listOfTokens[2][3] = token2_3
        listOfTokens[2][4] = token2_4
        listOfTokens[2][5] = token2_5

        token3_0= findViewById(R.id.x3y0)
        token3_1= findViewById(R.id.x3y1)
        token3_2= findViewById(R.id.x3y2)
        token3_3= findViewById(R.id.x3y3)
        token3_4= findViewById(R.id.x3y4)
        token3_5= findViewById(R.id.x3y5)

        token3_0.coordX = 3
        token3_0.coordY = 0

        token3_1.coordX = 3
        token3_1.coordY = 1

        token3_2.coordX = 3
        token3_2.coordY = 2

        token3_3.coordX = 3
        token3_3.coordY = 3

        token3_4.coordX = 3
        token3_4.coordY = 4

        token3_5.coordX = 3
        token3_5.coordY = 5

        listOfTokens[3][0] = token3_0
        listOfTokens[3][1] = token3_1
        listOfTokens[3][2] = token3_2
        listOfTokens[3][3] = token3_3
        listOfTokens[3][4] = token3_4
        listOfTokens[3][5] = token3_5

        token4_0= findViewById(R.id.x4y0)
        token4_1= findViewById(R.id.x4y1)
        token4_2= findViewById(R.id.x4y2)
        token4_3= findViewById(R.id.x4y3)
        token4_4= findViewById(R.id.x4y4)
        token4_5= findViewById(R.id.x4y5)

        token4_0.coordX = 4
        token4_0.coordY = 0

        token4_1.coordX = 4
        token4_1.coordY = 1

        token4_2.coordX = 4
        token4_2.coordY = 2

        token4_3.coordX = 4
        token4_3.coordY = 3

        token4_4.coordX = 4
        token4_4.coordY = 4

        token4_5.coordX = 4
        token4_5.coordY = 5

        listOfTokens[4][0] = token4_0
        listOfTokens[4][1] = token4_1
        listOfTokens[4][2] = token4_2
        listOfTokens[4][3] = token4_3
        listOfTokens[4][4] = token4_4
        listOfTokens[4][5] = token4_5


        token5_0= findViewById(R.id.x5y0)
        token5_1= findViewById(R.id.x5y1)
        token5_2= findViewById(R.id.x5y2)
        token5_3= findViewById(R.id.x5y3)
        token5_4= findViewById(R.id.x5y4)
        token5_5= findViewById(R.id.x5y5)


        token5_0.coordX = 5
        token5_0.coordY = 0

        token5_1.coordX = 5
        token5_1.coordY = 1

        token5_2.coordX = 5
        token5_2.coordY = 2

        token5_3.coordX = 5
        token5_3.coordY = 3

        token5_4.coordX = 5
        token5_4.coordY = 4

        token5_5.coordX = 5
        token5_5.coordY = 5

        listOfTokens[5][0] = token5_0
        listOfTokens[5][1] = token5_1
        listOfTokens[5][2] = token5_2
        listOfTokens[5][3] = token5_3
        listOfTokens[5][4] = token5_4
        listOfTokens[5][5] = token5_5

        token6_0= findViewById(R.id.x6y0)
        token6_1= findViewById(R.id.x6y1)
        token6_2= findViewById(R.id.x6y2)
        token6_3= findViewById(R.id.x6y3)
        token6_4= findViewById(R.id.x6y4)
        token6_5= findViewById(R.id.x6y5)

        token6_0.coordX = 6
        token6_0.coordY = 0

        token6_1.coordX = 6
        token6_1.coordY = 1

        token6_2.coordX = 6
        token6_2.coordY = 2

        token6_3.coordX = 6
        token6_3.coordY = 3

        token6_4.coordX = 6
        token6_4.coordY = 4

        token6_5.coordX = 6
        token6_5.coordY = 5

        listOfTokens[6][0] = token6_0
        listOfTokens[6][1] = token6_1
        listOfTokens[6][2] = token6_2
        listOfTokens[6][3] = token6_3
        listOfTokens[6][4] = token6_4
        listOfTokens[6][5] = token6_5

        initClickListeners()

    }

    private fun initClickListeners(){

        token0_0.onClick =  {
            onTokenClick?.invoke(it as Token)
        }
        token0_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token0_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token0_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token0_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token0_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token1_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token1_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token1_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token1_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token1_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token1_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token2_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token2_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token2_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token2_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token2_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token2_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token3_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token3_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token3_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token3_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token3_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token3_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token4_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token4_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token4_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token4_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token4_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token4_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token5_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token5_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token5_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token5_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token5_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token5_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

        token6_0.onClick = {
            onTokenClick?.invoke(it as Token)
        }
        token6_1.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token6_2.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token6_3.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token6_4.onClick = {

            onTokenClick?.invoke(it as Token)
        }
        token6_5.onClick = {

            onTokenClick?.invoke(it as Token)
        }

    }


}