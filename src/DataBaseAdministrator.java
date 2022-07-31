import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DataBaseAdministrator {                            // Клас для роботи з додаванням та відніманням об'єктів

    public void addUser(ArrayList<User> users) {            //Додавання користувача
        Scanner scan = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        int money = (int) Double.NEGATIVE_INFINITY;
        while (firstName.equals("")) {
            System.out.println("Set user first name");
            firstName = scan.next();
            if (firstName.equals("")) System.out.println("Please, set not empty field");
        }
        while (lastName.equals("")) {
            System.out.println("Set user last name");
            lastName = scan.next();
            if (lastName.equals("")) System.out.println("Please, set not empty field");
        }
        while (money < 0) {
            System.out.println("Set amount of money");
            money = scan.nextInt();
            if (money < 0) System.out.println("Set non negative amount of money");
        }
        users.add(new User(firstName, lastName, money));
    }

    public void addProduct(ArrayList<Product> products) {               //Додавання продукту
        Scanner scan = new Scanner(System.in);
        String name = "";
        int price = (int) Double.NEGATIVE_INFINITY;
        while (name.equals("")) {
            System.out.println("Set product name");
            name = scan.next();
            if (name.equals("")) System.out.println("Please, set not empty field");
        }
        while (price < 0) {
            System.out.println("Set price");
            price = scan.nextInt();
            if (price < 0) System.out.println("Set non negative amount of money");
            products.add(new Product(name, price));
        }
    }

    public void deleteUser ( int userId, ArrayList<User > users){                       //Видалення користувача
        User userToBeDeleted = null;
        for (User temp : users) {
            if (temp.getId() == userId) {
                userToBeDeleted = temp;
            }
        }
        if (userToBeDeleted == null) {
            System.out.println("Wrong user id");
            return;
        }
        users.remove(userToBeDeleted);
    }

    public void deleteProduct(int productId, ArrayList<Product> products, Map<User, ArrayList<Product>> mapUsers){  //Видалення продукту з списку продуктів та зі
        Product productToBeDeleted = null;                                                                                                                         //списку покупок всіх, хто його купив
        for(Product temp : products){
            if(temp.getId() == productId){
                productToBeDeleted = temp;
            }
        }
        if(productToBeDeleted == null){
            System.out.println("Wrong product id");
            return;
        }

        products.remove(productToBeDeleted);

        ArrayList<Product> alp;

        for(User temp : mapUsers.keySet()){
            if(mapUsers.get(temp).contains(productToBeDeleted)){
                alp = mapUsers.get(temp);
                alp.remove(productToBeDeleted);
                mapUsers.put(temp, alp);
            }
        }

    }
}
