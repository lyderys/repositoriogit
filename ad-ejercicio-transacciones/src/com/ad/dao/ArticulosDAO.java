package com.ad.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ad.jdbc.dto.Articulos;
import com.ad.conexion.Conexion;

public class ArticulosDAO {
	
	public Connection conexion;
	public Statement sta;
	public ResultSet rs;
	public ResourceBundle rb;
	public PreparedStatement pta;
	public CallableStatement cta;
	
	public final int ALTA = 10;
	public final int MODIFICACION = 20;

	
		public ArticulosDAO() {
			// INICIAMOS EL PROCESO DE OBTENCION DE CONEXION
			Conexion con = new Conexion();
			// SOLICITAMOS CONEXION SEGUN LA ESTRATEGIA QUE NECESITEMOS
			con.establecer_Conexion();
			// RECOGEMOS LA CONEXION OBTENIDA
			conexion = con.getConexion();
			// CARGAMOS EL FICHERO DE TEXTO CON LAS SENTENCIAS SQL A USAR
			rb = ResourceBundle.getBundle("com.ad.jdbc.modelo.sql");
			
		}
		
		public void liberar_Recursos() throws SQLException {
			if (rs != null) {
				// CERRAMOS EL RESULTSET
				rs.close();
			}
			if (pta != null) {
				// CERRAMOS EL PREPARESTATEMENT
				pta.close();
			}
			if (sta != null) {
				// CERRAMOS EL STATEMENT
				sta.close();
			}
			if (cta != null) {
				// CERRAMOS EL CALLABLESTATEMENT
				cta.close();
			}
			if (conexion != null) {
				// CERRAMOS LA CONEXION
				conexion.close();
			}
		}

		public void iniciar_Transaccion() throws SQLException {
			if (conexion != null) {
				conexion.setAutoCommit(false);
			}
		}

		public void confirmar_Transaccion() throws SQLException {
			if (conexion != null) {
				conexion.commit();
			}
		}

		public void anular_Transaccion() throws SQLException {
			if (conexion != null) {
				conexion.rollback();
			}
		}

		public void recibir_Conexion(Connection conexion) throws SQLException {
			liberar_Recursos();
			this.conexion = conexion;
		}
		
		public void alta_articulo(Articulos articulo_nuevo) throws SQLException {
			// SE PREPARA EL ALTA
			pta = conexion.prepareStatement(rb.getString("alta"));
			// SE CARGAN LOS DATOS
			this.CargarDatos(articulo_nuevo, ALTA);
			// SE EJECUTA LA OPERACION
			pta.execute();
		}
		
		public void modificacar_articulo(Articulos articulo_amodificar) throws SQLException {
			// SE PREPARA LA MODIFICACION
			pta = conexion.prepareStatement(rb.getString("modificar"));
			// SE CARGAN LOS DATOS
			this.CargarDatos(articulo_amodificar, MODIFICACION);
			// SE EJECUTA LA OPERACION
			pta.execute();
		}
		
		public void eleminar_articulo(Articulos articulo_borrar) throws SQLException {
			// SE PREPARA LA BAJA
			pta = conexion.prepareStatement(rb.getString("eliminar"));
			// SE CARGAN LOS DATOS
			pta.setLong(1, articulo_borrar.getCodigo_articulo());
			// SE EJECUTA LA OPERACION
			pta.execute();
		}

		
		private void CargarDatos(Articulos articulo_nuevo, int proceso) throws SQLException {
			int posicion_variable=0;
			if (proceso == ALTA) {
				posicion_variable = 2;
				pta.setLong(1, articulo_nuevo.getCodigo_articulo());
			}
			if (proceso == MODIFICACION) {
				posicion_variable = 1;
				pta.setLong(6, articulo_nuevo.getCodigo_articulo());
		}
			if (articulo_nuevo.getDescripcion() != null) {
				pta.setString(posicion_variable, articulo_nuevo.getDescripcion());
			} else {
				pta.setString(posicion_variable, new String());
			}
			posicion_variable++;
			if (articulo_nuevo.getPrecio_unidad() != null) {
				pta.setDouble(posicion_variable, articulo_nuevo.getPrecio_unidad());
			} else {
				pta.setDouble(posicion_variable, new Double(0));
			}
			posicion_variable++;
			if (articulo_nuevo.getCantidad() != null) {
				pta.setInt(posicion_variable, articulo_nuevo.getCantidad());
			} else {
				pta.setInt(posicion_variable, new Integer(0));
			}
			
		}
		
		public Articulos consultar_ArticuloPorCodigo(Integer codigo_articulo) throws SQLException {
			// SE PREPARA LA CONSULTA
			pta = conexion.prepareStatement(rb.getString("consultar.por.codigo"));
			// SE SUSTITUYE LA VARIABLE POR SU RESULTADO
			pta.setInt(1, codigo_articulo);
			// SE EJECUTA LA CONSULTA
			rs = pta.executeQuery();
			Articulos pedido_consultado = null;
			// SE BUSCA EN EL RESULTASET ALGUN RESULTADO SI LO HAY
			if (rs.next()) {
				// SE PASA LA INFORMACION AL OBJETO CORRESPONDIENTE
				pedido_consultado = new Articulos();
				// Cargar_Datos.cargar_Objeto_RS(rs, pedido_consultado);
				pedido_consultado.setCodigo_articulo(rs.getInt("codigo_articulo"));
				pedido_consultado.setDescripcion((rs.getString("descripcion")));
				pedido_consultado.setPrecio_unidad(rs.getDouble("precio_unidad_articulo"));
				pedido_consultado.setCantidad(rs.getInt("cantidad"));
				
			}
			// SE RETORNA EL RESULTADO DE LA CONSULTA
			return pedido_consultado;
		}
		
		public List<Articulos> consultar_LineasPedido() throws SQLException {
			// SE PREPARA LA CONSULTA
			pta = conexion.prepareStatement(rb.getString("consultar.todos.articulos"));
			// SE EJECUTA LA CONSULTA
			rs = pta.executeQuery();
			List<Articulos> lista = new ArrayList<>(0);
			Articulos articulo;
			// SE PASA EL CONJUNTO DE INFORMACION RESULTANTE DE LA CONSULTA A UNA
			// COLECCION
			while (rs.next()) {
				articulo = new Articulos();
				articulo.setCodigo_articulo(rs.getInt("codigo_articulo"));
				articulo.setDescripcion(rs.getString("descripcion_artiuclo"));
				articulo.setPrecio_unidad(rs.getDouble("precio_unidad_articulo"));
				articulo.setCantidad(rs.getInt("cantidad"));
				lista.add(articulo);
			}
			return lista;
		}
}
