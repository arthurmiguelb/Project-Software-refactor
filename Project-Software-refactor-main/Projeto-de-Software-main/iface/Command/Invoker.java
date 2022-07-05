package Command;

import java.util.ArrayList;
import Users.UserDo;
import Users.Users;
import Users.Community;

public class Invoker {
    ArrayList<Command> commands;
    public Invoker() {
        commands = new ArrayList<Command>();
        commands.add(0, new Exit());
        commands.add(1, new ProfileMenu());
        commands.add(2,new FeedNews());
        commands.add(3, new FriendMenu());
        commands.add(4, new CreateCommunity());
        commands.add(5, new RemoveProfile());
        commands.add(6, new Backup());
    }

    public void executeCommand(int option, final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        commands.get(option).execute(user, users, communityList, feedMessages);
    }
}
