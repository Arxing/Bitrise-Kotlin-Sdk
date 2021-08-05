package org.arxing.bitrisesdk.core.model.response.user

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.PlanEntity

data class GetMyPlanEntity(
  @SerializedName("data") val `data`: Data
) {
  data class Data(
    @SerializedName("current_plan") val currentPlan: PlanEntity,
    @SerializedName("pending_plan") val pendingPlan: PlanEntity?,
    @SerializedName("trial_expires_at") val trialExpiresAt: String?
  )
}
