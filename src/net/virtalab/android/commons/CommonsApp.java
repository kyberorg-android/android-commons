package net.virtalab.android.commons;

import android.app.Application;
import android.content.Context;

/**
 * Class to accessing to static context and resources from library
 * <p/>
 */
public class CommonsApp extends Application {
    private static Context mContext;

    /**
     * Method Called at application start (we use it to init context)
     */
    public void onCreate(){
        super.onCreate();
        mContext = this;
    }

    /**
     * Context getter
     *
     * @return context object
     */
    public static Context getContext(){
        return mContext;
    }
}
