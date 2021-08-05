package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class UserEntity(
  @SerializedName("avatar_url") val avatarUrl: String,
  @SerializedName("created_at") val createdAt: String?,
  @SerializedName("data_id") val dataId: Int?,
  @SerializedName("email") val email: String?,
  @SerializedName("has_used_organization_trial") val hasUsedOrganizationTrial: Boolean?,
  @SerializedName("payment_processor") val paymentProcessor: String?,
  @SerializedName("slug") val slug: String,
  @SerializedName("username") val username: String
)
