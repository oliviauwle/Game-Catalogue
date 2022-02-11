package com.example.gamecatalogue.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gamecatalogue.R
import com.example.gamecatalogue.databinding.ActivityDetailBinding
import com.example.gamecatalogue.network.RemoteDataSource
import com.example.gamecatalogue.network.response.PopularDetailResponse
import com.example.gamecatalogue.network.response.LatestDetailResponse
import com.example.gamecatalogue.presentation.model.Latest
import com.example.gamecatalogue.presentation.model.Popular
import com.example.gamecatalogue.utils.Const
import com.example.gamecatalogue.utils.Mapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    companion object{

        private const val POPULAR_EXTRA = "popular_extra"
        private const val LATEST_EXTRA = "latest_extra"

        @JvmStatic
        fun start(context: Context, data: Popular) {

            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(POPULAR_EXTRA, data)
            context.startActivity(starter)
        }


        fun start(context: Context, data: Latest) {

            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(LATEST_EXTRA, data)
            context.startActivity(starter)
        }
    }

    private lateinit var binding: ActivityDetailBinding
    private var popular: Popular? = null
    private var latest: Latest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initIntent()
        if (popular != null) {
            RemoteDataSource.getInstance().getPopularDetail(popular!!.id).enqueue(object :
                Callback<PopularDetailResponse> {
                override fun onResponse(call: Call<PopularDetailResponse>, response: Response<PopularDetailResponse>) {
                    response.body()?.let {
                        setPopular(Mapper.toPopularDetail(it))
                    }
                }

                override fun onFailure(call: Call<PopularDetailResponse>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            RemoteDataSource.getInstance().getLatestDetail(latest!!.id).enqueue(object :
                Callback<LatestDetailResponse> {
                override fun onResponse(call: Call<LatestDetailResponse>, response: Response<LatestDetailResponse>) {
                    response.body()?.let {
                        setLatest(Mapper.toLatestDetail(it))
                    }
                }

                override fun onFailure(call: Call<LatestDetailResponse>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun setPopular(popular: Popular) {
        with(binding) {
            Glide.with(root.context).load("${Const.baseImageUrl}${popular.backgroundimage}")
                .error(R.drawable.ic_baseline_cancel_24
                ).into(imgBackground)
            tvName.text = popular.name
            tvReleased.text = popular.released
            tvDescription.text=popular.description
        }
    }

    private fun setLatest(latest: Latest) {
        with(binding) {

            Glide.with(root.context).load("${Const.baseImageUrl}${latest.backgroundimage}").error(R.drawable.ic_baseline_cancel_24).into(imgBackground)
            tvName.text = latest.name
            tvReleased.text = latest.released
            tvDescription.text=latest.description
        }
    }

    private fun initIntent() {
        popular = intent.getParcelableExtra(POPULAR_EXTRA)
        latest = intent.getParcelableExtra(LATEST_EXTRA)
    }

}