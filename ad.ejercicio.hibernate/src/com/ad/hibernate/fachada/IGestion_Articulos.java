package com.ad.hibernate.fachada;

import com.ad.hibernate.dto.Articulos;

public interface IGestion_Articulos {

	void alta_Articulo(Articulos articulo_nuevo);

	void baja_Articulo(Articulos articulo_nuevo);

	void modificacion_Articulo(Articulos articulo_nuevo);

	void consultar_PorClave(Integer clave_articulo);

}