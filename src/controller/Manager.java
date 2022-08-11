package controller;

import model.Coordinate;
import model.Line;

public class Manager {

    public boolean isLinesCrossed(Line l1, Line l2) {
        boolean result = false;
        double v1 = multiplyVector(l2.getP1().getX() - l2.getP2().getX(), l2.getP1().getY() - l2.getP2().getY(),
                l1.getP1().getX() - l2.getP2().getX(), l1.getP1().getY() - l2.getP2().getY());
        double v2 = multiplyVector(l2.getP1().getX() - l2.getP2().getX(), l2.getP1().getY() - l2.getP2().getY(),
                l1.getP2().getX() - l2.getP2().getX(), l1.getP2().getY() - l2.getP2().getY());
        double v3 = multiplyVector(l1.getP1().getX() - l1.getP2().getX(), l1.getP1().getY() - l1.getP2().getY(),
                l2.getP1().getX() - l1.getP2().getX(), l2.getP1().getY() - l1.getP2().getY());
        double v4 = multiplyVector(l1.getP1().getX() - l1.getP2().getX(), l1.getP1().getY() - l1.getP2().getY(),
                l2.getP2().getX() - l1.getP2().getX(), l2.getP2().getY() - l1.getP2().getY());
        if (v1 * v2 < 0 && v3 * v4 < 0) {
            result = true;
        }
        if (l1.getP1().equals(l2.getP1()) || l1.getP1().equals(l2.getP2()) ||
                l2.getP1().equals(l1.getP2()) || l2.getP2().equals(l1.getP2())){
            result = true;
        }
        return result;
    }

    private static double multiplyVector(double ax, double ay, double bx, double by) {
        return ax * by - bx * ay;
    }

    public Coordinate getCrossedPoint(Line l1, Line l2, boolean isInfinityLine) {
        if (isLinesCrossed(l1, l2) || isInfinityLine){
            double cx1 = l1.getP2().getX() - l1.getP1().getX();
            double cx2 = l2.getP2().getX() - l2.getP1().getX();
            double cx3 = l2.getP1().getX() - l1.getP1().getX();

            double cy1 = l1.getP2().getY() - l1.getP1().getY();
            double cy2 = l2.getP2().getY() - l2.getP1().getY();
            double cy3 = l2.getP1().getY() - l1.getP1().getY();

            double t = (cy3 * cx1 - cx3 * cy1) / (cy1 * cx2 - cy2 * cx1);
            double s = (cx3 + cx2 * t) / cx1;
            double x0 = l1.getP1().getX() + s * (l1.getP2().getX() - l1.getP1().getX());
            double y0 = l1.getP1().getY() + s * (l1.getP2().getY() - l1.getP1().getY());
            return new Coordinate(x0, y0);
        }else {
            return null;
        }
    }
}
