package Command;

import java.util.ArrayList;

import Users.Community;
import Users.MenuLogin;
import Users.UserDo;
import Users.Users;

public class Backup implements Command {
    MenuLogin login = new MenuLogin();
    @Override
    public void execute(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        login.backup(user, users);
    }
    
}
