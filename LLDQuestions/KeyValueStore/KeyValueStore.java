package LLDQuestions.KeyValueStore;

import javafx.util.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class KeyValueStore {
    // ConcurrentHashMap to make the updates in store and attributeSchema threadsafe
    private final Map<String, ValueObject> store = new ConcurrentHashMap<>();
    private final Map<String, Class<?>> attributeSchema = new ConcurrentHashMap<>();
    private final ReentrantLock lock  = new ReentrantLock();

    // We are still using lock on put() method to make sure we don't end updating the schema of an attribute 
    // this is possible because when 2 threads T1 and T2 come and attribute schema is not defined
    // we can just update the schema of the attribute one after one
    public KeyValueStore()
    {

    }

    // search can be optimized by using inverted index
    // Map<String, Map<Object, Set<String>>> invertedIndex
    // need to update delete and put to update inverted index as well
    // "class" → {
    //     1 → ["ramesh"],
    //     2 → ["suresh", "prateek"]
    // }

    // "location" → {
    //     "India" → ["suresh"],
    //     "USA"   → ["prateek"]
    // }
    public List<String> search(String attributeKey, String attributeValue)
    {
        List<String> keys = new ArrayList<>();
        Object attributeObject = parseValue(attributeValue);
        for(var entry: store.entrySet())
        {
            ValueObject obj = entry.getValue();
            for(var attribute: obj.getAttributes().entrySet())
            {

                if(attribute.getKey().equals(attributeKey) && attributeObject.equals(attribute.getValue()))
                {
                    keys.add(entry.getKey());
                    break;
                }       
            }
        }
        return keys;
    }

    public void put(String key, List<Pair<String, String>> listOfAttributePairs)
    {
        try{
            lock.lock();
            Map<String, Object> objectMap = new HashMap<>();
            for(Pair<String, String> pair: listOfAttributePairs)
            {
                String attributeKey = pair.getKey();
                String rawValue = pair.getValue();
                Object parsedValue = parseValue(rawValue);
                Class<?> classType = parsedValue.getClass();
                if(attributeSchema.containsKey(attributeKey))
                {
                    Class<?> expectedClass = attributeSchema.get(attributeKey);
                    if(!expectedClass.equals(classType))
                        throw new IllegalArgumentException("Type mismatch for attribute key: "+ attributeKey + " expected type: "+ expectedClass.getSimpleName()+ " get type: "+ classType.getSimpleName());
                }
                attributeSchema.put(attributeKey, classType);
                objectMap.put(attributeKey, parsedValue);
            }
            store.put(key, new ValueObject(objectMap));
        } finally {
            lock.unlock();
        }
    }
    private Object parseValue(String value)
    {
        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
            return Boolean.parseBoolean(value);
        try {
            if(value.contains("."))
            {
                return Double.parseDouble(value);
            }
            else
            {
                return Integer.parseInt(value);
            }

        } catch(NumberFormatException e) {
            return value;
        }
    }
    public ValueObject get(String key)
    {
        return store.get(key);
    }
    public void delete(String key)
    {
        store.remove(key);
    }
    public List<String> keys()
    {
        return new ArrayList<>(store.keySet());
        // store.keySet() -> returns a Set but get converted to List after we put it in ArrayList<>
        // List<String> allKeys = new ArrayList<>();
        // for(var entry: store.entrySet())
        // {
        //     allKeys.add(entry.getKey());
        // }
        // return allKeys;
    }

}
