/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh.scheme.shamir;

import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ssh.param.ISchemeParams;
import ssh.secret.ISecret;
import ssh.secret.ISubSecret;

/**
 *
 * @author vlad
 */
public class ShamirTest {

    public ShamirTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setParams method, of class Shamir.
     */
    @Test
    public void testSetParams() {
        System.out.println("setParams");
        ISchemeParams params = ShamirParams.generateTestParameters();
        Shamir instance = new Shamir(null);
        instance.setParams(params);

        assert instance.getParams() == params;
    }

    /**
     * Test of generateSecret method, of class Shamir.
     */
    @Test
    public void testGenerateSecret() {
        System.out.println("generateSecret");
        Shamir instance = new Shamir(ShamirParams.generateTestParameters());
        ShamirSecret result = (ShamirSecret) instance.generateSecret();

        assert result.getWrappedBigInteger().bitLength() <= 512;
    }

    /**
     * Test of splitSecret method, of class Shamir.
     */
    @Test
    public void testSplitSecret() {
        System.out.println("splitSecret");
        ISecret secret = new ShamirSecret(BigInteger.TEN);
        ShamirParams params = ShamirParams.generateTestParameters();
        Shamir instance = new Shamir(params);
        ArrayList<ISubSecret> result = instance.splitSecret(secret);

        assert BigInteger.valueOf(result.size()).equals(params.k);
    }

    /**
     * Test of composeSecret method, of class Shamir.
     */
    @Test
    public void testComposeSecret() {
        System.out.println("composeSecret");
        ArrayList<ISubSecret> subSecrets = null;
        Shamir instance = new Shamir(null);
        ISecret expResult = null;
        ISecret result = instance.composeSecret(subSecrets);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
