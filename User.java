public  class User {
    private static int idCounter = 0;

    private final int userId;
    private final String userMail;
    private String userPassword;
    private String username;
    private Role role;

    public User(String userMail,String username, String userPassword,Role role) {
        this.userId = ++idCounter;
        this.userMail = userMail;
        this.username=username;
        this.userPassword = userPassword;
        this.role=role;

    }

    public int getUserId() {
        return userId;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
       if(username!=null) {
           this.username = username;
       }
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        if (userPassword != null && !userPassword.isEmpty()) {
            this.userPassword = userPassword;
        }
    }

    public Role getRole() {
        return role;
    }

    protected void setRole(Role role) {
        this.role = role;
    }
    public boolean authenticate(String inputpassword){
        return this.userPassword.equals(inputpassword);
    }
}
