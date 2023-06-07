package com.example.traveltest.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.traveltest.R
import com.example.traveltest.databinding.FragmentInputInfoBinding
import com.example.traveltest.databinding.FragmentLoginBinding
import com.example.traveltest.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_input_info.btn_start
import kotlinx.android.synthetic.main.fragment_input_info.btn_start2
import kotlinx.android.synthetic.main.fragment_input_info.btn_start3
import kotlinx.android.synthetic.main.fragment_input_info.ID
import kotlinx.android.synthetic.main.fragment_main.btn_next

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController
    lateinit var editTextFragment: EditText

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

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
        val view = inflater.inflate(R.layout.fragment_input_info, container, false)
        editTextFragment = view.findViewById(R.id.ID)

       // _binding = FragmentInputInfoBinding.inflate(inflater, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //버튼 비활성화
        btn_start2.isEnabled = false

        var ID: String = ""

        editTextFragment.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                ID = editTextFragment.text.toString()

                btn_start2.isEnabled = ID.isNotEmpty()

            }
            override fun afterTextChanged(s: Editable?) {  }
        })

        btn_start3.setOnClickListener {
//            println("이름 : $name")
            navController.navigate(R.id.action_inputInfoFragment_to_questionFragment)
        }
        //로그인 시 db에서 데이터 확인
        btn_start2.setOnClickListener{
            //로그인 프로시저 실행 후 반환된 값이 IsAllowFlag = 1일 시 다음페이지로 이동 / 아닐 시 ErrorMessage띄우기
            // if(R.id.ID.text == db.id && pw.text == db.pw)

            navController.navigate(R.id.action_inputInfoFragment_to_questionFragment)
        }
    }
    // EditText 값 가져오는 함수 예시
//    fun getEditTextValue(): String {
//        val name = editTextFragment.text.toString()
//
//        return name
//    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InputInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}