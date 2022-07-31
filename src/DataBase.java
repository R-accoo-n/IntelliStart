import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    static Map<User, ArrayList<Product>> mapUsers = new HashMap<>();
    static Map<Product, ArrayList<User>> mapProducts = new HashMap<>();
    ArrayList<User> users;
    ArrayList<Product> products;

    static void addDataByUser(User key, Product data){
        ArrayList<Product> alp;
        if(!mapUsers.containsKey(key)) {
            alp = new ArrayList<>();
        }else{
            alp = mapUsers.get(key);
        }
        alp.add(data);
        mapUsers.put(key, alp);
    }

    static void addDataByProduct(Product key, User data){
        ArrayList<User> alu;
        if(!mapProducts.containsKey(key)){
            alu = new ArrayList<>();
        }else{
            alu = mapProducts.get(key);
        }
        alu.add(data);
        mapProducts.put(key, alu);
    }

    public DataBase(ArrayList<User> users, ArrayList<Product> products) {
        this.users = users;
        this.products = products;
    }

}
