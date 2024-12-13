/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Utility class for encrypting passwords using BCrypt hashing algorithm.
 * This class provides methods to hash a password and verify it against a hash.
 * The class is designed to be used statically, and its constructor is private to prevent instantiation.
 * 
 * 
 */
public class Encriptacion {

    /**
     * The cost factor for the BCrypt hashing function. A higher value increases the hashing time.
     * The default cost value is set to 12.
     */
    public static final int COST = 12;

    /**
     * Private constructor to prevent instantiation of this utility class.
     * Throws an {@link IllegalStateException} if called.
     */
    private Encriptacion() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Encrypts a password using the BCrypt algorithm and a predefined cost factor.
     * 
     * @param password The password to encrypt.
     * @return A hashed password as a string.
     */
    public static String encriptarPassword(String password) {
        return BCrypt.withDefaults().hashToString(COST, password.toCharArray());
    }

    /**
     * Encrypts a password using the BCrypt algorithm and a predefined cost factor.
     * This method accepts the password as a character array.
     * 
     * @param password The password to encrypt, as a character array.
     * @return A hashed password as a string.
     */
    public static String encriptarPassword(char[] password) {
        return BCrypt.withDefaults().hashToString(COST, password);
    }

    /**
     * Verifies if a password matches a hashed password.
     * 
     * @param password The plaintext password to verify.
     * @param hashedPassword The hashed password to verify against.
     * @return {@code true} if the password matches the hash, {@code false} otherwise.
     */
    public static boolean verificarPasswordConHash(String password, String hashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }
}
