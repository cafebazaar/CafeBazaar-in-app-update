package com.farsitel.bazaar.inappupdate.callback.task

interface Task<Result> {
    fun getResult(): Result
    fun getException(): Exception
    fun isSuccessful(): Boolean
    fun isComplete(): Boolean
    fun addOnSuccessListener(onSuccessListener: OnSuccessListener<Result>)
    fun addOnFailureListener(onFailureListener: OnFailureListener)
    fun addOnCompleteListener(onCompleteListener: OnCompleteListener<Result>)
}