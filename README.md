# quarkus-rest-client-post-redirect-post

Project to reproduce a Post/redirect/Post request on an API using the REST client

See issue XXX

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
    --data '{"value": "test"}' \
    -v
```

# Resources

- XXX
- https://quarkus.io/guides/rest-client-reactive#redirection
- https://en.wikipedia.org/wiki/Post/Redirect/Get
