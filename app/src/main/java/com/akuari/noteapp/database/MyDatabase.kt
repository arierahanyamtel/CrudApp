package com.akuari.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akuari.noteapp.model.NoteDao
import com.akuari.noteapp.model.NoteModel




@Database(
    entities = [NoteModel::class],
    version = 3, 
    exportSchema = false 
)
abstract class MyDatabase : RoomDatabase() {
    
    abstract fun noteDao(): NoteDao

    
    companion object {
        
        @Volatile
        private var INSTANCE: MyDatabase? = null

        
        fun getDatabase(context: Context): MyDatabase {
            
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                
                return tempInstance
            }

            
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "noteData_database"
                )
                    .fallbackToDestructiveMigration() 
                    .build()
                INSTANCE = instance
                
                return instance
            }
        }
    }
}
