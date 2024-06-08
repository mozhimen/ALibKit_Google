package com.mozhimen.libk.google.firebase.auth.mos

/**
 * @ClassName AuthGoogleRes
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/10
 * @Version 1.0
 */
data class AuthGoogleRes(
    val isAnonymous: Boolean?,
    val tenantId: String?,
    val displayName: String?,
    val email: String?,
    val phoneNumber: String?,
    val photoUrl: String?,
    val providerId: String?,
    val uid: String?
)