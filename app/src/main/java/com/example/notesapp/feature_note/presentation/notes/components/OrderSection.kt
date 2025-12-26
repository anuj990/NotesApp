package com.example.notesapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.feature_note.data.domain.util.NoteOrder
import com.example.notesapp.feature_note.data.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier, noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                modifier = Modifier,
                text = "Title",
                checked = noteOrder is NoteOrder.Title,
                onCheck = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                modifier = Modifier,
                text = "Date",
                checked = noteOrder is NoteOrder.Date,
                onCheck = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                modifier = Modifier,
                text = "Color",
                checked = noteOrder is NoteOrder.Color,
                onCheck = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier.height(16.dp))
        Row(modifier.fillMaxWidth()) {
            DefaultRadioButton(
                modifier = Modifier,
                text = "Ascending",
                checked = noteOrder.orderType is OrderType.Ascending,
                onCheck = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
            )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                modifier = Modifier,
                text = "Descending",
                checked = noteOrder.orderType is OrderType.Descending,
                onCheck = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
            )
        }
    }
}