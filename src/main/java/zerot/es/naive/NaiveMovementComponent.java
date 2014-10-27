package zerot.es.naive;

/**
 * Created by Zerot on 10/27/2014.
 */
public class NaiveMovementComponent implements NaiveComponent {
    public float dx;
    public float dy;

    private NaiveTransformComponent transform;

    public NaiveMovementComponent(NaiveEntity e) {
        transform = e.getComponent(NaiveTransformComponent.class);
    }

    @Override
    public void update() {
        transform.x += dx;
        transform.y += dy;
    }
}
