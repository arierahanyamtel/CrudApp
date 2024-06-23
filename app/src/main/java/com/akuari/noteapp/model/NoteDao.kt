package com.akuari.noteapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {
    
    @Insert
    fun insertData(noteData: NoteModel)

    
    @Query("SELECT * FROM NoteModel")
    fun getAll(): LiveData<List<NoteModel>>

    
    @Update
    fun update(noteData: NoteModel)

    
    @Delete
    fun delete(noteData: NoteModel)
}
