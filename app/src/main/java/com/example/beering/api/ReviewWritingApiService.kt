package com.example.beering.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ReviewWritingApiService {
    @Multipart
    @POST("/members/{memberId}/drinks/{drinkId}/reviews")
    fun post(
        @Part("requestDto") requestDto: RequestBody, // 여기 RequestBody를 확인
        @Part reviewImages: List<MultipartBody.Part>,
        @Path(value = "memberId") memberId: Int,
        @Path(value = "drinkId") drinkId: Int
    ): Call<ReviewWritingResponse>
}