package com.example.myapplication.day8.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.day8.dto.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { createdInstance ->
                        instance = createdInstance
                    }
            }
        }
    }
}