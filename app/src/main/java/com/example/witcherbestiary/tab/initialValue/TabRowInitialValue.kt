package com.example.witcherbestiary.tab.initialValue

import com.example.bloc.value.InitialValue

interface TabRowInitialValue : InitialValue {
    val tabList: List<String>
    val index: Int
}