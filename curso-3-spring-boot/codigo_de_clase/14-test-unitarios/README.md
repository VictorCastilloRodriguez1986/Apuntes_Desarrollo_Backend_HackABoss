# 🏦 Simulador de Cuenta Bancaria

## 🎯 Objetivo

Diseñar e implementar una clase `CuentaBancaria` que represente una cuenta corriente con operaciones básicas, y desarrollar una batería de tests unitarios utilizando **JUnit 5** para validar su comportamiento en distintos escenarios.

---

## Parte 1: Implementación de la clase `CuentaBancaria`

Debes implementar la clase `CuentaBancaria` con los siguientes atributos y métodos:

### 🔧 Atributos

- `String titular`: nombre del titular de la cuenta.
- `double saldo`: saldo actual de la cuenta.
- `boolean bloqueada`: indica si la cuenta está bloqueada.

### 🧩 Métodos
```java
public CuentaBancaria(String titular, double saldoInicial);
public void depositar(double monto); 
public void retirar(double monto); 
public void bloquearCuenta(); 
public void desbloquearCuenta(); 
public double consultarSaldo(); 
public boolean estaBloqueada(); 
public String getTitular(); 
```

### 📋 Reglas de negocio
Tu implementación debe cumplir con las siguientes reglas:
- El titular no puede ser null ni una cadena vacía.
- El saldo inicial no puede ser negativo.
- No se puede depositar ni retirar si la cuenta está bloqueada.
- No se puede depositar un monto negativo o cero.
- No se puede retirar un monto negativo, cero o mayor al saldo disponible.
- El método consultarSaldo() debe devolver el saldo actual.
- Los métodos bloquearCuenta() y desbloquearCuenta() deben cambiar el estado de la cuenta correctamente.
## Parte 2: Tests Unitarios con JUnit 5

Debes crear una clase de test llamada CuentaBancariaTest que cubra los siguientes casos:

## 🧪 Casos a testear
1.	Creación válida e inválida de cuentas.
2.	Depósitos válidos e inválidos.
3.	Retiros válidos, inválidos y con saldo insuficiente.
4.	Operaciones cuando la cuenta está bloqueada.
5.	Bloqueo y desbloqueo de la cuenta.
6.	Secuencia de operaciones y verificación del saldo final.