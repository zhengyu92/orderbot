/**
 * @author zhengyu
 * @since 2017-05-13
 */
public class Order {
    private int userId;
    private String username, name;
    private double price;

    public Order(Integer userId, String userName, String name) {
        this.userId = userId;
        this.username = userName;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return username;
    }

    public String getName() {
        return name;
    }

    // For view command
    public String getViewString() {
        return "" + getName() + " by " + getUserName() + "";
    }

    public void setUserid(Integer newUserid){
        this.userId = newUserid;
    }

    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }
}