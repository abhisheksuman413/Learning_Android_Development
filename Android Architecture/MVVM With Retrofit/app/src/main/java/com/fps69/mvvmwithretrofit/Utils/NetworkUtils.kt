package com.fps69.mvvmwithretrofit.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkUtils {


//    companion object{
//
//
//        fun isNetworkAvailable(context: Context): Boolean {
//            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val network = connectivityManager.activeNetwork ?: return false
//            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
//
//            return when {
//                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//                else -> false
//            }
//        }
//    }

}