package io.github.chrislo27.rhre3.screen

import io.github.chrislo27.rhre3.RHRE3Application
import io.github.chrislo27.rhre3.editor.Editor
import io.github.chrislo27.rhre3.editor.EditorStage
import io.github.chrislo27.toolboks.ToolboksScreen


class EditorScreen(main: RHRE3Application) : ToolboksScreen<RHRE3Application, EditorScreen>(main) {

    val editor: Editor = Editor(main, main.defaultCamera)
    override val stage: EditorStage
        get() = editor.stage

    override fun render(delta: Float) {
        editor.render()
        super.render(delta)
        editor.postStageRender()
    }

    override fun renderUpdate() {
        super.renderUpdate()
        editor.renderUpdate()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        editor.stage.updatePositions()
    }

    override fun dispose() {
        editor.dispose()
    }

    override fun tickUpdate() {
    }
}