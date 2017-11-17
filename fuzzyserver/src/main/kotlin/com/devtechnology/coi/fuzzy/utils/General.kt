package com.devtechnology.coi.fuzzy.utils

fun CharSequence?.hasValue() = !this.isNullOrEmpty()

inline fun <T, R> Iterable<T>.filterThenMap(predicate : (T) -> Boolean, transform : (T) -> R): List<R> {
    return this.filterThenMap(mutableListOf(), predicate, transform)
}
inline fun <T, R> Iterable<T>.filterThenMap(mutableList: MutableList<R>, predicate : (T) -> Boolean, transform : (T) -> R): List<R> {
    @Suppress("LoopToCallChain")
    for (item in this) {
        if(predicate(item)) {
           mutableList.add(transform(item))
        }
    }
    return mutableList
}


