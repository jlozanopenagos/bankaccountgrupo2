public class CuentaEmpresarial extends CuentaBancaria {

    // Atributos propios de la cuenta empresarial
    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial,
                             String nombreEmpresa, String RUT) {
        // Tasa fija del 1.5% anual. En CuentaBancaria la tasa va como decimal (0.015)
        super(numeroCuenta, titular, saldoInicial, 0.015);

        // Saldo mínimo para abrir una cuenta empresarial
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException(
                    "El saldo mínimo para abrir una cuenta empresarial es $100,000. Saldo recibido: " + saldoInicial);
        }

        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }

        // El retiro cuesta el monto + la comisión, y eso no puede superar el saldo
        double totalRetiro = monto + comisionRetiro;
        if (totalRetiro > getSaldo()) {
            System.out.printf("Error: saldo insuficiente. Se necesitan $%.2f (monto + comisión) y el saldo es $%.2f%n",
                    totalRetiro, getSaldo());
            return;
        }

        // Restamos el monto y la comisión del saldo
        actualizarSaldo(getSaldo() - totalRetiro);

        System.out.printf("Retiro exitoso: $%.2f%n", monto);
        System.out.printf("Comisión por retiro: $%.2f%n", comisionRetiro);
        System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // lo que ya muestra la clase base
        System.out.println("Empresa          : " + nombreEmpresa);
        System.out.println("RUT              : " + RUT);
        System.out.printf("Comisión retiro  : $%.2f%n", comisionRetiro);
        System.out.println("------------------------------------");
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRUT() {
        return RUT;
    }

    public double getComisionRetiro() {
        return comisionRetiro;
    }

}
