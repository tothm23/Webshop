package com.webshop.Service;

import com.webshop.Exception.PasswordException;
import com.webshop.Model.User;

/**
 *
 * @author tothm23
 */
public class UserService {

    public static String regisztracio(String name, String email, String pw, Boolean admin) {

        try {
            if (!checkEmail(email)) {
                return "Az email cím nem elég hosszú, a domain-en kívül legalább 3 karaktert kell tartalmaznia!";

            } else if (!User.checkPassword(pw)) {
                return "Ez soha nem teljesülhet";

            } else if (User.regisztracio(name, email, pw, admin)) {
                return "Sikeres regisztráció!";
            } else {
                return "Sikertelen regisztráció";
            }
        } catch (PasswordException e) {
            return e.getMessage();
        }

    }

    public static boolean checkName(String name) {
        return !name.equalsIgnoreCase("");
    }

    public static boolean checkEmail(String email) {
        // Az emailcím formailag helyes, gmail domain, és a @ előtt legalább 3 karakteres, érvényes "név" szerepel

        if (email.contains("@")) {
            String[] pieces = email.split("@");

            if (pieces[0].length() >= 3) {
                if (pieces[1].startsWith("gmail")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return false;

    }
}
