package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class AppEntity(
  @SerializedName("avatar_url") val avatarUrl: String?,
  @SerializedName("is_disabled") val isDisabled: Boolean,
  @SerializedName("is_public") val isPublic: Boolean,
  @SerializedName("owner") val owner: OwnerAccountEntity?,
  @SerializedName("project_type") val projectType: String?,
  @SerializedName("provider") val provider: String?,
  @SerializedName("repo_owner") val repoOwner: String?,
  @SerializedName("repo_slug") val repoSlug: String?,
  @SerializedName("repo_url") val repoUrl: String?,
  @SerializedName("slug") val slug: String,
  @SerializedName("status") val status: Int,
  @SerializedName("title") val title: String
)
