package com.example.bloc.component

import android.os.Parcelable
import com.example.bloc.common.Initializable
import com.example.bloc.common.Destroyable
import com.example.bloc.description.ComponentDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.view.View

interface Component<TViewDescription : ViewDescription, TDescription: ComponentDescription<TViewDescription>, TView : View<TViewDescription>> : Initializable, Destroyable {
    val description: TDescription
    val view: TView

    fun getParcel(): Parcelable
}