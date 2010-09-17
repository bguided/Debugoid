
package novoda.debugoid;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

public class InputStreamObservable extends InputStream {

    private InputStream in;

    public InputStreamObservable(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }


}
