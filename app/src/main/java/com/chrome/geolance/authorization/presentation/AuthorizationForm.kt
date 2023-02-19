package com.chrome.geolance.authorization.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrome.geolance.R
import com.chrome.geolance.ui.theme.GeolanceTheme

@Composable
fun AuthorizationForm(
    modifier: Modifier = Modifier
) {

    var emailTextState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }

    var passwordTextState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.authorization_title),
                color = MaterialTheme.colors.onBackground,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = emailTextState,
                onValueChange = { emailTextState = it },
                label = { Text(text = stringResource(R.string.authorization_email_label)) },
                placeholder = { Text(text = stringResource(R.string.authorization_email_placeholder)) },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            OutlinedTextField(
                value = passwordTextState,
                onValueChange = { passwordTextState = it },
                label = { Text(text = stringResource(R.string.authorization_password_label)) },
                placeholder = { Text(text = stringResource(R.string.authorization_password_placeholder)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Lock,
                            contentDescription = null
                        )
                    }
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(percent = 50)
            ) {
                Text(
                    text = "Войти",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Зарегистрироваться", color = MaterialTheme.colors.primary)
                Text(text = "Забыли пароль?", color = MaterialTheme.colors.primary)
            }
        }
    }
}

@Preview
@Composable
fun AuthorizationFormPreview() {
    GeolanceTheme {
        AuthorizationForm()
    }
}