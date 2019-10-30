package com.alphacoder.core.util

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat


private const val PACKAGE_NAME = "com.alphacoder"

/**
 * Create an Intent with [Intent.ACTION_VIEW] to an [AddressableActivity].
 */
fun intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className)
}

fun intentTo(context: Context, addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        context,
        addressableActivity.className)
}

/**
 * An [android.app.Activity] that can be addressed by an intent.
 */
interface AddressableActivity {
    /**
     * The activity class name.
     */
    val className: String
}

/**
 * All addressable activities.
 *
 * Can contain intent extra names or functions associated with the activity creation.
 */
object Activities {

    /**
     * App
     */
    object app {
        object SplashActivity : AddressableActivity {
            override val className = "$PACKAGE_NAME.ui.SplashActivity"
        }
    }



    /**
     * Search
     */

    object Search {
        object SearchActivity : AddressableActivity {
            override val className = "$PACKAGE_NAME.search.presentation.SearchActivity"
            const val EXTRA_QUERY = "EXTRA_QUERY"
            const val RESULT_CODE_SAVE = 7
        }
    }


    /**
     * Detail
     */
    object Detail{
        object DetailActivity : AddressableActivity {
            override val className = "$PACKAGE_NAME.detail.ui.DetailActivity"
        }
    }



//    try{
//        Fragment f = (Fragment)(Class.forName("com.example.Fragment"+i).newInstance());
//        fragmentManager.beginTransaction().replace(R.id.container,f).commit();
//    }catch(ClassNotFoundException e){
//        Log.e("loading level","level class not found",e);
//    }
}
