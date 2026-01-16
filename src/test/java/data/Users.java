package data;

import models.User;

public class Users {

    public static final User VALID_USER =
            new User("bod@example.com", "10203040");

    public static final User LOCKED_OUT_USER =
            new User("alice@example.com", "10203040");

    private Users() {}
}
