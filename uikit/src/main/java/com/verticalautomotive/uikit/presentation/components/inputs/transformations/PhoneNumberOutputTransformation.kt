package com.verticalautomotive.uikit.presentation.components.inputs.transformations

import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert

class PhoneNumberOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (length > 0) insert(0, "+")
        if (length > 2) insert(2, " ")
        if (length > 3) insert(3, "(")
        if (length > 7) insert(7, ") ")
        if (length > 12) insert(12, "-")
    }
}