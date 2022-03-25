# spring-rest-tutorial

Consultar lista de empleados:
```
curl -v localhost:8080/employees | json_pp
```

Consultar empleado que no existe:

```
curl -v localhost:8080/employees/99
```

Crear un empleado:

```
curl -X POST localhost:8080/employees \
    -H 'Content-type:application/json' \
    -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

Actualizar un empleado:

```
curl -X PUT localhost:8080/employees/3 \
    -H 'Content-type:application/json' \
    -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'
```

Borrar un empleado:

```
curl -X DELETE localhost:8080/employees/3
```
