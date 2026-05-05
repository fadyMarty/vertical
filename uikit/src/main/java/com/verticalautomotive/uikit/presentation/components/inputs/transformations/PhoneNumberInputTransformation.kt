package com.verticalautomotive.uikit.presentation.components.inputs.transformations

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.core.text.isDigitsOnly

class PhoneNumberInputTransformation : InputTransformation {
    override fun TextFieldBuffer.transformInput() {
        if (!asCharSequence().isDigitsOnly()) {
            revertAllChanges()
        }
        if (length > MAX_LENGTH) {
            revertAllChanges()
        }
    }

    companion object {
        const val MAX_LENGTH = 11
    }
}