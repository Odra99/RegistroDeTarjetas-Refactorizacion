# Refactorizacion de RegistroDeTarjetas

Algunas acciones realizadas

1. Implementacion de patron Factory para las Operaciones, Tipos de Tarjeta y Reportes


![alt text](/ImgRefactor/Screenshot%202022-04-30%20222727.png)
![alt text](/ImgRefactor/OperacionFactor.png)

2. Eliminacion de archivos inecesarios o vacios.

3. Se unifico los controladores de numero de tarjeta  siendo estos Nacional,Regional e Internacional al archivo ControladorNumTarjetas.java
**Antes**

![alt text](/ImgRefactor/DupCode.png)

**Despues**

![alt text](/ImgRefactor/DupCode2.png)

4. Implementacion de Tipo Tarjeta como objeto

![alt text](/ImgRefactor/TipoTarjeta.png)
![alt text](/ImgRefactor/TipoTarjetaO.png)

