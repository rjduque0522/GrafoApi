package co.edu.umanizales.grafo.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(AristaPK.class)
public class Arista {
    private int origen;
    private int destino;
    private double peso;

    @Id
    @Column(name = "origen", nullable = false)
    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    @Id
    @Column(name = "destino", nullable = false)
    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    @Id
    @Column(name = "peso", nullable = false, precision = 0)
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
        Arista arista = (Arista) o;
        return origen == arista.origen && destino == arista.destino && Double.compare(arista.peso, peso) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, peso);
    }
}
