//package com.example.myapplication.storage
package com.heyletscode.tetris.storage

import android.content.Context
import android.content.SharedPreferences

//класс Context необходим для передачи конструктора класса при создании экземпляра класса
//класс Context поддерживает доступ к методу getSharedPreferences, который получает файл настроек
class AppPreferences(ctx: Context) {
    var data: SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    //принимает целое число - наибольшее количество очков, которое будет сохраняться,
    //когда единственный аргумент data.edit() возвратит объект Editor, разрешающий изменение файла настроек
    fun saveHighScore(highScore: Int) {
        data.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    //возвращает наибольшее количество очков при вызове данных с помощью функции getInt()
    fun getHighScore(): Int {
        return data.getInt("HIGH_SCORE", 0)
    }

    fun clearHighScore() {
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
}