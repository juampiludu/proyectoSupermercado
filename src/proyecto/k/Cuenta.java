package proyecto.k;

import java.util.ArrayList;

public class Cuenta extends LogIn {

    ArrayList<String> usuario = new ArrayList();
    ArrayList<String> contraseña = new ArrayList();

    public Cuenta() {

    }

    public void agregarUsuario(String a) {
        usuario.add(a);
    }

    public void agregarContraseña(String b) {
        contraseña.add(b);
    }

    public void mostrarUsuario() {
        for (int i = 0; i < usuario.size(); i++) {
            String a;
            a = usuario.get(i);
            System.out.println("Usuario: " + a);
        }
    }

    public void mostrarContraseña() {
        for (int i = 0; i < contraseña.size(); i++) {
            String b;
            b = contraseña.get(i);
            System.out.println("Contraseña: " + b);
        }
    }

}
