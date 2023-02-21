package com.chrome.geolance.core

sealed class Either<out A, out B> {

    data class Left<T>(val value: T) : Either<T, Nothing>()

    data class Right<T>(val value: T) : Either<Nothing, T>()
}

inline infix fun <A, B, C> Either<A, B>.map(f: (B) -> C): Either<A, C> = when (this) {
    is Either.Left -> this
    is Either.Right -> Either.Right(f(value))
}

inline infix fun <A, B, C> Either<A, B>.flatMap(f: (B) -> Either<A, C>): Either<A, C> =
    when (this) {
        is Either.Left -> this
        is Either.Right -> f(value)
    }

inline infix fun <A, B, C> Either<A, C>.mapLeft(f: (A) -> B): Either<B, C> = when (this) {
    is Either.Left -> Either.Left(f(value))
    is Either.Right -> this
}

fun <A, B> Either<A, B>.leftOrNull(): A? =
    when (this) {
        is Either.Left -> value
        is Either.Right -> null
    }

fun <A, B> Either<A, B>.rightOrNull(): B? =
    when (this) {
        is Either.Left -> null
        is Either.Right -> value
    }