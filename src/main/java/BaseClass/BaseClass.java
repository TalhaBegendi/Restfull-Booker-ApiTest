package BaseClass;

import com.google.common.io.Resources;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class BaseClass {

    WebDriver webDriver;

    public BaseClass(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public static JSONObject readJsonFile(String jsonFileName) throws IOException {

        URL jsonFile = Resources.getResource(jsonFileName+".json");
        String json = Resources.toString(jsonFile, Charset.defaultCharset());
        JSONObject jsonObject = new JSONObject( json );
        return jsonObject;
    }
}
