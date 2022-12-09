package com.jixcayau.pokedex.features.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jixcayau.pokedex.domain.entities.Region
import com.jixcayau.pokedex.features.auth.composables.AuthBody
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun LoginView(
    navController: NavHostController,
) {
    /*val viewModel = remember {
        LoginViewModel()
    }
    viewModel.loadRegions()*/

    AuthBody(
        onBackTap = null,
        actionTitle = "Aun no tienes cuenta?",
        actionButtonText = "Registrarse",
        actionOnTap = {
            navController.navigate(RoutesPath.Register)
        },
        content = {

        }
    )

    /*Content(
        regions = viewModel.regions,
    )*/
}

@Composable
private fun Content(
    regions: List<Region>,
) {
    /*BaseBody {
        regions.forEach {
            Text(
                text = it.name,
            )
        }
    }*/
    LoginView(
        navController = rememberNavController()
    )
}


@Preview
@Composable
private fun ContentPreview() {
    Content(
        regions = listOf(
            Region(
                name = "Kanto",
                url = "",
            ),
            Region(
                name = "Johto",
                url = "",
            ),
            Region(
                name = "Hoenn",
                url = "",
            ),
        )
    )
}