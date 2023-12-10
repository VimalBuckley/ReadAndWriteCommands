import java.util.HashMap;

public class Container {
    private HashMap<String, Runnable> map;
    public Container() {
        map.put("Print hi", () -> System.out.println("hi"));
        map.put("Print bye", () -> System.out.println("bye"));
    }

}
