package com.verticalautomotive.android.di

import com.verticalautomotive.android.presentation.phone_login.PhoneLoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::PhoneLoginViewModel)
}