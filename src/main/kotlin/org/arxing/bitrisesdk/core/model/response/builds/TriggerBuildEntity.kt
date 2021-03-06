package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName

data class TriggerBuildEntity(
  @SerializedName("build_number") val buildNumber: Int,
  @SerializedName("build_slug") val buildSlug: String,
  @SerializedName("build_url") val buildUrl: String,
  @SerializedName("message") val message: String?,
  @SerializedName("service") val service: String?,
  @SerializedName("slug") val slug: String,
  @SerializedName("status") val status: String?,
  @SerializedName("triggered_workflow") val triggeredWorkflow: String,
)
