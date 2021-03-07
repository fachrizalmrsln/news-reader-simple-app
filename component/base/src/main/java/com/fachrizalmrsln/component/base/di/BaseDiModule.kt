@file:Suppress("unused", "USELESS_CAST")

package com.fachrizalmrsln.component.base.di

import com.fachrizalmrsln.component.base.network.NetworkStateManager
import com.fachrizalmrsln.component.base.network.NetworkStateManagerImpl
import com.fachrizalmrsln.component.base.network.createOkHttpClient
import org.koin.dsl.module

val baseNetwork = module {
    single<NetworkStateManager> { NetworkStateManagerImpl(get()) }
    single { createOkHttpClient() }
}