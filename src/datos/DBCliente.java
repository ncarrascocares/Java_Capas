
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Cliente;
import presentacion.Interface_cliente;

public class DBCliente implements Interface_cliente {
    private final Connection con = new Conexion().getConexion();
    
    //Este método implementa la sentencia para agregar datos a nuestra base de datos
    public void agregar_cliente(Cliente cliente){
        try {
            //Creación de la consulta para insertar datos a la base de datos
            String sql = "INSERT INTO cliente(id_cliente, nombre_cliente, direccion_cliente, saldo_cliente) VALUES (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cliente.getId());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.setFloat(4, cliente.getSaldo());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar" + ex);
        }
        
        
    }
    
    public DefaultTableModel lista_grilla(){
        //Creación de la consulta para listar los datos de la base de datos
        String sql = "SELECT * FROM cliente";
        
        //objeto de la clase DefaultTableModel
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet resulset = pstmt.executeQuery();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");
            modelo.addColumn("Saldo");
            
            while(resulset.next()){
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = resulset.getObject(i + 1);
                }
                
                modelo.addRow(fila);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al agregar" + ex);
        }
        
        return modelo;
    }
            
}
