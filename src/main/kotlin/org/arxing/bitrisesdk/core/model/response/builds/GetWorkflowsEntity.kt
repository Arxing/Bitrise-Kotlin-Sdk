package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName

data class GetWorkflowsEntity(
  @SerializedName("data") val `data`: List<String>
)
