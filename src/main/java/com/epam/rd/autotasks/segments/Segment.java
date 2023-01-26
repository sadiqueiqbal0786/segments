package com.epam.rd.autotasks.segments;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

class Segment {
    Point start,end;

    public Segment(Point start, Point end) {
        if(start.equals(end))
            throw new RuntimeException();
            //throw new IllegalArgumentException();
        else if (start.getX()==end.getX() && start.getY()==end.getY()) {
            throw new RuntimeException();

        } else
        {
            this.start=start;
            this.end=end;
        }
    }

    double length() {
        double xDiff=end.getX()- start.getX();
        double yDiff= end.getY()- start.getY();
        double len=Math.sqrt((xDiff*xDiff)+(yDiff*yDiff));
        return len;
    }

    Point middle() {
        double x=((start.getX()+end.getX())/2);
        double y=((start.getY()+end.getY())/2);
        return new Point(x,y);

    }

    Point intersection(Segment another) {
      /*  double deno=(((start.getX()-end.getX())*(another.start.getY()-another.end.getY()))-((start.getY()-
                end.getY())*(another.start.getX()-another.end.getX())));
       /* Segment segment1 = new Segment(new Point(start.getX(), start.getY()), new Point(another.start.getX(),
                another.start.getY()));
        Segment segment2 = new Segment(new Point(end.getX(),end.getY()), new Point(another.end.getX(),
                another.end.getY()));
       Point intersectionPoint = segment1.intersection(segment2);
        if (intersectionPoint == null) {
            return null;
        }*/
/*
       if(deno==0)
            return null;

        else {
            double pX=((((start.getX()*end.getX())-(start.getY()*end.getX()) )*
                    (another.start.getX()-another.end.getX()))-((start.getX()-end.getX())*
                    ((another.start.getX()*another.end.getY())-(another.start.getY()*another.end.getX()))));
            double pY=((((start.getX()*end.getX())-(start.getY()*end.getX()) )*
                    (another.start.getY()-another.end.getY()))-((start.getY()-end.getY())*
                    ((another.start.getX()*another.end.getY())-(another.start.getY()*another.end.getX()))));
            double x=(pX/deno);
            double y=(pY/deno);
            return new Point(x,y);
        }*/
        double k1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
        double k2 = (another.end.getY() - another.start.getY()) / (another.end.getX() - another.start.getX());
        if (k1 == k2) return null;

        double b1 = (start.getY() * end.getX() - end.getY() * start.getX()) / (end.getX() - start.getX());
        double b2 = (another.start.getY() * another.end.getX() - another.end.getY() * another.start.getX()) /
                (another.end.getX() - another.start.getX());

        double x = (b2 - b1) / (k1 - k2);
        double y = (k1 * b2 - k2 * b1) / (k1 - k2);

        if ((x > start.getX() && x > end.getX()) || (x > another.start.getX() && x > another.end.getX()) ||
                (x < start.getX() && x < end.getX()) || (x < another.start.getX() && x < another.end.getX()) ||
                (y > start.getY() && y > end.getY()) || (y > another.start.getY() && y > another.end.getY()) ||
                (y < start.getY() && y < end.getY()) || (y < another.start.getY() && y < another.end.getY()))
            return null;

        return new Point(x, y);

    }

}
