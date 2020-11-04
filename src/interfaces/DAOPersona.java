package interfaces;

import entidades.Persona;
import java.util.List;

public interface DAOPersona {

    public void registrar (Persona p) throws Exception;
    public List<Persona> listar () throws Exception;
    public void actualizar(Persona p)throws  Exception;
    public void eliminar(Persona p)throws  Exception;
}