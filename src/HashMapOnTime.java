import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 18.08.2017.
 */
public class HashMapOnTime<K, V>
{
    private HashMap hashMapOnTime = new HashMap<>();
    private int TTL = 5000;

    public HashMapOnTime()
    {
        //this.hashMapOnTime = new HashMap<>();
    }

    public void put(K key, V value) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(System.currentTimeMillis());
        arrayList.add(value);
        this.hashMapOnTime.put(key, arrayList);
    }

    public <V>V get(K key){
        ArrayList currentArray = (ArrayList) this.hashMapOnTime.get(key);
        Long timeOfValue = (Long)currentArray.get(0);
        if (timeOfValue+TTL >= System.currentTimeMillis()){
            return (V) currentArray.get(1);
        }else
        {
            return null;
        }

    }

}
