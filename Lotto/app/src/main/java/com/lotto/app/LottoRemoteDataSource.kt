package com.lotto.app

import retrofit2.http.GET
import retrofit2.http.Query

interface LottoRemoteDataSource {
    @GET("/common.do")
    suspend fun getLotto(@Query("method") method: String, @Query("drwNo") num: Int): LottoResponse
}