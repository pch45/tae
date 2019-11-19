package com.example.kphomework

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImageSearchService {
    @GET("/v2/search/image")
    suspend fun getImage(@Header("Authorization") key: String, @Query("query") query: String): Response
}

interface LottoService {
    @GET("/common.do")
    suspend fun getLotto(@Query("method") method: String, @Query("drwNo") num: Int): LottoResponse
}

data class LottoResponse(
    @SerializedName("returnValue") private val returnValue: Boolean, //결과 값
    @SerializedName("totSellamnt") private val totSellamnt : Long, //누적 상금
    @SerializedName("drNo") private val drwNo : Int, //로또회차
    @SerializedName("drwNoDate")private val drwNoDate : String, //로또당첨일시
    @SerializedName("firstWinamnt") private val firstWinamnt : Long ,//1등 당첨금
    @SerializedName("firstPrzwnerCo") private val firstPrzwnerCo : Int, //1등 당첨 인원
    @SerializedName("firstAccumamnt") private val firstAccumamnt : Long, //1등 당첨금 총액
    @SerializedName("drwtNo1") private val drwtNo1 : Int,
    @SerializedName("drwtNo2") private val drwtNo2 : Int,
    @SerializedName("drwtNo3") private val drwtNo3 : Int,
    @SerializedName("drwtNo4") private val drwtNo4 : Int,
    @SerializedName("drwtNo5") private val drwtNo5 : Int,
    @SerializedName("drwtNo6") private val drwtNo6 : Int,
    @SerializedName("bnusNo") private val bnusNo : Int
)