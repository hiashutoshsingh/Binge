package ashu.com.bingetest;

public class MenuItemModel {
    String menu_item;
    String menu_cost;

    public MenuItemModel() {
    }

    public MenuItemModel(String menu_item, String menu_cost) {
        this.menu_item = menu_item;
        this.menu_cost = menu_cost;
    }

    public String getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(String menu_item) {
        this.menu_item = menu_item;
    }

    public String getMenu_cost() {
        return menu_cost;
    }

    public void setMenu_cost(String menu_cost) {
        this.menu_cost = menu_cost;
    }
}
