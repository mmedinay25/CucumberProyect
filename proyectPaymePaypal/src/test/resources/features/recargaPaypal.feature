#language:es

@RecargaPaypal
Característica: Como usuario quiero realzar mi recarga Paypal para realizar compras por internet

	@RecargaFeature
		Esquema del escenario: El usuario revisa las comisiones y total a pagar en base al monto ingresado
				Dado que el usuario ingreso a la página de recarga 
				Cuando digita los siguientes valores:
				| t_monto_recarga | t_cod_moneda |
				| <monto_recarga> | <cod_moneda> |
				Entonces debe observar los valores: Monto en soles <monto_soles>, Comisión <comision>, Total a pagar <total_pagar>
				
				Ejemplos: 
				| monto_recarga | cod_moneda |  monto_soles  |  comision   | total_pagar |
				|     20.00     |    604     |  "S/ 65.80"   |  "S/ 3.95"  | "S/ 69.75"  |
				|     40.00     |    840     |  "S/ 00.00"   |   "$ 2.40"  |  "$ 42.40"  |			

	
	@RecargaFeature
		Esquema del escenario: El usuario genera su código de pago de recarga
				Dado que el usuario ingreso a la página de recarga
				Cuando ingresa los siguientes valores en el formulario:
				|     t_monto     |   t_moneda   |
				| <monto_recarga> | <cod_moneda> |
				Entonces el aplicativo debe mostrar el código de pago, asi como el monto a pagar <total_pagar>
				Cuando el usuario selecciona la opción 'Movimientos'
				Entonces debe observar el formulario de movimientos 
				Y el estado de su operación como <estado>
				
				Ejemplos:
				| monto_recarga | cod_moneda |  total_pagar  |    estado    |
				|      25       |     840    |    "$ 26.50"  | "Procesando" | 
				|     100       |     604    |  "S/ 348.74"  | "Procesando" |				
						

			