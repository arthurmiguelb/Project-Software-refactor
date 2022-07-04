package Users;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import Users.Community;

public class MenuLogin{
    boolean feed;
    boolean exit; 
    boolean sai = false;  
    public void runMenuLogin(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){

        exit = false;
        while(!exit){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            printMenuLogin(user);
            final int choice = getInputMenu1();
            perfomAction(choice, user, users, communityList, feedMessages);
        }
     }

     private void printMenuLogin(final Users user){
         
            System.out.println("\n+------------------------------+");
            System.out.println("|                              |");
            System.out.println("           Welcome "+user.getName());
            System.out.println("|                              |");
            System.out.println("+------------------------------+");
            System.out.println("\n1) profile");
            System.out.println("2) news feed");
            System.out.println("3) friends");
            System.out.println("4) community");
            System.out.println("5) delete profile");
            System.out.println("6) backup");
            System.out.println("0) exit");

     }
     private int getInputMenu1(){
        final Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 6){
            try{
                System.out.println("\nEnter your choice: ");
                choice =  Integer.parseInt(kb.nextLine());

            }
            catch(final NumberFormatException e){
                System.out.println("Invalid selection, Please try again.");

            }
        }
        return choice;
    }
    

    private void perfomAction(final int choice, final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList, final ArrayList<String> feedMessages){
        // Scanner b = new Scanner(System.in);
        // int choice3 = b.nextInt();
        switch(choice){
            case 0:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            exit = true;
            System.out.println("\nThank you for using our application.");
            break;

            case 1:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            profileMenu(user, users);
            break;
        
            case 2:
            feedNews(user, users, feedMessages);
            break;

            case 3:
            FriendMenu(user, users);
            break;

            case 4:
            createCommunity(user, users, communityList);
            break;

            case 5:
            String option;
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("do you want to remove your profile?\n");
            System.out.println("y/n?");
            final Scanner a = new Scanner(System.in);
                option = a.next();
                if(option.equals("y") || option.equals("Y")){
                    exit = true;
                    delete_profile(user, users);
                    System.out.println("your profile has been removed!");
                    break;
                }
                else if(option.equals("n") || option.equals("N")){
                break;
                }

                if((!option.equals("y") && !option.equals("n")) || (!option.equals("Y") && !option.equals("N"))){
                    System.out.println("\nInvalid Input"); 
                } 
 
                case 6:
                backup(user, users);

                default:
            
        }
    }

    private void profileMenu(final Users user, final ArrayList<UserDo> users){
        
        while(true){
            System.out.println("\n1) show my profile");
            System.out.println("2) edit my profile");
            System.out.println("0) exit");
            final Scanner b = new Scanner(System.in);
            final int choice;
            try{
                choice =  Integer.parseInt(b.nextLine());
                switch(choice){
                    case 0:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("\nThank you for using our application.");
                    return;

                    case 1:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println(user);
                    break;
                
                    case 2:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    printrofileEdit();
                    perfomActionEdit(user, users);
                    break;

                    default:
                }
            }
        catch(final NumberFormatException e){
            System.out.println("\nInvalid selection, Please try again. ");
            Scanner ex = new Scanner(System.in);
            ex.nextLine();
        }

      }
    }

    private void printrofileEdit(){
        System.out.println("\n1) change nickname");
        System.out.println("2) change username");
        System.out.println("3) change password");
        System.out.println("4) add or change email");
        System.out.println("5) add or change number");
        System.out.println("0) exit");
    }
    private void perfomActionEditRefactor1(final Users user, final ArrayList<UserDo> users){
        System.out.println("\nenter your new nickname:");
                    final Scanner q = new Scanner(System.in);
                    final String newNickname = q.next();
                        for(final Users User : users){
                            if(user.getName().equals(newNickname)){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                System.out.println("\nnickname already exists. ");
                            return;
                            }
                        }
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        user.backup.add("old nickname "+user.getName());
                        user.setName(newNickname);
                        System.out.println("\nSuccess!");
                        System.out.println("\n your new nickname is "+ user.getName());

    }
    private void perfomActionEditRefactor2(final Users user, final ArrayList<UserDo> users){
                        System.out.println("\nenter your new name:");
                        final Scanner w = new Scanner(System.in);
                        final String newUsername = w.next();
                        for(final Users User : users){
                            if(user.getlogin().equals(newUsername)){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                System.out.println("\nname already exists. ");
                            return;
                            }
                        }
                        user.backup.add("old login "+user.getlogin());
                        user.setlogin(newUsername);
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println("\nSuccess!");
                        System.out.println("\n your new username is "+ user.getlogin());    

    }
    private void perfomActionEditRefactor3(final Users user, final ArrayList<UserDo> users){
                        System.out.println("\nEnter your new password: ");
                        final Scanner c = new Scanner(System.in);
                        final String password = c.next();
                        if(password.equals(user.getpassword())){
                            System.out.print("\033[H\033[2J");  
                            System.out.flush();
                            System.out.println("\nyour password cannot be the same as the previous!");
                        return;
        }
                        System.out.println("\nRepeat your password: ");
                        final Scanner c2 = new Scanner(System.in);
                        final String password2 = c2.next();
    
                        if(password.equals(password2)){
                            user.backup.add("old password "+user.getpassword());
                            user.setpassword(password); 
                        }
                        else{
                            System.out.print("\033[H\033[2J");  
                            System.out.flush();
                            System.out.println("\nPasswords are not the same ");
                            return;
                        }
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println("\nSuccess!");
                        System.out.println("\n your new password is "+ user.getpassword());

                        }
    private void perfomActionEditRefactor4(final Users user, final ArrayList<UserDo> users){
                        System.out.println("\nenter your new email:");
                        final Scanner e = new Scanner(System.in);
                        final String newEmail = e.next();
                        for(final Users User : users){
                            if(user.getEmail().equals(newEmail)){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                System.out.println("\nemail already exists. ");
                                return;
                            }
                        }
                        user.backup.add("old email "+user.getEmail());
                        user.setEmail(newEmail);
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println("\nSuccess!");
                        System.out.println("\n your new Email is "+ user.getEmail());

    }
                        private void perfomActionEditRefactor5(final Users user, final ArrayList<UserDo> users){
                        System.out.println("\nenter your new number:");
                        final Scanner r = new Scanner(System.in);
                        try{
                            final int newNumber = Integer.parseInt(r.nextLine());

                            for(final Users User : users){
                                if(user.getNumber() == newNumber){
                                    System.out.print("\033[H\033[2J");  
                                    System.out.flush();
                                    System.out.println("\nnumber already exists. ");
                                    return;
                                }
                            }
                            System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        user.backup.add("old number "+user.getNumber());
                        user.setNumber(newNumber); 
                        System.out.println("\nSuccess!");
                        System.out.println("\n your new number is "+ user.getNumber());

    }
                    catch(NumberFormatException i){
                        System.out.println("Invalid selection, Please try again.");
                        System.out.println("\ntype to continue:");
                        Scanner ex =  new Scanner(System.in);
                        ex.nextLine();
                    }

    }
    
    private void perfomActionEdit(final Users user, final ArrayList<UserDo> users){
   
        final Scanner a = new Scanner(System.in);
        int choice;
        //choice = a.nextInt();
            try{
                System.out.println("\nEnter your choice:");
                choice =  Integer.parseInt(a.nextLine());
                if(choice == 0){
                    sai = true;
                    return;
                }
                switch(choice){
        
                    case 1:
                        perfomActionEditRefactor1(user, users);
                    break;
                    case 2:
                        perfomActionEditRefactor2(user, users);
                    break;
        
                    case 3:
                        perfomActionEditRefactor3(user, users);
                    break;
        
                    case 4:
                    perfomActionEditRefactor4(user, users);

                    break;
                    case 5:
                    perfomActionEditRefactor5(user, users);
                    default:
                }
            }
            catch(final NumberFormatException e){
                System.out.println("\nInvalid selection, Please try again. ");
                Scanner ex = new Scanner(System.in);
                ex.nextLine();
            }
        
    }

    private void delete_profile(final Users user, final ArrayList<UserDo> users){
        users.remove(user);
    }

    public void FriendMenu(final Users user, final ArrayList<UserDo> users){
        
        final boolean exit = false;
        System.out.println("\n1) friend requests");
        System.out.println("2) add friend");
        System.out.println("3) list friends");
        System.out.println("4) send a message to a friend");
        System.out.println("5) received messages");
        System.out.println("6) remove friend");
        final Scanner in = new Scanner(System.in);
        final int choice;
         
        try{
            choice = Integer.parseInt(in.nextLine());
            if(choice == 1){
                printListFriend(user ,user.request, users);
            }
             if(choice == 2){
                Boolean it = false;
                System.out.println("\nenter the username of the user:");
                final Scanner a = new Scanner(System.in);
                final String nick = a.next();
                int i = 0;
                    for(i=0; i< users.size(); i++){
                        if(nick.equals(user.getName())){
                            it = true;
                            break;
                        }
                        if(nick.intern()== (users.get(i).getName().intern())){
                            System.out.println("\ndo you want to send request to " + users.get(i).getName()+"? y/n");
                            final Scanner b = new Scanner(System.in);
                            final String option = b.next();
                                if(option.equals("y")){
                                    //user.request.add(user);  
                                    users.get(i).request.add(user);
                                    System.out.println("\nfriendship request sent!");
                                    System.out.println("\ntype to continue");
                                    final Scanner c = new Scanner(System.in);
                                    final String op = c.nextLine();
                                    return;
                                }
                                else if(option.equals("n")){
                                    System.out.println("\ntype to continue:");
                                    Scanner ex =  new Scanner(System.in);
                                    ex.nextLine();
                                    return;
                                }
                                else{
                                    System.out.println("\nInvalid selection, Please try again. ");
                                    Scanner ex = new Scanner(System.in);
                                    ex.nextLine();
                                }
                                it = true;
                        }
                        else if(!nick.equals(user.getName())){
                            it = false;
                        }
                    }
                    if(!it){
                        System.out.println("User does not exist!");
                        System.out.println("\ntype to continue:");
                        Scanner ex = new Scanner(System.in);
                        ex.nextLine();
                        return;
                    }
                }
                if(choice == 3){
                    listFriends(user, user.friends);
                }
                if(choice == 4){
                    sendMensage(user, user.friends);
                }
                if(choice == 5){
                    printMessage(user, users);
                }

                if(choice == 6){
                    removeFriend(user, user.friends);
                }
            }
            catch(final NumberFormatException e){
                System.out.println("\nInvalid selection, Please try again. ");
                Scanner ex = new Scanner(System.in);
                ex.nextLine();
            }

        }
        

        public void printListFriend(final Users user, final ArrayList<Users> request, final ArrayList<UserDo> users){
            int i;
                System.out.println("\nfriendship request: ");
                for(i=0 ; i < request.size(); i++){
                        
                        System.out.println(request.get(i).getName());       
                }
                System.out.println("\ndo you want to accept the request? y/n?");
                final Scanner a = new Scanner(System.in);
                final String b = a.next();
                if(b.equals("y")){
                    aceptFriend(user, request, users);
                    return;
                }
                if(b.equals("n")){
                    System.out.println("\ntype to continue:");
                    Scanner ex = new Scanner(System.in);
                    ex.nextLine();
                    return;
                }
                else{
                    System.out.println("Invalid selection, Please try again. ");
                    Scanner ex = new Scanner(System.in);
                    ex.nextLine();
                }
        }


        public void aceptFriend(final Users user, final ArrayList<Users> request, final ArrayList<UserDo> users){

            int i;
            for(i=0 ; i < request.size(); i++){

                user.friends.add(user.request.get(i));
                for(final Users usersIdenx : users){
                    if(usersIdenx.getName().equals(user.request.get(i).getName())){
                        usersIdenx.friends.add(user);
                        System.out.println(user.request.get(i));
                        
                    }
                }
                user.request.remove(i);

            }

            System.out.println("\nfriend request accepted!");
            System.out.println("\ntype to continue:");
            final Scanner c = new Scanner(System.in);
            final String op = c.nextLine();
            if(op.equals("y")){
                return;
            }


        }

        public void listFriends(final Users user, final ArrayList<Users> friends){
            int i;
            System.out.println("\nfriends:");
            for(i=0; i < friends.size(); i++){
                System.out.println(user.friends.get(i).getName());
            }
            System.out.println("\ntype to continue:");
            final Scanner c = new Scanner(System.in);
            final String op = c.nextLine();
            if(op.equals("y")){
                return;
            }
            return;
            
        }

       public void removeFriend(final Users user, final ArrayList<Users> friends){
           System.out.println("\nenter friend's username");
           final Scanner a = new Scanner(System.in);
           final String nick = a.next();
           int i;
           for(i=0; i<friends.size(); i++){
                if(nick.equals(user.friends.get(i).getName())){
                    
                    System.out.println("\nremove friend? y/n");
                    final Scanner b = new Scanner(System.in);
                    final String option = b.nextLine();
                    if(option.equals("y")){
                        user.friends.remove(i);
                        System.out.println("\nfriend removed!");
                    }
                    else if(option.equals("n")){
                        return;

                    }
                        System.out.println("\ntype to continue:");
                        final Scanner c = new Scanner(System.in);
                        c.nextLine();           
                    }   
                }
        }
            public void sendMensage(final Users user, final ArrayList<Users> friends){
            System.out.println("\nenter friend's username to send menssage:");
            final Scanner a = new Scanner(System.in);
            final String nick = a.next();
            int i;
            final String username = user.getName();
            for(i=0; i<friends.size(); i++){
                 if(nick.equals(user.friends.get(i).getName())){
                     System.out.println("\ntype the message:");
                     final Scanner b =  new Scanner(System.in);
                     final String message = b.nextLine();
                     user.backup.add("\nmessage from: "+username+"\n"+message);
                     friends.get(i).menssage.add("\nmessage from: "+username+"\n"+message);
                     System.out.println("\nMessage sent!");
                     System.out.println("\ntype to continue:");
                     final Scanner q = new Scanner(System.in);
                     q.nextLine();
                 }

        }
    }

    public void printMessage(final Users user, final ArrayList<UserDo> users){
        
        for(final String s : user.menssage){
            System.out.println(s);
        }
        System.out.println("\ntype to continue:");      
        final Scanner a = new Scanner(System.in);
        a.nextLine();
    }

    public void createCommunity(final Users user, final ArrayList<UserDo> users, final ArrayList<Community> communityList){
        System.out.println("\n1) create community");
        System.out.println("2) add members");
        System.out.println("3) join some community");
        final Scanner a = new Scanner(System.in);
        int choice;
        try{
            choice = Integer.parseInt(a.nextLine());
            if(choice == 1){
                System.out.println("\nenter your community name: ");
                final Scanner b = new Scanner(System.in);
                final String commuName = b.nextLine();
                user.backup.add("community name "+ commuName);
                System.out.println("\nenter the description of your community:");
                final Scanner c = new Scanner(System.in);
                final String descriptionCommu = c.nextLine();
                user.backup.add("community description "+ descriptionCommu);
                communityList.add(new Community (user.getlogin(), user.getName(), user.getEmail(), user.getpassword(), user.getNumber(), commuName, descriptionCommu));
                System.out.println(commuName+" created!");
                //System.out.println(newcommu.UserAdm);
                System.out.println("\n type to continue:");
                final Scanner q = new Scanner(System.in);
                q.nextLine();
            }
            if(choice == 2){
                addMembers(user, users);

            }
            if(choice == 3){
                final Community newcommu = new Community("none","none","none","none",0,"none","none");
                    System.out.println("\nactive communities:");
                    int i;
                    int p;
                    int z;
                    boolean option =  false;
                    if(communityList.size() <= 1){
                        System.out.println("\nno existing community");
                        System.out.println("\ntype to continue:");
                        Scanner ex = new Scanner(System.in);
                        ex.nextLine();  
                        return; 
                    }
                        for(p=0; p<communityList.size(); p++){
                            
                            if(communityList.get(p).getNameComu().equals("none")){
                                p++;
                            }
                            System.out.println(communityList.get(p).getNameComu());
                        }
                        System.out.println("\nenter the name of the community you want to join: ");
                        final Scanner q = new Scanner(System.in);
                        final String namecommu = q.nextLine();
                        for(i=0; i<communityList.size(); i++){
                            if(communityList.get(i).getNameComu().equals(namecommu)){;
                                option = true;
                                for(z=0; z<communityList.size(); z++){
                                    if(users.get(z).getName().equals((communityList.get(i).getNameAdm()))){
                                        users.get(z).requestcommunity.add(user);
                                    }
                                }     
                            }
                        }
                        if(option == true){
                            System.out.println("\na request has been sent to "+communityList.get(i-1).getNameAdm()+"!");
                            System.out.println("\ntype to continue:");
                            final Scanner o = new Scanner(System.in);
                            o.nextLine();
                            
                        }
            }
        }
        catch(final NumberFormatException e){
            System.out.println("\nInvalid selection, Please try again.");
            Scanner b = new Scanner(System.in);
            b.nextLine();
        }

        }

        public void addMembers(final Users user, final ArrayList<UserDo> users){
            System.out.println(" community requests:");
            int i;
            if(user.requestcommunity.size() <= 0){
                System.out.println("\nno requests");
                System.out.println("\ntype to continue:");
                Scanner ex = new Scanner(System.in);
                ex.nextLine();
            }
                
            for(i=0; i<user.requestcommunity.size(); i++){
                System.out.println("request from ");
                System.out.println(user.requestcommunity.get(i).getName());
                System.out.println("\naccept? y/n" );
                final Scanner a = new Scanner(System.in);
                final String option = a.nextLine();
                if(option.equals("y")){
                    user.requestcommunity.add(user.requestcommunity.get(i));
                    System.out.println("\nuser accepted in the community!");
                    System.out.println("\n type to continue");
                    final Scanner q = new Scanner(System.in);
                    q.nextLine();
                    return;

                }
                else if(option.equals("n")){
                    user.requestcommunity.remove(user.requestcommunity.get(i));
                    System.out.println("\nuser removed!");
                    System.out.println("\n type to continue");
                    final Scanner q = new Scanner(System.in);
                    q.nextLine();
                    return;
                }
            }
        }

        public void backup(final Users user, final ArrayList<UserDo> users){
            for(final String s : user.backup){
                System.out.println(s);
                
                
            }
            System.out.println("\n type to continue:");
            final Scanner q = new Scanner(System.in);
            q.nextLine();
        }

        public void feedNews(final Users user, final ArrayList<UserDo> users, final ArrayList<String> feedMessages){
            System.out.println("\n1) post to feed");
            System.out.println("2) open feedNews");
            System.out.println("3) enable feed for friends");
            final Scanner a = new Scanner(System.in);
            try{
                final int option = Integer.parseInt(a.nextLine());
                if(option == 1){
                    System.out.println("\nenter the message to publish:");
                    final Scanner q = new Scanner(System.in);
                    final String messageFeed = q.nextLine();
                    feedMessages.add("\npublication of "+user.getName()+"\n "+messageFeed);
                    user.backup.add("\npublication of "+user.getName()+"\n "+messageFeed);
                    for(final UserDo userIndex : users ){
                        for(int i=0; i<user.friends.size();i++){
                            user.friends.get(i).feedFriends.add("\npublication of "+user.getName()+"\n "+messageFeed);
                        } 
                    }
                    System.out.println("\ntype to continue:");
                    Scanner ex =  new Scanner(System.in);
                    ex.nextLine();
                }
                if(option == 2){
                    if(feed == false){
                        for(final String s : feedMessages){
                            System.out.println(s);
                        }
                }
                    if(feed ==  true){
                        for(final String s : user.feedFriends){
                            System.out.println(s);
                        }
                    }
                        System.out.println("\n type to continue");
                        final Scanner q = new Scanner(System.in);
                        q.nextLine();
                }
                
                if(option == 3){
                    System.out.println("\nenable feed visible only to friends? y/n");
                    final Scanner b = new Scanner(System.in);
                    final String option2 = b.nextLine();
                    if(option2.equals("y")){
                        feed = true;
                        System.out.println("\nfeed enabled for friends only!");
                        System.out.println("\ntype to continue:");
                        final Scanner v = new Scanner(System.in);
                        
                        v.nextLine();
                        return;
                        
                    }
                    else if(option2.equals("n")){
                        feed = false;
                        System.out.println("\nfeed enabled for everyone!");
                        System.out.println("\ntype to continue:");
                        final Scanner v = new Scanner(System.in);
                        
                        v.nextLine();
                        return;
                    }
                    else{
                        System.out.println("\nInvalid selection, Please try again. ");
                        Scanner ex = new Scanner(System.in);
                        ex.nextLine();
                    }
            }
        }
        catch(final NumberFormatException e){
            System.out.println("\nInvalid selection, Please try again. ");
            Scanner ex = new Scanner(System.in);
            ex.nextLine();
        }
    }
}

    

