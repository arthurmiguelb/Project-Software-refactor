package Users;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import Users.Community;

public class MenuLogin{
    boolean feed;
    boolean exit; 
    boolean sai = false;
    Friend friend = new Friend();
    CommunityEdit communityEdit = new CommunityEdit();
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
            friend.FriendMenu(user, users);
            break;

            case 4:
            communityEdit.createCommunity(user, users, communityList);
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

    private void delete_profile(final Users user, final ArrayList<UserDo> users){
        users.remove(user);
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

    

