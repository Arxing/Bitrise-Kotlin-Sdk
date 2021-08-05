package org.arxing.bitrisesdk.core.model.request

import com.google.gson.annotations.SerializedName

data class AbortBuildRequestBody(
    @SerializedName("abort_reason") val abortReason: String,
    @SerializedName("abort_with_success") val abortWithSuccess: Boolean = true,
    @SerializedName("skip_notifications") val skipNotifications: Boolean = true,
)
