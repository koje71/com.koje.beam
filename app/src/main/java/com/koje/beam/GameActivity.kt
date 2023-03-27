package com.koje.beam

import android.view.WindowManager
import com.koje.framework.view.BaseActivity
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.LinearLayoutBuilder

class GameActivity : BaseActivity() {

    override fun setup(target: FrameLayoutBuilder) {
        with(window) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = target.getColorFromID(R.color.black)
            navigationBarColor = target.getColorFromID(R.color.black)
        }
        supportActionBar?.hide()
    }

    override fun createLayout(target: FrameLayoutBuilder) {
        with(target){
            addLinearLayout {
                setOrientationVertical()
                createHeader(this)
                createContent(this)
            }
        }
    }

    private fun createHeader(target:LinearLayoutBuilder){
        with(target){
            addLinearLayout {
                setOrientationHorizontal()
                setBackgroundColorId(R.color.black)
                setPaddingsDP(5,2,5,2)
                addTextView {
                    setTextSizeSP(28f)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.white)
                    setText("Monster Beam")
                }
            }
        }
    }

    private fun createContent(target:LinearLayoutBuilder){
        with(target){
            addSurfaceView {
                setSizeMatchParent()
                setSurface(Playground)
            }
        }
    }
}