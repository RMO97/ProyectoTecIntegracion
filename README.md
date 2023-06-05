# Perreria

##  Comandos para ejecutar los servicios
- mkdir app
- mv ProyectoTecIntegracion/script.sql app/
- mv ProyectoTecIntegracion/Perreria-PerreriaSOAP.jar app/
- mv ProyectoTecIntegracion/backend.jar app/
- mv ProyectoTecIntegracion/FormAdopcionJar/FormularioAdopcion-0.0.1-SNAPSHOT.jar app/
- mv ProyectoTecIntegracion/crear.yaml .

- docker-compose -f crear.yaml up

# Consumo

## SOAP
- /ws/lomitos.wsdl

## REST
- /formulario.html
- /adopcion
- /seguimiento

### Datos esperados para seguimiento
-{        
        "nombre": "nombre",
        "direccion": "direccion",
        "nombrePerro": "nombrePerro",
        "estado": "estado",
        "tadoptado": "tadoptado"
    }
