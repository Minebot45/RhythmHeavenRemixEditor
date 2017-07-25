package io.github.chrislo27.rhre3.registry.json.impl

import com.fasterxml.jackson.annotation.JsonTypeName
import io.github.chrislo27.rhre3.registry.json.NamedID

@JsonTypeName("pattern")
class PatternObject : NamedID() {

    lateinit var cues: List<CuePointerObject>

}