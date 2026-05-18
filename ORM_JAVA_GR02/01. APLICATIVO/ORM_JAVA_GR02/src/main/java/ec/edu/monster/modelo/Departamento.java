package ec.edu.monster.modelo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Le dice a Hibernate que esta clase es una tabla de la BD
@Table(name = "PEDEP_DEPAR") // El nombre exacto de tu tabla en MySQL
public class Departamento {
    
    @Id // Indica que esta es la Llave Primaria (Primary Key)
    @Column(name = "PEDEP_CODIGO", length = 3, nullable = false)
    private String codigo;
    
    @Column(name = "PEDEP_DESCRI", length = 50, nullable = false)
    private String descripcion;
    
    @Column(name = "PEDEP_NOMBRE", length = 50, nullable = false)
    private String nombre;
    
    @Column(name = "PEDEP_FECHA", nullable = false)
    private Date fecha;

    // Constructor vacío (obligatorio para Hibernate)
    public Departamento() {
    }

    public Departamento(String codigo, String descripcion, String nombre, Date fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // --- Getters y Setters (Son exactamente los mismos de antes) ---
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Departamento [" + codigo + "] - " + nombre;
    }
}