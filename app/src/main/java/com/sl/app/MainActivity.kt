package com.sl.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.sl.app.db.AppDatabase
import com.sl.app.entity.User
import com.sl.app.migrations.MIGRATION_1_TO_2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        thread {
//            val db = Room.databaseBuilder(
//                    applicationContext,
//                    AppDatabase::class.java, "database_name"
//            ).build()
//
//            val users = mutableListOf<User>().apply {
//                add(User(0, "chen", "sl"))
//                add(User(0, "chen1", "sl1"))
//                add(User(0, "chen2", "sl2"))
//                add(User(0, "chen3", "sl3"))
//            }
//
//            db.userDao().insertAll(*users.toTypedArray())
//
//            var all = db.userDao().getAll()
//
//            runOnUiThread {
//                findViewById<TextView>(R.id.textView).text = all.toString()
//            }
//
//        }

        lifecycleScope.launch(Dispatchers.Main) {
            val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "database_name"
            ).addMigrations(MIGRATION_1_TO_2)
                    .build()

            val getUsers = withContext(Dispatchers.IO) {
                val users = mutableListOf<User>().apply {
                    add(User(0, "chen", "sl", "attr1"))
                    add(User(0, "chen", "sl", "attr2"))
                }
                db.userDao().insertAll(*users.toTypedArray())
                db.userDao().getAll()
            }

            findViewById<TextView>(R.id.textView).text = getUsers.toString()
        }

    }
}