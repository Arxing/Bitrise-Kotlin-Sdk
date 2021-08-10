package org.arxing.bitrisesdk.core.model.error

import com.google.gson.annotations.SerializedName

data class BitriseErrorEntity(
  @SerializedName("message") val message: String
)
