package com.example.kphomework

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("pageable_count") val pageableCount: Int,
    @SerializedName("is_end") val isEnd: Boolean
)

data class ImageSearchEntity(
    @SerializedName("collection") val collection: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
@SerializedName("image_url") val imageUrl: String,
@SerializedName("width") val width: Int,
@SerializedName("height") val height: Int,
@SerializedName("display_sitename") val sitename: String,
@SerializedName("doc_url") val docUrl: String,
@SerializedName("datetime") val datetime: String
)

data class Response(
    @SerializedName("meta") val meta: MetaData,
    @SerializedName("documents") val resultList: List<ImageSearchEntity>
)