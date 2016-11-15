/**
 * Created by nberendea on 11/14/2016.
 */

import junit.framework.*;
import ssh.scheme.naor_shamir.NaorShamirParams;
import ssh.scheme.naor_shamir.NaorShamirSecret;

public class NaorShamirTest extends TestCase{
    public void testParams() {
        NaorShamirParams params = new NaorShamirParams();
        int n, k;

        assertEquals(params.getN(), 0);
        assertEquals(params.getK(), 0);

        try {
            params.setN(0);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), null);
        } catch (Exception e) {
            fail("Expected an IllegalArgumentException to be thrown");
        }

        try {
            params.setN(-1);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), null);
        } catch (Exception e) {
            fail("Expected an IllegalArgumentException to be thrown");
        }

        try {
            params.setK(0);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), null);
        } catch (Exception e) {
            fail("Expected an IllegalArgumentException to be thrown");
        }


        try {
            params.setK(-1);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), null);
        } catch (Exception e) {
            fail("Expected an IllegalArgumentException to be thrown");
        }

        n = 100;
        assertEquals(params.setN(n).getN(), n);

        k = 100;
        assertEquals(params.setK(k).getK(), k);
    }

    public void testSecret() {
        NaorShamirSecret s = new NaorShamirSecret();
        boolean img[] = new boolean[]{true, false, false, true};

        s.set(2, 2, img);
        s.save("img.bmp");
        s.load("img.bmp");
        assertEquals(img, s.getPixels());
    }
}
