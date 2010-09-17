
package novoda.debugoid;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import android.app.ProgressDialog;

public class CoObs implements HttpEntity {

    private HttpEntity entity;

    // This is not always true
    private long potentialContentLenght = -1;

    private ProgressDialog listener;

    public CoObs(HttpEntity entity, final ProgressDialog listener) {
        this.entity = entity;
        potentialContentLenght = entity.getContentLength();
        this.listener = listener;
        this.listener.setMax((int)potentialContentLenght);
    }

    @Override
    public void consumeContent() throws IOException {
        entity.consumeContent();
    }

    @Override
    public InputStream getContent() throws IOException, IllegalStateException {
        return new InputStreamObservable(entity.getContent());
    }

    @Override
    public Header getContentEncoding() {
        return entity.getContentEncoding();
    }

    @Override
    public long getContentLength() {
        return entity.getContentLength();
    }

    @Override
    public Header getContentType() {
        return entity.getContentType();
    }

    @Override
    public boolean isChunked() {
        return entity.isChunked();
    }

    @Override
    public boolean isRepeatable() {
        return entity.isRepeatable();
    }

    @Override
    public boolean isStreaming() {
        return entity.isStreaming();
    }

    @Override
    public void writeTo(OutputStream outstream) throws IOException {
        entity.writeTo(outstream);
    }

    public class InputStreamObservable extends InputStream {
        private InputStream in;

        private int progress;
        private int i;

        public InputStreamObservable(InputStream in) {
            this.in = in;
            progress = 0;
            i = 0;
        }

        @Override
        public int read() throws IOException {
            if (++progress > i * 10000) {
                listener.setProgress(progress);
                i++;
            }
            return in.read();
        }
    }

}
