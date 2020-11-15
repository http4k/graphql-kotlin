# GraphQL Kotlin http4k HTTP

[http4k](http://http4k.org/) is an HTTP toolkit written in pure Kotlin

### Running locally
Build the application by running the following from examples root directory:

```bash
# build example
./gradlew build
```

> NOTE: in order to ensure you use the right version of Gradle we highly recommend that you use the provided wrapper scripts

Start the server by running `Application.kt` directly from your IDE. (Make sure that your Kotlin Compiler jvm target is 1.8 or greater.)
Alternatively, you can start the server using Gradle.

```bash
cd /path/to/graphql-kotlin/examples
./gradlew run
```

#### Simple
Once the app has started you can explore the example schema by opening Playground endpoint at: [http://localhost:5000/graphql/book]

You can use the following example query to view several of the related models:
```graphql
query {
  search(params: { ids: [1,2,3] }) {
    id
    name
    books {
      title
    }
    university {
      id
      name
    }
  }

  searchUniversities(params: { ids: [1]}) {
    id
    name
  }
}
```

#### Contextual
Once the app has started you can explore the example schema by opening Playground endpoint at: [http://localhost:5000/graphql/user]

You can use the following example query to view several of the related models:
```graphql
query {
  search(params: { ids: [1,2,3] }) {
    id
    name
    books {
      title
    }
    university {
      id
      name
    }
  }

  searchUniversities(params: { ids: [1]}) {
    id
    name
  }
}
```
