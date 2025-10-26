package LLDQuestions.MySplitwise.Group;

import LLDQuestions.MySplitwise.User.*;
import java.util.*;
public class GroupController {
    List<Group> groups = new ArrayList<>();
    public void createGroup(int groupId, String groupName, List<User> users)
    {
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.setUsers(users);
        groups.add(group);
    }
    public void addUserToGroup(Group group, User user)
    {
        group.getUsers().add(user);
    }
    
}
