package org.arxing.bitrisesdk.core.service

import org.arxing.bitrisesdk.core.Constants.ADDON_ID
import org.arxing.bitrisesdk.core.Constants.API_VERSION
import org.arxing.bitrisesdk.core.Constants.USER_SLUG
import org.arxing.bitrisesdk.core.model.response.user.GetMyActiveAddonTokensEntity
import org.arxing.bitrisesdk.core.model.response.user.GetMyPlanEntity
import org.arxing.bitrisesdk.core.model.response.user.GetMyProfileEntity
import org.arxing.bitrisesdk.core.model.response.user.GetUserEntity
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.Result

interface UserService {

  @GET("/v${API_VERSION}/me")
  suspend fun getMyProfile(): Result<GetMyProfileEntity>

  @GET("/v${API_VERSION}/me/addon-tokens")
  suspend fun getMyActiveAddonTokens(): Result<GetMyActiveAddonTokensEntity>

  @DELETE("/v${API_VERSION}/me/addon-tokens/{$ADDON_ID}")
  suspend fun deleteMyActiveAddonToken(
    @Path(ADDON_ID) addonId: String,
  )

  @GET("/v${API_VERSION}/me/plan")
  suspend fun getMyPlan(): Result<GetMyPlanEntity>

  @GET("/v${API_VERSION}/users/{$USER_SLUG}")
  suspend fun getUser(
    @Path(USER_SLUG) userSlug: String
  ): Result<GetUserEntity>
}
