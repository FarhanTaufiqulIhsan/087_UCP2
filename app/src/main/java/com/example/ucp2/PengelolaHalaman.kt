package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.data.DataSource


enum class PengelolaHalaman{
    Home,
    Formulir,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UcpApp(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
        Scaffold ()
        { innerPadding -> val uiState by viewModel.stateUI.collectAsState()
        NavHost(navController = navController,
                startDestination = PengelolaHalaman.Home.name,
                modifier = Modifier.padding(innerPadding))
        {
            composable(route = PengelolaHalaman.Home.name){
                HalamanHome(
                    onNextButtonClicked = {navController.navigate(PengelolaHalaman.Formulir.name)}
                )
            }
            composable(route = PengelolaHalaman.Formulir.name){
            val context = LocalContext.current
            HalamanDua(
                    pilihandospem1 = DataSource.dosenpem.map { id ->
                        context.resources.getString(id)},
                    onSelectrionDp1 = {viewModel.setDp1(it)},
                    pilihandospem2 = DataSource.dosenpem.map { id ->
                        context.resources.getString(id)},
                    onSelectrionDp2 = {viewModel.setDp1(it)},
                    onNextButtonClicked = {navController.navigate(PengelolaHalaman.Summary.name)}
                )
            }
            composable(route = PengelolaHalaman.Summary.name){
                HalamanTiga(formUIState = uiState, onCancelButtonCLicked = { cancelOrderAndNavigateToForm(viewModel, navController) })
            }
        }
    }
}

private fun cancelOrderAndNavigateToForm(
    viewModel: FormViewModel,
    navController: NavHostController
){
    viewModel.resetPilihan()
    navController.popBackStack(PengelolaHalaman.Formulir.name, inclusive = false)
}
