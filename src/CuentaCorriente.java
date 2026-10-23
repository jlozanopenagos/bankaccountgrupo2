public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobreGiro;
    private double porcentajeComisionSobreGiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double tasaInteres, double limiteSobreGiro, double porcentajeComisionSobreGiro) {
        super(numeroCuenta, titular, saldoInicial, tasaInteres);
        this.limiteSobreGiro = limiteSobreGiro;
        this.porcentajeComisionSobreGiro = porcentajeComisionSobreGiro;
    }

    @Override
    public void retirar(double monto) {

    }

}
