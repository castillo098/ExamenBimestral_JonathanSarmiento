/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculos.findByAño", query = "SELECT v FROM Vehiculos v WHERE v.añoo = :año")
    , @NamedQuery(name = "Vehiculos.findByNumPasajeros", query = "SELECT v FROM Vehiculos v WHERE v.numPasajeros = :numPasajeros")
    , @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculos.findByCilindraje", query = "SELECT v FROM Vehiculos v WHERE v.cilindraje = :cilindraje")
    , @NamedQuery(name = "Vehiculos.findByPaisFabricacion", query = "SELECT v FROM Vehiculos v WHERE v.paisFabricacion = :paisFabricacion")
    , @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculos.findByConcesionarioPertenece", query = "SELECT v FROM Vehiculos v WHERE v.concesionarioPertenece = :concesionarioPertenece")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_vehiculo")
    private String idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "año")
    private String año;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_pasajeros")
    private String numPasajeros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais_fabricacion")
    private String paisFabricacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "concesionario_pertenece")
    private String concesionarioPertenece;

    public Vehiculos() {
    }

    public Vehiculos(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(String idVehiculo, String año, String numPasajeros, String modelo, String marca, String cilindraje, String paisFabricacion, String placa, String concesionarioPertenece) {
        this.idVehiculo = idVehiculo;
        this.año = año;
        this.numPasajeros = numPasajeros;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.paisFabricacion = paisFabricacion;
        this.placa = placa;
        this.concesionarioPertenece = concesionarioPertenece;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(String numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConcesionarioPertenece() {
        return concesionarioPertenece;
    }

    public void setConcesionarioPertenece(String concesionarioPertenece) {
        this.concesionarioPertenece = concesionarioPertenece;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }

}
