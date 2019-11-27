package com.alphacoder.core.extension

import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.setOnTextChangeListener(textChanged: (String) -> Unit) {
    addTextChangedListener( { _, _, _, _ ->
        // beforeTextChanged
    },
        {text, _, _, _ ->
            // onTextChanged
            textChanged(text.toString())
        },
        {
            // afterTextChanged
        })
}

