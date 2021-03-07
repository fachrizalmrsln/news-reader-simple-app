@file:Suppress("unused")

package com.fachrizalmrsln.component.base.di

import org.koin.core.module.Module

abstract class DiModuleContract {

    abstract fun remoteModule(): Module
    abstract fun repositoryModule(): Module
    abstract fun viewModelModule(): Module

    fun get(): List<Module> =  listOf(remoteModule(), repositoryModule(), viewModelModule())

}