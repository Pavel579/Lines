import model.Line;
import model.Coordinate;
import controller.Manager;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Coordinate p1l1 = new Coordinate(1, 1);
        Coordinate p2l1 = new Coordinate(3, 1);
        Coordinate p1l2 = new Coordinate(2, 0);
        Coordinate p2l2 = new Coordinate(2, 2);

        Line l1 = new Line(p1l1, p2l1);
        Line l2 = new Line(p1l2, p2l2);

        System.out.println(manager.getCrossedPoint(l1, l2, true));
        System.out.println(manager.getCrossedPoint(l1, l2, false));
    }
}
