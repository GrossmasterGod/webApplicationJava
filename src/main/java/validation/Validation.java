package validation;

import model.User;

public class Validation {
    public static boolean passwordValidation(User user){
        String patternForStringValidation = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        return user.getPassword().matches(patternForStringValidation);
    }
    public static boolean usernameValidation(User user){
        String patternForUsernameValidation = "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        return user.getLogin().matches(patternForUsernameValidation);
    }
}
