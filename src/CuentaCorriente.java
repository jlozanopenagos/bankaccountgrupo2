public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000, 5.0);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }

        if (monto > getSaldo() + this.limiteSobregiro) {
            throw new IllegalArgumentException("Fondos insuficientes. Límite de sobregiro excedido.");
        }

        double nuevoSaldo = getSaldo() - monto;

        // Si queda en negativo, se cobra comisión sobre el monto sobregirado
        if (nuevoSaldo < 0) {
            double montoSobregirado = Math.abs(nuevoSaldo);
            double comision = montoSobregirado * (this.porcentajeComisionSobregiro / 100);
            nuevoSaldo -= comision;
            System.out.printf("Comisión por sobregiro: $%.2f%n", comision);
        }

        actualizarSaldo(nuevoSaldo);
        System.out.printf("Retiro exitoso: $%.2f | Nuevo saldo: $%.2f%n", monto, getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("----- INFORMACIÓN DE LA CUENTA -----");
        System.out.println("Número de Cuenta : " + getNumeroCuenta());
        System.out.println("Titular          : " + getTitular());
        System.out.printf("Saldo actual     : $%.2f%n", getSaldo());
        System.out.printf("Comision Sobregiro  : %.2f%%%n", this.porcentajeComisionSobregiro * 100);
        System.out.printf("Limite de Sobregito : %.2f%%%n", this.limiteSobregiro);
        System.out.println("------------------------------------");
    }
}
