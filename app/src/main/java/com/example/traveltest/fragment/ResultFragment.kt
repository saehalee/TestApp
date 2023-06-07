package com.example.traveltest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.traveltest.R
import kotlinx.android.synthetic.main.fragment_result.btn_home
import kotlinx.android.synthetic.main.fragment_result.tv_main
import kotlinx.android.synthetic.main.fragment_result.tv_sub

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var option = -1

    lateinit var navController:NavController

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
        option = arguments?.getInt("index")?:-1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)
        btn_home.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option : Int){
        when(option){
            1 -> {
                tv_main.text = "Taiwan"
                tv_sub.text = "미국의 CNN채널에서도 반드시 먹어보아야 하는 타이완 맛집을 보도한 적이 있어요.타이완 문화를 더욱 심도있게 체험하고 싶다면 타이베이 뤼요왕에서 선정한 반드시 먹어보아야 하는 현지 맛집 10가지 요리를 맛보는 것부터 시작해 보십시오!"
            }
            2 -> {
                tv_main.text = "Japan"
                tv_sub.text = "일본은 풍부한 역사와 과가에 대한 존중, 진보적인 기술 및 IT, 건축 디자인 등 다양한 매력을 품고 있어 알찬 여행을 즐기기 좋은 나라입니다.옛 사찰부터 세계에서 가장 높고 현대적인 건물에 이르기까지, 상반된 모습이 공존하는 일본의 매력을 확인해 보세요."
            }
            3 -> {
                tv_main.text = "USA"
                tv_sub.text = "미국은 다양성, 개인의 자유와 독립, 경제적 열림과 기회, 민주주의 국가로 사회적 인터랙션과대화를 통해 사회적 상호작용을 중요시해요. 편안한 태도로 개방적이고 혁신적인 사고를 가진 사람과의 교류를 경험할 수 있어요."
            }
            4 -> {
                tv_main.text = "Thailand"
                tv_sub.text = "푸켓, 사무이, 크라비와 후아인, 방콕과 치앙마이 등이 대표적인 태국의 휴양지랍니다.안락하고 안정적인 기후로 인해 휴식을 원하는 사람들에게 추천하는 나라에요."
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}