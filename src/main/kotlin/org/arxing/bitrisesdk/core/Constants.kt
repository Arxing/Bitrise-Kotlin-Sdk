package org.arxing.bitrisesdk.core

object Constants {
  const val API_VERSION = "0.1"

  /** Headers */
  const val AUTHORIZATION = "authorization"

  /** Paths */
  const val APP_SLUG = "app-slug"
  const val ORG_SLUG = "org-slug"
  const val USER_SLUG = "user-slug"
  const val BUILD_SLUG = "build-slug"
  const val ADDON_ID = "addon-id"

  /** Queries */
  const val SORT_BY = "sort_by"
  const val NEXT = "next"
  const val LIMIT = "limit"
  const val BRANCH = "branch"
  const val WORKFLOW = "workflow"
  const val COMMIT_MESSAGE = "commit_message"
  const val TRIGGER_EVENT_TYPE = "trigger_event_type"
  const val PULL_REQUEST_ID = "pull_request_id"
  const val BUILD_NUMBER = "build_number"
  const val AFTER = "after"
  const val BEFORE = "before"
  const val STATUS = "status"
  const val OWNER_SLUG = "owner_slug"
  const val IS_ON_HOLD = "is_on_hold"

  /** Bodies */
  const val BUILD_ABORT_PARAMS = "build-abort-params"
}