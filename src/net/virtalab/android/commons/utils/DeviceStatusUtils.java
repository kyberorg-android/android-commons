package net.virtalab.android.commons.utils;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Class provides static utils what help to define status of different services at Android device
 * <p/>
 */
public class DeviceStatusUtils {
    /**
     * Defines if device connected to Internet
     *
     * @return true if mobile or wifi network is connected, false - otherwise
     */
    public static boolean isInternetEnabled(Context ctx){
        if(ctx==null){
            return false;
        }
        boolean haveWifiConnection = false;
        boolean haveMobileConnection = false;

        ConnectivityManager cm = null;
        try{
            Object obj = ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            cm = (ConnectivityManager) obj;
        }catch (NullPointerException npe){
            DebugUtils.showDialogWithExceptions("isInternetEnabled",npe.getMessage(),ctx);
        }catch (ClassCastException cce){
            DebugUtils.showDialogWithExceptions("isInternetEnabled",cce.getMessage(),ctx);
        }

        if(cm==null){
            return false;
        }

        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for(NetworkInfo ni: netInfo){
            if(ni.getTypeName().equalsIgnoreCase("WIFI")){
                if(ni.isConnected()){
                    haveWifiConnection = true;
                }
            }
            if(ni.getTypeName().equalsIgnoreCase("MOBILE")){
                if(ni.isConnected()){
                    haveMobileConnection = true;
                }
            }
        }
        return haveMobileConnection || haveWifiConnection;
    }

    /**
     * Defines if GPS is available at device
     *
     * @param ctx Application Context
     * @return true if GPS is present and available, false - otherwise
     */
    public static boolean isGPSEnabled(Context ctx){
        LocationManager lm = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
}
