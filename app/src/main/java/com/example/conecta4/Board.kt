package com.example.conecta4

import com.example.conecta4.TokenTypes
import com.example.conecta4.Board
import com.example.conecta4.MoveProvider

class Board private constructor(): java.io.Serializable {
    val tableBoard = Array(7) { arrayOfNulls<TokenTypes>(6) }
    var lastMove = Move()

    fun newMoveForPlayer(moveParams: Move?) {
        lastMove = provider!!.generateMove(moveParams)
    }

    companion object {
        private var provider: MoveProvider? = null
        private var instance: Board? = null

        fun generateBoard(): Board? {
            if (instance == null) {
                instance = Board()
                provider = MoveProvider(instance)
            }
            return instance
        }
    }
}