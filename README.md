# Scala.js Lambda Template

A [Giter8](http://www.foundweekends.org/giter8/) template for creating an AWS Lambda using [Scala.js](http://www.scala-js.org/).

# Development

Watch for changes and re-compile:
```
> ~fastOptJS::webpack
```

# Running locally

You can use [docker-lambda](https://github.com/lambci/docker-lambda) to test the function locally:

```
$ docker run --rm \
    -v $(pwd)/target/scala-2.13/scalajs-bundler/main:/var/task:ro,delegated \
    lambci/lambda:nodejs12.x \
    lambda-fastopt-bundle.handler \
    '{"body":"world"}'
```

The handler name will be `${project-name}-fastopt-bundle.handler`.

# Deploy

Package the lambda:
```
> lambda/universal:packageBin
```

Deploy the resulting zip in `target/universal` to AWS Lambda. The handler name will be `${project-name}.handler`.


# Template license

Written in 2020 by Bryan Gahagan 

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <https://creativecommons.org/publicdomain/zero/1.0/>.
