#language:es

@LoginPayme
Característica: Como usuario quiero acceder a mi cuenta Payme para realizar recargas paypal

	@LoginFeature
	Escenario: El usuario puede autenticarse en el aplicativo
			Dado que el usuario ingreso a la página de autenticación 
			Cuando ingresa los siguientes valores válidos en el formulario
			|         correo            |  clave    |
			| michael.medinay@gmail.com | Michael1% |
			Entonces el usuario debe acceder al home de bienvenida

	@LoginFeature
	Esquema del escenario: El usuario tiene su cuenta bloqueada
			Dado que el usuario ingreso a la página de autenticación
			Y tiene su cuenta payme en estado bloqueado 
			Cuando ingresa los siguientes valores en el formulario
			| t_correo | t_clave |
			| <correo> | <clave> |
			Entonces el aplicativo debe mostrar el mensaje "Cuenta temporalmente bloqueada"
			
			Ejemplos:
			|         correo            |   clave    |
			| miguel.cespedes@gmail.com | Michael30% | 
			| luis.sanches@gmail.com    | Michael1%  |
			
			
  @LoginFeature
	Escenario: El usuario olvidó su clave
			Dado que el usuario ingreso a la página de autenticación 
			Cuando seleccione la opción "¿Olvidaste tu contraseña?"
			Entonces el aplicativo debe mostrar un formulario para ingresar su correo
