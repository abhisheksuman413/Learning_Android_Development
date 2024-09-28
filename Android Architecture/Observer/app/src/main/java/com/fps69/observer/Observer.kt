package com.fps69.observer

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun OnCreateCalled(){
        Log.d("abhi","OnCreate of observer called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun OnResumeCalled(){
        Log.d("abhi","OnResume of observer called")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun OnPauseCalled(){
        Log.d("abhi","OnPause of observer called")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun OnStopCalled(){
        Log.d("abhi","OnStop of observer called")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun OnDestroyCalled(){
        Log.d("abhi","OnDestroy of observer called")
    }
}