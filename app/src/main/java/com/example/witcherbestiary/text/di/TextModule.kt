package com.example.witcherbestiary.text.di

import com.example.witcherbestiary.text.TextComponent
import com.example.witcherbestiary.text.TextComponentImpl
import com.example.witcherbestiary.text.store.TextStore
import com.example.witcherbestiary.text.store.TextStoreImpl
import com.example.witcherbestiary.text.view.TextView
import com.example.witcherbestiary.text.view.TextViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class TextModule {
    @Binds
    abstract fun bindComponent(component: TextComponentImpl): TextComponent

    @Binds
    abstract fun bindStore(store: TextStoreImpl): TextStore

    @Binds
    abstract fun bindView(view: TextViewImpl): TextView
}