
package presentacion;

import negocio.Cliente;

public interface Interface_cliente {
    
    public void agregar_cliente(Cliente cliente);
    public Cliente buscarCliente(int _id);
    public void modificar_cliente(Cliente cliente);
    public void eliminar_cliente(int _id);
    //public DefaultModel lista_grilla();
}
