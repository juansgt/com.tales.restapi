package com.tales.model.services

interface IQueryServiceNoInput<TResult> {
    fun execute() : TResult
}