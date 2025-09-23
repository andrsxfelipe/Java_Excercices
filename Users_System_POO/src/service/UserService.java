package service;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public boolean auth(String email, String password){
        for (User u : users ){
            if (u.authenticate(email, password)){
                return true;
            }
        }
        return false;
    }
}
