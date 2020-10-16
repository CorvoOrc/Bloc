package com.example.bloc.component

import android.os.Parcelable
import com.example.bloc.description.RootDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.router.Router
import com.example.bloc.store.Store
import com.example.bloc.value.RootInitialValue
import com.example.bloc.view.View

abstract class RootComponentBase<TViewDescription : ViewDescription,
        TDescription : RootDescription<TViewDescription>,
        TView : View<TViewDescription>,
        TStore : Store<*, *>>
(
        description: TDescription,
        val initialValue: RootInitialValue,
        store: TStore,
        view: TView,
        override val router: Router
) : ComponentBase<TViewDescription, TDescription, TView, TStore>(description, store, view), RootComponent<TViewDescription, TDescription, TView> {
    override fun init() {
        super.init()

        router.init(::route, initialValue.router, description.initialComponent)
    }

    protected abstract fun route(node: String, initialValue: Parcelable?) : Component<*, *, *>

    override fun destroy() {
        while (router.state.value.top != null)
            router.pop().destroy()

        super.destroy()
    }
}