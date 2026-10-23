public class CuentaEmpresarial  extends CuentaBancaria{

    String nombreEmpresa;
    String RUT;
    double comisionRetiro = 2000;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, double tasaInteres, String nombreEmpresa, String RUT, double comisionRetiro) {
        super(numeroCuenta, titular, saldoInicial, tasaInteres);
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
        this.comisionRetiro = comisionRetiro;
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

    @Override
    public void retirar(double monto) {

    }
}
