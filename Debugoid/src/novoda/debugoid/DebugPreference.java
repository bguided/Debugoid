package novoda.debugoid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class DebugPreference extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("TESST", "on here again");
    }
}
