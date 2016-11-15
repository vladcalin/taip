package ssh.scheme.shamir;

import java.math.BigInteger;
import java.security.SecureRandom;
import ssh.scheme.IScheme;
import ssh.param.ISchemeParams;
import ssh.secret.ISecret;
import ssh.secret.ISubSecret;

import java.util.ArrayList;

/**
 * Created by nberendea on 11/8/2016.
 */
public class Shamir implements IScheme {

    private ShamirParams params;

    public Shamir(ShamirParams params) {
        this.params = params;
    }

    @Override
    public void setParams(ISchemeParams params) {
        this.params = (ShamirParams) params;
    }

    public ShamirParams getParams() {
        return this.params;
    }

    @Override
    public ISecret generateSecret() {

        BigInteger secret = BigInteger.probablePrime(512, new SecureRandom());
        secret = secret.mod(this.params.P);

        return new ShamirSecret(secret);
    }

    @Override
    public ArrayList<ISubSecret> splitSecret(ISecret secret) {
        ArrayList<ISubSecret> subsecrets = new ArrayList<>();
        for (int i = 0; i < this.params.k.subtract(BigInteger.ONE).intValue(); i++) {
            subsecrets.add(new ShamirSubsecret(this.params.polinom.get(i)));
        }
        subsecrets.add(new ShamirSubsecret(((ShamirSecret) secret).getWrappedBigInteger()));

        return subsecrets;
    }

    @Override
    public ISecret composeSecret(ArrayList<ISubSecret> subSecrets) {
        return null;
    }
}
