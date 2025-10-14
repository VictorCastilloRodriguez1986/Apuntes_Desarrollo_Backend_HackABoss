package com.hackaboss.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria("Juan Pérez", 1000.0);
    }

    @Test
    public void testCreacionCuentaValida() {
        assertEquals("Juan Pérez", cuenta.getTitular());
        assertEquals(1000.0, cuenta.consultarSaldo());
        assertFalse(cuenta.estaBloqueada());
    }

    @Test
    public void testCreacionCuentaConTitularInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria("", 100));
        assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria(null, 100));
    }

    @Test
    public void testCreacionCuentaConSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria("Ana", -50));
    }

    @Test
    public void testDepositoValido() {
        cuenta.depositar(500);
        assertEquals(1500.0, cuenta.consultarSaldo());
    }

    @Test
    public void testDepositoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-100));
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
    }

    @Test
    public void testRetiroValido() {
        cuenta.retirar(300);
        assertEquals(700.0, cuenta.consultarSaldo());
    }

    @Test
    public void testRetiroConSaldoInsuficiente() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(2000));
    }

    @Test
    public void testRetiroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-50));
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(0));
    }

    @Test
    public void testBloqueoYDesbloqueo() {
        cuenta.bloquearCuenta();
        assertTrue(cuenta.estaBloqueada());

        cuenta.desbloquearCuenta();
        assertFalse(cuenta.estaBloqueada());
    }

    @Test
    public void testOperacionesConCuentaBloqueada() {
        cuenta.bloquearCuenta();
        assertThrows(IllegalStateException.class, () -> cuenta.depositar(100));
        assertThrows(IllegalStateException.class, () -> cuenta.retirar(100));
    }

    @Test
    public void testSecuenciaDeOperaciones() {
        cuenta.depositar(200);     // 1200
        cuenta.retirar(100);       // 1100
        cuenta.depositar(50);      // 1150
        cuenta.retirar(150);       // 1000
        assertEquals(1000.0, cuenta.consultarSaldo());
    }
}