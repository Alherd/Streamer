package com.alherd.streamer.entity

data class Camera(
    val access: String?,
    val description: String?,
    val location: String?,
    val picture: String?,
    val title: String?,
    val url: String?
) {

    data class Builder(
        var access: String? = null,
        var description: String? = null,
        var location: String? = null,
        var picture: String? = null,
        var title: String? = null,
        var url: String? = null
    ) {
        fun access(access: String?) = apply { this.access = access }
        fun description(description: String?) = apply { this.description = description }
        fun location(location: String?) = apply { this.location = location }
        fun picture(picture: String?) = apply { this.picture = picture }
        fun title(title: String?) = apply { this.title = title }
        fun url(url: String?) = apply { this.url = url }
    }

}