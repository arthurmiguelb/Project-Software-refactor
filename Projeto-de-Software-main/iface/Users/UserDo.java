package Users;

public class UserDo extends Users{

    public UserDo(String name, String login, String password, String email, int number){

        super(name, login, password, email, number);
    }
    
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\nName: " + getName() +
               "\nlogin: " + getlogin() +
               "\nemail: " + getEmail() + 
               "\nnumber: " + getNumber() +
              // "\npassword: " + this.password+
               "\n";
    }    


}