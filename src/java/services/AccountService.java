package services;

import models.Users;

public class AccountService {
        public Users login(String username, String password){
            if ((username.equals("abe") && password.equals("password")) || username.equals("barb") && password.equals("password")){
                return new Users(username,null);
            }
            return null;
        }
}
