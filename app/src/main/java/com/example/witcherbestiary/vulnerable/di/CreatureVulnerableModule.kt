package com.example.witcherbestiary.vulnerable.di

import com.example.witcherbestiary.vulnerable.CreatureVulnerableComponent
import com.example.witcherbestiary.vulnerable.CreatureVulnerableComponentImpl
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStoreImpl
import com.example.witcherbestiary.vulnerable.view.CreatureVulnerableView
import com.example.witcherbestiary.vulnerable.view.CreatureVulnerableViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class CreatureVulnerableModule {
    @Binds
    abstract fun bindComponent(component: CreatureVulnerableComponentImpl): CreatureVulnerableComponent

    @Binds
    abstract fun bindStore(store: CreatureVulnerablesStoreImpl): CreatureVulnerablesStore

    @Binds
    abstract fun bindView(view: CreatureVulnerableViewImpl): CreatureVulnerableView
}