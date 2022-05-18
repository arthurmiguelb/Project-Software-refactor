package Users;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Users user = new UserDo("name", "login", "password", "none", 0);
    MenuLogin menulogin = new MenuLogin();
    boolean exit;
    
    
    public void runMenu(ArrayList<UserDo> users, ArrayList<Community> communitList, ArrayList<String> feedMessages){
        while(!exit){
            printmenu();
            int choice = getInput();
            perfomAction(choice, users, communitList, feedMessages);
        }
    } 
    private void printmenu(){
        System.out.println("\n+-------------------------------+");
        System.out.println("|       Welcome to iFace        |");
        System.out.println("|       Menu Application        |");
        System.out.println("+-------------------------------+");
        System.out.println("\nSelect the option:");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("0) Exit");
    }
   
    private int getInput(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 2){
            try{
                System.out.println("\nEnter your choice: ");
                choice =  Integer.parseInt(kb.nextLine());

            }
            catch(NumberFormatException e){
                System.out.println("Invalid selection, Please try again.");

            }
        }
        return choice;
    }
    
    private void perfomAction(int choice, ArrayList<UserDo> users, ArrayList<Community> communityList, ArrayList<String> feedMessages){
        switch(choice){
            case 0:
            exit = true;
            //System.out.print("\033[H\033[2J");  
            //System.out.flush(); 
            System.out.println("\nThank you for using our application.");
            break;
            case 1:
            //System.out.print("\033[H\033[2J");  
            //System.out.flush();
            loginInf(users, communityList, feedMessages);
            break;
            
            case 2:
            //System.out.print("\033[H\033[2J");  
            //System.out.flush();
            registerInf(users);
            break;

            default:
        }
    }

    private void registerInf(ArrayList<UserDo> users){
       
        System.out.println("\nEnter your nickname: ");
        Scanner a = new Scanner(System.in);
        String nickname = a.next();
        for(Users user : users){
            if(user.getName().equals(nickname)){
                System.out.println("\nnickname already exists. ");
                return;
            }
        }
        System.out.println("\nEnter your username: ");
        Scanner b = new Scanner(System.in);
        String username = b.next();
        for(Users user : users){
            if(user.getlogin().equals(username)){
                System.out.println("\nusername already exists. ");
                return;
            }
        }
        System.out.println("\nEnter your password: ");
        Scanner c = new Scanner(System.in);
        String password = c.next();
        System.out.println("\nRepeat your password: ");
        Scanner c2 = new Scanner(System.in);
        String password2 = c2.next();
         
         if(password.equals(password2)){
            user.register(nickname, username, password, users); 
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("registered user!");
            return;
         }
         else{
             System.out.println("\nPasswords are not the same ");
             return;
         }
    }

    private void loginInf(ArrayList<UserDo> users, ArrayList<Community> communityList, ArrayList<String> feedMessages){
        boolean it = false;
        System.out.println("\nenter your username:");
        Scanner u = new Scanner(System.in);
        String login = u.next();
        for(Users user : users){
            if(user.getlogin().equals(login)){
                System.out.println("\nenter yous password: ");
                Scanner p = new Scanner(System.in);
                String password = p.next();
                it = true;
                
                if(user.getpassword().equals(password)){
                    menulogin.runMenuLogin(user, users, communityList, feedMessages);
                    break;
                }
                else{
                    it = false;
                }

            }  
        }
        if(it == false){
           
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\nuser is not registered!");
                runMenu(users, communityList, feedMessages);
        }



        //System.out.print("\033[H\033[2J");  
        //System.out.flush();
        

        

    }
}
