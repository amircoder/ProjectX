package com.alphacoder.core.extension



import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransitionImpl
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.transition.FragmentTransitionSupport
import com.alphacoder.core.R
import com.alphacoder.core.base.BaseActivity
import com.alphacoder.core.base.BaseFragment

fun BaseFragment.findNavController(fragment: BaseFragment, tag: String): NavController =
    NavHostFragment.findNavController(this)


fun BaseFragment.navigate(layout: Int, fragment: BaseFragment, tag: String) =
    parentFragmentManager.beginTransaction()
        .add(layout, fragment, tag)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        .addToBackStack(null)
        .commit()


