package co.edu.umanizales.grafo.domain.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AristaPK implements Serializable {
    private int origen;
    private int destino;
    private double peso;

    @Column(name = "origen", nullable = false)
    @Id
    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    @Column(name = "destino", nullable = false)
    @Id
    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    @Column(name = "peso", nullable = false, precision = 0)
    @Id
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AristaPK aristaPK = (AristaPK) o;
        return origen == aristaPK.origen && destino == aristaPK.destino && Double.compare(aristaPK.peso, peso) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, peso);
    }
}
