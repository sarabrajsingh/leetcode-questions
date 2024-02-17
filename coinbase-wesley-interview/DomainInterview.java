import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Random;

class Response{
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

    @Override
    public boolean equals(Object o) {
        Response other = (Response)o;

        return Objects.equals(this.traits, other.traits);
    }
}

class Traits {
    String name;
    String value;

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Traits other = (Traits)o;

        return  Objects.equals(this.name, other.name) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode(){ 
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
    
        for(java.util.Map.Entry<String, String[]> entry : map.entrySet()) {
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

        int uniqueNum = 5;

        Set<List<Traits>> alreadyGenerated = new HashSet<>(); // theoretical maximum # of unique trait combos can be 3^3 or 27
        List<Response> resp = new ArrayList<>();

        Map<String, String[]> map = new HashMap<>();

        map.put("eye_color", new String[]{"blue", "brown", "black"});
        map.put("mouth", new String[]{"smiling", "neutral", "barking"});
        map.put("attitude", new String[]{"happy", "sad", "pleased"});

        for(int i = 0; i < uniqueNum; i++) {
            List<Traits> t = generateTraits(map);

            if(!alreadyGenerated.contains(t)){
                alreadyGenerated.add(t);
            } else {
                while(!alreadyGenerated.contains(t)){
                    t = generateTraits(map);
                }
            }
        }

        List<List<Traits>> l = new ArrayList<>(alreadyGenerated);

        for(int i = 0; i < alreadyGenerated.size(); i++) {
            Response r = new Response("Cuddly Kitten #" + i);
            r.traits = l.get(i);
            resp.add(r);
        }
        System.out.println(resp);
    }
}