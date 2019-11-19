package com.lotto.app

import com.google.gson.annotations.SerializedName

data class LottoResponse(
    @SerializedName("returnValue")  val returnValue: String, //결과 값
    @SerializedName("totSellamnt")  val totSellamnt : Long, //누적 상금
    @SerializedName("drNo")  val drNo : Int, //로또회차
    @SerializedName("drwNoDate") val drwNoDate : String, //로또당첨일시
    @SerializedName("firstWinamnt")  val firstWinamnt : Long,//1등 당첨금
    @SerializedName("firstPrzwnerCo")  val firstPrzwnerCo : Int, //1등 당첨 인원
    @SerializedName("firstAccumamnt")  val firstAccumamnt : Long, //1등 당첨금 총액
    @SerializedName("drwtNo1")  val drwtNo1 : Int,
    @SerializedName("drwtNo2")  val drwtNo2 : Int,
    @SerializedName("drwtNo3")  val drwtNo3 : Int,
    @SerializedName("drwtNo4")  val drwtNo4 : Int,
    @SerializedName("drwtNo5")  val drwtNo5 : Int,
    @SerializedName("drwtNo6")  val drwtNo6 : Int,
    @SerializedName("bnusNo")  val bnusNo : Int
)