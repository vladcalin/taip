/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh.scheme.shamir;

import java.math.BigInteger;
import ssh.secret.ISecret;

/**
 *
 * @author vlad
 */
public class ShamirSecret implements ISecret {

    private BigInteger secret;

    public ShamirSecret() {
        this.secret = null;
    }

    public ShamirSecret(BigInteger secret) {
        this.secret = secret;
    }

    public static ShamirSecret fromBigInteger(BigInteger secret) {
        return new ShamirSecret(secret);
    }
    
    public BigInteger getWrappedBigInteger() {
        return this.secret;
    }

}
