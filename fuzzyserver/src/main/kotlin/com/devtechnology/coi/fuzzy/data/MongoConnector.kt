package com.devtechnology.coi.fuzzy.data

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object MongoConnector {

    val hostname: String = "localhost"
    val port: Int = 27017
    val databaseName: String = "coi"

    val client: MongoClient
    val database: MongoDatabase

    init {
        client = KMongo.createClient()
        database = client.getDatabase(databaseName)

        println("Initialized the database instance: ${database.name}")
    }

    fun getCollection(collectionName: String): MongoCollection<Hello> {
        val collection = database.getCollection<Hello>()
        println("Got collection: $collectionName")
        return collection
    }
}