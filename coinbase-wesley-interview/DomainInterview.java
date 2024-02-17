import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

class Response {
    String name;
    List<Traits> traits;

    public Response(String name) {
        this.name = name;
        this.traits = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "name=" + this.name + " traits=" + this.traits;
    }
}

class Traits {
    String name;
    String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Traits other = (Traits) o;
        return Objects.equals(this.name, other.name) && Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "name=" + this.name + " value=" + this.value;
    }
}

public class DomainInterview {

    public static List<Traits> generateTraits(Map<String, String[]> map) {
        Random random = new Random();
        List<Traits> resp = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            Traits t = new Traits();
            String keyName = entry.getKey();
            String[] values = entry.getValue();
            int rand_idx = random.nextInt(values.length);
            String val = values[rand_idx];
            t.name = keyName;
            t.value = val;
            resp.add(t);
        }
        return resp;
    }

    public static void main(String[] args) {
        int uniqueNum = 8000;
        List<List<Traits>> alreadyGenerated = new ArrayList<>();
        List<Response> resp = new ArrayList<>();
        Map<String, String[]> map = new HashMap<>();

        map.put("eye_color", new String[]{"blue", "brown", "black", "red"});
        map.put("mouth", new String[]{"smiling", "neutral", "barking", "frowning"});
        map.put("attitude", new String[]{"happy", "sad", "pleased", "crying"});
        map.put("condition", new String[]{"sick", "healthy", "depressed", "manic"});

        int maxCombinations = 1;
        for (String[] arr : map.values()) {
            maxCombinations *= arr.length;
        }
        
        for (int i = 0; i < uniqueNum; i++) {
            List<Traits> t = generateTraits(map);

            // Check if the list of traits is unique
            boolean isUnique = !alreadyGenerated.contains(t);

            // Check if all possible combinations have been exhausted
            if (!isUnique && alreadyGenerated.size() < maxCombinations) {
                while (!isUnique) {
                    t = generateTraits(map);
                    isUnique = !alreadyGenerated.contains(t);
                }
            }

            // Add the unique traits to the list
            if (isUnique) {
                alreadyGenerated.add(t);
            }
        }

        for (int i = 0; i < alreadyGenerated.size(); i++) {
            Response r = new Response("Cuddly Kitten #" + i);
            r.traits = alreadyGenerated.get(i);
            resp.add(r);
        }
        System.out.println(resp);
    }
}
