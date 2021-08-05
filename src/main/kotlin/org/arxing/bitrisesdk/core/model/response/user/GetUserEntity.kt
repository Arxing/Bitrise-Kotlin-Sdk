package org.arxing.bitrisesdk.core.model.response.user

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.UserEntity

data class GetUserEntity(
  @SerializedName("data") val `data`: UserEntity
)
