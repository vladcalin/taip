package ssh.param;

/**
 * Created by nberendea on 11/14/2016.
 */
public abstract class ThresholdSchemeParams {
    private final int defaultN = 0;
    private final int defaultK = 0;
    private int n;
    private int k;

    public ThresholdSchemeParams() {
        n = defaultN;
        k = defaultK;
    }

    public int getN() {
        return n;
    }

    public ThresholdSchemeParams setN(int n) throws IllegalArgumentException {
        if (n<=0) throw new IllegalArgumentException();

        this.n = n;
        return this;
    }

    public int getK() {
        return k;
    }

    public ThresholdSchemeParams setK(int k) throws IllegalArgumentException {
        if (n<=0) throw new IllegalArgumentException();

        this.k = k;
        return this;
    }
}
