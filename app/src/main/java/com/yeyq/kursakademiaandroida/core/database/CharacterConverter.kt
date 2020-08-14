package com.yeyq.kursakademiaandroida.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.characters.domain.model.OriginCharacter

class CharacterConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun originToJson(data: OriginCharacter): String = Gson().toJson(data)

        @TypeConverter
        @JvmStatic
        fun originFromJson(json: String): OriginCharacter =
            Gson().fromJson(json, object : TypeToken<OriginCharacter>() {}.type)

        @TypeConverter
        @JvmStatic
        fun locationToJson(data: LocationCharacter): String = Gson().toJson(data)

        @TypeConverter
        @JvmStatic
        fun locationFromJson(json: String): LocationCharacter =
            Gson().fromJson(json, object : TypeToken<LocationCharacter>() {}.type)
    }
}