package com.retheviper.common.extension

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni

/**
 * Creates a new [Multi] that emits the items individually after being subscribed to (according to the subscriber's request).
 * If iterable is null, an [IllegalArgumentException] is thrown at call time.
 * If one of the item from iterable is null, a failure event is fired (with an [IllegalArgumentException]).
 * When all the items have been emitted, the completion event is fired.
 */
fun <T> Iterable<T>.toMulti(): Multi<T> = Multi.createFrom().iterable(this)

/**
 * Creates a new [Uni] that completes immediately after being subscribed to with the specified (potentially null) item.
 */
fun <T> T.toUni(): Uni<T> = Uni.createFrom().item(this)