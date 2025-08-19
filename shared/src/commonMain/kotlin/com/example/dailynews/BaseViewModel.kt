package com.example.dailynews

import kotlinx.coroutines.CoroutineScope

/** We are using a scope in order to kick off the coroutines that are going
 * to carry the Http requests or the database queries.
 * And the reason we need the scope is that we want to have a single reference,
 * that if we kill all the work that started within this scope is also killed.
 * It is a concept that in the Kotlin coroutines we call structured concurrency.
 */
expect open class BaseViewModel() {

    val scope: CoroutineScope
}