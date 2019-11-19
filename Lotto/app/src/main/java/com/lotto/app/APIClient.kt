package com.lotto.app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.dhlottery.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitService(): LottoRemoteDataSource {
        return retrofit.create(LottoRemoteDataSource::class.java)
    }
}