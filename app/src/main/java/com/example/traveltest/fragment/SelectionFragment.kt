package com.example.traveltest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.traveltest.R
import kotlinx.android.synthetic.main.fragment_selection.btn_pre
import kotlinx.android.synthetic.main.fragment_selection.option_1
import kotlinx.android.synthetic.main.fragment_selection.option_2
import kotlinx.android.synthetic.main.fragment_selection.option_3
import kotlinx.android.synthetic.main.fragment_selection.option_4

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btn_pre.setOnClickListener (this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            (R.id.option_1) -> {navigateWithIndex(1)}
            (R.id.option_2) -> {navigateWithIndex(2)}
            (R.id.option_3) -> {navigateWithIndex(3)}
            (R.id.option_4) -> {navigateWithIndex(4)}
            (R.id.btn_pre) -> {
                navController.popBackStack()
            }
        }
    }
    fun navigateWithIndex(Index:Int){
        val bundle = bundleOf("index" to Index)
        navController.navigate(R.id.action_selectionFragment_to_resultFragment,bundle)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}