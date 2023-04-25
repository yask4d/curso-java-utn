import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class CalculadoraTest {
    private static final double DELTA = 1e-15;
    calculadora calc = new calculadora();

    @Test
    public void testSumar() {
        assertEquals(5.0, calc.sumar(2.0, 3.0), DELTA);
        assertEquals(-1.0, calc.sumar(2.0, -3.0), DELTA);
        assertEquals(100.0, calc.sumar(50.0, 50.0), DELTA);
    }

    @Test
    public void testRestar() {
        assertEquals(1.0, calc.restar(3.0, 2.0), DELTA);
        assertEquals(5.0, calc.restar(2.0, -3.0), DELTA);
        assertEquals(0.0, calc.restar(50.0, 50.0), DELTA);
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6.0, calc.multiplicar(2.0, 3.0), DELTA);
        assertEquals(-6.0, calc.multiplicar(2.0, -3.0), DELTA);
        assertEquals(2500.0, calc.multiplicar(50.0, 50.0), DELTA);
    }

    @Test
    public void testDividir() {
        assertEquals(2.0, calc.dividir(6.0, 3.0), DELTA);
        assertEquals(-2.0, calc.dividir(6.0, -3.0), DELTA);
        assertEquals(1.0, calc.dividir(50.0, 50.0), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDividirPorCero() {
        calc.dividir(5.0, 0.0);
    }
}
