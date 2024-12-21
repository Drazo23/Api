package foro.alura.api.consulta;


import jakarta.persistence.*;

import java.util.Objects;


@Table(name = "consultas")
@Entity(name = "Consulta")

public class Consulta {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String curso;
    private String titulo;

    public Consulta(){
    }
    public Consulta(String mensaje, String curso, String titulo){
        this.mensaje = mensaje;
        this.curso = curso;
        this.titulo = titulo;
    }

    public Consulta(DatosRegistroConsulta datosRegistroConsulta) {
        this.mensaje = datosRegistroConsulta.mensaje();
        this.curso = datosRegistroConsulta.curso();
        this.titulo = datosRegistroConsulta.titulo();
    }
    public void actualizarConsulta(DatosActualizarConsulta datosActualizarConsulta) {
        if (datosActualizarConsulta.mensaje() !=null){
            this.mensaje = datosActualizarConsulta.mensaje();
        }
        if (datosActualizarConsulta.curso() !=null){
            this.curso = datosActualizarConsulta.curso();
        }
        if (datosActualizarConsulta.titulo() !=null){
            this.titulo = datosActualizarConsulta.titulo();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", curso='" + curso + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }


}
