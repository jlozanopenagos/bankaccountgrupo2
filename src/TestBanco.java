public class TestBanco {
    public static void main(String[] args) {

        // ******************************************
        // PASO 1: Crear las cuentas
        // ******************************************

        // Cuenta de Ahorro: Ana Perez, AH001, $50,000, 2024-01-15 (tasa fija 2.5% = 0.025)
        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, 0.025, "2024-01-15");

        // Cuenta Corriente: Luis Gomez, CC001, $20,000 (valores por defecto: límite sobregiro $50,000, comisión 5%, tasa 0.0)
        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000, 50000, 5.0);

        // Cuenta Empresarial: Tech Solutions, EM001, $200,000, RUT 123456789-0 (tasa fija 1.5% = 0.015, comisión retiro $2,000)
        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000, 0.015, "Tech Solutions", "123456789-0", 2000);

        // Cuenta de Ahorro: Maria Lopez, AH002, $15,000, 2024-02-01 (tasa fija 2.5% = 0.025)
        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, 0.025, "2024-02-01");


        // ******************************************
        // PASO 2: Mostrar la información inicial
        // ******************************************
        System.out.println("**************************************************");
        System.out.println("PASO 2: INFORMACIÓN INICIAL DE LAS CUENTAS");
        System.out.println("**************************************************");

        // Pendiente colega: CuentaAhorro.mostrarInfo() actualmente está vacía en su clase
        cuentaAna.mostrarInfo();
        cuentaLuis.mostrarInfo();
        cuentaTech.mostrarInfo();
        cuentaMaria.mostrarInfo();


        // ******************************************
        // PASO 3: Realizar las operaciones
        // ******************************************
        System.out.println("\n**************************************************");
        System.out.println("PASO 3: OPERACIONES BANCARIAS");
        System.out.println("**************************************************");

        // 1. Ana Perez deposita $10,000
        System.out.println("\n1. Ana Perez deposita $10,000:");
        cuentaAna.depositar(10000);
        System.out.printf("Nuevo saldo: $%.2f%n", cuentaAna.getSaldo());

        // 2. Luis Gomez retira $25,000
        System.out.println("\n2. Luis Gomez retira $25,000:");
        cuentaLuis.retirar(25000);
        System.out.printf("Nuevo saldo: $%.2f%n", cuentaLuis.getSaldo());
        
        // 3. Tech Solutions retira $10,000
        System.out.println("\n3. Tech Solutions retira $10,000:");
        cuentaTech.retirar(10000);

        // 4. Maria Lopez intenta retirar $20,000 (saldo insuficiente: $15,000)
        System.out.println("\n4. Maria Lopez intenta retirar $20,000:");
        cuentaMaria.retirar(20000);
        System.out.printf("Saldo actual: $%.2f%n", cuentaMaria.getSaldo());


        // ******************************************
        // PASO 4: Aplicar intereses
        // ******************************************
        System.out.println("\n**************************************************");
        System.out.println("PASO 4: APLICAR INTERESES A TODAS LAS CUENTAS");
        System.out.println("**************************************************");

        System.out.println("\nCuenta " + cuentaAna.getNumeroCuenta() + " (" + cuentaAna.getTitular() + "):");
        cuentaAna.aplicarInteres();

        System.out.println("\nCuenta " + cuentaLuis.getNumeroCuenta() + " (" + cuentaLuis.getTitular() + "):");
        cuentaLuis.aplicarInteres();

        System.out.println("\nCuenta " + cuentaTech.getNumeroCuenta() + " (" + cuentaTech.getTitular() + "):");
        cuentaTech.aplicarInteres();

        System.out.println("\nCuenta " + cuentaMaria.getNumeroCuenta() + " (" + cuentaMaria.getTitular() + "):");
        cuentaMaria.aplicarInteres();


        // ******************************************
        // PASO 5: Mostrar el estado final
        // ******************************************
        System.out.println("\n**************************************************");
        System.out.println("PASO 5: ESTADO FINAL DE LAS CUENTAS");
        System.out.println("**************************************************");

        cuentaAna.mostrarInfo();
        cuentaLuis.mostrarInfo();
        cuentaTech.mostrarInfo();
        cuentaMaria.mostrarInfo();


        // ******************************************
        // PASO 6: Generar un resumen
        // Manejo individual sin arreglos ni listas
        // ******************************************
        System.out.println("\n**************************************************");
        System.out.println("PASO 6: RESUMEN GENERAL");
        System.out.println("==================================================");

        int totalCuentas = 4;
        double saldoTotal = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;

        CuentaBancaria cuentaMayor = cuentaAna;
        if (cuentaLuis.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaLuis;
        }
        if (cuentaTech.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaTech;
        }
        if (cuentaMaria.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaMaria;
        }

        System.out.println("Total de cuentas : " + totalCuentas);
        System.out.printf("Saldo total      : $%.2f%n", saldoTotal);
        System.out.printf("Promedio de saldo: $%.2f%n", promedioSaldo);
        System.out.println("Cuenta con mayor saldo:");
        System.out.println("  Número : " + cuentaMayor.getNumeroCuenta());
        System.out.println("  Titular: " + cuentaMayor.getTitular());
        System.out.printf("  Saldo  : $%.2f%n", cuentaMayor.getSaldo());
    }
}
