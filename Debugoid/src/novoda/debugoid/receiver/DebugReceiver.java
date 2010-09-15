
package novoda.debugoid.receiver;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

public class DebugReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        //return list.size() > 0;
    }
}
