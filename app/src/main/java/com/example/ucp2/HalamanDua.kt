package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDua(
    pilihandospem1: List<String>,
    onSelectrionDp1: (String) -> Unit,
    pilihandospem2: List<String>,
    onSelectrionDp2: (String) -> Unit,
    onNextButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier

){
    var namaTxt by rememberSaveable { mutableStateOf("")}
    var nimTxt by rememberSaveable { mutableStateOf("")}
    var konsentrasiTxt by rememberSaveable { mutableStateOf("")}
    var judulTxt by remember { mutableStateOf("") }
    var dosenpemb1 by remember { mutableStateOf("") }
    var dosenpemb2 by remember { mutableStateOf("") }

    var ListDataTxt: MutableList<String> = mutableListOf(namaTxt,nimTxt,konsentrasiTxt,judulTxt,dosenpemb1,dosenpemb2)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "Formulir Pengujian Skripsi",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = namaTxt,
            onValueChange = {namaTxt = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.nama))},
            placeholder = {Text(text= "Masukkan nama")})
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = nimTxt,
            onValueChange = {nimTxt = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.nim))},
            placeholder = {Text(text= "Masukkan NIM")})
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = konsentrasiTxt,
            onValueChange = {konsentrasiTxt = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.konsentrasi))},
            placeholder = {Text(text= "Masukkan konsentrasi")})
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = judulTxt,
            onValueChange = {judulTxt = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.judul))},
            placeholder = {Text(text= "Masukkan Judul")})
        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween)
        {
            Row (){
                pilihandospem1.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = dosenpemb1 == item,
                        onClick = {
                            dosenpemb1 = item
                            onSelectrionDp1(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = dosenpemb1 == item,
                            onClick = {
                                dosenpemb1 = item
                                onSelectrionDp1(item)
                            }
                        )
                        Text(item)
                    }
                }
            }
            Row (){
                pilihandospem2.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = dosenpemb2 == item,
                        onClick = {
                            dosenpemb2 = item
                            onSelectrionDp2(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = dosenpemb2 == item,
                            onClick = {
                                dosenpemb2 = item
                                onSelectrionDp2(item)
                            }
                        )
                        Text(item)
                    }
                }
            }
        }
        Button(onClick = { onNextButtonClicked(ListDataTxt) }) {
            Text(stringResource(R.string.next))
        }
    }
}