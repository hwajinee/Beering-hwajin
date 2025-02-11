package com.example.beering
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beering.databinding.FragmentDrinkSearchBinding
import com.example.naverwebtoon.data.DrinkCover
import com.google.gson.Gson

class DrinkSearchFragment: Fragment() {
    lateinit var binding: FragmentDrinkSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkSearchBinding.inflate(inflater, container, false)
        return binding.root

    }
    var drinkSearchAdapter: DrinkSearchAdapter? = null
    var drinkSearchList = ArrayList<DrinkCover>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.drinkSearchTopSearchCancelIv.setOnClickListener {
            // api로 데이터 받아오는 부분 작성 -> 이거를 버튼 눌렀을때로 변경해야할듯
            val data : ArrayList<DrinkCover> = ArrayList()

            data.add(0,
                DrinkCover("타이거",
                    "Tiger",
                    "Pilsner Urquell Brewery",
                    1,
                    R.drawable.img_temp_drink)
            )
            data.add(1,
                DrinkCover("타이거",
                    "Tiger",
                    "Pilsner Urquell Brewery",
                    1,
                    R.drawable.img_temp_drink)
            )
            data.add(2,
                DrinkCover("타이거",
                    "Tiger",
                    "Pilsner Urquell Brewery",
                    1,
                    R.drawable.img_temp_drink)
            )


            // 받아온 데이터 넣는 부분
            if (data != null) {
                initData(data)
            }

            // 상세 페이지 구현시, 구현
            drinkSearchAdapter!!.setOnItemClickListener(object : DrinkSearchAdapter.OnItemClickListener {
                override fun onItemClick(drinkInfo: DrinkCover) {
                    val intent = Intent(requireContext(), DrinkDetailActivity::class.java)
                    intent.putExtra("drinkId", drinkInfo.id)
                    startActivity(intent)

                }


            })


            drinkSearchAdapter!!.setOnHeartClickListener(object : DrinkSearchAdapter.OnHeartClickListener {
                override fun onButtonClick(position: Int) {
                    drinkSearchAdapter!!.setBindHeart(position, true)
                    drinkSearchAdapter!!.notifyItemChanged(position, "heartChange")
                }
            })

        }

        binding.drinkSearchButtonFilterMcv.setOnClickListener {
            val intent = Intent(requireContext(), SearchFilterActivity::class.java)
            startActivity(intent)
        }







        drinkSearchAdapter = DrinkSearchAdapter((drinkSearchList))
        binding.drinkSearchResultRv.adapter = drinkSearchAdapter
        binding.drinkSearchResultRv.layoutManager = GridLayoutManager(context,2)


    }



    private fun initData(data: ArrayList<DrinkCover>) {
        drinkSearchList.addAll(data)
        drinkSearchAdapter?.notifyDataSetChanged()
    }
}