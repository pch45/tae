package com.example.kphomework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dapi.kakao.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitService(): ImageSearchService {
        return retrofit.create(ImageSearchService::class.java)
    }

    fun getRetrofitService2(): LottoService {
        return Retrofit.Builder().baseUrl("https://www.dhlottery.co.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LottoService::class.java)
    }
}