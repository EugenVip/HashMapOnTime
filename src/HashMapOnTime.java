import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 18.08.2017.
 */
public class HashMapOnTime
{
    private HashMap<String, ArrayList> hashMapOnTime;
    private int TTL = 5000;

    public HashMapOnTime()
    {
        this.hashMapOnTime = new HashMap<>();
    }

    public void put(String key, String value) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(System.currentTimeMillis());
        arrayList.add(value);
        this.hashMapOnTime.put(key, arrayList);
    }

    public String get(String key){
        ArrayList currentrray = this.hashMapOnTime.get(key);
        Long timeOfValue = (Long)currentrray.get(0);
        if (timeOfValue+TTL >= System.currentTimeMillis()){
            return (String) currentrray.get(1);
        }else
        {
            return null;
        }

    }

}
