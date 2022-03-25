# spring-rest-videotutorial

## Actuator

Consultar todos los Actuators disponibles:

```bash
curl -v localhost:8080/actuator | json_pp
```

## Requests

Consultar lista de libros:

```bash
curl -v localhost:8080/books | json_pp
```

Agregar libro:
```bash
curl -X POST localhost:8080/books \
    -H 'Content-type:application/json' \
    -d '{"isbn": "SADF2345", "title": "Hello World"}' \
    | json_pp
```

Actualizar libro:

```bash
curl -X PUT localhost:8080/books/3 \
    -H 'Content-type:application/json' \
    -d '{"isbn": "SADF2345", "title": "Hola Mundo"}' \
    | json_pp
```

Eliminar libro:

```bash
curl -X DELETE localhost:8080/books/1 | json_pp
```