package org.arxing.bitrisesdk.core.model.error

data class BitriseError(
  val errorCode: Int,
  val errorEntity: BitriseErrorEntity
) : Error(errorEntity.message)
