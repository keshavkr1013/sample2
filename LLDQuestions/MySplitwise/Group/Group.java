package LLDQuestions.MySplitwise.Group;

import LLDQuestions.MySplitwise.User.*;

import java.util.*;
public class Group {
    int groupId;
    String groupName;
    List<User> users;

    public int getGroupId()
    {
        return groupId;
    }
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
    public String getGroupName()
    {
        return groupName;
    }
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }
    public List<User> getUsers()
    {
        return users;
    }
    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
