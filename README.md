# spring-rest-tutorial

## Parte 1: Empleados

### Requests

Consultar lista de empleados:
```bash
curl -v localhost:8080/employees | json_pp
```

Consultar empleado que no existe:

```bash
curl -v localhost:8080/employees/99
```

Crear un empleado:

```bash
curl -X POST localhost:8080/employees \
    -H 'Content-type:application/json' \
    -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

Actualizar un empleado:

```bash
curl -X PUT localhost:8080/employees/3 \
    -H 'Content-type:application/json' \
    -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'
```

Borrar un empleado:

```bash
curl -X DELETE localhost:8080/employees/3
```

### Responses

Representación de un empleado en REST:

```json
{
  "id": 1,
  "firstName": "Bilbo",
  "lastName": "Baggins", 
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
            "firstName": "Bilbo",
            "lastName": "Baggins",
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
            "firstName": "Frodo",
            "lastName": "Baggins",
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

## Parte 2: Órdenes

### Requests

Obtener todas las órdenes:

```bash
curl -v http://localhost:8080/orders | json_pp
```

Cancelar una orden:
```bash
curl -v -X DELETE http://localhost:8080/orders/4/cancel | json_pp
```

Completar una orden:

```bash
curl -v -X PUT http://localhost:8080/orders/4/complete | json_pp
```

### Responses

Representación de una orden en curso:
```json
{
    "_links" : {
        "cancel" : {
            "href" : "http://localhost:8080/orders/4/cancel"
        },
        "complete" : {
            "href" : "http://localhost:8080/orders/4/complete"
        },
        "orders" : {
            "href" : "http://localhost:8080/orders"
        },
        "self" : {
            "href" : "http://localhost:8080/orders/4"
        }
    },
    "description" : "iPhone",
    "id" : 4,
    "status" : "IN_PROGRESS"
}
```

Representación de una orden completada:

```json
{
    "_links" : {
        "orders" : {
            "href" : "http://localhost:8080/orders"
        },
        "self" : {
            "href" : "http://localhost:8080/orders/3"
        }
    },
    "description" : "MacBook Pro",
    "id" : 3,
    "status" : "COMPLETED"
}
```

Representación de una orden cancelada:

```json
{
    "_links" : {
        "orders" : {
            "href" : "http://localhost:8080/orders"
        },
        "self" : {
            "href" : "http://localhost:8080/orders/4"
        }
    },
    "description" : "iPhone",
    "id" : 4,
    "status" : "CANCELLED"
}
```

Errores al intentar cancelar o completar una orden ya cancelada:

```json
{
    "detail" : "You can't cancel an order that is in the CANCELLED status",
    "title" : "Method not allowed"
}
```

```json
{
    "detail" : "You can't complete an order that is in the COMPLETED status",
    "title" : "Method not allowed"
}
```