package org.arxing.bitrisesdk.core.model.response.builds

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.BuildEntity
import org.arxing.bitrisesdk.core.model.shared.PagingEntity

data class GetBuildsEntity(
  @SerializedName("data") val `data`: List<BuildEntity>,
  @SerializedName("paging") val paging: PagingEntity
) {
}
