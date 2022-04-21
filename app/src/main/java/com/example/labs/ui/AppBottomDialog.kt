package com.example.labs.ui

import com.example.labs.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class AppBottomDialog : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog
}