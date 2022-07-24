import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dispatcher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        Map<User, ArrayList<Product>> mapUsers = new HashMap<>();
        Map<Product, ArrayList<User>> mapProducts = new HashMap<>();
        Displayer displayer = new Displayer();
        DataBaseAdministrator admin = new DataBaseAdministrator();

        int id = 0;
        while (true){                                                                                       //Меню для виконання операцій
            System.out.println("""
                    
                    Set the id of chosen action
                    1 - Display list of all users
                    2 - Display list of all products
                    3 - Buy product
                    4 - Display list of user products by user id
                    5 - Display list of users that bought product by product id
                    6 - Stop the program
                    7 - Add user
                    8 - Add product
                    9 - Remove user
                    10 - Remove product""");
            id = scan.nextInt();
            if(id < 1 || id > 10){
                System.out.println("Wrong number, try again");
                continue;
            }
            switch (id) {
                case 1 -> displayer.displayUsers(users);
                case 2 -> displayer.displayProducts(products);
                case 3 -> {
                    System.out.println("Type user id and product id");
                    try {
                        User.buy(scan.nextInt(), scan.nextInt(), users, products, mapUsers, mapProducts);
                    } catch (NotEnoughMoneyException e) {
                        System.out.println("Not Enough money");
                    }
                }
                case 4 -> displayer.displayBoughtProductsByUsers(mapUsers);
                case 5 -> displayer.displayUsersByBoughtProducts(mapProducts);
                case 6 -> System.exit(0);
                case 7 -> admin.addUser(users);
                case 8 -> admin.addProduct(products);
                case 9 -> {
                    System.out.println("Set user id to be deleted");
                    int uId = scan.nextInt();
                    admin.deleteUser(uId, users);
                }
                case 10 -> {
                    System.out.println("Set product id to be deleted");
                    int pId = scan.nextInt();
                    admin.deleteProduct(pId, products, mapUsers);
                }
            }
        }

    }

}
