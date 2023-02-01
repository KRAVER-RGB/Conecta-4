package com.example.conecta4.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.conecta4.PLayer
import com.example.conecta4.R
import com.example.conecta4.TokenTypes
import com.example.conecta4.viewmodel.StateManagerViewModel

class DialogFragmentNewGameMenu private constructor() : DialogFragment() {

    private var tokenColorPlayer1: TokenTypes = TokenTypes.NEUTRAL
    private var tokenColorPlayer2:TokenTypes = TokenTypes.NEUTRAL
    private val stateManagerViewModel:StateManagerViewModel by activityViewModels()

    var onPlayClick:(() -> Unit)? = null

    var onCancelClick:(() -> Unit)? = null



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val newGameMenu: View = LayoutInflater.from(context).inflate(R.layout.new_game_menu,null,false)
        val editTextNickNamePlayer1:EditText = newGameMenu.findViewById(R.id.editTextTextPersonName)
        val editTextNickNamePlayer2:EditText = newGameMenu.findViewById(R.id.editTextTextPersonName2)

        val containerTokenRedPlayer1:FrameLayout = newGameMenu.findViewById(R.id.containerTokenRedPlayer1)
        val containerTokenYellowPlayer1:FrameLayout = newGameMenu.findViewById(R.id.containerYellowTokenPLayer1)

        val containerTokenRedPlayer2:FrameLayout = newGameMenu.findViewById(R.id.containerRedTokenPlayer2)
        val containerTokenYellowPlayer2:FrameLayout = newGameMenu.findViewById(R.id.containerYellowTokenPlayer2)

        val redTokenCVPlayer1:CardView = newGameMenu.findViewById(R.id.tokenRedPlayer1)
        val yellowTokenCVPlayer1:CardView = newGameMenu.findViewById(R.id.tokenYellowPlayer1)

        val redTokenCVPlayer2:CardView = newGameMenu.findViewById(R.id.tokenRedPlayer2)
        val yellowTokenCVPlayer2:CardView = newGameMenu.findViewById(R.id.tokenYellowPlayer2)

        val buttonPlay:Button = newGameMenu.findViewById(R.id.button3)
        val buttonCancel:Button = newGameMenu.findViewById(R.id.button4)

        redTokenCVPlayer1.setOnClickListener {
            tokenColorPlayer1 = TokenTypes.RED
            tokenColorPlayer2 = TokenTypes.YELLOW

            containerTokenRedPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_color_green))
            containerTokenYellowPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))

            containerTokenRedPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))
            containerTokenYellowPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_pink_color))


        }

        yellowTokenCVPlayer1.setOnClickListener {
            tokenColorPlayer1 = TokenTypes.YELLOW
            tokenColorPlayer2 = TokenTypes.RED

            containerTokenRedPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))
            containerTokenYellowPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_color_green))

            containerTokenRedPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_pink_color))
            containerTokenYellowPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))

        }

        redTokenCVPlayer2.setOnClickListener {
            tokenColorPlayer1 = TokenTypes.YELLOW
            tokenColorPlayer2 = TokenTypes.RED

            containerTokenRedPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))
            containerTokenYellowPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_color_green))

            containerTokenRedPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_pink_color))
            containerTokenYellowPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))

        }

        yellowTokenCVPlayer2.setOnClickListener {
            tokenColorPlayer1 = TokenTypes.RED
            tokenColorPlayer2 = TokenTypes.YELLOW

            containerTokenRedPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_color_green))
            containerTokenYellowPlayer1.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))

            containerTokenRedPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_gray_color))
            containerTokenYellowPlayer2.setBackgroundColor(requireContext().getColor(R.color.app_pink_color))
        }

        redTokenCVPlayer1.callOnClick()

        buttonPlay.setOnClickListener {
            if (editTextNickNamePlayer1.text.toString().isEmpty() || editTextNickNamePlayer2.text.toString().isEmpty()){
                Toast.makeText(requireContext(),requireContext().getText(R.string.nickname_are_required_msg),Toast.LENGTH_LONG).show()
            }else{

                if (editTextNickNamePlayer1.text.toString().length>9 || editTextNickNamePlayer2.text.toString().length > 9)
                    Toast.makeText(requireContext(),requireContext().getText(R.string.nickname_length_msg),Toast.LENGTH_LONG).show()
                else{
                    val nickNamePlayer1:String = editTextNickNamePlayer1.text.toString()
                    val nickNamePlayer2:String = editTextNickNamePlayer2.text.toString()

                    val player1 = PLayer(1,tokenColorPlayer1,0,nickNamePlayer1,tokenColorPlayer1 == TokenTypes.RED)
                    val player2 = PLayer(2,tokenColorPlayer2,0,nickNamePlayer2,tokenColorPlayer2 == TokenTypes.RED)

                    val hashMapNewGame:HashMap<Int,PLayer> = HashMap()
                    hashMapNewGame.put(1,player1)
                    hashMapNewGame.put(2,player2)
                    stateManagerViewModel.setPlayers(player1,player2)

                    onPlayClick?.invoke()

                }
            }
        }

        buttonCancel.setOnClickListener {
            onCancelClick?.invoke()
        }

        val alertDialog = AlertDialog.Builder(context).setView(newGameMenu).setCancelable(false).create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return alertDialog
    }

    companion object{
        @JvmStatic
       fun newInstance():DialogFragmentNewGameMenu{

           return DialogFragmentNewGameMenu()
       }
    }

}