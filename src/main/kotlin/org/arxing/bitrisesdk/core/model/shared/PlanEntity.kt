package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class PlanEntity(
  @SerializedName("container_count") val containerCount: Any,
  @SerializedName("expires_at") val expiresAt: Any,
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("price") val price: Long
)
