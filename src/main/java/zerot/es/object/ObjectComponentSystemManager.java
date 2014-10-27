package zerot.es.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zerot on 10/27/2014.
 */
public class ObjectComponentSystemManager {
    private static final int MAX_ENTITIES = 1000;

    private List<List<ObjectComponent>> components;
    private Map<Class<? extends ObjectComponent>, Integer> typeMap;
    private List<ObjectSystem> systems;

    public ObjectComponentSystemManager() {
        components = new ArrayList<>();
        typeMap = new HashMap<>();
        systems = new ArrayList<>();
    }

    public void addComponent(ObjectEntity e, ObjectComponent comp)
    {
        Integer typeID = typeMap.get(comp.getClass());
        if (typeID == null)
        {
            typeID = addNewComponentType(comp.getClass());
        }
        components.get(typeID).set(e.id, comp);
    }

    private Integer addNewComponentType(Class<? extends ObjectComponent> aClass) {
        List<ObjectComponent> compList = new ArrayList<>(MAX_ENTITIES);
        for (int i=0; i<MAX_ENTITIES; i++)
        {
            compList.add(null);
        }
        Integer id = components.size();
        components.add(compList);

        typeMap.put(aClass, id);

        return id;
    };

    public List<ObjectComponent> getComponents(Class<? extends ObjectComponent> aClass) {
        return components.get(typeMap.get(aClass));
    }

    public void addSystem(ObjectSystem system)
    {
        system.init(this);
        systems.add(system);
    }

    public void tick()
    {
        for (ObjectSystem system : systems)
        {
            system.tick();
        }
    }
}
