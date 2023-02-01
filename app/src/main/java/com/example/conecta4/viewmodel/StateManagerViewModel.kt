package com.example.conecta4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.conecta4.Board
import com.example.conecta4.PLayer
import com.example.conecta4.TokenColorNames
import com.example.conecta4.TokenTypes


class StateManagerViewModel (private val state: SavedStateHandle) : ViewModel() {

    private val _player1 = MutableLiveData(PLayer())
    val player1: LiveData<PLayer> = _player1

    private val _player2 = MutableLiveData(PLayer())
    val player2:LiveData<PLayer> = _player2

    private val _gamesCount = MutableLiveData<Int>()
    val gamesCount:LiveData<Int> = _gamesCount

    private val _isFirstGame = MutableLiveData<Boolean>()
    val isFirstGame:LiveData<Boolean> = _isFirstGame

    private val _boardGameData = MutableLiveData<Board>()
    val boardGameData:LiveData<Board> = _boardGameData

    private val _lastFragmentOnScreen = MutableLiveData<String>()
    val lastFragmentOnScreen = _lastFragmentOnScreen

    fun setLastFragmentOnScreen(lastFragmentOnScreen:String){
        _lastFragmentOnScreen.value = lastFragmentOnScreen
        state["lastFragmentOnScreen"] = _lastFragmentOnScreen.value
    }




    fun setPlayers(player1:PLayer, player2:PLayer){
        _player1.value = player1
        _player2.value = player2
        savePlayersState()
    }

    fun setBoardGameData(boardData:Board){
        _boardGameData.value = boardData
        state["boardData"] = _boardGameData.value
    }

    fun setFirstGame(isFirstGame:Boolean){
        _isFirstGame.value = isFirstGame
    }

    private fun savePlayersState(){
        state["player1Number"] = _player1.value?.playerNumber
        state["tokenTypePlayer1"] = if (_player1.value?.tokenType == TokenTypes.RED) TokenColorNames.redColor else TokenColorNames.yellowColor
        state["victoriesPlayer1"] = _player1.value?.victories
        state["player1NickName"] = _player1.value?.playerNickName
        state["player1OnTurn"] = _player1.value?.onTurn

        state["player2Number"] = _player2.value?.playerNumber
        state["tokenTypePlayer2"] = if (_player2.value?.tokenType == TokenTypes.RED) TokenColorNames.redColor else TokenColorNames.yellowColor
        state["victoriesPlayer2"] = _player2.value?.victories
        state["player2NickName"] = _player2.value?.playerNickName
        state["player2OnTurn"] = _player2.value?.onTurn

    }

    public fun restartPlayersState(){
        state["player1Number"] = 0
        state["tokenTypePlayer1"] = TokenColorNames.yellowColor
        state["victoriesPlayer1"] = 0
        state["player1NickName"] = ""
        state["player1OnTurn"] = false

        state["player2Number"] = 0
        state["tokenTypePlayer2"] = TokenColorNames.yellowColor
        state["victoriesPlayer2"] = 0
        state["player2NickName"] = ""
        state["player2OnTurn"] = false
    }

    public fun restorePlayersState(){

        _player1.value?.playerNumber = state["player1Number"]!!
        val player1TokenColor:String = state["tokenTypePlayer1"]!!
        _player1.value?.tokenType = if (player1TokenColor == TokenColorNames.redColor) TokenTypes.RED  else TokenTypes.YELLOW
        _player1.value?.victories = state["victoriesPlayer1"]!!
        _player1.value?.playerNickName = state["player1NickName"]!!
        _player1.value?.onTurn = state["player1OnTurn"]!!

        _player2.value?.playerNumber = state["player2Number"]!!
        val player2TokenColor:String = state["tokenTypePlayer2"]!!
        _player2.value?.tokenType = if (player2TokenColor == TokenColorNames.redColor) TokenTypes.RED  else TokenTypes.YELLOW
        _player2.value?.victories = state["victoriesPlayer2"]!!
        _player2.value?.playerNickName = state["player2NickName"]!!
        _player2.value?.onTurn =  state["player2OnTurn"]!!

    }

    public fun setInitialGameCount(){
        _gamesCount.value = 0
        state["gamesCount"] = _gamesCount.value
    }

    public fun addAGameToCount(){
        _gamesCount.value = _gamesCount.value?.plus(1)
        state["gamesCount"] = _gamesCount.value
    }


}
