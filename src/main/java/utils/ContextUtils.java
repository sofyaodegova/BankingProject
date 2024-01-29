package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContextUtils {
    static final Map<String, Object> data = new HashMap<>();

    public static Object get(String key) {
        return data.get(key);
    }

    public static void put(String key, Object value) {
        data.put(key, value);
    }

    public static void clearContext() {
        data.clear();
    }
}
