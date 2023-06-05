Comandos para lanzar el proyecto en Docker

mkdir app
mv ProyectoTecIntegracion/script.sql app/
mv ProyectoTecIntegracion/Perreria-PerreriaSOAP.jar app/
mv ProyectoTecIntegracion/backend.jar app/
mv ProyectoTecIntegracion/FormAdopcionJar/FormularioAdopcion-0.0.1-SNAPSHOT.jar app/
mv ProyectoTecIntegracion/crear.yaml .

docker-compose -f crear.yaml up