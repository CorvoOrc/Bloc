package com.example.witcherbestiary.app

import android.os.Bundle
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.example.bloc.description.DescriptionGraph
import com.example.witcherbestiary.app.di.AppAssembler
import com.example.witcherbestiary.app.di.DaggerAppAssembler
import com.example.witcherbestiary.root.BestiaryRootComponent
import com.example.bloc.value.RootInitialValue
import com.example.bloc.view.ActivityBase
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import com.example.witcherbestiary.root.di.RootAssembler
import com.example.witcherbestiary.ui.WitcherBestiaryTheme
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import com.example.witcherbestiary.root.BestiaryRootComponent.Input as Input
import com.example.witcherbestiary.root.BestiaryRootComponent.Output as Output

class MainActivity : ActivityBase<DescriptionGraph<BestiaryRootDescription>, RootAssembler.Factory, AppAssembler, BestiaryRootComponent>() {//AppCompatActivity() {
    override val assembler: AppAssembler = DaggerAppAssembler.factory().create(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WitcherBestiaryTheme {
                Surface {
                    rootComponent.view.render()
                }
            }
        }
    }

    override fun createComponent(initialValue: RootInitialValue): BestiaryRootComponent {
        val rootInput = BroadcastChannel<Input>(Channel.BUFFERED)
        val rootOutput = BroadcastChannel<Output>(Channel.BUFFERED)
        return assembler.rootFactory()
            .create(rootInput.openSubscription(), rootOutput, assembler.descriptionGraph.rootComponent, lifecycle, initialValue)
            .createComponent()
    }
}