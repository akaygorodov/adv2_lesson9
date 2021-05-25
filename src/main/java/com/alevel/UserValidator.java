package com.alevel;

public class UserValidator {

    UserRepository userRepository;

    public static void main(String[] args) {

    }

    public boolean validateLogin(String login) {
        return !userRepository.existByLogin(login);
    }

    public boolean validatePassword(String password) {
        if (password.length()<8) {
            return false;
        }
        if (password.matches("\\d*")) {
            return false;
        }
        return true;
    }
}
