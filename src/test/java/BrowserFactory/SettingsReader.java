package BrowserFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class SettingsReader {

    private Object obj;

    public void readFile (String file) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            this.obj = obj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue (String key) {
        JSONObject jsonObject = (JSONObject) obj;
        String data = (String) jsonObject.get(key);
        return data;
    }

    public String getValueLong (String key) {
        JSONObject jsonObject = (JSONObject) obj;
        long data = (long) jsonObject.get(key);
        return String.valueOf(data);
    }


}
