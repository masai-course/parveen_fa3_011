package com.example.basisapp.remote

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

class customgson : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    )
            : Converter<ResponseBody, *>? = ResponseBodyConverter<Any>(type)

    override fun requestBodyConverter(
        type: Type, parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    )
            : Converter<*, RequestBody>? = RequestBodyConverter<Any>()

    class ResponseBodyConverter<T> internal constructor(private val type: Type) :
        Converter<ResponseBody, T> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T? {
            // here we handle this '\' on the start of the server's response
            return DEFAULT_GSON_FACTORY.fromJson<T>(value.string().substring(1), type)
        }
    }

    class RequestBodyConverter<T> : Converter<T, RequestBody> {

        override fun convert(value: T): RequestBody =
            RequestBody.create(MEDIA_TYPE, DEFAULT_GSON_FACTORY.toJson(value))

    }

    companion object {
        private val MEDIA_TYPE = "application/json; charset=UTF-8".toMediaTypeOrNull()
        private val DEFAULT_GSON_FACTORY = Gson() // you can define here your own gson
    }
}