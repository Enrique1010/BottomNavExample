package com.erapps.bottomnavbarexample.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erapps.bottomnavbarexample.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onButtonClick: (name: String) -> Unit) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.title_home),
                modifier = modifier.align(CenterHorizontally)
            )
            Spacer(modifier = modifier)
            Button(
                onClick = { onButtonClick("Klk PP ${5}") },
                modifier = modifier
                    .align(CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.btn_text_go_to_details))
            }
        }
    }
}