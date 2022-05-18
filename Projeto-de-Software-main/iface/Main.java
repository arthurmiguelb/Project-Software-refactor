import java.util.ArrayList;

import Users.Community;
import Users.Menu;
import Users.UserDo;


public class Main{

    public static void main(String[] args){
        ArrayList<Community> communityList = new ArrayList<>();
        ArrayList<String> feedMessages = new ArrayList<>();
        ArrayList<UserDo> users = new ArrayList<>();
        communityList.add(new Community("none", "none", "none", "none", 0, "none", "none"));
        users.add(new UserDo("admin", "adm", "admin", "none", 0));
        Menu menu = new Menu();
        menu.runMenu(users, communityList,feedMessages);
    }
}