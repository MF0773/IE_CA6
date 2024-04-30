package org.ie.mizdooni.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.ie.mizdooni.utils.validator.EmailValidator;
import org.ie.mizdooni.utils.validator.UserNameVlidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserModel extends BaseModel {
    static private List<UserModel> allObjects = new ArrayList<>();

    static class UserAddress {
        public String country, city;
    }

    public enum UserRole {
        @JsonProperty("client")
        CLIENT, @JsonProperty("manager")
        MANAGER
    };

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    UserRole role;
    @FieldValidator(UserNameVlidator.class)
    String username;
    String password;
    @FieldValidator(EmailValidator.class)
    String email;
    UserAddress address;

    public UserModel() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    // @Override public void validate() throws ValidatorException{
    // var usernameValidator = new UserNameVlidator();
    // usernameValidator.validate(this.username);
    // (new EmailValidator() ).validate(this.email);
    // }

    static private UserModel loginnedUser = null;

    public static UserModel getLoginnedUser() {
        return loginnedUser;
    }

    public static void setLoginnedUser(UserModel user) {
        loginnedUser = user;
    }

    static public List<UserModel> findUserByUserPass(String username, String password) {
        List<UserModel> matchedUserList = allObjects.stream().filter(
                user -> user.getUsername().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0)
                .collect(Collectors.toList());
        return matchedUserList;
    }

    static public void addObject(UserModel user) {
        allObjects.add(user); // TODO : remove data redundancy
    }

    static public List<UserModel> getAllObjects() {
        return allObjects.stream().toList();
    }

    static public UserModel findByUsername(String username) {
        List<UserModel> matchedUserList = allObjects.stream().filter(
                user -> user.getUsername().compareTo(username) == 0).collect(Collectors.toList());
        if (matchedUserList.isEmpty()) {
            return null;
        }
        return matchedUserList.get(0);
    }
}
