
package novoda.debugoid;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class DebugPreference extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.debug_preference);
    }
}
