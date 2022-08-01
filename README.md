# Exemplo Simples de Publicação / Consumo de fila utilizando RabbitMq

Para subir o RabbitMQ podemos utilizar o `Docker`, para isso utilize o seguinte `docker-compose`:

```
services:
    rabbitmq:
        image: rabbitmq:3-management
        container_name: rabbitmq
        restart: always
        ports:
            - 5672:5672
            - 15672:15672
        volumes:
            - ./dados:/var/lib/rabbitmq
        environment:
            - RABBITMQ_DEFAULT_USER=admin
            - RABBITMQ_DEFAULT_PASS=admin
            
```

Com o `Docker` instalado e configurado, basta dar o seguinte comando:

```
$ docker-compose up -d
```
