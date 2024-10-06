package automovil;

public class Automovil {
    // Atributos
    private String marca;
    private String modelo;
    private double motor; 
    private TipoCombustible tipoCombustible;
    private TipoAutomovil tipoAutomovil;
    private int numeroPuertas;
    private int cantidadAsientos;
    private double velocidadMaxima; 
    private Color color;
    private double velocidadActual; 

    // Enumerados
    public enum TipoCombustible {
        GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL
    }

    public enum TipoAutomovil {
        CARRO_CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV
    }

    public enum Color {
        BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA
    }

    // Constructor
    public Automovil(String marca, String modelo, double motor,
            TipoCombustible tipoCombustible, TipoAutomovil tipoAutomovil,
            int numeroPuertas, int cantidadAsientos, double velocidadMaxima, 
            Color color) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.velocidadActual = 0.0;
    }

    // Métodos get y set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    // Métodos para controlar la velocidad
    public void acelerar(double incremento) { // Cambiar incremento a double
        if (velocidadActual + incremento <= velocidadMaxima) {
            velocidadActual += incremento;
            System.out.println("Velocidad actual después de acelerar: " + velocidadActual + " km/h");
        } else {
            System.out.println("No se puede acelerar más allá de la velocidad máxima de " + velocidadMaxima + " km/h");
        }
    }

    public void desacelerar(double decremento) { 
        if (velocidadActual - decremento >= 0) {
            velocidadActual -= decremento;
            System.out.println("Velocidad actual después de desacelerar: " + velocidadActual + " km/h");
        } else {
            System.out.println("No se puede desacelerar a una velocidad negativa.");
        }
    }

    public void frenar() {
        velocidadActual = 0.0;
        System.out.println("El automóvil ha frenado. Velocidad actual: " + velocidadActual + " km/h");
    }

    // Método para calcular el tiempo estimado de llegada
    public double calcularTiempoEstimadoLlegada(double distancia) {
        if (velocidadActual > 0) {
            return distancia / velocidadActual;
        } else {
            System.out.println("El automóvil está detenido. No se puede calcular el tiempo estimado de llegada.");
            return 0;
        }
    }

    // Método para mostrar los atributos del automóvil
    public void mostrarAtributos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor: " + motor + " L");
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Automóvil: " + tipoAutomovil);
        System.out.println("Número de Puertas: " + numeroPuertas);
        System.out.println("Cantidad de Asientos: " + cantidadAsientos);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Velocidad Actual: " + velocidadActual + " km/h");
    }

    // Método main
    public static void main(String[] args) {
        // Crear un automóvil
        Automovil auto = new Automovil("Toyota", "Corolla", 1.8, TipoCombustible.GASOLINA,
                TipoAutomovil.COMPACTO, 4, 5, 180, Color.AZUL);

        // Colocar velocidad actual en 100 km/h
        auto.setVelocidadActual(100);
        System.out.println("Velocidad actual: " + auto.getVelocidadActual() + " km/h");

        // Aumentar velocidad en 20 km/h
        auto.acelerar(20);

        // Disminuir velocidad en 50 km/h
        auto.desacelerar(50);

        // Frenar
        auto.frenar();

        // Mostrar atributos finales
        auto.mostrarAtributos();
    }
}
