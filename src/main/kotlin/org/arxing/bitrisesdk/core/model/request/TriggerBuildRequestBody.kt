package org.arxing.bitrisesdk.core.model.request

import com.google.gson.annotations.SerializedName
import org.arxing.bitrisesdk.core.model.shared.CommitPathEntity

data class TriggerBuildRequestBody(
  @SerializedName("build_params") val buildParams: TriggerBuildParams,
  @SerializedName("hook_info") val hookInfo: HookInfo,
) {
  data class TriggerBuildParams(
    @SerializedName("base_repository_url") val baseRepositoryUrl: String? = null,
    @SerializedName("branch") val branch: String? = null,
    @SerializedName("branch_dest") val branchDest: String? = null,
    @SerializedName("branch_dest_repo_owner") val branchDestRepoOwner: String? = null,
    @SerializedName("branch_repo_owner") val branchRepoOwner: String? = null,
    @SerializedName("build_request_slug") val buildRequestSlug: String? = null,
    @SerializedName("commit_hash") val commitHash: String? = null,
    @SerializedName("commit_message") val commitMessage: String? = null,
    @SerializedName("commit_paths") val commitPaths: List<CommitPathEntity>? = null,
    @SerializedName("diff_url") val diffUrl: String? = null,
    @SerializedName("environments") val environments: List<Environment>? = null,
    @SerializedName("head_repository_url") val headRepositoryUrl: String? = null,
    @SerializedName("pull_request_author") val pullRequestAuthor: String? = null,
    @SerializedName("pull_request_head_branch") val pullRequestHeadBranch: String? = null,
    @SerializedName("pull_request_id") val pullRequestId: Int? = null,
    @SerializedName("pull_request_merge_branch") val pullRequestMergeBranch: String? = null,
    @SerializedName("pull_request_repository_url") val pullRequestRepositoryUrl: String? = null,
    @SerializedName("skip_git_status_report") val skipGitStatusReport: Boolean? = null,
    @SerializedName("tag") val tag: String? = null,
    @SerializedName("workflow_id") val workflowId: String? = null,
  ) {

    data class Environment(
      @SerializedName("is_expand") val isExpand: Boolean? = null,
      @SerializedName("mapped_to") val mappedTo: String,
      @SerializedName("value") val value: String
    )
  }

  data class HookInfo(
    @SerializedName("type") val type: String,
  )
}
