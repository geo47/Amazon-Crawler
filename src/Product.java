import java.util.Random;

public class Product {

    private int maxAge;
    private int estAge;
    private int minAge;
    private String price;
    private String url;
    private String title;
    private String clothingType;
    private String color;
    private String gender;
    private String desc;
    private float rate;

    public Product(){
       /* minAge = 20;
        maxAge = 35;
        estAge = generateRandomAge(minAge);*/
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getEstAge() {
        return estAge;
    }

    public void setEstAge(int estAge) {
        this.estAge = estAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int generateRandomAge(int minAge) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(15) + minAge;
//        System.out.println("Random number generated is : " + randomInt);
        return randomInt;
    }
}
