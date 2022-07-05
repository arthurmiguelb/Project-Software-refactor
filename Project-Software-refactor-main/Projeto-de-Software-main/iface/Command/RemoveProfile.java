package Command;

import java.util.ArrayList;
import java.util.Scanner;

import Users.Community;
import Users.Friend;
import Users.MenuLogin;
import Users.UserDo;
import Users.Users;

public class RemoveProfile implements Command {
    MenuLogin login = new MenuLogin();
    
    @Override
    public void execute(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        String option;
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("do you want to remove your profile?\n");
        System.out.println("y/n?");
        final Scanner a = new Scanner(System.in);
            option = a.next();
            if(option.equals("y") || option.equals("Y")){
                login.exit2 = true;
               login.delete_profile(user, users);
                System.out.println("your profile has been removed!");
                return;
            }
            else if(option.equals("n") || option.equals("N")){
            return;
            }

            if((!option.equals("y") && !option.equals("n")) || (!option.equals("Y") && !option.equals("N"))){
                System.out.println("\nInvalid Input"); 
            }
    }
    
}
