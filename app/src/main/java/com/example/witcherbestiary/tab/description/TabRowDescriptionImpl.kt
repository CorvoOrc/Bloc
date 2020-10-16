package com.example.witcherbestiary.tab.description

import com.example.witcherbestiary.tab.view.description.TabRowViewDescription

data class TabRowDescriptionImpl(
        override val id: String,
        override val tabs: List<String>,
        override val startIndex: Int,
        override val view: TabRowViewDescription
) : TabRowDescription