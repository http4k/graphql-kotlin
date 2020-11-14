/**
 * Copyright 2020 Expedia, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.graphql.examples.http4k

import org.http4k.core.Method.GET
import org.http4k.core.Method.OPTIONS
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

fun App(): RoutingHttpHandler {
    val graphQLHandler = GraphQLHandler()

    return routes(
        "/graphql" bind routes(
            OPTIONS to { _ -> Response(OK) },
            POST to { req: Request ->
                Response(OK).body(graphQLHandler.handle(req) ?: "")
            }
        ),
        "/hello" bind GET to { _ -> Response(OK).body("Hello, World") }
    )
}

fun main() {
    App().asServer(SunHttp(5000)).start()
}
