package com.chrome.geolance.authorization.presentation.registration

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrome.geolance.R
import com.chrome.geolance.authorization.domain.model.RegistrationUiState
import com.chrome.geolance.core.ui.hiltViewModelPreviewSafe
import com.chrome.geolance.core.ui.uiStatePreviewSafe
import com.chrome.geolance.ui.theme.GeolanceTheme

@Composable
fun RegistrationScreen(
    goToAuthorization: () -> Unit
) {

    Surface {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            val viewModel: RegistrationViewModel? = hiltViewModelPreviewSafe()

            val state = uiStatePreviewSafe(viewModel = viewModel, ::previewState)

            UI(
                email = viewModel?.email ?: "",
                password = viewModel?.password ?: "",
                firstName = viewModel?.firstName ?: "",
                lastName = viewModel?.lastName ?: "",
                onEmailChanged = { viewModel?.onEvent(RegistrationEvent.EmailChanged(it)) },
                onPasswordChanged = { viewModel?.onEvent(RegistrationEvent.PasswordChanged(it)) },
                onFirstNameChanged = { viewModel?.onEvent(RegistrationEvent.FirstNameChanged(it)) },
                onLastNameChanged = { viewModel?.onEvent(RegistrationEvent.LastNameChanged(it)) },
                goToAuthorization = goToAuthorization,
                onSignUpClick = { email, password, firstName, lastName ->
                    viewModel?.onEvent(
                        RegistrationEvent.SignUpClick(
                            email,
                            password,
                            firstName,
                            lastName
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun UI(
    email: String,
    password: String,
    firstName: String,
    lastName: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onSignUpClick: (String, String, String, String) -> Unit,
    goToAuthorization: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                text = stringResource(R.string.registration_signin),
                color = MaterialTheme.colors.onBackground,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = email,
                onValueChange = { onEmailChanged(it) },
                label = { Text(text = stringResource(R.string.authorization_email_label)) },
                placeholder = { Text(text = stringResource(R.string.authorization_email_placeholder)) },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { onPasswordChanged(it) },
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

            OutlinedTextField(
                value = firstName,
                onValueChange = { onFirstNameChanged(it) },
                label = { Text(text = stringResource(R.string.registration_first_name)) },
                placeholder = { Text(text = stringResource(R.string.registration_first_name)) },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { onLastNameChanged(it) },
                label = { Text(text = stringResource(R.string.registration_last_name)) },
                placeholder = { Text(text = stringResource(R.string.registration_last_name)) },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Button(
                onClick = {
                    onSignUpClick(email, password, firstName, lastName)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(percent = 50)
            ) {
                Text(
                    text = stringResource(R.string.authorization_signup),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
                )
            }
            Text(
                text = stringResource(R.string.registration_go_to_signin),
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    goToAuthorization()
                }
            )
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    GeolanceTheme {
        RegistrationScreen {}
    }
}

private fun previewState(): RegistrationUiState = RegistrationUiState(isLoading = false)