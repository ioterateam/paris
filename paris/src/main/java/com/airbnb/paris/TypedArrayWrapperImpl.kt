package com.airbnb.paris

import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import java.util.*

internal class TypedArrayWrapperImpl constructor(val typedArray: TypedArray) : TypedArrayWrapper {

    /**
     * Unfortunately Android doesn't support reading @null resources from a style resource like it
     * does from an AttributeSet so this trickery is required
     */
    private val NULL_RESOURCE_IDS = HashSet(Arrays.asList(R.anim.null_, R.color.null_, R.drawable.null_))

    override fun isNull(index: Int): Boolean {
        return NULL_RESOURCE_IDS.contains(typedArray.getResourceId(index, 0))
    }

    override fun getIndexCount(): Int {
        return typedArray.indexCount
    }

    override fun getIndex(at: Int): Int {
        return typedArray.getIndex(at)
    }

    override fun hasValue(index: Int): Boolean {
        return typedArray.hasValue(index)
    }

    override fun getBoolean(index: Int, defValue: Boolean): Boolean {
        return typedArray.getBoolean(index, defValue)
    }

    override fun getColor(index: Int, defValue: Int): Int {
        return typedArray.getColor(index, defValue)
    }

    override fun getColorStateList(index: Int): ColorStateList {
        return typedArray.getColorStateList(index)
    }

    override fun getDimensionPixelSize(index: Int, defValue: Int): Int {
        return typedArray.getDimensionPixelSize(index, defValue)
    }

    override fun getDrawable(index: Int): Drawable {
        return typedArray.getDrawable(index)
    }

    override fun getFloat(index: Int, defValue: Float): Float {
        return typedArray.getFloat(index, defValue)
    }

    override fun getFraction(index: Int, base: Int, pbase: Int, defValue: Float): Float {
        return typedArray.getFraction(index, base, pbase, defValue)
    }

    override fun getInt(index: Int, defValue: Int): Int {
        return typedArray.getInt(index, defValue)
    }

    override fun getLayoutDimension(index: Int, defValue: Int): Int {
        return typedArray.getLayoutDimension(index, defValue)
    }

    override fun getResourceId(index: Int, defValue: Int): Int {
        return if (isNull(index)) 0 else typedArray.getResourceId(index, 0)
    }

    override fun getString(index: Int): String {
        return typedArray.getString(index)
    }

    override fun getText(index: Int): CharSequence {
        return typedArray.getText(index)
    }

    override fun getTextArray(index: Int): Array<CharSequence> {
        return typedArray.getTextArray(index)
    }

    override fun recycle() {
        typedArray.recycle()
    }
}