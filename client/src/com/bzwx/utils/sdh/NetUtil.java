package com.bzwx.utils.sdh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil
{
  public static boolean checkNet(Context context)
  {
    try
    {
      ConnectivityManager connectivity = (ConnectivityManager) context
          .getSystemService(Context.CONNECTIVITY_SERVICE);
      if (connectivity != null)
      {
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        if (info != null && info.isConnected())
        {
          if (info.getState() == NetworkInfo.State.CONNECTED)
          {
            return true;
          }
        }
      }
    }
    catch (Exception e)
    {
    }
    return false;
  }
}
