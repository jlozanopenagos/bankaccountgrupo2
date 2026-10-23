public class CuentaAhorro  extends CuentaBancaria{
    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public void mostrarInfo(){
        // agregar fecha de apertura
    }
}
