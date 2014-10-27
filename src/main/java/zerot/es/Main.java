package zerot.es;

import zerot.es.naive.NaiveEntity;
import zerot.es.naive.NaiveEntityManager;
import zerot.es.naive.NaiveMovementComponent;
import zerot.es.naive.NaiveTransformComponent;
import zerot.es.object.*;

/**
 * Created by Zerot on 10/27/2014.
 */
public class Main {


    public static void main(String[] args)
    {
        RunObjectES();
        RunNaiveES();
    }

    private static void RunNaiveES() {
        // create world
        NaiveEntityManager manager = new NaiveEntityManager();
        for (int i=0; i<1000; i++)
        {
            createNaiveEntity(manager);
        }


        long startTime = System.nanoTime();
        // run 1000 loops
        for (int i=0; i<1000; i++)
        {
            manager.tick();
        }

        long endTime = System.nanoTime();
        System.out.println("Naive: " + (endTime - startTime) + " nanoseconds");
    }

    private static void RunObjectES() {
        long startTime;
        long endTime;ObjectEntityManager entityManager = new ObjectEntityManager();
        ObjectComponentSystemManager objectComponentSystemManager = new ObjectComponentSystemManager();
        ObjectMovementSystem objectMovementSystem = new ObjectMovementSystem();

        for (int i=0; i<1000; i++)
        {
            createObjectEntity(entityManager, objectComponentSystemManager);
        }
        objectComponentSystemManager.addSystem(objectMovementSystem);

        startTime = System.nanoTime();
        // run 1000 loops
        for (int i=0; i<1000; i++)
        {
            objectComponentSystemManager.tick();
        }

        endTime = System.nanoTime();
        System.out.println("Object: " + (endTime - startTime) + " nanoseconds");
    }

    private static void createObjectEntity(ObjectEntityManager entityManager, ObjectComponentSystemManager objectComponentSystemManager) {
        ObjectEntity entity = entityManager.create();
        objectComponentSystemManager.addComponent(entity, new ObjectTransformComponent());
        ObjectMovementComponent mov = new ObjectMovementComponent();
        mov.dx = 0.1f;
        mov.dy = 0.1f;
        objectComponentSystemManager.addComponent(entity, mov);
    }

    private static void createNaiveEntity(NaiveEntityManager manager) {
        NaiveEntity entity = manager.create();
        entity.addComponent(NaiveTransformComponent.class);
        NaiveMovementComponent mov = entity.addComponent(NaiveMovementComponent.class);
        mov.dx = 0.1f;
        mov.dy = 0.1f;
    }
}
