package org.arxing.bitrisesdk.core.model.response.user

import com.google.gson.annotations.SerializedName

data class GetMyActiveAddonTokensEntity(
  @SerializedName("active_tokens") val activeTokens: List<String>,
  @SerializedName("offline_tokens") val offlineTokens: List<String>
)
