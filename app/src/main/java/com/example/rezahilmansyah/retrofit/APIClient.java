package com.example.rezahilmansyah.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.BuildConfig;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import timber.log.Timber;

/**
 * Created by user on 1/10/2018.
 */

public class APIClient {

    private static Retrofit retrofit = null;
    private static String Base_URL = "https://randomuser.me/api?results=5&exc=login,registered,i";

    public static Retrofit getClient() {



        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Log.e("siapp",message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new StringConverter());
        Gson gson = gb.excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).serializeNulls().create();


        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();



        return retrofit;
    }

    public static Retrofit getClientWithApi(String tokenAuth) {

        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("Authorization", "Bearer "+ tokenAuth).build();
                return chain.proceed(newRequest);
            }
        };


         HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Log.e("siapp",message));
         loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
           OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                   .connectTimeout(1, TimeUnit.MINUTES)
                   .readTimeout(30, TimeUnit.SECONDS)
                   .writeTimeout(30, TimeUnit.SECONDS)
                   .addInterceptor(interceptor)
                                    .build();

        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new StringConverter());
        Gson gson = gb.excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).serializeNulls().create();


        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();



        return retrofit;
    }

    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    public static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }

}
