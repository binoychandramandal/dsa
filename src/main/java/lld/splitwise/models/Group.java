package lld.splitwise.models;

import java.util.List;

public class Group extends BaseModel {
    private String name;
    private String description;
    private List<User> members;
    private List<User> admins;
    private User createdBy;
}
