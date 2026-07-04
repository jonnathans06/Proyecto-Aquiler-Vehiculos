package proyecto_final.dao.interfaces;

import proyecto_final.modelo.Usuario;

public interface DaoUsuario {
    boolean crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorUsername(String username);
}