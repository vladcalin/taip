/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh.scheme.shamir;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ssh.param.ISchemeParams;

/**
 *
 * @author vlad
 */
public class ShamirParams implements ISchemeParams {

    public final BigInteger P;
    public final List<BigInteger> polinom;
    public final BigInteger k;
    public final BigInteger n;

    public ShamirParams(BigInteger prime, BigInteger k, BigInteger n, List<BigInteger> polinom) {
        this.P = prime;
        if (polinom == null) {
            this.polinom = new ArrayList<>();
        } else {
            this.polinom = polinom;
        }
        this.k = k;
        this.n = n;
    }

    public static ShamirParams generateTestParameters() {

        BigInteger prime = BigInteger.probablePrime(512, new SecureRandom());
        BigInteger n = BigInteger.TEN;
        BigInteger k = BigInteger.valueOf(7L);
        List<BigInteger> polinom = new ArrayList<>(k.subtract(BigInteger.ONE).intValue());

        for (int i = 0; i < k.subtract(BigInteger.ONE).intValue(); i++) {
            BigInteger temp = new BigInteger(512, 10, new Random()).mod(prime);
            polinom.add(temp);
        }

        ShamirParams toReturn = new ShamirParams(prime, k, n, polinom);
        return toReturn;
    }

}
