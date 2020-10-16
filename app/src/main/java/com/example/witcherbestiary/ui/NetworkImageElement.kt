package com.example.witcherbestiary.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.graphics.drawscope.drawCanvas
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.ContextAmbient
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// adapted from https://github.com/vinaygaba/Learn-Jetpack-Compose-By-Example/blob/f585049555838a69909b9c9dd92619f89f89769e/app/src/main/java/com/example/jetpackcompose/image/ImageActivity.kt#L223
@Composable
fun NetworkImage(url: String, modifier: Modifier = Modifier) {
    WithConstraints() {
        var image = remember { mutableStateOf<ImageAsset?>(null) }
        var drawable = remember { mutableStateOf<Drawable?>(null) }
        val context = ContextAmbient.current
        onCommit(url) {
            val glide = Glide.with(context)
            var target: CustomTarget<Bitmap>? = null
            var job = CoroutineScope(Dispatchers.Main).launch {
                target = object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        image.value = null
                        drawable.value = placeholder
                    }

                    override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
                        FrameManager.ensureStarted()
                        image.value = bitmap.asImageAsset()
                    }
                }

                glide
                        .asBitmap()
                        .load(url)
                        .override(constraints.maxWidth, constraints.maxHeight)
                        .into(target!!)
            }

            onDispose {
                image.value = null
                drawable.value = null
                glide.clear(target)
                job.cancel()
            }
        }

        val theImage = image
        val theDrawable = drawable
        if (theImage.value != null) {
            Image(asset = theImage.value!!, modifier = modifier)
        } else if (theDrawable.value != null) {
            Canvas(modifier = modifier) {
                drawIntoCanvas { canvas ->
                    theDrawable.value?.draw(canvas.nativeCanvas)
                }
            }
        }
    }
}