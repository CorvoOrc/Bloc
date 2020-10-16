package com.example.witcherbestiary.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.VectorAsset

val Icons.Outlined.ArrowUp: VectorAsset
    get() {
        if (icon != null) return icon!!
        icon = materialIcon {
            materialPath {
                moveTo(7.0f, 10.0f)
                lineToRelative(5.0f, -5.0f)
                lineToRelative(5.0f, 5.0f)
                horizontalLineTo(7.0f)
                close()
            }
        }
        return icon!!
    }

private var icon: VectorAsset? = null