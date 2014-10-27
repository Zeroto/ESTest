package zerot.es.naive;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zerot on 10/27/2014.
 */
public class NaiveEntity {
    private List<NaiveComponent> components = new ArrayList<>();

    public void update()
    {
        for (NaiveComponent comp : components)
        {
            comp.update();
        }
    }

    public <T extends NaiveComponent> T getComponent(Class<T> type) {
        for (NaiveComponent comp : components)
        {
            if (type.isAssignableFrom(comp.getClass()))
                return type.cast(comp);
        }
        return null;
    }

    public <T extends NaiveComponent> T addComponent(Class<T> componentClass) {
        T result = null;
        try {
            result = componentClass.getConstructor(NaiveEntity.class).newInstance(this);
            components.add(result);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    };
}
