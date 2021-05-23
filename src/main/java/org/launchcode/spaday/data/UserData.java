package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    //add a user
    public static void add(User user){
        users.put(user.getId(),user);
    }

    //get a list of all users
    public static Collection<User> getAll(){
        return users.values();
    }

    //get a user by ID
    public static User getId(int id){
        return users.get(id);
    }
}
