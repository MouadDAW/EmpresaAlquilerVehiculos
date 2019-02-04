/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaalquilervehiculos;

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
}
