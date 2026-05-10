package com.verticalautomotive.android.di

import com.verticalautomotive.android.domain.use_case.ValidateEmailUseCase
import com.verticalautomotive.android.presentation.email_login.EmailLoginViewModel
import com.verticalautomotive.android.presentation.home.HomeViewModel
import com.verticalautomotive.android.presentation.phone_login.PhoneLoginViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factoryOf(::ValidateEmailUseCase)
    viewModelOf(::PhoneLoginViewModel)
    viewModelOf(::EmailLoginViewModel)
    viewModelOf(::HomeViewModel)
}