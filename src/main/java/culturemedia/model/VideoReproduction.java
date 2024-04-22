package culturemedia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoReproduction {

    private String usuario;
    private LocalDateTime fechaHora;
    private Integer edad;

    public VideoReproduction() {
    }
    public VideoReproduction(String usuario, LocalDateTime fechaHora, Integer edad) {
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
