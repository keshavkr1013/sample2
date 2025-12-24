package LLDQuestions.KeyValueStore;

import java.util.*;
public class ValueObject {
    private final Map<String, Object> attributes;
    ValueObject(Map<String, Object> attributes)
    {
        this.attributes = attributes;
    }

    public  Map<String, Object> getAttributes()
    {
        return attributes;
    }
    @Override
    public String toString()
    {
        List<String> strings = new ArrayList<>();
        for(var entry: attributes.entrySet())
        {
            strings.add(entry.getKey()+": "+entry.getValue());
        }
        return String.join(",", strings);
    }
}
