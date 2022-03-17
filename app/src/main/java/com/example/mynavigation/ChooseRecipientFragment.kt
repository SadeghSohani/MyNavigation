package com.example.mynavigation

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mynavigation.databinding.FragmentChooseRecipientBinding




class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private var binding: FragmentChooseRecipientBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding!!.btnNext.setOnClickListener(this)
        binding!!.btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btn_next -> {
                if (binding!!.inputRecipient.text.toString().isNotEmpty()) {
                    val bundle = bundleOf("recipient" to binding!!.inputRecipient.text.toString() )
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Please enter a recipient name.", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btn_cancel -> {
                activity?.onBackPressed()
            }
        }
    }

}