#language:es

@AsociacionPayme
Característica: Como cliente Payme quiero asociar mi cuenta a PayPal para realizar recargas desde Pay-me

	
	@AsociacionFeature
	Esquema del escenario: Usuario con nombre/apellidos inconsistes o con Nro. documento que no le pertenece quiere asociar se cuenta Payme a Paypal
		Dado que el usuario ha ingresado a la opción de asociación
		Cuando ingrese el correo: "rafael.romero.vilcherrez-buyer@gmail.com"
		Y complete los siguientes campos:
		  | t_nombres | t_apellidos | t_tipo_documento | t_nro_documento | t_nro_celular | t_operador |
			| <nombres> | <apellidos> | <tipo_documento> | <nro_documento> | <nro_celular> | <operador> |
		Y selecciona la opción 'Siguiente'
		Entonces se debe visualizar el mensaje de validacion <mensaje_validacion>
			
		Ejemplos:
		|  nombres  |     apellidos       | tipo_documento | nro_documento | nro_celular | operador |                      mensaje_validacion                                |
		|  Luis     | "Medina Yacupoma"   |      DNI       |    44953537   |  994754259  | Claro    | "El nombre debe ser el mismo que aparece en tu documento de identidad" |
		|  Camila   | "Cervantes de León" |      DNI       |    44953537   |  950143239  | Movistar | "El nombre debe ser el mismo que aparece en tu documento de identidad" |
		|  Michael  | "Medina Yacupoma"   |      DNI       |    46933130   |  994754259  | Claro    | "El nombre debe ser el mismo que aparece en tu documento de identidad" |
	
	@AsociacionFeature
	Escenario: Realizar la asociación directa de una cuenta Payme a Paypal
		Dado que el usuario ha ingresado a la opción de asociación
		Cuando ingrese el correo: "rafael.romero.vilcherrez-buyer@gmail.com"
		Y complete los siguientes datos personales:
		  |  nombres  |     apellidos     | tipo_documento | nro_documento | nro_celular | operador |
		  | "Michael" | "Medina Yacupoma" |     "DNI"      |   "44953537"  | "994754259" |  "Claro" |
		Y complete los siguientes datos de direccion:
		  | pais | departamento | ciudad | distrito  |    direccion      |
		  | "PE" |    "Lima"    | "Lima" | "LIMA 13" | "Jr. Lucanas 568" |
		Y complete finalmente la clave paypal "123456790"
		Entonces se debe visualizar el mensaje de confirmación: "La cuenta PayPal se asoció correctamente"
			
	
	@AsociacionFeature
	Escenario: Realizar la asociación usando un correo paypal ya registrado
		Dado que el usuario se ubica en el formulario de asociación
		Cuando ingrese el correo: "rafael.romero.vilcherrez-buyer@gmail.com"
		Y selecciona la opción 'Asociar'
		Entonces se debe visualizar el mensaje de validacion "La cuenta PayPal ya se encuentra asociada a otra cuenta Pay-me."