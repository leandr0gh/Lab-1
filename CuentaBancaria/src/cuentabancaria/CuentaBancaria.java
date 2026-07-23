
package cuentabancaria;

public class CuentaBancaria {

    public String titular;
    private double saldo;
    public int numeroCuenta;
    public int transexitosas;
    
    CuentaBancaria(String titular, int numeroCuenta){
    this.numeroCuenta=numeroCuenta;
    this.titular=titular;
    
    
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto){
        if (monto>0) {
            saldo=saldo+monto;
            transexitosas++;
        } else{
            System.out.println("monto no valido");
        }
    }

    public void retirar(double monto){
        if ( monto<=saldo && monto>0) {
            saldo=saldo-monto;
            transexitosas++;
        } else{
            System.out.println("no hay saldo suficiente");}
    }
    
    public void mostrarSaldo(){
        System.out.println("Cuenta #"+numeroCuenta+" | "+"Titular: "+titular+" | "+"Saldo: "+getSaldo()+
                " |"+"Transacciones exitosas: "+transexitosas);
    }
    
    public static void main(String[] args) {
        CuentaBancaria c1=new CuentaBancaria("Leandro", 1042);

        c1.depositar(2000);
        c1.retirar(500);
        c1.mostrarSaldo();

    }
    
}
