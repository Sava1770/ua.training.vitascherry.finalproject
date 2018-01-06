package ua.training.vitascherry.model.util;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EncryptorTest {

    @Test
    public void encrypt() throws Exception {
        //Get files from resources folder
        File passwords = new File(extractUrl("100_passwords.txt").getFile());
        File hashes = new File(extractUrl("100_password_hashes.txt").getFile());

        try (Scanner psc = new Scanner(passwords); Scanner hsc = new Scanner(hashes)) {
            while (psc.hasNextLine() && hsc.hasNextLine()) {
                String password = psc.nextLine();
                String hash = hsc.nextLine();
                assertEquals(hash, Encryptor.encrypt(password));
            }
        }
    }

    @Test
    public void matches() throws Exception {
        //Get files from resources folder
        File passwords = new File(extractUrl("100_passwords.txt").getFile());
        File hashes = new File(extractUrl("100_password_hashes.txt").getFile());

        try (Scanner psc = new Scanner(passwords); Scanner hsc = new Scanner(hashes)) {
            while (psc.hasNextLine() && hsc.hasNextLine()) {
                String password = psc.nextLine();
                String hash = hsc.nextLine();
                assertTrue(Encryptor.matches(password, hash));
            }
        }
    }

    private URL extractUrl(String fileName) {
        return this.getClass().getResource(fileName);
    }

}