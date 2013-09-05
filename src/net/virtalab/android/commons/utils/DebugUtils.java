package net.virtalab.android.commons.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

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
   public static void showInfoToast(String message,Context ctx){
       DebugUtils.showInfoToast(message,Toast.LENGTH_LONG,ctx);
   }

    /**
     * Shows toast with custom duration (even outside of activity)
     *
     * @param message String with message to display
     * @param duration Toast.LENGTH_LONG or Toast.LENGTH_SHORT
     * @param ctx Context
     */
    public static void showInfoToast(String message,int duration,Context ctx){
        Toast t = Toast.makeText(ctx,message,duration);
        t.show();
    }

    /**
     * Dialog to report exceptions
     *
     * @param method Method that throws an exception
     * @param message Exception message
     * @param ctx Context
     */
    public static void showDialogWithExceptions(String method,String message,Context ctx){
        String exceptionString = "Method "+method+" throws an exception"+"\n Message is: "+message;
        AlertDialog.Builder messageBox = new AlertDialog.Builder(ctx);
        messageBox.setTitle("Fatal Error");
        messageBox.setMessage(exceptionString);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK",null);
        messageBox.show();
    }
}
