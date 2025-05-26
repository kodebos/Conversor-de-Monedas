public class Operacion {
    ConsultaConversion consulta = new ConsultaConversion();

    public double operacionConversion(String div1, String div2, double cantidad){
        return consulta.realizaConversion(div1, div2, cantidad);
    }

}
