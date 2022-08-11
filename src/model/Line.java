package model;

public class Line {
    private final Coordinate p1;
    private final Coordinate p2;

    public Line (Coordinate p1, Coordinate p2){
        if (p1.getX() < p2.getX()){
            this.p1 = p1;
            this.p2 = p2;
        }else {
            this.p1 = p2;
            this.p2 = p1;
        }
    }

    public Coordinate getP1() {
        return p1;
    }

    public Coordinate getP2() {
        return p2;
    }

    public double getLength(){
        double length;
        double katet1Length = p2.getX() - p1.getX();
        double katet2Length = p2.getY() - p1.getY();
        length = Math.sqrt(Math.pow(katet1Length, 2) + Math.pow(katet2Length, 2));
        return length;
    }
}
