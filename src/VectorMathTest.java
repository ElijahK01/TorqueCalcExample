import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorMathTest {

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
        assert(0.001 > VectorMath.vectorToCartesian(v2)[0]);
        assertEquals(1, VectorMath.vectorToCartesian(v2)[1]);
    }

    @org.junit.jupiter.api.Test
    void vectorX() {
        assertEquals(1, 1);
    }

    @org.junit.jupiter.api.Test
    void vectorY() {
    }

    @org.junit.jupiter.api.Test
    void scaleVector() {
    }

    @org.junit.jupiter.api.Test
    void sum() {
    }

    @org.junit.jupiter.api.Test
    void testSum() {
    }
}