package com.example.bloc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bloc.component.RootComponent
import com.example.bloc.description.DescriptionGraph
import com.example.bloc.di.AppAssembler
import com.example.bloc.value.RootInitialValue
import com.example.bloc.value.RootInitialValueImpl

abstract class ActivityBase <TDescriptionGraph : DescriptionGraph<*>, TFactory : Any, TAssembler : AppAssembler<TDescriptionGraph, TFactory>, TRootComponent: RootComponent<*, *, *>> : AppCompatActivity() {
    abstract val assembler: TAssembler

    protected lateinit var rootComponent: TRootComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        val initialValue: RootInitialValue =
            if (savedInstanceState?.getParcelable<RootInitialValue>(assembler.descriptionGraph.rootComponent.id) != null)
                savedInstanceState!!.getParcelable(assembler.descriptionGraph.rootComponent.id)!!
            else
                RootInitialValueImpl()

        rootComponent = createComponent(initialValue)
        rootComponent.init()

        super.onCreate(savedInstanceState)
    }

    protected abstract fun createComponent(initialValue: RootInitialValue) : TRootComponent

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(assembler.descriptionGraph.rootComponent.id, rootComponent.getParcel())
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (rootComponent.router.state.value.stack.size > 1)
            rootComponent.router.pop()
        else
            super.onBackPressed()
    }
}