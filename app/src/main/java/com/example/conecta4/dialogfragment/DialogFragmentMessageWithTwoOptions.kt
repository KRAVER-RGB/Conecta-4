package com.example.conecta4.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.conecta4.R

class DialogFragmentMessageWithTwoOptions private constructor() : DialogFragment(){


    private var onCancelClick:(() -> Unit)? = null

    private var onAcceptClick:(() -> Unit)? = null

    companion object {
        @JvmStatic
        fun newInstance(mainMessage: String,
                        onCancelButtonText: String?,
                        onAcceptButtonText: String?): DialogFragmentMessageWithTwoOptions{

            val bundle:Bundle = Bundle()
            bundle.putString("mainMessage",mainMessage)
            bundle.putString("onCancelButtonText",onCancelButtonText)
            bundle.putString("onAcceptButtonText",onAcceptButtonText)

            val dialogFragmentMessageWithTwoOptions = DialogFragmentMessageWithTwoOptions()
            dialogFragmentMessageWithTwoOptions.arguments = bundle

            return dialogFragmentMessageWithTwoOptions
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var mainMessage:String = ""
        var onCancelButtonText:String? = null
        var onAcceptButtonText:String? = null


        if (arguments != null){
            mainMessage = requireArguments().getString("mainMessage","")
            onCancelButtonText = requireArguments().getString("onCancelButtonText")
            onAcceptButtonText = requireArguments().getString("onAcceptButtonText")

        }

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.return_to_main_menu_dialog,null,false)

        val textViewMainMessage:TextView = view.findViewById(R.id.textView18)
        val buttonAccept:Button = view.findViewById(R.id.button8)
        val buttonCancel:Button = view.findViewById(R.id.button7)

        textViewMainMessage.text = mainMessage
        if (onCancelButtonText == null) buttonCancel.visibility = View.GONE
        else{
            buttonCancel.visibility = View.VISIBLE
            buttonCancel.text = onCancelButtonText
        }

        if (onAcceptButtonText == null) buttonAccept.visibility = View.GONE
        else{
            buttonAccept.visibility = View.VISIBLE
            buttonAccept.text = onAcceptButtonText
        }

        buttonCancel.setOnClickListener {
            onCancelClick?.invoke()
        }

        buttonAccept.setOnClickListener {
            onAcceptClick?.invoke()
        }

        val alertDialog = AlertDialog.Builder(requireContext()).setView(view).setCancelable(false).create()

        return alertDialog
    }

}