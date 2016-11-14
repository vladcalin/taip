package ssh.scheme.naor_shamir;

import ssh.scheme.IScheme;
import ssh.param.ISchemeParams;
import ssh.secret.ISecret;
import ssh.secret.ISubSecret;

import java.util.ArrayList;

/**
 * Created by nberendea on 11/14/2016.
 */
public class NaorShamirScheme implements IScheme{
    NaorShamirParams params;

    NaorShamirScheme() {
        params = null;
    }

    NaorShamirScheme(NaorShamirScheme params) {

    }

    public NaorShamirParams getParams() {
        return params;
    }

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
