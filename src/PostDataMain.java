import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PostDataMain {

    public static void main(String[] args) {

        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("/home/muzamil/Desktop/Project/Curation/java/Selenium_Client/in/data/women/Sweater/dataset_2")));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Contents (Java 7) : " + contents);

        if(null != contents){

            Type products = new TypeToken<ArrayList<Product>>(){}.getType();
            List<Product> productList = new Gson().fromJson(contents, products);

            System.out.println("product size: "+productList.size());

            System.out.println(new Gson().toJson(productList.get(0)));
            for(Product product:productList){
                product.setMinAge(20);
                product.setMaxAge(35);
                product.setEstAge(product.generateRandomAge(20));
                new PostDataToServer().post(product);
            }

        }

    }
}
