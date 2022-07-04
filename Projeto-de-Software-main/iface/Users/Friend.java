package Users;
import java.util.ArrayList;
import java.util.Scanner;

public class Friend{

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
}