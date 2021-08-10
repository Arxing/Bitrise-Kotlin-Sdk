package org.arxing.bitrisesdk.core.service

import okhttp3.ResponseBody
import org.arxing.bitrisesdk.core.Constants.API_VERSION
import org.arxing.bitrisesdk.core.Constants.APP_SLUG
import org.arxing.bitrisesdk.core.Constants.LIMIT
import org.arxing.bitrisesdk.core.Constants.NEXT
import org.arxing.bitrisesdk.core.Constants.ORG_SLUG
import org.arxing.bitrisesdk.core.Constants.SORT_BY
import org.arxing.bitrisesdk.core.Constants.USER_SLUG
import org.arxing.bitrisesdk.core.model.response.application.GetAppBranchesEntity
import org.arxing.bitrisesdk.core.model.response.application.GetAppEntity
import org.arxing.bitrisesdk.core.model.response.application.GetAppsEntity
import org.arxing.bitrisesdk.core.model.response.application.GetAppsOfOrganizationEntity
import org.arxing.bitrisesdk.core.model.response.application.GetAppsOfUserEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import org.arxing.bitrisesdk.core.result.Result

interface ApplicationService {

  @GET("/v$API_VERSION/apps")
  suspend fun getApps(
    @Query(SORT_BY) sortBy: String? = null,
    @Query(NEXT) next: String? = null,
    @Query(LIMIT) limit: Int? = null,
  ): Result<GetAppsEntity>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}")
  suspend fun getApp(
    @Path(APP_SLUG) appSlug: String,
  ): Result<GetAppEntity>

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/bitrise.yml")
  suspend fun getAppBitriseYml(
    @Path(APP_SLUG) appSlug: String,
  ): ResponseBody

  @GET("/v$API_VERSION/apps/{$APP_SLUG}/branches")
  suspend fun getAppBranches(
    @Path(APP_SLUG) appSlug: String,
  ): Result<GetAppBranchesEntity>

  @GET("/v$API_VERSION/organizations/{$ORG_SLUG}/apps")
  suspend fun getAppsOfOrganization(
    @Path(ORG_SLUG) orgSlug: String,
    @Query(SORT_BY) sortBy: String? = null,
    @Query(NEXT) next: String? = null,
    @Query(LIMIT) limit: Int? = null,
  ): Result<GetAppsOfOrganizationEntity>

  @GET("/v$API_VERSION/users/{$USER_SLUG}/apps")
  suspend fun getAppsOfUser(
    @Path(USER_SLUG) userSlug: String,
    @Query(SORT_BY) sortBy: String? = null,
    @Query(NEXT) next: String? = null,
    @Query(LIMIT) limit: Int? = null,
  ): Result<GetAppsOfUserEntity>
}
