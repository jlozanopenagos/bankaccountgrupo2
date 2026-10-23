public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo: " + saldoInicial);
        }
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa: " + tasaInteres);
        }

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }

    // Permite a las clases hijas modificar el saldo sin romper el encapsulamiento
    protected void actualizarSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
        }
        this.saldo += monto;
        System.out.printf("Depósito exitoso: $%.2f | Nuevo saldo: $%.2f%n", monto, this.saldo);
    }

    // Método abstracto: obliga a cada clase hija (como CuentaAhorro) a definir sus propias reglas
    public abstract void retirar(double monto);

    public void aplicarInteres() {
        // Si tasaInteres se maneja en porcentaje (ej: 0.05 para 5%), se multiplica directo
        double interesGenerado = this.saldo * this.tasaInteres;
        this.saldo += interesGenerado;
        System.out.printf("Interés generado: $%.2f (Tasa: %.2f%%) | Nuevo saldo: $%.2f%n", 
                interesGenerado, this.tasaInteres * 100, this.saldo);
    }

    public void mostrarInfo() {
        System.out.println("----- INFORMACIÓN DE LA CUENTA -----");
        System.out.println("Número de Cuenta : " + this.numeroCuenta);
        System.out.println("Titular          : " + this.titular);
        System.out.printf("Saldo actual     : $%.2f%n", this.saldo);
        System.out.printf("Tasa de interés  : %.2f%%%n", this.tasaInteres * 100);
        System.out.println("------------------------------------");
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}
