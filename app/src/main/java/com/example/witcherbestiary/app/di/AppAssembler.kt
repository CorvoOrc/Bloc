package com.example.witcherbestiary.app.di

import android.content.Context
import com.example.bloc.description.DescriptionGraph
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import com.example.witcherbestiary.root.di.RootAssembler
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DescriptionGraphModule::class,
        DatabaseModule::class,
        SubcomponentsModule::class
    ]
)
interface AppAssembler : com.example.bloc.di.AppAssembler<DescriptionGraph<BestiaryRootDescription>, RootAssembler.Factory> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppAssembler
    }
}