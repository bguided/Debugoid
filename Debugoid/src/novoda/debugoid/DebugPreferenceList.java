
package novoda.debugoid;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DebugPreferenceList extends ListActivity {

    private List<ResolveInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setAction("android.provider.Telephony.SECRET_CODE");
        intent.setData(Uri.parse("android_secret_code://666"));
        final PackageManager packageManager = getPackageManager();
        list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        List<String> app = new ArrayList<String>(list.size());
        for (ResolveInfo info : list) {
            Log.i("TEST", info.activityInfo.name + " ");
            app.add(info.activityInfo.name);
        }
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, app));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ResolveInfo info = list.get(position);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
        startActivity(intent);
        finish();
        super.onListItemClick(l, v, position, id);
    }
}
