package net.virtalab.android.commons.utils;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import net.virtalab.android.commons.CommonsApp;

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
    public static boolean isInternetEnabled(){
        boolean haveWifiConnection = false;
        boolean haveMobileConnection = false;

        ConnectivityManager cm = (ConnectivityManager) CommonsApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

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
     * @return true if GPS is present and available, false - otherwise
     */
    public static boolean isGPSEnabled(){
        LocationManager lm = (LocationManager) CommonsApp.getContext().getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
}
