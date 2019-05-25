package ashu.com.bingetest;

public class ItemData {


    private String res_name;
    private String res_type;
    private String res_cost;
    private String res_rating;
    private int res_image;

    public String getRes_type() {
        return res_type;
    }

    public void setRes_type(String res_type) {
        this.res_type = res_type;
    }

    public String getRes_cost() {
        return res_cost;
    }

    public void setRes_cost(String res_cost) {
        this.res_cost = res_cost;
    }

    public String getRes_rating() {
        return res_rating;
    }

    public void setRes_rating(String res_rating) {
        this.res_rating = res_rating;
    }

    public ItemData(String res_name, String res_type, String res_cost, String res_rating, int res_image) {
        this.res_name = res_name;
        this.res_type = res_type;
        this.res_cost = res_cost;
        this.res_rating = res_rating;
        this.res_image = res_image;
    }


    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public int getRes_image() {
        return res_image;
    }

    public void setRes_image(int res_image) {
        this.res_image = res_image;
    }
}
