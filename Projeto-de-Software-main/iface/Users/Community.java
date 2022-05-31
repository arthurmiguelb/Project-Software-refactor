package Users;
import java.util.ArrayList;

public class Community extends UserDo{
    UserDo userComu = new UserDo(getName(), "", "", "", 0);
    
    ArrayList<UserDo> CommunityUsers;
    String UserAdm = userComu.getName();
    String nameCommu;
    String description;

    public Community(String name, String login, String password, String email, int number, String nameCommu, String description){
        super(name, login, password, email, number);
        this.CommunityUsers = new ArrayList<UserDo>();
        this.UserAdm = UserAdm;
        this.nameCommu = nameCommu;
        this.description = description;

    }
    public String getNameComu(){
        return nameCommu;
    }
    public void setNameCommu(String nameCommu){
         this.nameCommu = nameCommu;
    }
    public String getDescription(){
        return description;
    }
    public void setName(String name){
         this.description = description;
    }
    public String getNameAdm(){
        return UserAdm;
    }
    public void setNameAdm(String UserAdm){
         this.UserAdm = UserAdm;
    }

    
       
}
