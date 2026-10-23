public class CuentaEmpresarial  extends CuentaBancaria{

    String nombreEmpresa;
    String RUT;
    double comisionRetiro = 2000;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }
    //implementar consructores y metodos que falten

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
