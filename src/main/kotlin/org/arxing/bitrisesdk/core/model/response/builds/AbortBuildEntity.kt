package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName

data class AbortBuildEntity(
  @SerializedName("status") val status: String
)
