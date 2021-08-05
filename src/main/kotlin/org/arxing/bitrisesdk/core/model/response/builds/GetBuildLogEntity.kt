package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName

data class GetBuildLogEntity(
  @SerializedName("expiring_raw_log_url") val expiringRawLogUrl: String,
  @SerializedName("is_archived") val isArchived: Boolean,
  @SerializedName("log_chunks") val logChunks: List<LogChunkEntity>,
  @SerializedName("next_after_timestamp") val nextAfterTimestamp: String,
  @SerializedName("next_before_timestamp") val nextBeforeTimestamp: String
) {
  data class LogChunkEntity(
    @SerializedName("chunk") val chunk: String,
    @SerializedName("position") val position: Int
  )
}
