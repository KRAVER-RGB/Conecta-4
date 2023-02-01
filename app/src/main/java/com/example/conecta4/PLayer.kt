package com.example.conecta4

import android.os.Parcelable

class PLayer @JvmOverloads constructor(
    var playerNumber:Int = 0,
    var tokenType:TokenTypes = TokenTypes.NEUTRAL,
    var victories:Int = 0,
    var playerNickName:String = "",
    var onTurn:Boolean = false)