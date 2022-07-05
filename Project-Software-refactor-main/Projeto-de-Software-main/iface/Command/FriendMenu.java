package Command;

import java.util.ArrayList;

import Users.Community;
import Users.Friend;
import Users.MenuLogin;
import Users.UserDo;
import Users.Users;

public class FriendMenu implements Command {
    MenuLogin login = new MenuLogin();
    Friend friend = new Friend();
    @Override
    public void execute(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        friend.FriendMenu(user, users);
    }
    
}
