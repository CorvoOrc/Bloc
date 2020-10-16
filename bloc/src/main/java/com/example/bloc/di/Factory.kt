package com.example.bloc.di

interface Factory<TItem> {
    fun build(key: String): TItem
}