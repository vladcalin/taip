package ssh.scheme;

/**
 * Created by nberendea on 11/8/2016.
 */
public class SecretSharingScheme {
    private IScheme scheme;

    SecretSharingScheme(String schemeName) {
        scheme = SchemeFactory.getScheme(schemeName);
    }
}
