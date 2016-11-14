package ssh.scheme.shamir;

import ssh.scheme.IScheme;
import ssh.param.ISchemeParams;
import ssh.secret.ISecret;
import ssh.secret.ISubSecret;

import java.util.ArrayList;

/**
 * Created by nberendea on 11/8/2016.
 */
public class Shamir implements IScheme {
    public void setParams(ISchemeParams params) {

    }

    public ISecret generateSecret() {
        return null;
    }

    public ArrayList<ISubSecret> splitSecret(ISecret secret) {
        return null;
    }

    public ISecret composeSecret(ArrayList<ISubSecret> subSecrets) {
        return null;
    }
}
