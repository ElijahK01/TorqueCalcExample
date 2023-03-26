import org.opentest4j.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VectorMathTest {

    final double PRECISION = 0.00001;
    @org.junit.jupiter.api.Test
    void cartesianToVector() {
        Vector v1 = VectorMath.cartesianToVector(1, 0);
        assertEquals(v1.angle, 0);
        assertEquals(v1.radius, 1);

        Vector v2 = VectorMath.cartesianToVector(0, 1);
        assertEquals(Math.PI / 2, v2.angle);
        assertEquals(1, v2.radius);
    }

    @org.junit.jupiter.api.Test
    void vectorToCartesian() {
        Vector v1 = new Vector(1, 0);
        assertEquals(1, VectorMath.vectorToCartesian(v1)[0]);
        assertEquals(0, VectorMath.vectorToCartesian(v1)[1]);

        Vector v2 = new Vector(1, Math.PI / 2.0);
        assert(PRECISION > VectorMath.vectorToCartesian(v2)[0]);
        assertEquals(1, VectorMath.vectorToCartesian(v2)[1]);
    }

    @org.junit.jupiter.api.Test
    void vectorX() {
        Vector v = new Vector(1, Math.PI/4);
        assert(Math.abs(Math.sqrt(2)/2 - VectorMath.vectorX(v)) < PRECISION);
    }

    @org.junit.jupiter.api.Test
    void vectorY() {
        Vector v = new Vector(1, Math.PI/4);
        assert(Math.abs(Math.sqrt(2)/2 - VectorMath.vectorY(v)) < PRECISION);
    }

    @org.junit.jupiter.api.Test
    void scaleVector() {
        Vector v = new Vector(1, 0, 1);
        assertEquals(2, VectorMath.scaleVector(v, 2.0).radius);
    }

    @org.junit.jupiter.api.Test
    void sum() {
        Vector v1 = new Vector(1, 0);
        Vector v2 = new Vector(1, Math.PI / 2);
        Vector v3 = VectorMath.sum(v1, v2);

        assert (Math.abs(1 - VectorMath.vectorX(v3)) < PRECISION);
        assert (Math.abs(1 - VectorMath.vectorY(v3)) < PRECISION);

        ArrayList<Vector> vecList = new ArrayList<Vector>();
        vecList.add(v1);
        vecList.add(v2);
        vecList.add(v3);

        Vector v4 = VectorMath.sum(vecList);
        assert (Math.abs(2 - VectorMath.vectorX(v4)) < PRECISION);
        assert (Math.abs(2 - VectorMath.vectorY(v4)) < PRECISION);
    }
}