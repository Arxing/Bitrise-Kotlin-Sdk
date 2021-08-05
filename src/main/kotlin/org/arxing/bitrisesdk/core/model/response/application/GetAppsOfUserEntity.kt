package org.arxing.bitrisesdk.core.model.response.application

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.AppEntity
import org.arxing.bitrisesdk.core.model.shared.PagingEntity

data class GetAppsOfUserEntity(
  @SerializedName("data") val `data`: List<AppEntity>,
  @SerializedName("paging") val paging: PagingEntity
)
