import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengyu
 * @since 5/13/17
 */
public class ShakeShackMenu {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShakeShackMenu.class);
    private Map<String, MenuItem> menuList;

    public ShakeShackMenu() {
        menuList = new HashMap<>();
        loadMenu();
    }

    public Map<String, MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(Map<String, MenuItem> menuList) {
        this.menuList = menuList;
    }

    public void loadMenu() {
        LOGGER.info("Loaded menu in Shake Shack Menu.");

        MenuItem food1 = new MenuItem("shroom burger", 6.99);
        MenuItem food2 = new MenuItem("shack stack", 9.95);
        MenuItem food3 = new MenuItem("fries", 2.99);
        MenuItem food4 = new MenuItem("cheese fries", 3.99);
        MenuItem food5 = new MenuItem("coke", 2.35);

        menuList.put(food1.getFoodName(), food1);
        menuList.put(food2.getFoodName(), food2);
        menuList.put(food3.getFoodName(), food3);
        menuList.put(food4.getFoodName(), food4);
        menuList.put(food5.getFoodName(), food5);
    }

    public double getPrice(String foodName) {
        LOGGER.debug("Trying to get the price of {}", foodName.toLowerCase());

        Map<String, MenuItem> list = getMenuList();
        return list.get(foodName.toLowerCase()).getPrice();
    }
}
