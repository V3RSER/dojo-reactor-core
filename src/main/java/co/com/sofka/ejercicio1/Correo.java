package co.com.sofka.ejercicio1;

public class Correo {

    private String direccion;

    public Correo(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Correo correo = (Correo) o;

        return direccion.equals(correo.direccion);
    }

    @Override
    public int hashCode() {
        return direccion.hashCode();
    }

    @Override
    public String toString() {
        return "Direccion: " + this.direccion;
    }
}
