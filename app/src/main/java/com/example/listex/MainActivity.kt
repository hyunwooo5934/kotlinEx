package com.example.listex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.listex.databinding.ActivityMainBinding
import com.example.listex.model.apiService
import com.example.listex.model.dayMovieInfo
import com.example.listex.model.dayMovieResponse
import com.example.listex.model.serviceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val apiKey: String = "d071b57fbe83afdf78f878e7dbf3a0ea"
    private lateinit var service: apiService


    private var mBinding: ActivityMainBinding? = null // 전역 변수로 바인딩 객체 선언
    private val binding get() = mBinding!! // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    lateinit var listAdapter: listAdapter
    var index: Int = 0
    var datas = mutableListOf<dayMovieInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        listAdapter = listAdapter(this)
        binding.recyclerView.adapter = listAdapter

        service = serviceManager.retrofit.create(apiService::class.java)


        binding.addBtn.setOnClickListener {
            binding.recyclerView.visibility = View.VISIBLE
            binding.failTv.visibility = View.GONE
            getMovieInfo()
        }
    }


    private fun getMovieInfo() {
        service.dayMoviveInfoData(apiKey, binding.itemName.text.toString())
            .enqueue(object : Callback<dayMovieResponse> {
                override fun onResponse(call: Call<dayMovieResponse>, response: Response<dayMovieResponse>) {
                    if (response.code() == 200) {

                        val listSize : Int ?= response.body()?.boxofficeResult?.dailyBoxOfficeList?.size
                        for (i:Int in 0..listSize!!-1){
                            var item : dayMovieInfo = response.body()?.boxofficeResult?.dailyBoxOfficeList!!.get(i)
                            datas.add(item)
                        }

                        listAdapter.datas = datas
                        listAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<dayMovieResponse>, t: Throwable) {
                    binding.recyclerView.visibility = View.GONE
                    binding.failTv.visibility = View.VISIBLE
                    Log.e("getMovieInfo", t.message.toString())
                }
            })
    }

}

