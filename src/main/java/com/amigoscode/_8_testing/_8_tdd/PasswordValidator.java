package com.amigoscode._8_testing._8_tdd;

/**
 * TDD Exercise: Password Validator
 *
 * This class is intentionally EMPTY. Students should:
 * 1. First write tests in PasswordValidatorTest.java (test-first approach)
 * 2. Then implement this class to make the tests pass
 *
 * Password rules to implement:
 * - Must be at least 8 characters long
 * - Must contain at least one uppercase letter
 * - Must contain at least one lowercase letter
 * - Must contain at least one digit
 * - Must contain at least one special character (!@#$%^&*()_+-=)
 * - Null password should throw IllegalArgumentException
 * - Empty password should return false
 */
public class PasswordValidator {

    public static final int MIN_LENGTH_OF_PASSWORD = 8;
    public static final String SPECIAL_CHAR_REGEX = ".*[!@#$%^&*()_+=<>?/\\[\\]{}|].*";
    public static final String DIGIT_REGEX = ".*\\d.*";
    public static final String ONE_LOWERCASE_LETTER_REGEX = ".*[a-z].*";
    public static final String ONE_UPPERCASE_LETTER_REGEX = ".*[A-Z].*";

    /**
     * Validates whether the given password meets all strength requirements.
     *
     * @param password the password to validate
     * @return true if the password meets all requirements, false otherwise
     * @throws IllegalArgumentException if password is null
     */
    public boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can not be null");
        }
        if (password.isBlank()){
            return false;
        }
        String trimmed = password.trim();
        if (trimmed.length() < MIN_LENGTH_OF_PASSWORD){
            return false;
        }
        if (!trimmed.matches(ONE_UPPERCASE_LETTER_REGEX)) {
            return false;
        }
        if (!trimmed.matches(ONE_LOWERCASE_LETTER_REGEX)) {
            return false;
        }
        if (!trimmed.matches(DIGIT_REGEX)) {
            return false;
        }
        if (!trimmed.matches(SPECIAL_CHAR_REGEX)){
            return false;
        }

        return true;


        // TODO: Students implement this after writing tests first (TDD approach)
//        throw new UtrimmednsupportedOperationException("Implement me using TDD!");
    }
}
