package com.example.conecta4

data class Move @JvmOverloads constructor(
    var cordX:Int = 0,
    var cordY:Int = 0,
    var player:PLayer = PLayer(),
    var isAWinner:Boolean = false,
    var isAnImpossibleMove:Boolean = false,
    var winnerData: WinnerData? = null)