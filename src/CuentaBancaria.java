public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;

        if (saldoInicial < 0) {
            // hacer trew new IllegalException
            System.out.println("El saldo no puede ser negativo");
            this.saldo = 0;
        }

        if (tasaInteres < 0) {
            // hacer trew new IllegalException
            System.out.println("La tasa de interes no puede ser negativa");
            tasaInteres = 0;
        }
    }

    protected void actualizarSaldo(double nuevoSaldo){
        //aqui cuerpo de metodo
        this.saldo = nuevoSaldo;
    }

    public void depositar(double deposito){
        //validaciones
        //a implementar
    }

    public double retirar(String numeroCuenta){
        //validaciones
        //a implementar
        return 0;
    }

    public void aplicarInteres(/*mirar que argumentos usar*/){
        //validaciones
        //a implementar
    }

    public void mostrarInfo(){
        // implementar
    }

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
