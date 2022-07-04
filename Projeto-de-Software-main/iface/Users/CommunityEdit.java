package Users;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunityEdit {
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
    
}
