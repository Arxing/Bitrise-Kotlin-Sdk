package org.arxing.bitrisesdk.core.model.response.application
import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.AppEntity

data class GetAppEntity(
  @SerializedName("data") val `data`: AppEntity
)
