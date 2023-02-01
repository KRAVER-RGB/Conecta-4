package com.example.conecta4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.conecta4.databinding.FragmentFirstBinding
import com.example.conecta4.dialogfragment.DialogFragmentNewGameMenu

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment constructor() : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    companion object{
        private lateinit var instance:FirstFragment
        @JvmStatic
        fun newInstance():FirstFragment{
            instance = FirstFragment()
            return instance
        }

    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.button2?.setOnClickListener {
            (requireActivity() as MainActivity).showNewGameMenu()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}