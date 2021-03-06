package com.igoryasko.justmusic.validator;

/**
 * The class {@code UserValidator} validates user's input.
 *
 * @author Igor Yasko on 2019-07-19.
 */
public class UserValidator implements Validator {

    private static final String LOGIN_REGEX_PATTERN = "^[(\\w)-]{4,20}";

    private static final String PASSWORD_REGEX_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=\\S+$).{6,12}$";

    private static final String NAME_REGEX_PATTERN = "[a-zA-Zа-яА-ЯёЁ]{3,20}";

    private static final String EMAIL_REGEX_PATTERN = "^[A-Za-z0-9_.-]{3,20}@[A-Za-z.]{3,15}$";

    private static final String ROLE_REGEX_PATTERN = "USER|GUEST";

    public boolean validate(String firstName, String lastName, String email, String login, String password) {
        if (firstName == null || lastName == null || email == null || login == null || password == null) {
            return false;
        }
        return !firstName.isBlank()
                && !lastName.isBlank()
                && !email.isBlank()
                && !login.isBlank()
                && !password.isBlank()
                && firstName.matches(NAME_REGEX_PATTERN)
                && lastName.matches(NAME_REGEX_PATTERN)
                && email.matches(EMAIL_REGEX_PATTERN)
                && login.matches(LOGIN_REGEX_PATTERN)
                && password.matches(PASSWORD_REGEX_PATTERN);
    }

    public boolean validate(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        return !login.isBlank()
                && !password.isBlank()
                && login.matches(LOGIN_REGEX_PATTERN)
                && password.matches(PASSWORD_REGEX_PATTERN);
    }

    @Override
    public boolean validate(String s) {
        if (s == null) {
            return false;
        }
        return !s.isBlank() && s.matches(ROLE_REGEX_PATTERN);
    }

}
