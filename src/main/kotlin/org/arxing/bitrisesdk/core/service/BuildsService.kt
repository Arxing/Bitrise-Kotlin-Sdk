package org.arxing.bitrisesdk.core.service

import org.arxing.bitrisesdk.core.Constants.AFTER
import org.arxing.bitrisesdk.core.Constants.API_VERSION
import org.arxing.bitrisesdk.core.Constants.APP_SLUG
import org.arxing.bitrisesdk.core.Constants.BEFORE
import org.arxing.bitrisesdk.core.Constants.BRANCH
import org.arxing.bitrisesdk.core.Constants.BUILD_NUMBER
import org.arxing.bitrisesdk.core.Constants.BUILD_SLUG
import org.arxing.bitrisesdk.core.Constants.COMMIT_MESSAGE
import org.arxing.bitrisesdk.core.Constants.IS_ON_HOLD
import org.arxing.bitrisesdk.core.Constants.LIMIT
import org.arxing.bitrisesdk.core.Constants.NEXT
import org.arxing.bitrisesdk.core.Constants.OWNER_SLUG
import org.arxing.bitrisesdk.core.Constants.PULL_REQUEST_ID
import org.arxing.bitrisesdk.core.Constants.SORT_BY
import org.arxing.bitrisesdk.core.Constants.STATUS
import org.arxing.bitrisesdk.core.Constants.TRIGGER_EVENT_TYPE
import org.arxing.bitrisesdk.core.Constants.WORKFLOW
import org.arxing.bitrisesdk.core.model.request.AbortBuildRequestBody
import org.arxing.bitrisesdk.core.model.request.TriggerBuildRequestBody
import org.arxing.bitrisesdk.core.model.response.builds.GetBuildEntity
import org.arxing.bitrisesdk.core.model.response.builds.GetBuildLogEntity
import org.arxing.bitrisesdk.core.model.response.builds.GetBuildsEntity
import org.arxing.bitrisesdk.core.model.response.builds.GetBuildsOfAppEntity
import org.arxing.bitrisesdk.core.model.response.builds.GetWorkflowsEntity
import org.arxing.bitrisesdk.core.model.response.builds.TriggerBuildEntity
import org.arxing.bitrisesdk.core.result.SimpleResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BuildsService {

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/build-workflows")
  suspend fun getWorkflows(
    @Path(APP_SLUG) appSlug: String,
  ): SimpleResult<GetWorkflowsEntity>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/builds")
  suspend fun getBuildsOfApp(
    @Path(APP_SLUG) appSlug: String,
    @Query(SORT_BY) sortBy: String? = null,
    @Query(NEXT) next: String? = null,
    @Query(LIMIT) limit: Int? = null,
    @Query(BRANCH) branch: String? = null,
    @Query(WORKFLOW) workflow: String? = null,
    @Query(COMMIT_MESSAGE) commitMessage: String? = null,
    @Query(TRIGGER_EVENT_TYPE) triggerEventType: String? = null,
    @Query(PULL_REQUEST_ID) pullRequestId: Int? = null,
    @Query(BUILD_NUMBER) buildNumber: Int? = null,
    @Query(AFTER) after: Int? = null,
    @Query(BEFORE) before: Int? = null,
    @Query(STATUS) status: Int? = null,
  ): SimpleResult<GetBuildsOfAppEntity>

  @POST("/v$API_VERSION/apps/{$APP_SLUG}/builds")
  suspend fun triggerBuild(
    @Path(APP_SLUG) appSlug: String,
    @Body body: TriggerBuildRequestBody,
  ): SimpleResult<TriggerBuildEntity>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/builds/{$BUILD_SLUG}")
  suspend fun getBuild(
    @Path(APP_SLUG) appSlug: String,
    @Path(BUILD_SLUG) buildSlug: String,
  ): SimpleResult<GetBuildEntity>

  @POST("/v$API_VERSION/apps/{$APP_SLUG}/builds/{$BUILD_SLUG}/abort")
  suspend fun abortBuild(
    @Path(APP_SLUG) appSlug: String,
    @Path(BUILD_SLUG) buildSlug: String,
    @Body body: AbortBuildRequestBody,
  ): SimpleResult<String>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/builds/{$BUILD_SLUG}/bitrise.yml")
  suspend fun getBitriseYmlOfBuild(
    @Path(APP_SLUG) appSlug: String,
    @Path(BUILD_SLUG) buildSlug: String,
  ): SimpleResult<String>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/builds/{$BUILD_SLUG}/log")
  suspend fun getBuildLog(
    @Path(APP_SLUG) appSlug: String,
    @Path(BUILD_SLUG) buildSlug: String,
  ): SimpleResult<GetBuildLogEntity>

  @GET("/v$API_VERSION/builds")
  suspend fun getBuilds(
    @Query(OWNER_SLUG) ownerSlug: String? = null,
    @Query(IS_ON_HOLD) isOnHold: Boolean? = null,
    @Query(STATUS) status: Int? = null,
    @Query(NEXT) next: String? = null,
    @Query(LIMIT) limit: Int? = null,
  ): SimpleResult<GetBuildsEntity>
}
