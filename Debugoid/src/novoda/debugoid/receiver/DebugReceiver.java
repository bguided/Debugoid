
package novoda.debugoid.receiver;

import novoda.debugoid.DebugPreferenceList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

public class DebugReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intentReceived) {
        Intent intent = new Intent(intentReceived.getAction(), intentReceived.getData());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 0);
        if (list != null && list.size() == 1) {
            context.startActivity(intent);
        } else {
            intent = new Intent(context,DebugPreferenceList.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
