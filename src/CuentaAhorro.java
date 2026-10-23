public class CuentaAhorro extends CuentaBancaria {

    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial,
                        double tasaInteres, String fechaApertura) {

        super(numeroCuenta, titular, saldoInicial, tasaInteres);

        if (saldoInicial < 10000) {
            throw new IllegalArgumentException(
                    "Por favor recuerde que el saldo minimo para abrir la cuenta es $10000"
            );
        }

        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Por favor recuerde que el monto a retirar debe ser mayor a cero");
        } else if (monto > getSaldo()) {
            System.out.println("Lo sentimos el Saldo actual es insuficiente");
        } else {
            actualizarSaldo(getSaldo() - monto);
            System.out.println("El retiro fue exitoso: $" + monto);
            System.out.println("Su saldo actual es: $" + getSaldo());
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
    }
}