package com.example.movieappmad24.logic

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@Composable
fun TrailerPlayer(filename: String){
    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }

    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(filename, "raw", context.packageName)

    val mediaItem =
        MediaItem.fromUri("android.resource://${context.packageName}/$resourceId")

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
            val observer = LifecycleEventObserver { _, event -> lifecycle = event  }
       lifecycleOwner.lifecycle.addObserver(observer)

        onDispose { exoPlayer.release()
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    AndroidView(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(18f / 9f),
        factory = {
            PlayerView(context).also { playerView -> playerView.player = exoPlayer

            }
        }, update = {
            when(lifecycle){
          Lifecycle.Event.ON_RESUME -> {
              it.onPause()
              it.player?.pause()
          }
            Lifecycle.Event.ON_PAUSE -> {
                it.onResume()
            } else -> Unit

        }})

}


/*
@Composable
@Preview
fun videotest(){
    //Surface(modifier = Modifier.fillMaxSize()){
    TrailerPlayer(filename = "R.raw.trailer_placeholder")
    //Text("ich bin ein Test")
    //}

}*/