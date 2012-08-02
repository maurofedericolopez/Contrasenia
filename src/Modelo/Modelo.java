package Modelo;

import java.util.Observable;

/**
 *
 * @author Mauro Federico Lopez
 */
public class Modelo extends Observable {
    private String username = "mauro";
    private String password = "mauro";
    private Integer cantidadDeLogin;

    public Modelo() {
        cantidadDeLogin = 0;
    }

    public void incrementar() {
        cantidadDeLogin++;
    }

    public Boolean sePuedeLoguear() {
        if (cantidadDeLogin < 3)
            return true;
        else
            return false;
    }

    public Boolean validarNombre(String username) {
        if (this.username.equals(username))
            return true;
        else
            return false;
    }

    public Boolean validarContrasenia(String password) {
        if (this.password.equals(password))
            return true;
        else {
            incrementar();
            if (!sePuedeLoguear()) {
                setChanged();
                notifyObservers();
            }
            return false;
        }
    }
}
