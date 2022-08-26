package com.erapps.bottomnavbarexample.ui.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.erapps.bottomnavbarexample.R

@Composable
fun DetailsScreen(name: String, OnIconClick: () -> Unit) {
    Scaffold(topBar = { TopBar() { OnIconClick() } }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name, modifier = Modifier
                    .padding(it)
                    .align(CenterHorizontally)
            )
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    OnIconClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.title_details)) },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = modifier.clickable { OnIconClick() }
            )
        },
        contentColor = MaterialTheme.colors.background,
        modifier = modifier
    )
}