
package novoda.debugoid;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class DebugPreference extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.debug_preference);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIndeterminate(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        final AndroidHttpClient client = AndroidHttpClient.newInstance("test");

        try {
            new Thread() {
                public void run() {
                    HttpResponse response;
                    try {
                        response = client
                                .execute(new HttpGet(
                                        URI
                                                .create("http://upload.wikimedia.org/wikipedia/commons/archive/4/4e/20090223155149!Pleiades_large.jpg")));
                        CoObs o = new CoObs(response.getEntity(), dialog);
                        EntityUtils.toByteArray(o);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
