package net.virtalab.android.commons.utils;

import android.widget.Toast;
import net.virtalab.android.commons.CommonsApp;

/**
 * Provides utils for debugging purposes
 * <p/>
 *
 */
public class DebugUtils {
    /**
     * Shows toast with long length (even outside of activity)
     *
     * @param message String with message to display
     */
   public static void showInfoToast(String message){
       DebugUtils.showInfoToast(message,Toast.LENGTH_LONG);
   }

    /**
     * Shows toast with custom duration (even outside of activity)
     *
     * @param message String with message to display
     * @param duration Toast.LENGTH_LONG or Toast.LENGTH_SHORT
     */
    public static void showInfoToast(String message,int duration){
        Toast.makeText(CommonsApp.getContext(),message,duration);
    }
}
