package Command;

import java.util.ArrayList;

import Users.Community;
import Users.CommunityEdit;
import Users.MenuLogin;
import Users.UserDo;
import Users.Users;

public class CreateCommunity implements Command {
    MenuLogin login = new MenuLogin();
    CommunityEdit comu = new CommunityEdit();
    @Override
    public void execute(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        comu.createCommunity(user, users, communityList);
    }
    
}
