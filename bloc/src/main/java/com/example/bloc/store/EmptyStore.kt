package com.example.bloc.store

class EmptyStore(initialValue: Any) : StoreBase<Any, Any>(initialValue) {
    override fun init() {}

    override fun execute(intent: Any) {
        TODO("EmptyStore cant execute its just stub")
    }

    override fun destroy() {}
}