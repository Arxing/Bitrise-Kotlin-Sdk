package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class OwnerAccountEntity(
  @SerializedName("account_type") val accountType: String,
  @SerializedName("name") val name: String,
  @SerializedName("slug") val slug: String
)
