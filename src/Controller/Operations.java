package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Operations {
    private Map ListtoMap(String fpath, Map mapselected){
        Map<String, Object> mapList = mapselected;
        List<List> list = ReadFile.text(fpath);

        for (List<String> row : list) {
            String key = row.get(0);
            Object value = row.get(1);

            if (mapList.containsKey(key)) {
                Object currentValue = mapList.get(key);

                if (currentValue instanceof List) {
                    List<Object> valueList = (List<Object>) currentValue;
                    valueList.add(value);
                } else {
                    List<Object> valueList = new ArrayList<>();
                    valueList.add(currentValue);
                    valueList.add(value);
                    mapList.put(key, valueList);
                }
            } else {
                mapList.put(key, value);
            }
        }
        return mapList;
    }


}
