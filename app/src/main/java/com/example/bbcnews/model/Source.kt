package com.example.bbcnews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(@Expose
                  @SerializedName("id")
                  val id: String,
                  @Expose
                  @SerializedName("name")
                  val name: String)
