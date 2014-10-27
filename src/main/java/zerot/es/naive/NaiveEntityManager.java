package zerot.es.naive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zerot on 10/27/2014.
 */
public class NaiveEntityManager {

    private List<NaiveEntity> entities = new ArrayList<>();

    public NaiveEntity create()
    {
        NaiveEntity result = new NaiveEntity();
        entities.add(result);
        return result;
    }

    public void destroy(NaiveEntity entity)
    {
        entities.remove(entity);
    }

    public void tick()
    {
        for (NaiveEntity entity : entities)
        {
            entity.update();
        }
    }
}
