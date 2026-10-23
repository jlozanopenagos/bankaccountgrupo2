public class CuentaAhorro  extends CuentaBancaria{
    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteres, String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, tasaInteres);
        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public void retirar(double monto) {

    }

    @Override
    public void mostrarInfo(){
        // agregar fecha de apertura
    }
}
