package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class Utils {

    public static WebDriver driver;
    public static HashMap<String, String> myMap = new HashMap<String, String>();

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Utils.url = url;
    }

    static String url;

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        Utils.browser = browser;
    }

    static String browser;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Utils.password = password;
    }

    static String password;

    public static void setUsername(String username) {
        Utils.username = username;
    }

    public static String getUsername() {
        return username;
    }

    private static String username;

    static{
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("Environment.properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUrl(props.getProperty("url"));
        setUsername(props.getProperty("username"));
        setPassword(props.getProperty("password"));
        setBrowser(props.getProperty("browser"));
    }

    public void readData() throws IOException {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        int lastRowNum = sheet.getLastRowNum();

        for(int i=1;i<=lastRowNum;i++){
            DataFormatter formatter = new DataFormatter();
            String key = formatData(sheet,i,0);
            String value = formatData(sheet,i,1);
            myMap.put(key,value);
        }
    }

    public String formatData(Sheet sheet,int row, int cell){
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(cell));

    }

    public void launchBrowser() {
        String value = getBrowser();
       if(value.contains("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
        }else if(value.contains("firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }
        driver.manage().window().maximize();

    }

    public void navigateToUrl(){ driver.get(getUrl()); }

    public void enterText(WebElement ele, String str)
    {
        ele.sendKeys(str);
    }

    public void click(WebElement ele){
        ele.click();
    }

}
