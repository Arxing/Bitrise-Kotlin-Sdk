package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class CommitPathEntity(
  @SerializedName("added") val added: List<String>,
  @SerializedName("modified") val modified: List<String>,
  @SerializedName("removed") val removed: List<String>
)
