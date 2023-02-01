package com.example.conecta4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.conecta4.databinding.FragmentSecondBinding
import com.example.conecta4.dialogfragment.DialogFragmentAWinner
import com.example.conecta4.viewmodel.StateManagerViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment constructor() : Fragment() {//, OnClickListener{


    private var _binding: FragmentSecondBinding? = null

    private val stateManagerViewModel:StateManagerViewModel by activityViewModels()

    companion object{


        @JvmStatic
        fun newInstance():SecondFragment{
            val bundle = Bundle()
            val instance = SecondFragment()
            instance.arguments = bundle
            return instance
        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        stateManagerViewModel.setBoardGameData(Board.generateBoard()!!)

        _binding?.textViewNamePLayer1?.text = stateManagerViewModel.player1.value?.playerNickName
        _binding?.textView3?.text = stateManagerViewModel.player1.value?.victories.toString()

        _binding?.textView6?.text = stateManagerViewModel.player2.value?.playerNickName
        _binding?.textView7?.text = stateManagerViewModel.player2.value?.victories.toString()

        _binding?.textView8?.text = getString(R.string.txt_on_turn)
        _binding?.textView4?.text = getString(R.string.txt_on_turn)

        setFirstTurn()

        _binding!!.boardComponent.onTokenClick = { token ->
            val move = Move(token.coordX, token.coordY,
                if (stateManagerViewModel.player1.value?.onTurn!!) stateManagerViewModel.player1.value!! else stateManagerViewModel.player2.value!!)
            stateManagerViewModel.boardGameData.value?.newMoveForPlayer(move)
            if(stateManagerViewModel.boardGameData.value?.lastMove!!.isAnImpossibleMove){
                Toast.makeText(requireContext(),getString(R.string.impossible_movement_message),Toast.LENGTH_LONG).show()
            }else{
                _binding?.boardComponent?.updateBoard(stateManagerViewModel.boardGameData.value?.tableBoard!!)
                changeTurnOnBoard()
                if (stateManagerViewModel.boardGameData.value?.lastMove!!.isAWinner){

                }
            }

        }
        return binding.root

    }

    private fun showWinnerDialog(){
        val onCancelClick: (() -> Unit) = {

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setFirstTurn(){

        stateManagerViewModel.setFirstGame(true)

        if (stateManagerViewModel.player1.value?.onTurn!!){
            _binding?.textView4?.visibility = View.VISIBLE
            _binding?.textView8?.visibility = View.INVISIBLE

        }else{
            _binding?.textView4?.visibility = View.INVISIBLE
            _binding?.textView8?.visibility = View.VISIBLE
        }

        _binding?.cardViewTokenColorPLayer1?.setCardBackgroundColor(
            ContextCompat.getColor(requireContext(),
                if (stateManagerViewModel.player1.value?.tokenType == TokenTypes.RED) R.color.app_red_token_color else R.color.app_yellow_token_color)
        )

        _binding?.cardViewTokenColorPLayer2?.setCardBackgroundColor(
            ContextCompat.getColor(requireContext(),
                if (stateManagerViewModel.player2.value?.tokenType == TokenTypes.RED) R.color.app_red_token_color else R.color.app_yellow_token_color)
        )

    }

    private fun changeTurnOnBoard(){

        stateManagerViewModel.setFirstGame(false)

        if (stateManagerViewModel.player1.value?.onTurn!!){

            val _player1 = stateManagerViewModel.player1.value
            val _player2 = stateManagerViewModel.player2.value

            _player2?.onTurn = true
            _player1?.onTurn = false

            stateManagerViewModel.setPlayers(_player1!!,_player2!!)

            _binding?.textView4?.visibility = View.INVISIBLE
            _binding?.textView8?.visibility = View.VISIBLE


        }else{

            val _player1 = stateManagerViewModel.player1.value
            val _player2 = stateManagerViewModel.player2.value

            _player2?.onTurn = false
            _player1?.onTurn = true

            stateManagerViewModel.setPlayers(_player1!!,_player2!!)

            _binding?.textView4?.visibility = View.VISIBLE
            _binding?.textView8?.visibility = View.INVISIBLE

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    *
    *  override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.x0y0 ->{
                board?.newMoveForPlayer(Move(0,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x1y0 ->{
                board?.newMoveForPlayer(Move(1,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y0 ->{
                board?.newMoveForPlayer(Move(2,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y0 ->{
                board?.newMoveForPlayer(Move(3,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y0 ->{
                board?.newMoveForPlayer(Move(4,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y0 ->{
                board?.newMoveForPlayer(Move(5,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y0 ->{
                board?.newMoveForPlayer(Move(6,0,if(player1.onTurn)player1 else player2))
            }
            R.id.x0y1 ->{
                board?.newMoveForPlayer(Move(0,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x1y1 ->{
                board?.newMoveForPlayer(Move(1,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y1 ->{
                board?.newMoveForPlayer(Move(2,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y1 ->{
                board?.newMoveForPlayer(Move(3,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y1 ->{
                board?.newMoveForPlayer(Move(4,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y1 ->{
                board?.newMoveForPlayer(Move(5,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y1 ->{
                board?.newMoveForPlayer(Move(6,1,if(player1.onTurn)player1 else player2))
            }
            R.id.x0y2 ->{
                board?.newMoveForPlayer(Move(0,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x1y2 ->{
                board?.newMoveForPlayer(Move(1,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y2 ->{
                board?.newMoveForPlayer(Move(2,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y2 ->{
                board?.newMoveForPlayer(Move(3,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y2 ->{
                board?.newMoveForPlayer(Move(4,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y2 ->{
                board?.newMoveForPlayer(Move(5,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y2 ->{
                board?.newMoveForPlayer(Move(6,2,if(player1.onTurn)player1 else player2))
            }
            R.id.x0y3 ->{
                board?.newMoveForPlayer(Move(0,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x1y3 ->{
                board?.newMoveForPlayer(Move(1,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y3 ->{
                board?.newMoveForPlayer(Move(2,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y3 ->{
                board?.newMoveForPlayer(Move(3,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y3 ->{
                board?.newMoveForPlayer(Move(4,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y3 ->{
                board?.newMoveForPlayer(Move(5,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y3 ->{
                board?.newMoveForPlayer(Move(6,3,if(player1.onTurn)player1 else player2))
            }
            R.id.x0y4 ->{
                board?.newMoveForPlayer(Move(0,4,if(player1.onTurn)player1 else player2))
            }
            R.id.tokenCardView ->{
                board?.newMoveForPlayer(Move(1,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y4 ->{
                board?.newMoveForPlayer(Move(2,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y4 ->{
                board?.newMoveForPlayer(Move(3,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y4 ->{
                board?.newMoveForPlayer(Move(4,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y4 ->{
                board?.newMoveForPlayer(Move(5,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y4 ->{
                board?.newMoveForPlayer(Move(6,4,if(player1.onTurn)player1 else player2))
            }
            R.id.x0y5 ->{
                board?.newMoveForPlayer(Move(0,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x1y5 ->{
                board?.newMoveForPlayer(Move(1,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x2y5 ->{
                board?.newMoveForPlayer(Move(2,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x3y5 ->{
                board?.newMoveForPlayer(Move(3,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x4y5 ->{
                board?.newMoveForPlayer(Move(4,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x5y5 ->{
                board?.newMoveForPlayer(Move(5,5,if(player1.onTurn)player1 else player2))
            }
            R.id.x6y5 ->{
                board?.newMoveForPlayer(Move(6,5,if(player1.onTurn)player1 else player2))
            }



        }
    }
    *
    * */

    //private fun clickListener

    private fun refreshUIBoard(){
        //binding.x0y0.

    }

}