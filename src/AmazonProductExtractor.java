import com.google.gson.Gson;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AmazonProductExtractor {

    private List<String> urlList;
    private List<Product> productList;

    public AmazonProductExtractor(){
        this.urlList = new ArrayList<>();
        this.productList = new ArrayList<>();
    }

    public static void main(String[] args) {
        //Scanner scan= new Scanner(System.in);
        System.out.println("Enter Page URL (Amazon): ");
//        String appUrl = scan.nextLine();

//        Men
//        Shirts
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=7147441011&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147441011%2Cn%3A1040658&dc&crid=15WNF9ISRYLD0&qid=1558861983&rnid=7147441011&sprefix=shirts%2Caps%2C320&ref=sr_nr_n_1";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=7147441011&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658&dc&page=2&crid=15WNF9ISRYLD0&qid=1558862000&rnid=7147441011&sprefix=shirts%2Caps%2C320&ref=sr_pg_2";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=7147441011&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658&dc&page=3&crid=15WNF9ISRYLD0&qid=1558862273&rnid=7147441011&sprefix=shirts%2Caps%2C320&ref=sr_pg_3";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=7147441011&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658&dc&page=4&crid=15WNF9ISRYLD0&qid=1558862539&rnid=7147441011&sprefix=shirts%2Caps%2C320&ref=sr_pg_4";

//        Jeans
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045564&dc&crid=15WNF9ISRYLD0&qid=1558862785&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_nr_n_5";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045564&dc&page=2&crid=15WNF9ISRYLD0&qid=1558929482&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_pg_2";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045564&dc&page=3&crid=15WNF9ISRYLD0&qid=1558929763&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_pg_3";

//        Jackets & Coats
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045830&dc&crid=15WNF9ISRYLD0&qid=1558930223&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_nr_n_4";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045830&dc&page=2&crid=15WNF9ISRYLD0&qid=1558930242&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_pg_2";

//        Pants
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045558&dc&crid=15WNF9ISRYLD0&qid=1558930685&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_nr_n_6";
//        String appUrl = "https://www.amazon.com/s?k=shirts+for+men&i=fashion-mens&bbn=1040658&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147441011%2Cn%3A1040658%2Cn%3A1045558&dc&page=2&crid=15WNF9ISRYLD0&qid=1558937384&rnid=1040658&sprefix=shirts%2Caps%2C320&ref=sr_pg_2";

//        Women
//        dress
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024&dc&qid=1558944662&rnid=1040660&ref=sr_nr_n_1";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024&dc&page=2&qid=1558944676&rnid=1040660&ref=sr_pg_2";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024&dc&page=3&qid=1558945082&rnid=1040660&ref=sr_pg_3";

//        Sweater
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1044456&dc&qid=1558945757&rnid=1040660&ref=sr_nr_n_3";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1044456&dc&page=2&qid=1558945767&rnid=1040660&ref=sr_pg_2";

//        Jeans
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048188&dc&qid=1558946583&rnid=1040660&ref=sr_nr_n_5";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048188&dc&page=2&qid=1558946587&rnid=1040660&ref=sr_pg_2";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048188&dc&page=3&qid=1558946863&rnid=1040660&ref=sr_pg_3";

//        Pants
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048184&dc&qid=1558947277&rnid=1040660&ref=sr_nr_n_6";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048184&dc&page=2&qid=1558947370&rnid=1040660&ref=sr_pg_2";

//        Skirt
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045022&dc&qid=1558947784&rnid=1040660&ref=sr_nr_n_7";
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A7141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045022&dc&page=2&qid=1558947789&rnid=1040660&ref=sr_pg_2";

//        Shorts
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1048186&dc&qid=1558948356&rnid=1040660&ref=sr_nr_n_8";

//        Legging
//        String appUrl = "https://www.amazon.com/s?k=women+fashion&i=fashion-womens&bbn=1040660&rh=n%3A7141123011%2Cn%3A%217141124011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1258967011&dc&qid=1558948601&rnid=1040660&ref=sr_nr_n_9";
        String appUrl = "https://www.amazon.com/s?k=blouse&i=fashion-womens-clothing&ref=nb_sb_noss_2";


        System.out.println("The URL is: "+appUrl);

        AmazonProductExtractor amazonProductExtractor = new AmazonProductExtractor();
        amazonProductExtractor.loadProductListing(appUrl);
    }

    private void loadProductListing(String appUrl) {

        WebDriver driver = ChromeDriverInstance.getInstance();
        driver.get(appUrl);
        if(null != driver)
            System.out.println("OK");
        else
            System.out.println("NOT OK");

        List<WebElement> webElements = ((ChromeDriver) driver).findElementsByXPath("//div[@class='s-result-list s-search-results sg-row']");
        System.out.println(webElements.size());

        WebElement webElement = webElements.get(0);

        List<WebElement> linkElements = webElement.findElements(By.xpath("//div[@class='sg-col-inner']//div[@class='sg-row'][2]//div[1]//span[@data-component-type='s-product-image']//a[@class='a-link-normal']"));
        System.out.println(linkElements.size());

        for(WebElement linkElement: linkElements){
            String link = linkElement.getAttribute("href");
            System.out.println("link: "+link);
            urlList.add(link);
        }

//        loadProductDescription();
        poolWorkerTask();
//        log(productData);

//// close the web browser
//        driver.close();
//        System.out.println("Test script executed successfully.");
//
//// terminate the program
//        System.exit(0);
        driver.close();
        driver.quit();
    }

    private void poolWorkerTask(){
        System.out.println("listSize: "+urlList.size());
        ExecutorService executor = Executors.newFixedThreadPool(4);//creating a pool of 5 threads
        for (int i = 0; i < urlList.size(); i++) {
            Runnable worker = new WorkerThread(""+i, urlList.get(i));
            executor.execute(worker);//calling execute method of ExecutorService
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");

        try {
            log(new Gson().toJson(productList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProductDescription(String url, String poolingId){

        System.out.println("Pool "+poolingId+" starts executing");
        WebDriver driver = ChromeDriverInstance.getInstance();
        driver.get(url);

        WebElement webElement = ((ChromeDriver) driver).findElementByXPath("//div[@id='dp']");

        WebElement categoryElement = null;
        try{
            categoryElement = webElement.findElement(By.xpath("//div[@id='dp']//div[@id='wayfinding-breadcrumbs_container']//ul"));
        }catch (NoSuchElementException noElementFoundEx){
            System.out.println("Pool "+poolingId+" execution failed");
            noElementFoundEx.printStackTrace();
            driver.close();
            driver.quit();
        }

        if(null != categoryElement){

            List<WebElement> categoryList = categoryElement.findElements(By.tagName("li"));
            categoryList = cleanCategoryList(categoryList);

            /*for(WebElement categotyItem: categoryList)
                System.out.println(categotyItem.getText());*/

            if(categoryList.get(2).getText().equals("Clothing")){

                String gender = categoryList.get(1).getText();
                String clothingType = categoryList.get(3).getText();

                //div[@class='a-row'][2]//div[@class='a-column a-span8 a-span-last']
                /*WebElement containerElement = webElement.findElement(By.xpath("//div[@id='dp-container']//div[@id='ppd']"));
                WebElement contentElement = containerElement.findElement(By.xpath("//div[@class='a-row'][2]"));
                WebElement cleanerElement = contentElement.findElement(By.xpath("//div[@class='a-column a-span8 a-span-last']//div[@class='a-fixed-right-grid']//div[@class='a-fixed-right-grid-inner']//div[@id='centerCol']"));*/

//                WebElement containerElement = webElement.findElement(By.xpath("//div[@id='centerCol']"));
                WebElement containerElement = webElement.findElement(By.id("centerCol"));
                WebElement leftContainerElement = webElement.findElement(By.id("leftCol"));

                WebElement titleAndRatingElement = containerElement.findElement(By.id("title_feature_div"));
                WebElement titleElement = titleAndRatingElement.findElement(By.id("productTitle"));
                WebElement ratingElement = titleAndRatingElement.findElement(By.id("acrPopover"));

                WebElement priceElement = containerElement.findElement(By.id("priceblock_ourprice"));

                WebElement imgDivElement = leftContainerElement.findElement(By.id("imgTagWrapperId"));
                WebElement imgElement = imgDivElement.findElement(By.tagName("img"));

                WebElement colorElement = containerElement.findElement(By.id("variation_color_name"));
                WebElement colorSelection = colorElement.findElement(By.xpath("div[@class='a-row']//span"));

                WebElement descElement = containerElement.findElement(By.id("feature-bullets"));
                List<WebElement> ulDesc = descElement.findElements(By.xpath("ul[@class='a-unordered-list a-vertical a-spacing-none']"));

                String title = titleElement.getText();
                String rating = ratingElement.getAttribute("title").split(" ")[0];
                String price = priceElement.getText();
                String imageUrl = imgElement.getAttribute("src");
                String color = colorSelection.getText();
                String desc = "";
                for(WebElement li:ulDesc){
//                    System.out.println(li.getText());
                    desc += li.getText();
                }

                System.out.println("gender: "+gender);
                System.out.println("clothingType: "+clothingType);
                System.out.println("title: "+title);
                System.out.println("rating: "+rating);
                System.out.println("price: "+price);
                System.out.println("color: "+color);
                System.out.println("desc: "+desc);

                Product product = new Product();
                product.setPrice(price.replace("$",""));
                product.setUrl(imageUrl);
                product.setTitle(title);
                product.setDesc(desc);
                product.setColor(color);
                product.setRate(Float.parseFloat(rating));
                product.setGender(gender);
                product.setClothingType(clothingType);

                productList.add(product);
                System.out.println("Pool "+poolingId+" execution Successful");
            }
        }
        driver.close();
        driver.quit();
    }

    //div[@id='centerCol']

    public static void log(String message) throws IOException {
        FileWriter fileWriter = new FileWriter("//home//muzamil//Desktop//Project//Curation//java//selenium-java-3.14.0//output.txt", true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(message);

//        fileWriter.close();
        writer.close();
//        PrintWriter out = new PrintWriter(new FileWriter("//home//muzamil//Desktop//Project//Curation//java//selenium-java-3.14.0//output.txt", true), true);
//        out.write(message);
//        out.close();
    }

    public static List<WebElement> cleanCategoryList(List<WebElement> categoryList){
        // studentList is a list of students
        Iterator iterator = categoryList.iterator();
        // loop over the list using iterator
        while(iterator.hasNext()) {
            WebElement webElement = (WebElement) iterator.next();
            // check if result of student is "Fail"
            if(webElement.getText().equals("›")) {
                // remove it using iterator
                iterator.remove();
            }
        }
        return categoryList;
    }

    class WorkerThread implements Runnable {
        private String messageID;
        private String message;
        public WorkerThread(String messageID, String message){
            this.messageID = messageID;
            this.message = message;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+" (Start) messageID = "+messageID+" message: "+message);
            loadProductDescription(message, messageID);//call loadProductDescription method that load the description page
            System.out.println(Thread.currentThread().getName()+" (End) messageID = "+messageID+" message: "+message);//prints thread name
        }
        /*private void processmessage() {
            try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }
        }*/
    }
}
