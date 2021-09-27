package com.example.paisamanage.Views

import com.example.paisamanage.models.local.Model

interface onItemClicked {
    fun onEditClicked(model: Model)
    fun onDeleteClicked(model: Model)
}