package com.ngonim.room

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
     fun getContactsOrderedByFirstName():Flow<List<Contact>>

     @Query("SELECT * FROM contact ORDER BY lastName ASC")
     fun getContactsOrderedByLastName():Flow<List<Contact>>

     @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
     fun getContactsOrderedByPhoneNumber():Flow<List<Contact>>
}