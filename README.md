# Quarkus Sample

## TL;DR

A simple sample of Rest API by [Quarkus](https://quarkus.io/) with Kotlin.

This is another implementation version of [Spring Boot Sample](https://github.com/retheviper/springbootsample).

In Construction!

## Includes

- [Gradle](https://gradle.org) (Kotlin DSL)
- [RESTEasy](https://resteasy.github.io/) (Reactive-Jackson)
- [REST Assured](https://rest-assured.io/)

## Build

### Uber-jar (for JVM)

1. Run below.

```shell
./gradlew quarkusBuild -Dquarkus.package.type=uber-jar
```

2. Jar file will be found in `/build`.

### Native build

1. Run below.

```shell
./gradlew build -Dquarkus.package.type=native
```

2. Executable file will be fount in `/build`.