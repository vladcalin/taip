package ssh.scheme;

import ssh.param.ISchemeParams;
import ssh.secret.ISecret;
import ssh.secret.ISubSecret;

import java.util.ArrayList;

/**
 * Created by nberendea on 11/8/2016.
 */
public interface IScheme {
    void setParams(ISchemeParams params);
    ISecret generateSecret();
    ArrayList<ISubSecret> splitSecret(ISecret secret);
    ISecret composeSecret(ArrayList<ISubSecret> subSecrets);
}
