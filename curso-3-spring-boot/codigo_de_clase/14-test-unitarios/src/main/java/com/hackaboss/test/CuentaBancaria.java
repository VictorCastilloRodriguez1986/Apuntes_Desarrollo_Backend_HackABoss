package com.hackaboss.test;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private boolean bloqueada;

    public CuentaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
        this.bloqueada = false;
    }

    public void depositar(double monto) {
        if (bloqueada) {
            throw new IllegalStateException("La cuenta está bloqueada.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    public void retirar(double monto) {
        if (bloqueada) {
            throw new IllegalStateException("La cuenta está bloqueada.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= monto;
    }

    public void bloquearCuenta() {
        bloqueada = true;
    }

    public void desbloquearCuenta() {
        bloqueada = false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }

    public String getTitular() {
        return titular;
    }
}