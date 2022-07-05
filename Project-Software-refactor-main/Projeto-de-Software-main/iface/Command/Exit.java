package Command;

import java.util.ArrayList;

import Users.Community;
import Users.MenuLogin;
import Users.UserDo;
import Users.Users;
import Users.Menu;

public class Exit implements Command {
    MenuLogin login = new MenuLogin();
    @Override
    public void execute(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        login.exit2 = true;
        System.out.println("\nThank you for using our application.");
        Menu menu = new Menu();
        menu.runMenu(users, communityList, feedMessages);
        return;
    }
    
}
