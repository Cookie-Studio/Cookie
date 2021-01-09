package top.cookie.util.yml;

import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Yml {
    private final Map map = new HashMap();
    private final Path path;
    private final static Yaml yaml = new Yaml();
    public Yml(Path path){
        this.path = path;
        Object m = null;
        try {
            m = yaml.load(Files.newInputStream(this.path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (m != null){
            this.map.putAll((Map) m);
        }
    }
    public Path getPath(){
        return this.path;
    }
    public <T> T get(Object key){
        if (key instanceof String && ((String)key).contains(".")){
            Queue<String> queue = new LinkedList<>(Arrays.asList(((String) key).split("\\.")));
            Map tmp = this.map;
            while(!queue.isEmpty()){
                if (queue.size() != 1){
                    tmp = (Map) tmp.get(queue.poll());
                    continue;
                }
                if (queue.size() == 1){
                    return (T)tmp.get(queue.poll());
                }
            }
        }
        return (T)this.map.get(key);
    }
    public void put(Object key,Object value){
        if (key instanceof String && ((String)key).contains(".")){
            Queue<String> queue = new LinkedList<>(Arrays.asList(((String) key).split("\\.")));
            Map tmp = this.map;
            while(!queue.isEmpty()){
                if (queue.size() != 1){
                    if (tmp.containsKey(queue.peek())) {
                        tmp = (Map) tmp.get(queue.poll());
                        continue;
                    }
                    if (!tmp.containsKey(queue.peek())){
                        tmp.put(queue.peek(),new HashMap());
                        tmp = (Map) tmp.get(queue.poll());
                        continue;
                    }
                }
                if (queue.size() == 1){
                    tmp.put(queue.poll(),value);
                }
            }
            return;
        }
        this.map.put(key, value);
    }
    public void remove(Object key){
        if (key instanceof String && ((String)key).contains(".")){
            Queue<String> queue = new LinkedList<>(Arrays.asList(((String) key).split("\\.")));
            Map tmp = this.map;
            while(!queue.isEmpty()){
                if (queue.size() != 1){
                    tmp = (Map) tmp.get(queue.poll());
                    continue;
                }
                if (queue.size() == 1){
                    tmp.remove(queue.poll());
                    continue;
                }
            }
            return;
        }
        this.map.remove(key);
    }
    public void save(){
        try {
            Files.write(this.path,yaml.dump(this.map).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


