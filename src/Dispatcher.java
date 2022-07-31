import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dispatcher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase dataBase = new DataBase(new ArrayList<>(), new ArrayList<>());
        Displayer displayer = new Displayer();
        DataBaseAdministrator admin = new DataBaseAdministrator();

        int id;
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
                case 1 -> displayer.displayUsers(dataBase.users);
                case 2 -> displayer.displayProducts(dataBase.products);
                case 3 -> {
                    System.out.println("Type user id and product id");
                    try {
                        User.buy(scan.nextInt(), scan.nextInt(), dataBase.users, dataBase.products);
                    } catch (NotEnoughMoneyException e) {
                        System.out.println("Not Enough money");
                    }
                }
                case 4 -> displayer.displayBoughtProductsByUsers(DataBase.mapUsers);
                case 5 -> displayer.displayUsersByBoughtProducts(DataBase.mapProducts);
                case 6 -> System.exit(0);
                case 7 -> admin.addUser(dataBase.users);
                case 8 -> admin.addProduct(dataBase.products);
                case 9 -> {
                    System.out.println("Set user id to be deleted");
                    int uId = scan.nextInt();
                    admin.deleteUser(uId, dataBase.users);
                }
                case 10 -> {
                    System.out.println("Set product id to be deleted");
                    int pId = scan.nextInt();
                    admin.deleteProduct(pId, dataBase.products, DataBase.mapUsers);
                }
            }
        }

    }

}
