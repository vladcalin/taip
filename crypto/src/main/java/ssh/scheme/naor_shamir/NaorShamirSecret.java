package ssh.scheme.naor_shamir;

import ssh.secret.ISecret;

/**
 * Created by nberendea on 11/14/2016.
 */
public class NaorShamirSecret extends NaorShamirImage implements ISecret{
    public NaorShamirSecret() {
        super();
    }

    public void set(int width, int height, boolean pixels[]) {
        if (width<=0) throw new IllegalArgumentException();
        if (height<=0) throw new IllegalArgumentException();
        if (pixels==null) throw new IllegalArgumentException();
        if (pixels.length != width*height) throw new IllegalArgumentException();

        this.width = width;
        this.height = height;
        this.pixels = pixels.clone();
    }
}
