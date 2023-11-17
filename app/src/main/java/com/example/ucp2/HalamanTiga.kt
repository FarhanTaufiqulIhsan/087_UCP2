package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ucp2.data.FormUIState

@Composable
fun HalamanTiga(
    formUIState: FormUIState,
    modifier: Modifier = Modifier,
    onCancelButtonCLicked: () -> Unit

){
    val items = listOf(
        Pair(stringResource(R.string.nama), formUIState.nama),
        Pair(stringResource(R.string.nim), formUIState.nim),
        Pair(stringResource(R.string.konsentrasi), formUIState.konsentrasi),
        Pair(stringResource(R.string.judul), formUIState.judulS),
        Pair(stringResource(R.string.dosenpem1), formUIState.dospem1),
        Pair(stringResource(R.string.dosenpem2), formUIState.dospem2)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(
                        text = item.second.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(thickness = 1.dp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCancelButtonCLicked
            ) {
                Text(stringResource(R.string.back))
            }
        }
    }
}