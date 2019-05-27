package ashu.com.bingetest;

public class ItemData {

    private String fire_res_name;
    private String fire_res_type;
    private String fire_res_cost;
    private String fire_res_rating;
    private String fire_res_image;


    public ItemData() {

    }

    public ItemData(String fire_res_name, String fire_res_type, String fire_res_cost, String fire_res_rating, String fire_res_image) {
        this.fire_res_name = fire_res_name;
        this.fire_res_type = fire_res_type;
        this.fire_res_cost = fire_res_cost;
        this.fire_res_rating = fire_res_rating;
        this.fire_res_image = fire_res_image;
    }

    public String getFire_res_type() {
        return fire_res_type;
    }


    public String getFire_res_cost() {
        return fire_res_cost;
    }

    public void setFire_res_name(String fire_res_name) {
        this.fire_res_name = fire_res_name;
    }

    public void setFire_res_type(String fire_res_type) {
        this.fire_res_type = fire_res_type;
    }

    public void setFire_res_cost(String fire_res_cost) {
        this.fire_res_cost = fire_res_cost;
    }

    public void setFire_res_rating(String fire_res_rating) {
        this.fire_res_rating = fire_res_rating;
    }

    public void setFire_res_image(String fire_res_image) {
        this.fire_res_image = fire_res_image;
    }

    public String getFire_res_rating() {
        return fire_res_rating;
    }

    public String getFire_res_name() {
        return fire_res_name;
    }

    public String getFire_res_image() {
        return fire_res_image;
    }

}
