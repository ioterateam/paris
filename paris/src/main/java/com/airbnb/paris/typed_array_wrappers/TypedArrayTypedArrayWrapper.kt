package com.airbnb.paris.typed_array_wrappers

import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import com.airbnb.paris.styles.ResourceStyle
import com.airbnb.paris.styles.Style

internal class TypedArrayTypedArrayWrapper constructor(
    private val typedArray: TypedArray
) : TypedArrayWrapper() {

    private fun isNull(index: Int): Boolean = isNullRes(typedArray.getResourceId(index, 0))

    override fun getIndexCount(): Int = typedArray.indexCount

    override fun getIndex(at: Int): Int = typedArray.getIndex(at)

    override fun hasValue(index: Int): Boolean = typedArray.hasValue(index)

    override fun getBoolean(index: Int): Boolean =
        typedArray.getBoolean(index, false)

    override fun getColor(index: Int): Int = typedArray.getColor(index, -1)

    override fun getColorStateList(index: Int): ColorStateList? {
        return if (isNull(index)) {
            null
        } else {
            typedArray.getColorStateList(index)
        }
    }

    override fun getDimensionPixelSize(index: Int): Int =
        typedArray.getDimensionPixelSize(index, -1)

    override fun getDrawable(index: Int): Drawable? {
        return if (isNull(index)) {
            null
        } else {
            typedArray.getDrawable(index)
        }
    }

    override fun getFloat(index: Int): Float = typedArray.getFloat(index, -1f)

    override fun getFraction(index: Int, base: Int, pbase: Int): Float =
        typedArray.getFraction(index, base, pbase, -1f)

    override fun getInt(index: Int): Int = typedArray.getInt(index, -1)

    override fun getLayoutDimension(index: Int): Int =
        typedArray.getLayoutDimension(index, -1)

    override fun getResourceId(index: Int): Int {
        return if (isNull(index)) {
            // One of our alternate null resources was used here so we return 0 instead of an
            // existing resource
            0
        } else {
            typedArray.getResourceId(index, 0)
        }
    }

    override fun getString(index: Int): String? = typedArray.getString(index)

    override fun getText(index: Int): CharSequence? = typedArray.getText(index)

    override fun getTextArray(index: Int): Array<CharSequence>? = typedArray.getTextArray(index)

    override fun getStyle(index: Int): Style = ResourceStyle(getResourceId(index))

    override fun recycle() {
        typedArray.recycle()
    }
}
