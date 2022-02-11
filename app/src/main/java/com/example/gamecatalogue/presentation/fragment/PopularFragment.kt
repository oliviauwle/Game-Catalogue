package com.example.gamecatalogue.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamecatalogue.databinding.FragmentPopularBinding
import com.example.gamecatalogue.network.RemoteDataSource
import com.example.gamecatalogue.network.response.PopularResponse
import com.example.gamecatalogue.presentation.activity.DetailActivity
import com.example.gamecatalogue.presentation.adapter.PopularAdapter
import com.example.gamecatalogue.presentation.model.Popular
import com.example.gamecatalogue.utils.Mapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentPopularBinding
    private lateinit var popularAdapter: PopularAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            PopularFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularAdapter = PopularAdapter(
            onItemClickedCallback = object : PopularAdapter.OnItemClickedCallback {
                override fun onItemClicked(data: Popular) {
                    DetailActivity.start(requireContext() ,data)
                }
            }
        )

        initRecyclerView()

        RemoteDataSource.getInstance().getPopular().enqueue(object : Callback<PopularResponse> {
            override fun onResponse(call: Call<PopularResponse>, response: Response<PopularResponse>) {
                response.body()?.let {
                    popularAdapter.setItems(Mapper.toPopular(it))
                }
            }

            override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        with(binding) {
            rvPopular.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = popularAdapter
                addItemDecoration (
                    DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                )
            }
        }
    }
}