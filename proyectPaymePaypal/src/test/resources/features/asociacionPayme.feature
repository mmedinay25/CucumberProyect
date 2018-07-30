#language:es

@AsociacionPayme
Característica: Como cliente Payme quiero asociar mi cuenta a PayPal para realizar recargas desde Payme

	@HappyPath
	Escenario: Realizar la asociación de una cuenta Payme a Paypal
			Dado que se ha ingresado a la opción de asociación
			Y el usuario no tiene deudas financieros y/o crediticios 
			Y no tiene una cuenta registrada en Paypal
			Cuando ingrese los todos campos obligatorios correctamente 
			Y complete su clave Paypal 
			Entonces el sistema deberá mostrar el mensaje de confirmación: "Su cuenta se asoció correctamente" 
			Y redireccionar al usuario al home de bienvenida 
			Y mostrar la opción: "Recarga ya"
	
	@SadPath1
	Escenario: Usuario sin historial financiero y/o crediticio quiere asociar su cuenta Payme a Paypal
			Dado que se ha ingresado a la opción de asociación 
			Y el usuario está registrado en Sentinel 
			Cuando ingrese los campos obligatorios 
			Y seleccione "Siguiente" 
			Entonces el sistema deberá mostrar el mensaje de validación: "Error con los datos del usuario"
	
	@SadPath2
	Escenario: Usuario con Nro. documento que no le pertenece quiere asociar se cuenta Payme a Paypal
			Dado que se ha ingresado a la opción de asociación 
			Y el usuario no tiene una cuenta registrada en Paypal 
			Cuando ingrese un Nro. documento que no le corresponde 
			Y digite un nombre/apellido que no le corresponde 
			Y seleccione "Siguiente" 
			Entonces el sistema deberá mostrar el mensaje de validación: "Datos del usuario son inválidos"
	
 

