package com.webshop.Service;

import com.webshop.Config.Token;
import com.webshop.Model.User;
import org.json.JSONObject;

/**
 *
 * @author tothm23
 */
public class UserService {

    public static String regisztracio(String name, String email, String pw, Boolean admin) {
        // Logikai validálás
        try {
            if (!User.checkEmail(email)) {
                return "Érvénytelen email cím";
            } else if (!User.checkPassword(pw)) {
                return "Érvénytelen jelszó";
            } else if (User.regisztracio(name, email, pw, admin)) {
                return "Sikeres regisztráció!";
            } else {
                return "Sikertelen regisztráció";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public static JSONObject bejelentkezes(String email, String pw) {
        User u = User.bejelentkezes(email, pw);
        String token = Token.createJwt(u, 3600000);

        JSONObject obj = new JSONObject();
        obj.put("token", token);

        return obj;
    }
}
