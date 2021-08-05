package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.BuildEntity

data class GetBuildEntity(
  @SerializedName("data") val `data`: BuildEntity
)
