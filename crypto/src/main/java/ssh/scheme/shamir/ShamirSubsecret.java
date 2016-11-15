/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh.scheme.shamir;

import java.math.BigInteger;
import ssh.secret.ISubSecret;

/**
 *
 * @author vlad
 */
public class ShamirSubsecret implements ISubSecret {

    private final BigInteger toWrap;

    public ShamirSubsecret(BigInteger toWrap) {
        this.toWrap = toWrap;

    }

}
