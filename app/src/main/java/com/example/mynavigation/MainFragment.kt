package com.example.mynavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mynavigation.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding!!.btnViewTransactions.setOnClickListener(this)
        binding!!.btnSendMoney.setOnClickListener(this)
        binding!!.btnViewBalance.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btn_view_transactions ->
                navController.navigate(R.id.action_homeFragment_to_viewTransactionFragment)
            R.id.btn_send_money ->
                navController.navigate(R.id.action_homeFragment_to_chooseRecipientFragment)
            R.id.btn_view_balance ->
                navController.navigate(R.id.action_homeFragment_to_viewBalanceFragment)
        }
    }
}