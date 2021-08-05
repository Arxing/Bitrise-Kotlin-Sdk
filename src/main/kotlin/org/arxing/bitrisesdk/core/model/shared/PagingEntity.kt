package org.arxing.bitrisesdk.core.model.shared
import com.google.gson.annotations.SerializedName

data class PagingEntity(
  @SerializedName("next") val next: String?,
  @SerializedName("page_item_limit") val pageItemLimit: Int,
  @SerializedName("total_item_count") val totalItemCount: Int
)
