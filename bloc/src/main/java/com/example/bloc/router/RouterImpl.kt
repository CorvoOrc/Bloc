package com.example.bloc.router

import android.os.Bundle
import android.os.Parcelable
import com.example.bloc.component.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import javax.inject.Inject
import com.example.bloc.router.Router.*
import com.example.bloc.value.InitialValue

class RouterImpl @Inject constructor(): Router {
    private val _state = MutableStateFlow(State(Stack<Component<*, *, *>>(), null))
    override val state: StateFlow<State> = _state

    private lateinit var route: (String, Parcelable?) -> Component<*, *, *>

    override fun init(routeCallback: (String, Parcelable?) -> Component<*, *, *>, parcel: Parcelable, initial: String) {
        route = routeCallback

        val stack = (parcel as Bundle).getStringArrayList("stack")
        if (stack != null)
            stack.forEach{ push(it, parcel.getParcelable(it)!!) }
        else
            push(initial, null)
    }

    override fun push(id: String, initialValue: InitialValue?) {
        val component = route(id, initialValue)
        val newStack = _state.value.stack
        newStack.push(component)
        _state.value = _state.value.copy(
                stack = newStack,
                top = component
        )
    }

    override fun pop(): Component<*, *, *> {
        val newStack = _state.value.stack
        val result = newStack.pop()

        _state.value = _state.value.copy(
                stack = newStack,
                top = if (newStack.size > 0) newStack.peek() else null
        )

        return result
    }

    override fun getParcel(): Parcelable {
        val parcel = Bundle()
        _state.value.stack.forEach{ parcel.putParcelable(it.description.id, it.getParcel()) }
        val arrayList = ArrayList<String>(_state.value.stack.map{ it.description.id })
        parcel.putStringArrayList("stack", arrayList)
        return parcel
    }
}