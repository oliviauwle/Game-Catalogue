package com.example.gamecatalogue.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamecatalogue.databinding.FragmentLatestBinding
import com.example.gamecatalogue.network.RemoteDataSource
import com.example.gamecatalogue.network.response.LatestResponse
import com.example.gamecatalogue.presentation.activity.DetailActivity
import com.example.gamecatalogue.presentation.adapter.LatestAdapter
import com.example.gamecatalogue.presentation.model.Latest
import com.example.gamecatalogue.utils.Mapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LatestFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentLatestBinding
    private lateinit var latestAdapter : LatestAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            LatestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestAdapter ; LatestAdapter (
            onItemClickedCallback = object : LatestAdapter.OnItemClickedCallback {
                override fun onItemClicked(data: Latest) {
                    DetailActivity.start(requireContext() ,data)
                }
            }
        )

        initRecyclerView()

        RemoteDataSource.getInstance().getLatest().enqueue(object : Callback<LatestResponse> {
            override fun onResponse(call: Call<LatestResponse>, response: Response<LatestResponse>) {
                response.body()?.let {
                    latestAdapter.setItems(Mapper.toLatest(it))
                }
            }

            override fun onFailure(call: Call<LatestResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        with(binding) {
            rvLatest.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = latestAdapter
                addItemDecoration (
                    DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                )
            }
        }
    }
}