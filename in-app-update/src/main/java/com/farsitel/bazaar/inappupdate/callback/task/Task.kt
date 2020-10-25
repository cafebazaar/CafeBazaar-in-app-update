package com.farsitel.bazaar.inappupdate.callback.task

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

interface Task<Result> {
    fun getResult(): Result
    fun getException(): Exception?
    fun isSuccessful(): Boolean
    fun isComplete(): Boolean
    fun addOnSuccessListener(onSuccessListener: OnSuccessListener<Result>)
    fun addOnSuccessListener(onSuccess: (Result) -> Unit)
    fun addOnFailureListener(onFailureListener: OnFailureListener)
    fun addOnFailureListener(onFailure: (InstallErrorCode) -> Unit)
    fun addOnCompleteListener(onCompleteListener: OnCompleteListener<Result>)
    fun addOnCompleteListener(onComplete: (Result) -> Unit)
}