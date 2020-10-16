package com.example.bloc.store

import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

abstract class LabelStoreBase<TIntent : Any, TState : Any, TLabel: Any>(
        initialValue: TState
) : StoreBase<TIntent, TState>(initialValue), LabelStore<TIntent, TState, TLabel> {
    private val _labelChannel: BroadcastChannel<TLabel> = BroadcastChannel(Channel.BUFFERED)
    override val labelChannel: ReceiveChannel<TLabel> = _labelChannel.openSubscription()

    override fun mark(label: TLabel) {
        scope.launch {
            try {
                _labelChannel.send(label)
            }
            catch (e: Exception){
                println("mark exception: channel closed")
            }
        }
    }

    override fun destroy() {
        _labelChannel.close()

        super.destroy()
    }
}