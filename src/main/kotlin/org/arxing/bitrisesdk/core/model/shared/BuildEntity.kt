package org.arxing.bitrisesdk.core.model.shared

import com.google.gson.annotations.SerializedName

data class BuildEntity(
  @SerializedName("abort_reason") val abortReason: String?,
  @SerializedName("branch") val branch: String,
  @SerializedName("build_number") val buildNumber: Int,
  @SerializedName("commit_hash") val commitHash: String,
  @SerializedName("commit_message") val commitMessage: String,
  @SerializedName("commit_view_url") val commitViewUrl: String,
  @SerializedName("credit_cost") val creditCost: Long?,
  @SerializedName("environment_prepare_finished_at") val environmentPrepareFinishedAt: String,
  @SerializedName("finished_at") val finishedAt: String,
  @SerializedName("is_on_hold") val isOnHold: Boolean,
  @SerializedName("machine_type_id") val machineTypeId: String,
  @SerializedName("original_build_params") val originalBuildParams: OriginalBuildParamsEntity,
  @SerializedName("pull_request_id") val pullRequestId: Int,
  @SerializedName("pull_request_target_branch") val pullRequestTargetBranch: String,
  @SerializedName("pull_request_view_url") val pullRequestViewUrl: String,
  @SerializedName("repository") val repository: RepositoryEntity?,
  @SerializedName("slug") val slug: String,
  @SerializedName("stack_identifier") val stackIdentifier: String,
  @SerializedName("started_on_worker_at") val startedOnWorkerAt: String?,
  @SerializedName("status") val status: Int,
  @SerializedName("status_text") val statusText: String,
  @SerializedName("tag") val tag: String?,
  @SerializedName("triggered_at") val triggeredAt: String,
  @SerializedName("triggered_by") val triggeredBy: String,
  @SerializedName("triggered_workflow") val triggeredWorkflow: String
) {
  data class OriginalBuildParamsEntity(
    @SerializedName("base_repository_url") val baseRepositoryUrl: String,
    @SerializedName("branch") val branch: String,
    @SerializedName("branch_dest") val branchDest: String,
    @SerializedName("branch_dest_repo_owner") val branchDestRepoOwner: String,
    @SerializedName("branch_repo_owner") val branchRepoOwner: String,
    @SerializedName("commit_hash") val commitHash: String,
    @SerializedName("commit_message") val commitMessage: String,
    @SerializedName("commit_paths") val commitPaths: Any?,
    @SerializedName("diff_url") val diffUrl: String,
    @SerializedName("head_repository_url") val headRepositoryUrl: String,
    @SerializedName("pull_request_author") val pullRequestAuthor: String,
    @SerializedName("pull_request_head_branch") val pullRequestHeadBranch: String,
    @SerializedName("pull_request_id") val pullRequestId: Int,
    @SerializedName("pull_request_merge_branch") val pullRequestMergeBranch: String,
    @SerializedName("pull_request_repository_url") val pullRequestRepositoryUrl: String
  )

  data class RepositoryEntity(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("is_disabled") val isDisabled: Boolean,
    @SerializedName("is_public") val isPublic: Boolean,
    @SerializedName("owner") val owner: OwnerAccountEntity?,
    @SerializedName("project_type") val projectType: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("repo_owner") val repoOwner: String,
    @SerializedName("repo_slug") val repoSlug: String,
    @SerializedName("repo_url") val repoUrl: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("status") val status: Int,
    @SerializedName("title") val title: String
  )
}
