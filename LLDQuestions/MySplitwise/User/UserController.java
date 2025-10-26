package LLDQuestions.MySplitwise.User;

import java.util.*;
public class UserController {
    List<User> users = new ArrayList<>();
    public void addUser(User user)
    {
        users.add(user);
    }
    public List<User> getAllUsers()
    {
        return users;
    }
    public User getUserByUserId(int userId)
    {
        for(User user: users)
        {
            if(user.getUserId()==userId)
                return user;
        }
        return null;
    }
}
