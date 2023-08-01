# quarkus-rest-client-post-redirect-post

Project to reproduce a Post/redirect/Post request on an API using the REST client

See issue https://github.com/quarkusio/quarkus/issues/34644

# How to run

## Server

```sh
cd server && ./mvnw quarkus:dev
```

## Client

```sh
cd client && ./mvnw quarkus:dev
```

# How to test the server using cURL

```sh
curl --location 'http://localhost:8080/token' \
    --header 'Content-Type: application/json' \
    --header 'X-Api-Version: v1.0' \
    --data '{"value": "test"}' \
    -v
```

# Resources

- https://github.com/quarkusio/quarkus/issues/34644
- https://github.com/quarkusio/quarkus/issues/35126
- https://quarkus.io/guides/rest-client-reactive#redirection
- https://github.com/quarkusio/quarkus/issues/30942
- https://github.com/quarkusio/quarkus/issues/26517
- https://en.wikipedia.org/wiki/Post/Redirect/Get
