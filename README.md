* Los controladores no deben trabajar con las entidades
* Cual es la diferencia entre una entidad y un modelo?
* Los controles deberian usar los services y no entities

#### 46 Introduccion a query dsl

http://querydsl.com
* query dsl sirve para hacer consultas.
* Tiene modulos para trabajar JPA, SQL, Mongo, Lucene, etc.
* Query dsl genera sus propias clases para gestionar las queries
* El plugin query dsl nos genera una clase Q por cada entidad que tengamos.

#### 47 Nuestra primera consulta con querydsl
* em, entity manager es un recurso que se encarga de administrar las persistencia de las entidades en la aplicacion.
```java
@PersistenceContext
    private EntityManager em;
 ```   
* Si no tenemos disponible la clase Querydsl de nuestra entidad en nuestro proyecto, debemos hacer maven update project.
* Siempre que usaremos una consulta en las clases usaremos JPAQuery
https://github.com/querydsl/querydsl/tree/master/querydsl-jpa



#### 48 Preparar el proyecto backendininja
* Limpiaremos todos los ejemplos para empezar la app.
- **Tendremos solo 2 paquetes**
    - Component: Aqui estara la clase RequestTimeInterceptorComponent
    - Configuration: la clase WebMvcConfiguration donde activaremos la clase RequestTimeInterceptorComponent




