package org.arxing.bitrisesdk.core.model.response.application

import com.google.gson.annotations.SerializedName

data class GetAppBranchesEntity(
  @SerializedName("data") val `data`: List<String>
)
