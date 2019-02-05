/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaalquilervehiculos;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;

/**
 *
 * @author mouad
 */
public class EmpresaAlquilerVehiculos {

    // Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;

    private int totalClientes;
    private Cliente[] clientes;

    private int totalVehiculos;
    private Vehiculo[] vehiculos;

    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;

    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
        this.totalClientes = 0;
        this.clientes = new Cliente[50]; // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new Vehiculo[50]; // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new VehiculoAlquilado[100]; // apuntan a null
    }

    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb, int totalClientes, Cliente[] clientes, int totalVehiculos, Vehiculo[] vehiculos, int totalAlquileres, VehiculoAlquilado[] alquileres) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.totalClientes = totalClientes;
        this.clientes = clientes;
        this.totalVehiculos = totalVehiculos;
        this.vehiculos = vehiculos;
        this.totalAlquileres = totalAlquileres;
        this.alquileres = alquileres;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "EmpresaAlquilerVehiculos{" + "cif=" + cif + ", nombre=" + nombre + ", paginaWeb=" + paginaWeb + ", totalClientes=" + totalClientes + ", clientes=" + clientes + ", totalVehiculos=" + totalVehiculos + ", vehiculos=" + vehiculos + ", totalAlquileres=" + totalAlquileres + ", alquileres=" + alquileres + '}';
    }
    
    

    public void registrarCliente(Cliente nuevo) {
        this.clientes[this.totalClientes] = nuevo;
        this.totalClientes++;
    }

    public void registrarVehiculo(Vehiculo nuevo) {

        this.vehiculos[this.totalVehiculos] = nuevo;
        this.totalVehiculos++;
    }

    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(clientes[i].toString());
        }
    }

    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int i = 0; i < this.totalVehiculos; i++) {
            System.out.println(vehiculos[i].toString());
        }
    }
      


    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes[i].toString().equals(nif)) {
                return this.clientes[i];
            }

        }
        return null;
    }
    
    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.totalVehiculos; i++) {
            if (this.vehiculos[i].getMatricula().equals(matricula)) {
                return this.vehiculos[i];
            }
        }
        return null;
    }
    
    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
// busca el cliente con el NIF dado en el array
// clientes y el vehículo con la matrícula dada en el
// array vehiculos, si el vehículo está disponible se
// alquila con la fecha actual, que se obtiene
// ejecutando los métodos diaHoy(), mesHoy() y
// añoHoy(), cuya declaración no se incluye
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres]
                    = new VehiculoAlquilado(cliente, vehiculo,
                            diaHoy(), mesHoy(), añoHoy(), dias);

            this.totalAlquileres++;
        }
    }
    
    public static int diaHoy(){
        return LocalDate.now().getDayOfMonth();
    }
    
    
    public static int mesHoy(){
        return LocalDate.now().getDayOfMonth();
    }
    
    
    public static int añoHoy(){
        return LocalDate.now().getDayOfMonth();
    }
    
    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }
    public class MisVehiculos {
    }
        public static void main(String[] args) {
// la instancia easydrive de la clase EmpresaAlquilerVehiculos
            EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive",
                    "www.easydrive.com");
// registro de los clientes de la empresa
            easydrive.registrarCliente(new Cliente("X5618927C",
                    "Juan", "González López"));

            easydrive.registrarCliente(new Cliente("Z7568991Y",
                    "Luis", "Fernández Gómez"));

// registro de los vehículos de la empresa
            easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda",
                    "Fabia", "Blanco", 90.0, true));

            easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang",
                    "Rojo", 150.0, true));

            easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI",
                    

            "Azul", 110.0, true));

easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza",
                    "Blanco", 90.0, true));

            easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato",
                    "Azul", 80.0, true));
// imprime la relación de clientes de easydrive
            easydrive.imprimirClientes();
// imprime el catálogo de vehículos de easydrive
            easydrive.imprimirVehiculos();
        }
    }


