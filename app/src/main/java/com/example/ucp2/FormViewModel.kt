package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.FormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI: StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setContact(listData: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judulS = listData[3],
                dospem1 = listData[4],
                dospem2 = listData[5]
            )
        }
    }
    fun setDp1(dp1Pilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem1 = dp1Pilihan
            )
        }
    }

    fun setDp2(dp2Pilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem2 = dp2Pilihan
            )
        }
    }

fun resetPilihan(){
    _stateUI.value = FormUIState()
}
}