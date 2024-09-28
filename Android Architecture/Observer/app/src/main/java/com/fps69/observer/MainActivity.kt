package com.fps69.observer

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        lifecycle.addObserver(Observer()) // Here we are adding observer
                                          // Yha hamlog muiltiple observer add kr skte hai


        Log.d("abhi","OnCreate of activity called")
    }


    override fun onResume() {
        super.onResume()
        Log.d("abhi","OnResume of activity called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("abhi","OnPause of activity called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("abhi","OnStop of activity called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abhi","OnDestroy of activity called")
    }
}



/*
>>>
*/





/*
  In Android development, Lifecycle-aware components are components that are
  designed to perform actions in response to changes in the lifecycle state of
  activities or fragments. They help manage tasks that should be started or stopped
  at specific points in the lifecycle, like registering listeners, starting data loading,
  or pausing ongoing processes when an activity or fragment is no longer visible.

    Android introduced the Lifecycle library as part of Android Jetpack, which allows
    components to be aware of the lifecycle state of the activity or fragment they're
    associated with. Here's an overview of how it works:

Key Concepts:
LifecycleOwner:

>>> An interface that represents a class that has an Android
    lifecycle, such as an activity or fragment.
>>> Activity and Fragment are LifecycleOwners by default.



Lifecycle:
>>> Represents the lifecycle of a component, and it can be in various states
    like CREATED, STARTED, RESUMED, DESTROYED, etc.
>>> The Lifecycle object can notify other objects about state changes.


LifecycleObserver:
>>> An interface that can be implemented by classes that want to
    observe lifecycle events.
>>> LifecycleObservers can register with a LifecycleOwner, and their
    methods will be triggered by lifecycle changes.


Common Lifecycle-aware Components:
>>> LiveData: It observes changes in data while being aware of the lifecycle of
    the activity or fragment. It updates only when the LifecycleOwner is in an
    active state (e.g., STARTED or RESUMED).
>>> ViewModel: It survives configuration changes (like screen rotations) and is aware
    of the activity or fragment lifecycle. It is designed to store and manage UI-related
    data in a lifecycle-conscious way.
>>> Coroutines: Lifecycle can be used in combination with Kotlin coroutines to
    launch coroutines that automatically cancel when the lifecycle is destroyed.


Benefits:
>>> Automatic lifecycle management: They automatically clean up
    resources or pause tasks when the lifecycle is destroyed.
>>> Less boilerplate code: You don't need to manually manage
    lifecycle states (e.g., start and stop tasks in onStart() or onStop()).
>>> Increased code reliability: Helps avoid memory leaks and other
    common lifecycle-related issues.



*/