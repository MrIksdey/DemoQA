package UtilPackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DataReader {

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

    public String getValueString (String key, int id) {
        JSONObject object = (JSONObject) obj;
        JSONArray array = (JSONArray) object.get("id");
        JSONObject idPeople =(JSONObject) array.get(id);
        String data = (String) idPeople.get(key);
        return data;
    }

    public String getValueLong (String key, int id) {
        JSONObject object = (JSONObject) obj;
        JSONArray array = (JSONArray) object.get("id");
        JSONObject idPeople =(JSONObject) array.get(id);
        long data = (long) idPeople.get(key);
        return String.valueOf(data);
    }
}
