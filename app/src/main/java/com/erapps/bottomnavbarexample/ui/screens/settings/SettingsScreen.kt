package com.erapps.bottomnavbarexample.ui.screens.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.erapps.bottomnavbarexample.R

@Composable
fun SettingScreen(){
    Surface {
        Text(
            text = stringResource(id = R.string.title_settings),
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            textAlign = TextAlign.Center
        )
    }
}