#language:es

@RegisterPayme
Característica: Como usuario quiero registrarme en Payme para asociar mi cuenta Paypal a Payme

	@HappyPath
	Esquema del escenario: Registro en Payme como usuario nuevo con nacionalidad peruana y extranjero
			Dado que se ha ingreso a la página de registro
			Y el usuario es nuevo sin cuenta en Paypal
			Cuando ingrese los campos: <Nombres>, <Apellidos>, <Correo>, <Clave>, <Conf_clave> 
			Y seleccione como país <Nombre_pais> 
			Entonces el sistema deberá mostrar el mensaje de confirmación de registro
			Y redireccionar al usuario al home de bienvenida
			Y mostrar la opción de <Nombre_opcion>
	
			Ejemplos:
			| Nombres |  Apellidos    |         Correo         |   Clave    | Conf_clave | Nombre_pais |      Nombre_opcion         |
			| Javier 	| Perez Limay   | javier.perez@gmail.com | Michael25& | Michael25& |    Perú     | "Asociar cuenta a Paypal"  |
			| Karen 	| Pereida Asmat | karen.asmat@gmail.com  | Michael25& | Michael25& |    México   | "Actualizar ya"            |
	
	
	@SadPath
	Escenario: No debería realizarse el registro si el usuario ingresa un correo ya registrado en Payme
			Dado que se ha ingreso a la página de registro 
			Y el usuario ya cuenta con una cuenta en Payme 
			Cuando ingrese un correo ya registrado 
			Y los campos obligatorios
			Entonces el sistema no debe permitir el registro del usuario 
			Y debe decirle al usuario que la cuenta de correo ya existe
	
 

