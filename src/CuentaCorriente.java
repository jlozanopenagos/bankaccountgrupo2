public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobreGiro;
    private double porcentajeComisionSobreGiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobreGiro, double porcentajeComisionSobreGiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteSobreGiro = limiteSobreGiro;
        this.porcentajeComisionSobreGiro = porcentajeComisionSobreGiro;
    }
}
