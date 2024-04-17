package com.example.movieappmad24.models

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDatabase:RoomDatabase() {
    abstract fun movieDao():MovieDao


    companion object {
        @Volatile
        private var instance: MovieDatabase? = null

        fun getDatabase(context: Context):MovieDatabase{
            return instance?: synchronized(this){
                Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{
                        instance = it
                    }
            }
        }
    }
}

@Dao
interface MovieDao{

}