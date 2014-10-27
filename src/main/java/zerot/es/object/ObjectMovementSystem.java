package zerot.es.object;

import java.util.List;

/**
 * Created by Zerot on 10/27/2014.
 */
public class ObjectMovementSystem implements ObjectSystem {
    private List<ObjectComponent> transformComponents;
    private List<ObjectComponent> movementComponents;

    @Override
    public void init(ObjectComponentSystemManager manager) {
        transformComponents = manager.getComponents(ObjectTransformComponent.class);
        movementComponents = manager.getComponents(ObjectMovementComponent.class);
    }

    @Override
    public void tick() {
        for (int i=0; i< transformComponents.size(); i++)
        {
            ObjectTransformComponent tr = (ObjectTransformComponent)transformComponents.get(i);
            ObjectMovementComponent mov = (ObjectMovementComponent)movementComponents.get(i);
            tr.x += mov.dx;
            tr.y += mov.dy;
        }
    }
}
