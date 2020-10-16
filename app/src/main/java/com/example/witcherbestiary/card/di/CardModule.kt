package com.example.witcherbestiary.card.di

import com.example.witcherbestiary.card.CardComponent
import com.example.witcherbestiary.card.CardComponentImpl
import com.example.witcherbestiary.card.store.CardStore
import com.example.witcherbestiary.card.store.CardStoreImpl
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.CardViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class CardModule {
    @Binds
    abstract fun bindComponent(component: CardComponentImpl): CardComponent

    @Binds
    abstract fun bindStore(store: CardStoreImpl): CardStore

    @Binds
    abstract fun bindView(view: CardViewImpl): CardView
}