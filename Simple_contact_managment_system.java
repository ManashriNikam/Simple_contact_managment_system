
import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    String name;
    String phone;
    String email;

    public Contact(String name,String phone,String email) {
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
}

public class Simple_contact_managment_system {
    static ArrayList<Contact> contacts=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("*** Contact Management System ***");
        System.out.println("1. Add Contact");
        System.out.println("2. View Conatct");
        System.out.println("3. Update Conatct");
        System.out.println("4. Delete Conatct");
        System.out.println("5. Exit");

        int ch;

        do{
            System.out.print("\nEnter your operation : ");
            ch=sc.nextInt();
            
            switch (ch) {
                case 1: add_contact();
                        break;
                case 2: view_contact();
                        break;
                case 3: update_contact();
                        break;
                case 4: delete_contact();
                        break;
                case 5: System.out.println("Exit ");
                        break;
                default:System.out.println("INVALID CHOICE..!!");
                        break;
            }
        }while(ch!=5);
    }
       
    static boolean isValidPhone(String phone)
    {
        return phone.matches("^[0-9]{10}");
    }

    static boolean isValidEmail(String email){
        return email.matches("^[a-zA-Z0-9._]+@gmail.com$");
    }


    static void add_contact(){
        sc.nextLine();
        System.out.print("Enter Name : ");
        String name=sc.nextLine();

        String phone;
        do { 
            System.out.print("Enter Phone No : ");
            phone=sc.nextLine();
            if(!isValidPhone(phone)){
                System.out.println("Enter Valid 10 Digit phone number ");
            }

        } while (!isValidPhone(phone));
        
        String email;
        do { 
            System.out.print("Enter Email ID : ");
            email=sc.nextLine();
            if(!isValidEmail(email)){
                System.out.println("Enter Valid Email ID ");
            }

        } while (!isValidEmail(email));

        contacts.add(new Contact(name,phone,email));
        System.out.println("Contact Add Successfully");
    }
    
    static void view_contact(){
        if(contacts.isEmpty()){
            System.out.print("Contact Not Found !!");
            return;
        }

        System.out.println("Contact List : ");
        for(int i=0;i<contacts.size();i++){
            Contact c =contacts.get(i);
            System.out.println((i+1)+" || Name : "+c.name +" || Phone : "+c.phone +" || Email : "+c.email);
        }
    }

    static void update_contact(){
        view_contact();
        if(contacts.isEmpty()) return;
        
        System.out.println("Enter Contact Number to Update : ");
        int idx=sc.nextInt()-1;
        
        if(idx>=0 && idx<contacts.size()){
            sc.nextLine();
            System.out.println("Enter new Name : ");
            contacts.get(idx).name=sc.nextLine();

            String phone;
            do { 
                System.out.println("Enter Phone No : ");
                phone=sc.nextLine();
                if(!isValidPhone(phone)){
                    System.out.println("Enter Valid 10 Digit phone number ");
            }

            } while (!isValidPhone(phone));
            contacts.get(idx).phone=phone;

            String email;
            do { 
                System.out.println("Enter Email ID : ");
                email=sc.nextLine();
                
                if(!isValidEmail(email)){
                    System.out.println("Enter Valid Email ID ");
                }

            } while (!isValidEmail(email));
            contacts.get(idx).email=email;

            System.out.println("Contact update Successfully");
        }
        else{
            System.out.println("Invalid Contact number..!!");
        }
    }

    static void delete_contact(){
        view_contact();
        if(contacts.isEmpty()) return;
        
        System.out.println("Enter Contact Number to delete: ");
        int idx=sc.nextInt()-1;
    
        if(idx>=0 && idx<contacts.size()){
            contacts.remove(idx);
            System.out.println("Contact delete Successfully");
        }
        else{
            System.out.println("Invalid Contact number..!!");
        
        }
    }
}
