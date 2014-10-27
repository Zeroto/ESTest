package zerot.es.object;

/**
 * Created by Zerot on 10/27/2014.
 */
public class ObjectEntityManager {

    private int nextId = 0;

    public ObjectEntity create(){
        ObjectEntity result = new ObjectEntity();
        result.id = nextId++;

        return result;
    }
}
