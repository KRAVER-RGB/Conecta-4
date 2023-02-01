package com.example.conecta4.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.conecta4.R

class DialogFragmentAWinner constructor() : DialogFragment() {

    var onCancelClick:(() -> Unit)? = null
    var onRetryClick:(() -> Unit)? = null

    companion object{
        @JvmStatic
        fun newInstance(winnerNickName:String,
                        nickNamePlayer1:String,
                        nickNamePlayer2:String,
                        victoryNumPlayer1:Int,
                        victoryNumPlayer2: Int):DialogFragmentAWinner{
            val bundle = Bundle()
            bundle.putString("winnerNickName",winnerNickName)
            bundle.putString("nickNamePlayer1",nickNamePlayer1)
            bundle.putString("nickNamePlayer2",nickNamePlayer2)
            bundle.putInt("victoryNumPlayer1",victoryNumPlayer1)
            bundle.putInt("victoryNumPlayer2",victoryNumPlayer2)
            val instance = DialogFragmentAWinner()
            instance.arguments = bundle
            return DialogFragmentAWinner()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.item_dialogfragment_a_winner,null,false)
        val imageViewCancel: ImageView = dialogView.findViewById(R.id.imageView4)
        val imageViewRetry:ImageView = dialogView.findViewById(R.id.imageView)
        val textViewWinnerNickName:TextView = dialogView.findViewById(R.id.textView9)
        val textViewNickNamePlayer1:TextView = dialogView.findViewById(R.id.textView11)
        val textViewNickNamePlayer2:TextView = dialogView.findViewById(R.id.textView13)
        val textViewVictoryNumPlayer1:TextView = dialogView.findViewById(R.id.textView12)
        val textViewVictoryNumPlayer2:TextView = dialogView.findViewById(R.id.textView14)

        imageViewCancel.setOnClickListener {
            onCancelClick?.invoke()
        }

        imageViewRetry.setOnClickListener {
            onRetryClick?.invoke()
        }

        var winnerNickName:String = ""
        var nickNamePlayer1:String = ""
        var nickNamePlayer2:String = ""
        var victoryNumPlayer1:Int = 0
        var victoryNumPlayer2: Int = 0

        if (arguments != null){
            winnerNickName = arguments?.getString("winnerNickName")!!
            nickNamePlayer1 = arguments?.getString("nickNamePlayer1")!!
            nickNamePlayer2 = arguments?.getString("nickNamePlayer2")!!
            victoryNumPlayer1 = arguments?.getInt("victoryNumPlayer1")!!
            victoryNumPlayer2 = arguments?.getInt("victoryNumPlayer2")!!
        }

        textViewWinnerNickName.text = winnerNickName
        textViewNickNamePlayer1.text = nickNamePlayer1
        textViewNickNamePlayer2.text = nickNamePlayer2
        textViewVictoryNumPlayer1.text = victoryNumPlayer1.toString()
        textViewVictoryNumPlayer2.text = victoryNumPlayer2.toString()

        val alertDialog = AlertDialog.Builder(context).setCancelable(false)
            .setView(dialogView).create()
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return alertDialog
    }



}