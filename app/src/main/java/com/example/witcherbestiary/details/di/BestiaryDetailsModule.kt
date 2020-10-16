package com.example.witcherbestiary.details.di

import com.example.witcherbestiary.details.BestiaryDetailsComponent
import com.example.witcherbestiary.details.BestiaryDetailsComponentImpl
import com.example.witcherbestiary.details.view.BestiaryDetailsView
import com.example.witcherbestiary.details.view.BestiaryDetailsViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class BestiaryDetailsModule {
    @Binds
    abstract fun bindComponent(component: BestiaryDetailsComponentImpl): BestiaryDetailsComponent

    @Binds
    abstract fun bindView(view: BestiaryDetailsViewImpl): BestiaryDetailsView
}