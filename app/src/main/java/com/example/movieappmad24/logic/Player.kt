package com.example.movieappmad24.logic

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

@Composable
fun player(uri: String): ExoPlayer {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(uri, "raw", context.packageName)
    val uri = Uri.parse("android.resource://${context.packageName}/$resourceId")
    val mediaItem = MediaItem.fromUri(uri)
    val player = remember { ExoPlayer.Builder(context).build().apply { setMediaItem(mediaItem)
        prepare() } }
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(player) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> player.play()
                Lifecycle.Event.ON_STOP -> player.pause()
                else -> Unit
            }
        }
        lifecycle.addObserver(lifecycleObserver)
    }
    return player
}

@Composable
fun view(uri: String){
    val player = player(uri = uri)

    AndroidView({ context ->
        val playerView = androidx.media3.ui.PlayerView(context)
        playerView.player = player
        playerView
    }, modifier = Modifier.fillMaxWidth())
}