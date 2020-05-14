package lec.javaexam.dto;

public class RoleDto {
    private int roleId;
    private String description;

    public RoleDto(int roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", description='" + description + '\'' +
                '}'+"\n";
    }
}
