#language:es

@AsociacionPaypal
Característica: Como cliente Paypal quiero asociar mi cuenta a Payme para realizar recargas desde Payme

	@HappyPath
	Escenario: Realizar la asociación de una cuenta Paypal nacional a una Payme nacional
			Dado que se ha ingresado a la opción de asociación
			Y el usuario tiene una cuenta en Payme
			Y una cuenta nacional en Paypal
			Cuando ingrese su correo Paypal
			Y seleccione "Asociar ahora" 
			Y termina de completar los campos requeridos
			Entonces el sistema deberá mostrar el mensaje de confirmación: "Su cuenta se asoció correctamente" 
			Y redireccionaral usuario al home de bienvenida
			Y mostrar la opción: "Recarga ya"
	
	@SadPath1
	Escenario: No realizar la asociación de una cuenta Paypal extranjera a Payme nacional
			Dado que se ha ingresado a la opción de asociación 
			Y el usuario tiene una cuenta en Payme 
			Y tiene una cuenta extranjera en Paypal 
			Cuando ingrese su correo Paypal
			Y seleccione "Asociar ahora" 
			Entonces el sistema deberá mostrar el mensaje de validación: "El correo Paypal ingresado no es válido"
	
	@SadPath2
	Escenario: Usuario con cuenta bloqueada en Paypal quiere asociarlo a Payme
			Dado que se ha ingresado a la opción de asociación
			Y el usuario tiene una cuenta en Payme
			Y tiene una cuenta bloqueada en Paypal
			Cuando ingrese su correo Paypal
			Y seleccione "Asociar ahora"
			Entonces el sistema deberá mostrar el mensaje de validación: "Error en la asociación, verifique su cuenta Paypal
	
 

