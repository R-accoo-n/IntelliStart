import java.util.ArrayList;
import java.util.Map;

public class Displayer {                        //Клас з методами для виводу в консоль різних видів даних

    public  void displayUsers(ArrayList<User> users){       //Вивід всіх користувачів
        for(User temp : users){
            System.out.println(temp.toString());
        }
    }

    public  void displayProducts(ArrayList<Product> products){      //Вивід всіх продуктів
        for(Product temp : products){
            System.out.println(temp.toString());
        }
    }

    public void displayBoughtProductsByUsers(Map<User, ArrayList<Product>> map){        // вивід списку покупок за ід покупця
        for(User temp : map.keySet()){
            System.out.println(temp + " : " + map.get(temp));
        }
    }

    public void displayUsersByBoughtProducts(Map<Product, ArrayList<User>> map){        //Вивід списку покупців за ід продукту
        for(Product temp : map.keySet()){
            System.out.println(temp + " : " + map.get(temp));
        }
    }
}
