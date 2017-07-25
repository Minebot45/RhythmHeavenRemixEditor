package io.github.chrislo27.rhre3.registry.datamodel

import io.github.chrislo27.rhre3.registry.GameRegistry
import io.github.chrislo27.rhre3.registry.json.CuePointerObject

fun CuePointerObject.toDatamodel(): CuePointer = CuePointer(this)

fun List<CuePointerObject>.mapToDatamodel(): List<CuePointer> = this.map(::CuePointer)

class CuePointer {

    val id: String
    val beat: Float

    val backingDuration: Float
    val semitone: Int
    val track: Int

    val duration: Float
        get() =
            if (backingDuration <= 0f) {
                (GameRegistry.data.objectMap[id] as Cue).duration
            } else {
                backingDuration
            }

    constructor(obj: CuePointerObject) {
        id = obj.id
        beat = obj.beat
        backingDuration = obj.duration
        semitone = obj.semitone
        track = obj.track
    }

    constructor(id: String, beat: Float, duration: Float = 0f, semitone: Int = 0, track: Int = 0) {
        this.id = id
        this.beat = beat
        this.backingDuration = duration
        this.semitone = semitone
        this.track = track
    }


}