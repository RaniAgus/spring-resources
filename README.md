# spring-rest-tutorial

## Requests

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

## Responses

Representación de un empleado en REST:

```json
{
  "id": 1,
  "name": "Bilbo Baggins",
  "role": "burglar",
  "_links": {
    "self": {
      "href": "http://localhost:8080/employees/1"
    },
    "employees": {
      "href": "http://localhost:8080/employees"
    }
  }
}
```

Representación de una lista de empleados en REST:

```json
{
   "_embedded" : {
      "employeeList" : [
         {
            "_links" : {
               "employees" : {
                  "href" : "http://localhost:8080/employees"
               },
               "self" : {
                  "href" : "http://localhost:8080/employees/1"
               }
            },
            "id" : 1,
            "name" : "Bilbo Baggins",
            "role" : "burglar"
         },
         {
            "_links" : {
               "employees" : {
                  "href" : "http://localhost:8080/employees"
               },
               "self" : {
                  "href" : "http://localhost:8080/employees/2"
               }
            },
            "id" : 2,
            "name" : "Frodo Baggins",
            "role" : "thief"
         }
      ]
   },
   "_links" : {
      "self" : {
         "href" : "http://localhost:8080/employees"
      }
   }
}
```