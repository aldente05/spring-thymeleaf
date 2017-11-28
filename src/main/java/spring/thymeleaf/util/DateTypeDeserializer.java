package spring.thymeleaf.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by f.putra on 12/14/16.
 */
public class DateTypeDeserializer implements JsonDeserializer<Date> {
    private String[] DATE_FORMATS = new String[]{
            "EEE MMM dd HH:mm:ss z yyyy",
            "HH:mm:ss",
            "MMM d',' yyyy H:mm:ss a",
            "MM/dd/yyyy HH:mm:ss aaa",
            "yyyy-MM-dd",
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd HH:mmZ",
            "yyyy-MM-dd HH:mmZ",
            "yyyy-MM-dd HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd HH:mm:ss.SSSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'"

    };

    @Override
    public synchronized Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.getDefault()).parse(jsonElement.getAsString());
            } catch (ParseException e) {
                e.getStackTrace();
            }
        }
        throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                + "\". Supported formats: \n" + Arrays.toString(DATE_FORMATS));
    }
}
