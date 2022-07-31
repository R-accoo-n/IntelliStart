import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private int money;
    private static int totalId = 0;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", money=" + money +
                '}';
    }

    public User(String firstName, String lastName, int money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.id = totalId;
        totalId++;
    }

    public static void buy(int userId, int productId , ArrayList<User> users, ArrayList<Product> products) throws NotEnoughMoneyException {
        User tempUser = null;                                                               //Метод для купівлі
        Product tempProduct = null;
        for(Product temp : products){
            if(temp.getId() == productId){
                tempProduct = temp;
                break;
            }
        }
        if(tempProduct == null){
            System.out.println("Wrong product id");
            return;
        }
        for(User temp : users){
            if(temp.id == userId){
                tempUser = temp;
                if(tempUser.money < tempProduct.getPrice()){
                    throw new NotEnoughMoneyException();
                }else{
                    System.out.println("Successfully bought the product");
                    tempUser.money -= tempProduct.getPrice();

                    DataBase.addDataByUser(tempUser, tempProduct);                                              //Додавання даних за користувачем

                    DataBase.addDataByProduct(tempProduct, tempUser);                                           //Додавання даних за продуктом
                }
                break;
            }
        }
        if(tempUser == null){
            System.out.println("Wrong user id");
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
